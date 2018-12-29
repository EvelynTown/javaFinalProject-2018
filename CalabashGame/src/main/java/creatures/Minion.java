package creatures;

import ui.Main;

/**
 * 
 * Ð¡à¶†ª
 * 
 * @author TangSiyi
 *
 */

public class Minion extends Creature {

	public Minion(int index) {
		super("à¶†ª" + index, Species.MINION,"/minion.jpg");
		this.quality = EVIL;
	}
}
