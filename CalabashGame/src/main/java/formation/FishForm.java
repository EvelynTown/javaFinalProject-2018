package formation;

import java.util.List;

import creatures.Creature;
import creatures.Minion;
import creatures.Scorpion;

/**
 * 
 * ”„¡€’Û–Õ¿‡
 * 
 * @author TangSiyi
 *
 */
public class FishForm extends Form {

	public FishForm() {
		// TODO Auto-generated constructor stub
		formation = Formation.FISH;
	}

	@Override
	public void form(Creature[][] ground, Scorpion scorpion, List<Minion> minions) {
		// TODO Auto-generated method stub
		minions.clear();
		for (int index = 0; index < 10; index++)
			minions.add(new Minion(index));
		scorpion.stand(ground, 4, 7);
		minions.get(0).stand(ground, 5, 8);
		minions.get(1).stand(ground, 6, 6);
		minions.get(2).stand(ground, 6, 7);
		minions.get(3).stand(ground, 6, 8);
		minions.get(4).stand(ground, 7, 5);
		minions.get(5).stand(ground, 7, 6);
		minions.get(6).stand(ground, 7, 7);
		minions.get(7).stand(ground, 7, 8);
		minions.get(8).stand(ground, 7, 9);
		minions.get(9).stand(ground, 8, 7);

	}

}
