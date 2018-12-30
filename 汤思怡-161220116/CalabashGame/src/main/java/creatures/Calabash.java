package creatures;

/**
 * 
 * ��«����
 * 
 * @author TangSiyi
 *
 */

//���е�ö����
enum Rank {
	ONE("����", "/one.jpg"), TWO("����", "/two.jpg"), THREE("����", "/three.jpg"),
	FOUR("����", "/four.jpg"), FIVE("����", "/five.jpg"), SIX("����", "/six.jpg"),
	SEVEN("����", "/seven.jpg");
	private String rank;
	private String path;

	private Rank(String rank, String path) {
		this.rank = rank;
		this.path = path;
	}

	public String getRank() {
		return this.rank;
	}

	public String getPath() {
		return this.path;
	}
};

// ��«����
public class Calabash extends Creature {
	public Calabash(int index) {
		super(Rank.values()[index].getRank(), Species.CALABASH, Rank.values()[index].getPath());
		this.quality = GOOD;
	}
	
	public Calabash(int index, boolean test) {
		super(Rank.values()[index].getRank(), Species.CALABASH);
		this.quality = GOOD;
	}

	public int getRank() {
		for (int index = 0; index < NUM; index++) {
			if (Rank.values()[index].getRank() == name)
				return Rank.values()[index].ordinal();
		}
		return -1;
	}
	
	public String getRankName() {
		for (int index = 0; index < NUM; index++) {
			if (Rank.values()[index].getRank() == name)
				return name;
		}
		return null;
	}

}