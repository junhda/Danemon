package Model.Skills;

import Model.Pokemon;
import Model.Type;
import Model.TypeSet;

public class Megahorn extends AbstractSkill {
  public Megahorn() {
    super(new TypeSet(Type.BUG), "Megahorn", 110);
  }

  @Override
  public void affectStats(Pokemon user, Pokemon enemy) {
    int damage = this.damageCalc(user, enemy);
    user.takeDamage((int)(damage * 0.15));
  }
}
