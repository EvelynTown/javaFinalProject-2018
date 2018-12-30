package ground;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import constants.Constants;
import creatures.Calabash;
import creatures.Creature;
import creatures.Grandpa;
import creatures.Minion;
import formation.CraneForm;
import formation.FishForm;
import formation.Formation;
import formation.FrontForm;
import formation.GooseForm;
import formation.MoonForm;
import formation.SnakeForm;
import formation.SquareForm;
import formation.YokeForm;
import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import log.Log;
import log.LogFile;
import sides.EvilSide;
import sides.GoodSide;
import ui.Main;

/**
 * 
 * 战场类
 * 
 * @author TangSiyi
 *
 */
public class Ground implements Constants {
	private ImageView[][] images = new ImageView[Constants.NUM][Constants.NUM];
	private Creature[][] field = new Creature[Constants.NUM][Constants.NUM];
	private TextArea textArea = new TextArea();
	final int[] order = { 2, 6, 3, 5, 1, 4, 0 };
	EvilSide evilSide;
	GoodSide goodSide;
	public static int goodSideCnt = 8, evilSideCnt = 0;
	private LogFile logFile = new LogFile();
	private boolean replay = false;
	List<Thread> threads = new ArrayList<>();

	// 初始化生物二维数组
	public void initGround() {
		for (int i = 0; i < Constants.NUM; i++) {
			for (int j = 0; j < Constants.NUM; j++) {
				field[i][j] = null;
			}
		}
	}

	// 初始化图像
	public void initImages(GridPane gridPane) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				textArea.setTranslateX(IMAGE_WIDTH * 13+10);
				textArea.setDisable(true);
				gridPane.setHgap(5);
				gridPane.setVgap(5);
				for (int i = 0; i < Constants.NUM; i++) {
					for (int j = 0; j < Constants.NUM; j++) {
						images[i][j] = new ImageView();
						gridPane.add(images[i][j], j, i);
					}
				}
			}
		});
	}

	public void initFormation(GridPane gridPane, Formation formation) {
		initGround();
		evilSide = new EvilSide();
		goodSide = new GoodSide(order);
		goodSide.formate(field, new SnakeForm());
		switch (formation) {
		case CRANE:
//			System.out.println("鹤翼");
			textArea.setText(hint+"当前阵型：鹤翼");
			evilSide.formate(field, new CraneForm());
			logFile.setFormation("CRANE");
			break;
		case GOOSE:
//			System.out.println("雁行");
			textArea.setText(hint+"当前阵型：雁行");
			evilSide.formate(field, new GooseForm());
			logFile.setFormation("GOOSE");
			break;
		case YOKE:
//			System.out.println("冲轭");
			textArea.setText(hint+"当前阵型：冲轭");
			evilSide.formate(field, new YokeForm());
			logFile.setFormation("YOKE");
			break;
		case FISH:
//			System.out.println("鱼鳞");
			textArea.setText(hint+"当前阵型：鱼鳞");
			evilSide.formate(field, new FishForm());
			logFile.setFormation("FISH");
			break;
		case SQUARE:
//			System.out.println("方円");
			textArea.setText(hint+"当前阵型：方円");
			evilSide.formate(field, new SquareForm());
			logFile.setFormation("SQUARE");
			break;
		case MOON:
//			System.out.println("偃月");
			textArea.setText(hint+"当前阵型：偃月");
			evilSide.formate(field, new MoonForm());
			logFile.setFormation("MOON");
			break;
		case FRONT:
//			System.out.println("锋失");
			textArea.setText(hint+"当前阵型：锋失");
			evilSide.formate(field, new FrontForm());
			logFile.setFormation("FRONT");
			break;
		default:
			break;
		}
		showInitGround();
	}

	// 在面板中显示图片
	public void showInitGround() {
		try {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					evilSideCnt = 0;
					for (int i = 1; i < Constants.NUM; i++) {
						for (int j = 0; j < Constants.NUM; j++) {
							if (field[i][j] != null) {
								images[i][j].setImage(field[i][j].getIcon());
								images[i][j].setVisible(true);
								if (field[i][j].getQuality() == EVIL)
									evilSideCnt++;
							} else {
								images[i][j].setImage(new Image(Main.class.getResourceAsStream("/background.jpg"), Constants.IMAGE_WIDTH,
										Constants.IMAGE_WIDTH, false, false));
								images[i][j].setVisible(false);
							}
						}
					}
//					System.out.println(evilSideCnt);
				}
			});
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		} finally {
			goodSide.getGrandpa().setGround(this);
		}
	}

	private void initThread(Creature thread, int id) {
		thread.setStatus(ALIVE);
		thread.setId(id);
		thread.setName(thread.getThisName());
		threads.add(thread);
	}

	private void initThreads() {
		try {
			threads = new ArrayList<>();
			int id = 0;
			initThread(goodSide.getGrandpa(), id++);
			for (Calabash calabash : goodSide.getCalabashBrothers())
				initThread(calabash, id++);
			initThread(evilSide.getSnake(), id++);
			initThread(evilSide.getScorpion(), id++);
			for (Minion minion : evilSide.getMinions())
				initThread(minion, id++);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void startThreads() {
		initThreads();
		for (Thread thread : threads)
			thread.start();
	}

	public void setImage(int x, int y, Image image) {
		images[x][y].setImage(image);
	}

	public void setImageVisible(int x, int y, boolean flag) {
		images[x][y].setVisible(flag);
	}

	public Creature getCreature(int x, int y) {
		return field[x][y];
	}

	public void setCreature(int x, int y, Creature creature) {
		field[x][y] = creature;
	}

	public boolean isFightable(int x, int y, boolean quality) {
		return ((field[x][y] != null) && (field[x][y].getStatus() == ALIVE) && (field[x][y].getQuality() != quality));
	}

	public void updateCnt(boolean quality) {
		if (quality == GOOD)
			goodSideCnt--;
		else
			evilSideCnt--;
	}

	public void prtResult(boolean quality) {
		if (evilSideCnt == 0 && quality == EVIL) {
//			System.out.println("葫芦娃赢啦！");
			logFile.setResult("葫芦娃赢啦！");
			textArea.setText(getTextArea().getText() + "\n" + "葫芦娃赢啦！");
		} else if (goodSideCnt == 0 && quality == GOOD) {
//			System.out.println("蛇精赢啦！");
			textArea.setText(getTextArea().getText() + "\n" + "蛇精赢啦！");
			logFile.setResult("蛇精赢啦！");
		}
	}

	public boolean isOver() {
		if ((evilSideCnt == 0) || (goodSideCnt == 0)) {
			logFile.saveFile();
			return true;
		}
		return false;
	}

	public void readFile(File file, GridPane gridPane) {
		logFile.readFile(file);
		initFormation(gridPane, logFile.getFormation());
		replay = true;
	}

	public boolean isOccupied(int x, int y) {
		return (getCreature(x, y) != null);
	}

	public boolean isReplay() {
		return replay;
	}

	public void addLog(Log log) {
		logFile.add(log);
	}

	public Log getLog() {
		return logFile.getLog();
	}

	public void delLog() {
		logFile.delLog();
	}

	public TextArea getTextArea() {
		return textArea;
	}

	public String getResult() {
		return logFile.getResult();
	}

}
