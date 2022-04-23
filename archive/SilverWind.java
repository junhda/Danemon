package Model.Skills;

import Model.Type;
import Model.TypeSet;

public class SilverWind extends AbstractSkill {
  public SilverWind() {
    super(new TypeSet(Type.BUG), "Silver Wind", 40);
  }
}
