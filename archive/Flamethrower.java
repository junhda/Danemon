package Model.Skills;

import Model.Type;
import Model.TypeSet;

public class Flamethrower extends AbstractSkill {
  public Flamethrower() {
    super(new TypeSet(Type.FIRE), "Flamethrower", 90);
  }
}
