package ModelTest;

import Model.Skill;
import Model.SkillMap;
import Model.Type;
import Model.SkillImpl;

import Model.TypeSet;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;

/**
 * Class SkillMapTest tests the methods of the skillMap class
 */
public class SkillMapTest {
  private SkillMap map = new SkillMap();
  private ArrayList<SkillImpl> normalSkills = new ArrayList<>();
  private ArrayList<SkillImpl> waterSkills = new ArrayList<>();
  private ArrayList<SkillImpl> fireSkills = new ArrayList<>();
  private ArrayList<SkillImpl> grassSkills = new ArrayList<>();
  private ArrayList<SkillImpl> rockSkills = new ArrayList<>();
  private ArrayList<SkillImpl> bugSkills = new ArrayList<>();
  private ArrayList<SkillImpl> electricSkills = new ArrayList<>();

  /**
   * Sets up list of skills we expect to exist in the SkillMap into
   * ArrayLists for further method testing
   */
  @Before
  public void setUp() {
    SkillImpl tackle = new SkillImpl(new TypeSet(Type.NORMAL), "Tackle", 30,
        0.0, 0.0, 0.0,
        0.0, 0.0, 0.0);
    SkillImpl howl = new SkillImpl(new TypeSet(Type.NORMAL), "Howl", 0,
        0.2, 0.0, 0.0,
        0.0, 0.0, 0.0);
    SkillImpl leer = new SkillImpl(new TypeSet(Type.NORMAL), "Leer", 0,
        0.0, 0.0, 0.0,
        0.0, -0.2, 0.0);
    SkillImpl scaryFace = new SkillImpl(new TypeSet(Type.NORMAL), "Scary Face", 0,
        0.0, 0.0, 0.0,
        -0.2, 0.0, 0.0);
    SkillImpl bodySlam = new SkillImpl(new TypeSet(Type.NORMAL), "Body Slam", 70,
        0.0, 0.0, 0.0,
        0.0, 0.0, 0.0);
    SkillImpl harden = new SkillImpl(new TypeSet(Type.NORMAL), "Harden", 0,
        0.0, 0.2, 0.0,
        0.0, 0.0, 0.0);
    SkillImpl waterGun = new SkillImpl(new TypeSet(Type.WATER), "Water Gun", 40,
        0.0, 0.0, 0.0,
        0.0, 0.0, 0.0);
    SkillImpl waterPulse = new SkillImpl(new TypeSet(Type.WATER), "Water Pulse", 60,
        0.0, 0.0, 0.0,
        0.0, -0.2, 0.0);
    SkillImpl ember = new SkillImpl(new TypeSet(Type.FIRE), "Ember", 40,
        0.0, 0.0, 0.0,
        0.0, 0.0, 0.0);
    SkillImpl flamethrower = new SkillImpl(new TypeSet(Type.FIRE), "Flamethrower", 90,
        0.0, 0.0, 0.0,
        0.0, 0.0, 0.0);
    SkillImpl grassKnot = new SkillImpl(new TypeSet(Type.GRASS), "Grass Knot", 30,
        0.0, 0.0, 0.0,
        0.0, 0.0, -0.1);
    SkillImpl leafBlade = new SkillImpl(new TypeSet(Type.GRASS), "Leaf Blade", 70,
        0.0, 0.0, 0.2,
        0.0, 0.0, 0.0);
    SkillImpl rockThrow = new SkillImpl(new TypeSet(Type.ROCK), "Rock Throw", 30,
        0.0, 0.0, 0.0,
        0.0, 0.0, 0.0);
    SkillImpl earthquake = new SkillImpl(new TypeSet(Type.ROCK), "Earthquake", 100,
        0.0, -0.2, 0.0,
        0.0, 0.0, 0.0);
    SkillImpl silverWind = new SkillImpl(new TypeSet(Type.BUG), "Silver Wind", 40,
        0.0, 0.0, 0.0,
        0.0, 0.0, 0.0);
    SkillImpl megahorn = new SkillImpl(new TypeSet(Type.BUG), "Megahorn", 110,
        -0.3, 0.0, 0.0,
        0.0, 0.0, 0.0);
    SkillImpl thundershock = new SkillImpl(new TypeSet(Type.ELECTRIC), "Thundershock", 40,
        0.0, 0.0, 0.0,
        0.0, 0.0, 0.0);
    SkillImpl shockwave = new SkillImpl(new TypeSet(Type.ELECTRIC), "Shockwave", 60,
        0.2, 0.0, 0.0,
        0.0, 0.0, 0.0);
    normalSkills.add(tackle);
    normalSkills.add(howl);
    normalSkills.add(leer);
    normalSkills.add(scaryFace);
    normalSkills.add(bodySlam);
    normalSkills.add(harden);
    waterSkills.add(waterGun);
    waterSkills.add(waterPulse);
    fireSkills.add(ember);
    fireSkills.add(flamethrower);
    grassSkills.add(grassKnot);
    grassSkills.add(leafBlade);
    rockSkills.add(rockThrow);
    rockSkills.add(earthquake);
    bugSkills.add(silverWind);
    bugSkills.add(megahorn);
    electricSkills.add(thundershock);
    electricSkills.add(shockwave);
  }
  /**
   * Tests method getSkillMap() of the SkillMap class.
   * Also effectively tests the construction of the SkillMap's
   * skillmap property
   */
  @Test
  public void testGetSkillMap() {
    HashMap<Type, HashMap<Integer, Skill>> skillMap = this.map.getSkillMap();
    //normal moves
    Assert.assertEquals(6, this.normalSkills.size());
    for(int i = 1; i <= skillMap.get(Type.NORMAL).size(); i++) {
      this.normalSkills.remove(skillMap.get(Type.NORMAL).get(i));
    }
    Assert.assertEquals(0, this.normalSkills.size());

    //water moves
    Assert.assertEquals(2, this.waterSkills.size());
    for(int i = 1; i <= skillMap.get(Type.WATER).size(); i++) {
      this.waterSkills.remove(skillMap.get(Type.WATER).get(i));
    }
    Assert.assertEquals(0, this.waterSkills.size());

    //fire moves
    Assert.assertEquals(2, this.fireSkills.size());
    for(int i = 1; i <= skillMap.get(Type.FIRE).size(); i++) {
      this.fireSkills.remove(skillMap.get(Type.FIRE).get(i));
    }
    Assert.assertEquals(0, this.fireSkills.size());

    //grass moves
    Assert.assertEquals(2, this.grassSkills.size());
    for(int i = 1; i <= skillMap.get(Type.GRASS).size(); i++) {
      this.grassSkills.remove(skillMap.get(Type.GRASS).get(i));
    }
    Assert.assertEquals(0, this.grassSkills.size());

    //rock moves
    Assert.assertEquals(2, this.rockSkills.size());
    for(int i = 1; i <= skillMap.get(Type.ROCK).size(); i++) {
      this.rockSkills.remove(skillMap.get(Type.ROCK).get(i));
    }
    Assert.assertEquals(0, this.rockSkills.size());

    //bug moves
    Assert.assertEquals(2, this.bugSkills.size());
    for(int i = 1; i <= skillMap.get(Type.BUG).size(); i++) {
      this.bugSkills.remove(skillMap.get(Type.BUG).get(i));
    }
    Assert.assertEquals(0, this.bugSkills.size());

    //electric moves
    Assert.assertEquals(2, this.electricSkills.size());
    for(int i = 1; i <= skillMap.get(Type.ELECTRIC).size(); i++) {
      this.electricSkills.remove(skillMap.get(Type.ELECTRIC).get(i));
    }
    Assert.assertEquals(0, this.electricSkills.size());
  }
}
