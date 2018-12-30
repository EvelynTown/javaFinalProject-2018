package formation;

import java.util.List;

import creatures.Creature;
import creatures.Minion;
import creatures.Scorpion;

/**
 * 
 * ∑ΩÉ“’Û–Õ¿‡
 * 
 * @author TangSiyi
 *
 */
public class SquareForm extends Form {
	public SquareForm() {
		// TODO Auto-generated constructor stub
		formation = Formation.SQUARE;
	}

	@Override
	public void form(Creature[][] ground, Scorpion scorpion, List<Minion> minions) {
		// TODO Auto-generated method stub
		minions.clear();
		for (int index = 0; index < 7; index++)
			minions.add(new Minion(index));
		scorpion.stand(ground, 4, 7);
		minions.get(0).stand(ground, 5, 6);
		minions.get(1).stand(ground, 5, 8);
		minions.get(2).stand(ground, 6, 5);
		minions.get(3).stand(ground, 6, 9);
		minions.get(4).stand(ground, 7, 6);
		minions.get(5).stand(ground, 7, 8);
		minions.get(6).stand(ground, 8, 7);
	}

}
