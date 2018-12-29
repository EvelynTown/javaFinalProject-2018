package formation;

import java.util.List;

import creatures.Creature;
import creatures.Minion;
import creatures.Scorpion;

/**
 * 
 * ≥ÂÈÓ’Û–Õ¿‡
 * 
 * @author TangSiyi
 *
 */
public class YokeForm extends Form {
	public YokeForm() {
		// TODO Auto-generated constructor stub
		formation = Formation.YOKE;
	}

	@Override
	public void form(Creature[][] ground, Scorpion scorpion, List<Minion> minions) {
		// TODO Auto-generated method stub
		minions.clear();
		for (int index = 0; index < 8; index++)
			minions.add(new Minion(index));
		scorpion.stand(ground, 2, 8);
		minions.get(0).stand(ground, 3, 7);
		minions.get(1).stand(ground, 4, 8);
		minions.get(2).stand(ground, 5, 7);
		minions.get(3).stand(ground, 6, 8);
		minions.get(4).stand(ground, 7, 7);
		minions.get(5).stand(ground, 8, 8);
		minions.get(6).stand(ground, 9, 7);
		minions.get(7).stand(ground, 10, 8);

	}

}
