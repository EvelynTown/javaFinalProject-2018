package constants;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ui.Main;

/**
 * 
 * �����ӿ�
 * 
 * @author EvelynTown
 *
 */
public interface Constants {
	final static int IMAGE_WIDTH = 47; // ͼƬ��
	final static int IMAGE_HEIGHT = 47; // ͼƬ��
	final static int NUM = 12; // ��ά�����С
	final static int BG_WIDTH = IMAGE_WIDTH * 17; // ��ά�����
	final static int BG_HEIGHT = IMAGE_HEIGHT * 13; // ��ά�����
	final static int WINDOW_WIDTH = IMAGE_WIDTH * 17; // ��ά�����
	final static int WINDOW_HEIGHT = IMAGE_HEIGHT * 13; // ��ά�����
	final static int STEP_LENGTH = IMAGE_HEIGHT; // ÿ���ƶ�50��λ

	// ��������״̬
	final static boolean ALIVE = true;
	final static boolean DEAD = false;
	// ����û�
	final static boolean GOOD = true;
	final static boolean EVIL = false;

	final ImageView background = new ImageView(
			new Image(Main.class.getResourceAsStream("/background.jpg"), BG_WIDTH, WINDOW_HEIGHT, false, false));
	final Image deadBody = new Image(Main.class.getResourceAsStream("/deadBody.png"), IMAGE_WIDTH, IMAGE_HEIGHT, false,
			false);

	final static boolean WIN = true;
	final static boolean LOSE = false;

	final static String hint = "����ָ�ϣ�\n" + "����1������\n" + "����2������\n" + "����3������\n" + "����4������\n" + "����5������\n" + "����6������\n"
			+ "�ո������Ϸ��ʼ\n" + "����L����ȡ��¼\n" + "*******************\n";
}
