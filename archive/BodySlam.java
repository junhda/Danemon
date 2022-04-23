package Model.Skills;

import Model.Pokemon;
import Model.Type;
import Model.TypeSet;

public class BodySlam extends AbstractSkill {
  public BodySlam() {
    super(new TypeSet(Type.NORMAL), "Body Slam", 70);
  }
}
