package Model.Skills;

import Model.Pokemon;
import Model.Type;
import Model.TypeSet;

public class Tackle extends AbstractSkill {
  public Tackle() {
    super(new TypeSet(Type.NORMAL), "tackle", 30);
  }
}
