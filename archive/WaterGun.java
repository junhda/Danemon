package Model.Skills;

import Model.Type;
import Model.TypeSet;

public class WaterGun extends AbstractSkill {
  public WaterGun() {
    super(new TypeSet(Type.WATER), "Water Gun", 40);
  }
}
