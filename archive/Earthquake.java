package Model.Skills;

import Model.Type;
import Model.TypeSet;

public class Earthquake extends AbstractSkill {
  public Earthquake() {
    super(new TypeSet(Type.ROCK), "Earthquake", 100);
  }
}
