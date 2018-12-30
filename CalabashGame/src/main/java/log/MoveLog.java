package log;

public class MoveLog extends Log {
	// ±Ì æ»•(x,y)
	public MoveLog(int id, int x, int y) {
		super(id, x, y);
		motion = "move";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String string = motion + " " + id + " " + x + " " + y;
		return string;
	}
}
