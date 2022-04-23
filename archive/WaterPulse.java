package Model.Skills;

import Model.Pokemon;
import Model.Type;
import Model.TypeSet;

public class WaterPulse extends AbstractSkill {
  public WaterPulse() {
    super(new TypeSet(Type.WATER), "WaterPulse", 60);
  }

  @Override
  public void affectStats(Pokemon user, Pokemon enemy) {
    int enemyDefense = enemy.getStatsSet().getCurrentDefense();
    enemy.getStatsSet().setCurrentDefense((int)(enemyDefense * 0.8));
  }
}
