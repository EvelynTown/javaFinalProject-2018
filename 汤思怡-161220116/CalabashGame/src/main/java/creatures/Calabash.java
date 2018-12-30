package creatures;

/**
 * 
 * 葫芦娃类
 * 
 * @author TangSiyi
 *
 */

//排行的枚举类
enum Rank {
	ONE("大娃", "/one.jpg"), TWO("二娃", "/two.jpg"), THREE("三娃", "/three.jpg"),
	FOUR("四娃", "/four.jpg"), FIVE("五娃", "/five.jpg"), SIX("六娃", "/six.jpg"),
	SEVEN("七娃", "/seven.jpg");
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

// 葫芦娃类
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