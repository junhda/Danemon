package Model.Skills;

import Model.Pokemon;
import Model.Type;
import Model.TypeSet;

public class ShockWave extends AbstractSkill {
  public ShockWave() {
    super(new TypeSet(Type.ELECTRIC), "Shock Wave", 60);
  }

  @Override
  public void affectStats(Pokemon user, Pokemon enemy) {
    int userAttack = user.getStatsSet().getCurrentAttack();
    user.getStatsSet().setCurrentAttack((int)(userAttack * 1.2));
  }
}
