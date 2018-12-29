package constants;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ui.Main;

/**
 * 
 * 常数接口
 * 
 * @author EvelynTown
 *
 */
public interface Constants {
	final static int IMAGE_WIDTH = 47; // 图片宽
	final static int IMAGE_HEIGHT = 47; // 图片高
	final static int NUM = 12; // 二维方阵大小
	final static int BG_WIDTH = IMAGE_WIDTH * 17; // 二维方阵宽
	final static int BG_HEIGHT = IMAGE_HEIGHT * 13; // 二维方阵高
	final static int WINDOW_WIDTH = IMAGE_WIDTH * 17; // 二维方阵宽
	final static int WINDOW_HEIGHT = IMAGE_HEIGHT * 13; // 二维方阵高
	final static int STEP_LENGTH = IMAGE_HEIGHT; // 每步移动50单位

	// 生物生命状态
	final static boolean ALIVE = true;
	final static boolean DEAD = false;
	// 生物好坏
	final static boolean GOOD = true;
	final static boolean EVIL = false;

	final ImageView background = new ImageView(
			new Image(Main.class.getResourceAsStream("/background.jpg"), BG_WIDTH, WINDOW_HEIGHT, false, false));
	final Image deadBody = new Image(Main.class.getResourceAsStream("/deadBody.png"), IMAGE_WIDTH, IMAGE_HEIGHT, false,
			false);

	final static boolean WIN = true;
	final static boolean LOSE = false;

	final static String hint = "操作指南：\n" + "按键1：鹤翼\n" + "按键2：雁行\n" + "按键3：冲轭\n" + "按键4：鱼鳞\n" + "按键5：方円\n" + "按键6：偃月\n"
			+ "空格键：游戏开始\n" + "按键L：读取记录\n" + "*******************\n";
}
