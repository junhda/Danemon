package Model.Skills;

import Model.Pokemon;
import Model.Type;
import Model.TypeSet;

public class StickyString extends AbstractSkill {
  public StickyString() {
    super(new TypeSet(Type.BUG), "Sticky String", 0);
  }

  @Override
  public void affectStats(Pokemon user, Pokemon enemy) {
    int enemySpeed = enemy.getStatsSet().getCurrentSpeed();
    enemy.getStatsSet().setCurrentSpeed((int)(enemySpeed * 1.2));
  }
}
