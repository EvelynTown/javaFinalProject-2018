package creatures;

/**
 * 
 * ����ö����
 * 
 * @author TangSiyi
 *
 */
public enum Species {
	CALABASH("��«��"), GRANDPA("��үү"), SNAKE("�߾�"), SCORPION("Ы�Ӿ�"), MINION("Сආ�");
	private String name;

	private Species(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
