package formation;

import java.util.List;

import creatures.Calabash;
import creatures.Creature;
import creatures.Grandpa;

/**
 * 
 * ≥§…ﬂ’Û–Õ¿‡
 * 
 * @author TangSiyi
 *
 */
public class SnakeForm extends Form {
	public SnakeForm() {
		// TODO Auto-generated constructor stub
		formation = Formation.SNAKE;
	}

	@Override
	public void form(Creature[][] ground, Grandpa grandpa, List<Calabash> calabashBrothers) {
		// TODO Auto-generated method stub
		calabashBrothers.get(0).stand(ground, 3, 1);
		calabashBrothers.get(1).stand(ground, 4, 1);
		calabashBrothers.get(2).stand(ground, 5, 1);
		calabashBrothers.get(3).stand(ground, 6, 1);
		calabashBrothers.get(4).stand(ground, 7, 1);
		calabashBrothers.get(5).stand(ground, 8, 1);
		calabashBrothers.get(6).stand(ground, 9, 1);
		grandpa.stand(ground, 6, 0);
	}

}
