package Model.Skills;

import Model.Pokemon;
import Model.Type;
import Model.TypeSet;

public class LeafBlade extends AbstractSkill {
  public LeafBlade() {
    super(new TypeSet(Type.GRASS), "Leaf Blade", 70);
  }

  @Override
  public void affectStats(Pokemon user, Pokemon enemy) {
    int userSpeed = user.getStatsSet().getCurrentSpeed();
    user.getStatsSet().setCurrentSpeed((int)(userSpeed * 1.2));
  }
}
