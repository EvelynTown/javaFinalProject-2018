package creatures;

/**
 * 
 * 物种枚举类
 * 
 * @author TangSiyi
 *
 */
public enum Species {
	CALABASH("葫芦娃"), GRANDPA("老爷爷"), SNAKE("蛇精"), SCORPION("蝎子精"), MINION("小喽啰");
	private String name;

	private Species(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
