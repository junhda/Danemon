package Model.Skills;

import Model.Pokemon;
import Model.Type;
import Model.TypeSet;

public class ScaryFace extends AbstractSkill {
  public ScaryFace() {
    super(new TypeSet(Type.NORMAL), "Scary Face", 0);
  }

  @Override
  public void affectStats(Pokemon user, Pokemon enemy) {
    int enemyAttack = enemy.getStatsSet().getCurrentAttack();
    enemy.getStatsSet().setCurrentAttack((int)(enemyAttack * 0.8));
  }
}
