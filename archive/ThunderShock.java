package Model.Skills;

import Model.Type;
import Model.TypeSet;

public class ThunderShock extends AbstractSkill {
  public ThunderShock() {
    super(new TypeSet(Type.ELECTRIC), "Thunder Shock", 40);
  }
}
