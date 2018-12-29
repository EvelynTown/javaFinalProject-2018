package creatures;

/**
 * 
 * 蝎子精
 * 
 * @author TangSiyi
 *
 */

public class Scorpion extends Creature {

	public Scorpion() {
		super("蝎子精", Species.SCORPION, "/scorpion.jpg");
		this.quality = EVIL;
	}
}
