package log;

public class FightLog extends Log {
	int opponent;
	int op_x;
	int op_y;
	boolean re;

	public FightLog(int id, int x, int y, int opponent, int op_x, int op_y, boolean re) {
		super(id, x, y);
		motion = "fight";
		this.opponent = opponent;
		this.op_x = op_x;
		this.op_y = op_y;
		this.re = re;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String string = motion + " " + id + " " + x + " " + y + " " + opponent + " " + op_x + " " + op_y + " ";
		if (re == WIN)
			string += "win";
		else
			string += "lose";
		return string;
	}

	public int getOpponent() {
		return opponent;
	}

	public boolean getResult() {
		return re;
	}

	public int getOpX() {
		return op_x;
	}

	public int getOpY() {
		return op_y;
	}
}
