package creatures;

import ui.Main;

/**
 * 
 * Сආ�
 * 
 * @author TangSiyi
 *
 */

public class Minion extends Creature {

	public Minion(int index) {
		super("ආ�" + index, Species.MINION,"/minion.jpg");
		this.quality = EVIL;
	}
}
