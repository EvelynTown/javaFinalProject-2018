package creatures;

/**
 * 
 * ��үү
 * 
 * @author TangSiyi
 *
 */

public class Grandpa extends Creature {

	public Grandpa() {
		// TODO Auto-generated constructor stub
		super("��үү", Species.GRANDPA, "/grandpa.jpg");
		this.quality = GOOD;
	}
	
	public Grandpa(boolean flag) {
		// TODO Auto-generated constructor stub
		super("��үү", Species.GRANDPA);
		this.quality = GOOD;
	}
}