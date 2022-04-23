package Model.Skills;

import Model.Pokemon;
import Model.Type;
import Model.TypeSet;

public class Harden extends AbstractSkill {
  public Harden() {
    super(new TypeSet(Type.NORMAL), "Harden", 0);
  }

  @Override
  public void affectStats(Pokemon user, Pokemon enemy) {
    int userDefense = user.getStatsSet().getCurrentDefense();
    user.getStatsSet().setCurrentDefense((int)(userDefense * 1.2));
  }
}
