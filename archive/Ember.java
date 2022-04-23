package Model.Skills;

import Model.Type;
import Model.TypeSet;

public class Ember extends AbstractSkill {
  public Ember() {
    super(new TypeSet(Type.FIRE), "Ember", 40);
  }
}
