package log;

import constants.Constants;

public abstract class Log implements Constants {
	String motion; // 执行的动作
	int id;
	int x; // 做出动作时所在的位置
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
