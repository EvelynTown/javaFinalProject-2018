package sides;

import java.util.ArrayList;
import java.util.List;

import creatures.Creature;
import creatures.Minion;
import creatures.Scorpion;
import creatures.Snake;
import formation.Form;

/**
 * 
 * а���һ����Ы�Ӿ����߾���Сආ�
 * 
 * @author TangSiyi
 *
 */
public class EvilSide implements Formate {
	private Snake snake = new Snake();
	private Scorpion scorpion = new Scorpion();
	private List<Minion> minions = new ArrayList<>();

	public EvilSide() {

	}

	public Snake getSnake() {
		return snake;
	}

	public Scorpion getScorpion() {
		return scorpion;
	}

	public List<Minion> getMinions() {
		return minions;
	}

	// ��ȡа��ս������
	public int getCnt() {
		return minions.size() + 2;
	}

	@Override
	public void formate(Creature[][] ground, Form form) {
		// TODO Auto-generated method stub
		snake.stand(ground, 6, 11);
		form.form(ground, scorpion, minions);
	}

	public void setMinionCnt(int cnt) {
		if (cnt > 0) {
			minions.clear();
			for (int i = 0; i < cnt; i++)
				minions.add(new Minion(i));
		}
	}

}