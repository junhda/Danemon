package Model.Skills;

import Model.Type;
import Model.TypeSet;

public class RockThrow extends AbstractSkill {
  public RockThrow() {
    super(new TypeSet(Type.ROCK), "Rock Throw", 30);
  }
}
