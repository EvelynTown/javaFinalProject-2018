package formation;

import java.util.List;

import creatures.Creature;
import creatures.Minion;
import creatures.Scorpion;

/**
 * 
 * Ÿ»‘¬’Û–Õ¿‡
 * 
 * @author TangSiyi
 *
 */
public class MoonForm extends Form {
	public MoonForm() {
		// TODO Auto-generated constructor stub
		formation = Formation.MOON;
	}

	@Override
	public void form(Creature[][] ground, Scorpion scorpion, List<Minion> minions) {
		// TODO Auto-generated method stub
		minions.clear();
		for (int index = 0; index < 18; index++)
			minions.add(new Minion(index));
		scorpion.stand(ground, 6, 3);
		minions.get(0).stand(ground, 2, 8);
		minions.get(1).stand(ground, 3, 6);
		minions.get(2).stand(ground, 3, 7);
		minions.get(3).stand(ground, 4, 5);
		minions.get(4).stand(ground, 4, 6);
		minions.get(5).stand(ground, 5, 3);
		minions.get(6).stand(ground, 5, 4);
		minions.get(7).stand(ground, 5, 5);
		minions.get(8).stand(ground, 6, 4);
		minions.get(9).stand(ground, 6, 5);
		minions.get(10).stand(ground, 7, 3);
		minions.get(11).stand(ground, 7, 4);
		minions.get(12).stand(ground, 7, 5);
		minions.get(13).stand(ground, 8, 5);
		minions.get(14).stand(ground, 8, 6);
		minions.get(15).stand(ground, 9, 6);
		minions.get(16).stand(ground, 9, 7);
		minions.get(17).stand(ground, 10, 8);

	}

}
