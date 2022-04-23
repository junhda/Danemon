package Model.Skills;

import Model.Pokemon;
import Model.Type;
import Model.TypeSet;

public class Absorb extends AbstractSkill {
  public Absorb() {
    super(new TypeSet(Type.GRASS), "Absorb", 20);
  }

  @Override
  public void affectStats(Pokemon user, Pokemon enemy) {
    int maxUserHealth = user.getStatsSet().getHealth();
    int userHealth = user.getStatsSet().getCurrentHealth();
    int damage = this.damageCalc(user, enemy);
    user.getStatsSet().setCurrentHealth(Math.min(userHealth +
        (int)(damage * 0.1), maxUserHealth));
  }
}
