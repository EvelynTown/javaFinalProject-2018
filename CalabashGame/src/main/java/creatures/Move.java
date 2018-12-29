package creatures;

/**
 * 
 * ÒÆ¶¯½Ó¿Ú
 * 
 * @author TangSiyi
 *
 */
public interface Move {
	void swapPosition(int x0, int y0, int x1, int y1);

	void moveTo(int x, int y);

	void takeStep();
}
