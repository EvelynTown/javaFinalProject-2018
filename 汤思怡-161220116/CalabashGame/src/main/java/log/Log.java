package log;

import constants.Constants;

public abstract class Log implements Constants {
	String motion; // ִ�еĶ���
	int id;
	int x; // ��������ʱ���ڵ�λ��
	int y;

	public Log(int id, int x, int y) {
		this.id = id;
		this.x = x;
		this.y = y;
	}

	public abstract String toString();

	public int getId() {
		return id;
	}

	public String getMotion() {
		return motion;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
