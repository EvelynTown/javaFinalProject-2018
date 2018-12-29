package creatures;

import java.util.Random;

import constants.Constants;
import ground.Ground;
import ground.Position;
import javafx.application.Platform;
import javafx.scene.image.Image;
import log.FightLog;
import log.Log;
import log.MoveLog;
import ui.Main;

/**
 * 
 * 生物抽象类
 * 
 * @author TangSiyi
 *
 */

public abstract class Creature extends Thread implements Constants, Move, Fight {
	protected String name; // 名字
	protected int id;
	protected Species species; // 物种
	protected boolean status; // 生存状态
	protected boolean quality; // 品质（阵营
	protected Image icon; // 照片
	protected Position position; // ground上的位置
	protected static Ground ground;

	public Creature() {
		status = ALIVE;
		position = new Position();
	}

	public Creature(String name, Species species) {
		this();
		this.name = name;
		this.species = species;
	}

	public Creature(String name, Species species, String path) {
		this();
		this.name = name;
		this.species = species;
		this.icon = new Image(Main.class.getResourceAsStream(path), Constants.IMAGE_WIDTH, Constants.IMAGE_HEIGHT,
				false, false);
	}

	public boolean getQuality() {
		return quality;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getThisName() {
		return name;
	}

	public Position getPosition() {
		return position;
	}

	public void setPostion(Position position) {
		this.position = position;
	}

	public Image getIcon() {
		return icon;
	}

	public void setGround(Ground ground) {
		Creature.ground = ground;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getThisId() {
		return id;
	}

	// 根据坐标站点
	public void stand(Creature ground[][], int x, int y) {
		ground[x][y] = this;
		position.setX(x);
		position.setY(y);
	}

	@Override
	public void run() {
		while (!ground.isOver() && getStatus() == ALIVE) {
			if (!ground.isReplay()) {
				takeStep();
				fightWithOpponent();
			} else {
				runAsLog();
			}
			try {
				if (!ground.isReplay())
					Thread.sleep(1000);
				else
					Thread.sleep(600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void getKilled() {
		setStatus(DEAD);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				ground.setImage(position.getX(), position.getY(), deadBody);
			}
		});
		ground.updateCnt(quality);
	}

	private boolean isSuccess() {
		Random random = new Random();
		int r = random.nextInt(10);
		if (r < 6)
			return (getStatus() == GOOD);
		else
			return (getStatus() == EVIL);
	}

	@Override
	public void fightWith(int x, int y) {
		// 胜利
		if (isSuccess()) {
			ground.getCreature(x, y).getKilled();
			ground.getTextArea().setText(
					ground.getTextArea().getText() + "\n" + name + " kills " + ground.getCreature(x, y).getThisName());
			System.out.println(name + " kills " + ground.getCreature(x, y).getThisName());
			ground.prtResult(!getQuality());
			FightLog log = new FightLog(id, position.getX(), position.getY(), ground.getCreature(x, y).getThisId(),
					ground.getCreature(x, y).getPosition().getX(), ground.getCreature(x, y).getPosition().getY(), true);
			ground.addLog(log);
		} else {
			getKilled();
			ground.getTextArea().setText(
					ground.getTextArea().getText() + "\n" + ground.getCreature(x, y).getThisName() + " kills " + name);
			System.out.println(ground.getCreature(x, y).getThisName() + " kills " + name);
			ground.prtResult(getQuality());
			FightLog log = new FightLog(id, position.getX(), position.getY(), ground.getCreature(x, y).getThisId(),
					ground.getCreature(x, y).getPosition().getX(), ground.getCreature(x, y).getPosition().getY(),
					false);
			ground.addLog(log);
		}
	}

	@Override
	public void fightAround(int x0, int x1, int x2, int x3, int x4, int x5, int x6, int x7) {
		Random random = new Random();
		synchronized (ground) {
			int x = position.getX(), y = position.getY();
			int flag = random.nextInt(3);
			if (flag > 0) {
				if (x0 == 1) {
					if (ground.isFightable(x - 1, y - 1, quality) && (getStatus() == ALIVE))
						fightWith(x - 1, y - 1);
				}
			}
			flag = random.nextInt(3);
			if (flag > 0) {
				if (x1 == 1) {
					if (ground.isFightable(x - 1, y, quality) && (getStatus() == ALIVE))
						fightWith(x - 1, y);
				}
			}
			flag = random.nextInt(3);
			if (flag > 0) {
				if (x2 == 1) {
					if (ground.isFightable(x - 1, y + 1, quality) && (getStatus() == ALIVE))
						fightWith(x - 1, y + 1);
				}
			}
			flag = random.nextInt(3);
			if (flag > 0) {
				if (x3 == 1) {
					if (ground.isFightable(x, y - 1, quality) && (getStatus() == ALIVE))
						fightWith(x, y - 1);
				}
			}
			flag = random.nextInt(3);
			if (flag > 0) {
				if (x4 == 1) {
					if (ground.isFightable(x, y + 1, quality) && (getStatus() == ALIVE))
						fightWith(x, y + 1);
				}
			}
			flag = random.nextInt(3);
			if (flag > 0) {
				if (x5 == 1) {
					if (ground.isFightable(x + 1, y - 1, quality) && (getStatus() == ALIVE))
						fightWith(x + 1, y - 1);
				}
			}
			flag = random.nextInt(3);
			if (flag > 0) {
				if (x6 == 1) {
					if (ground.isFightable(x + 1, y, quality) && (getStatus() == ALIVE))
						fightWith(x + 1, y);
				}
			}
			flag = random.nextInt(3);
			if (flag > 0) {
				if (x7 == 1) {
					if (ground.isFightable(x + 1, y + 1, quality) && (getStatus() == ALIVE))
						fightWith(x + 1, y + 1);
				}
			}
		}

	}

	// 与周围一圈的人战斗
	@Override
	public void fightWithOpponent() {
		int x = position.getX(), y = position.getY();

		if (x == 0) {
			if (y == 0)
				fightAround(0, 0, 0, 0, 1, 0, 1, 1);
			else if (y == NUM - 1)
				fightAround(0, 0, 0, 1, 0, 1, 1, 0);
			else
				fightAround(0, 0, 0, 1, 1, 1, 1, 1);

		} else if (x == NUM - 1) {
			if (y == 0)
				fightAround(0, 1, 1, 0, 1, 0, 0, 0);
			else if (y == NUM - 1)
				fightAround(1, 1, 0, 1, 0, 0, 0, 0);
			else
				fightAround(1, 1, 1, 1, 1, 0, 0, 0);
		} else if (y == 0)
			fightAround(0, 1, 1, 0, 1, 0, 1, 1);
		else if (y == NUM - 1)
			fightAround(1, 1, 0, 1, 0, 1, 1, 0);
		else
			fightAround(1, 1, 1, 1, 1, 1, 1, 1);
	}

	@Override
	public void swapPosition(int x0, int y0, int x1, int y1) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				ground.setImageVisible(x0, y0, false);
				ground.setImage(x1, y1, icon);
				ground.setImageVisible(x1, y1, true);
			}
		});
	}

	@Override
	public void moveTo(int x, int y) {
		ground.setCreature(x, y, this);
		ground.setCreature(position.getX(), position.getY(), null);
		position.setX(x);
		position.setY(y);
		if (!ground.isReplay()) {
			MoveLog log = new MoveLog(id, position.getX(), position.getY());
			ground.addLog(log);
		}
	}

	@Override
	public void takeStep() {
		try {
			synchronized (ground) {

				int x = position.getX(), y = position.getY();
				Random random = new Random();
				int direction = random.nextInt(4);
				int step = random.nextInt(6);
				// UP
				if (direction == 0) {
					if (getStatus() == DEAD)
						return;
					if (y > step && !ground.isOccupied(x, y - step - 1)) {
						swapPosition(x, y, x, y - step - 1);
						moveTo(x, y - step - 1);
					}
				}
				// down
				else if (direction == 1) {
					if (getStatus() == DEAD)
						return;
					if (y < NUM - 1 - step && !ground.isOccupied(x, y + 1 + step)) {
						swapPosition(x, y, x, y + 1 + step);
						moveTo(x, y + 1 + step);
					}
				}
				// left
				else if (direction == 2) {
					if (getStatus() == DEAD)
						return;
					if (x > step && !ground.isOccupied(x - 1 - step, y)) {
						swapPosition(x, y, x - 1 - step, y);
						moveTo(x - 1 - step, y);

					}
				}
				// right
				else if (direction == 3) {
					if (getStatus() == DEAD)
						return;
					if (x < NUM - 1 - step && !ground.isOccupied(x + 1 + step, y)) {
						swapPosition(x, y, x + 1 + step, y);
						moveTo(x + 1 + step, y);

					}
				}
			}
		} catch (Exception e) {
			System.out.println("Creatures takeStep");
			e.printStackTrace();
		}
	}

	private void runAsLog() {
		synchronized (ground) {
			if (ground.getLog() != null && ground.getLog().getId() == this.id) {
				Log log = ground.getLog();
				if (log.getMotion().equals("move") && log instanceof MoveLog) {
//					ground.getTextArea()
//							.setText(ground.getTextArea().getText() + "\n" + name + " move to " + log.getX() + " " + log.getY());
					System.out.println(name + " move to " + log.getX() + " " + log.getY());
					swapPosition(position.getX(), position.getY(), log.getX(), log.getY());
					moveTo(log.getX(), log.getY());
				} else if (log.getMotion().equals("fight") && log instanceof FightLog) {
					FightLog fightLog = (FightLog) log;
					if (fightLog.getResult() == WIN) {
						ground.getCreature(fightLog.getOpX(), fightLog.getOpY()).setStatus(DEAD);
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								ground.setImage(fightLog.getOpX(), fightLog.getOpY(), deadBody);
							}
						});
						ground.getTextArea().setText(ground.getTextArea().getText() + "\n" + name + " kills "
								+ ground.getCreature(fightLog.getOpX(), fightLog.getOpY()).getThisName());
						System.out.println(name + " kills "
								+ ground.getCreature(fightLog.getOpX(), fightLog.getOpY()).getThisName());
						ground.updateCnt(getQuality());
					} else {
						setStatus(DEAD);
						Platform.runLater(new Runnable() {

							@Override
							public void run() {
								ground.setImage(position.getX(), position.getY(), deadBody);
							}
						});
						ground.getTextArea()
								.setText(ground.getTextArea().getText() + "\n"
										+ ground.getCreature(fightLog.getOpX(), fightLog.getOpY()).getThisName()
										+ " kills " + name);
						System.out.println(ground.getCreature(fightLog.getOpX(), fightLog.getOpY()).getThisName()
								+ " kills " + name);
						ground.updateCnt(ground.getCreature(fightLog.getOpX(), fightLog.getOpY()).getQuality());
					}
				}
				ground.delLog();
				if (ground.getLog() == null) {
					ground.getTextArea().setText(ground.getTextArea() + "\n" + ground.getResult());
				}
			}
		}
	}

}
