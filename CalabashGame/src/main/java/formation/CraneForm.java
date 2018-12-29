package formation;

import java.util.List;

import creatures.Creature;
import creatures.Minion;
import creatures.Scorpion;

/**
 * 
 * ∫◊“Ì’Û–Õ¿‡
 * 
 * @author TangSiyi
 *
 */
public class CraneForm extends Form {

	public CraneForm() {
		// TODO Auto-generated constructor stub
		formation = Formation.CRANE;
	}

	@Override
	public void form(Creature[][] ground, Scorpion scorpion, List<Minion> minions) {
		// TODO Auto-generated method stub
		minions.clear();
		for (int index = 0; index < 6; index++)
			minions.add(new Minion(index));
		scorpion.stand(ground, 8, 6);
		minions.get(0).stand(ground, 5, 3);
		minions.get(1).stand(ground, 6, 4);
		minions.get(2).stand(ground, 7, 5);
		minions.get(3).stand(ground, 7, 7);
		minions.get(4).stand(ground, 6, 8);
		minions.get(5).stand(ground, 5, 9);

	}

}
