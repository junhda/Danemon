package Model.Skills;

import Model.Pokemon;
import Model.TypeSet;
import Model.Type;

public class Howl extends AbstractSkill {
  public Howl() {
    super(new TypeSet(Type.NORMAL), "Howl", 0);
  }

  @Override
  public void affectStats(Pokemon user, Pokemon enemy) {
    int userAttack = user.getStatsSet().getCurrentAttack();
    user.getStatsSet().setCurrentAttack((int)(userAttack * 1.2));
  }
}
