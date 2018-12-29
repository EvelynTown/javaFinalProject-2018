package sides;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import creatures.Calabash;
import creatures.Creature;
import creatures.Grandpa;
import formation.Form;

/**
 * 
 * ��������Ӫ����«��+��үү
 * 
 * @author TangSiyi
 *
 */

public class GoodSide implements Formate {
	private final int NUM = 7;
	private Grandpa grandpa;
	private List<Calabash> calabashBrothers = new ArrayList<>();

	public GoodSide(int order[]) {
		// TODO Auto-generated constructor stub
		grandpa = new Grandpa();
		calabashBrothers.clear();
		for (int i = 0; i < NUM; i++) {
			Calabash calabash = new Calabash(order[i]);
			calabashBrothers.add(calabash);
		}
	}

	public GoodSide(int order[], boolean flag) {
		// TODO Auto-generated constructor stub
		grandpa = new Grandpa(flag);
		calabashBrothers.clear();
		for (int i = 0; i < NUM; i++) {
			Calabash calabash = new Calabash(order[i], flag);
			calabashBrothers.add(calabash);
		}
	}

	// ��ȡ������ս������
	public int getCnt() {
		return 8;
	}

	public Grandpa getGrandpa() {
		return grandpa;
	}

	public List<Calabash> getCalabashBrothers() {
		return calabashBrothers;
	}

	// �Ժ�«������comparator����
	public void sortCalabash() {
		Comparator<Calabash> comparator = new Comparator<Calabash>() {
			public int compare(Calabash a, Calabash b) {
				if (a.getRank() > b.getRank())
					return 1;
				else if (a.getRank() < b.getRank())
					return -1;
				else
					return 0;
			}
		};
		Collections.sort(calabashBrothers, comparator);
	}

	// ��«��վ��������
	@Override
	public void formate(Creature ground[][], Form form) {
		// TODO Auto-generated method stub
		sortCalabash();
		form.form(ground, grandpa, calabashBrothers);
	}

}
