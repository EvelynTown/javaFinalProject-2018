package formation;

/**
 * 
 * ����ö����
 * 
 * @author TangSiyi
 *
 */
public enum Formation {
	/*
	 * �任���Σ��������С�������ߡ����ۡ����ҡ����¡���ʧ
	 */
	CRANE("����"), GOOSE("����"), YOKE("����"), SNAKE("����"), FISH("����"), SQUARE("����"), MOON("����"), FRONT("��ʧ");
	private String name;

	private Formation(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
