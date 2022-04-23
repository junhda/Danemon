package Model.Skills;

import Model.Pokemon;
import Model.Type;
import Model.TypeSet;

public class Leer extends AbstractSkill {
  public Leer() {
    super(new TypeSet(Type.NORMAL), "Leer", 0);
  }

  @Override
  public void affectStats(Pokemon user, Pokemon enemy) {
    int enemyDefense = enemy.getStatsSet().getCurrentDefense();
    enemy.getStatsSet().setCurrentDefense((int)(enemyDefense * 0.8));
  }
}
