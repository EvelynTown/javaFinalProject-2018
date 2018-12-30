package formation;

import java.util.List;

import creatures.Creature;
import creatures.Minion;
import creatures.Scorpion;

/**
 * 
 * —„––’Û–Õ¿‡
 * 
 * @author TangSiyi
 *
 */
public class GooseForm extends Form {

	public GooseForm() {
		// TODO Auto-generated constructor stub
		formation = Formation.GOOSE;
	}

	@Override
	public void form(Creature[][] ground, Scorpion scorpion, List<Minion> minions) {
		// TODO Auto-generated method stub
		minions.clear();
		for (int index = 0; index < 6; index++)
			minions.add(new Minion(index));
		scorpion.stand(ground, 9, 3);
		minions.get(0).stand(ground, 8, 4);
		minions.get(1).stand(ground, 7, 5);
		minions.get(2).stand(ground, 6, 6);
		minions.get(3).stand(ground, 5, 7);
		minions.get(4).stand(ground, 4, 8);
		minions.get(5).stand(ground, 3, 9);
	}

}
