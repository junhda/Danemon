package ModelTest;

import Model.PokemonImpl;
import Model.Skill;
import Model.SkillImpl;
import Model.StatsSet;
import Model.Status;

import Model.Type;
import Model.TypeSet;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;

/**
 * Class PokemonTest includes JUnit tests for testing methods of the Pokemon class
 */
public class PokemonTest {
  private PokemonImpl p1, p2, p3;

  /**
   * Initializes Pokemon objects for further method testing.
   */
  @Before
  public void setUp() {
    ArrayList<Skill> skills = new ArrayList<>();
    skills.add(new SkillImpl(new TypeSet(Type.NORMAL), "Tackle", 30,
        0.0, 0.0, 0.0,
        0.0, 0.0, 0.0));
    skills.add(new SkillImpl(new TypeSet(Type.NORMAL), "Harden", 0,
        0.0, 0.2, 0.0,
        0.0, 0.0, 0.0));
    skills.add(new SkillImpl(new TypeSet(Type.GRASS), "Grass Knot", 30,
        0.0, 0.0, 0.0,
        0.0, 0.0, -0.1));
    skills.add(new SkillImpl(new TypeSet(Type.GRASS), "Leaf Blade", 70,
        0.0, 0.0, 0.2,
        0.0, 0.0, 0.0));

    StatsSet stats = new StatsSet(100, 80, 131, 42);
    this.p1 = new PokemonImpl("Bulbasaur", new TypeSet(Type.GRASS), stats,
        "/Users/dan/Documents/Documents/NORTHEASTERN/CS5004/CS5004_Final_Project/images/bulbasaur.png",
        skills);

    this.p2 = new PokemonImpl("Pikachu", new TypeSet("electric"), "/Users/dan/"
        + "Documents/Documents/NORTHEASTERN/CS5004/CS5004_Final_Project/images/pikachu.png",
        2);

    ArrayList<Skill> skills2 = new ArrayList<>();
    skills2.add(new SkillImpl(new TypeSet(Type.NORMAL), "Howl", 0,
        0.2, 0.0, 0.0,
        0.0, 0.0, 0.0));
    skills2.add(new SkillImpl(new TypeSet(Type.NORMAL), "Scary Face", 30,
        0.0, 0.0, 0.0,
        -0.2, 0.0, 0.0));
    skills2.add(new SkillImpl(new TypeSet(Type.NORMAL), "Leer", 0,
        0.0, 0.0, 0.0,
        0.0, -0.2, 0.0));
    skills2.add(new SkillImpl(new TypeSet(Type.FIRE), "Flamethrower", 90,
        0.0, 0.0, 0.0,
        0.0, 0.0, 0.0));

    StatsSet stats2 = new StatsSet(100, 100, 100, 100);
    this.p3 = new PokemonImpl("Charmander", new TypeSet(Type.FIRE), stats2,
        "/Users/dan/Documents/Documents/NORTHEASTERN/CS5004/"
            + "CS5004_Final_Project/images/charmander.png", skills2);
  }

  /**
   * Tests Constructor method throws IllegalArgumentException when provided indexScale
   * value < 1
   * @throws IllegalArgumentException when indexScale < 1 or indexScale > 3
   */
  @Test (expected = IllegalArgumentException.class)
  public void testContructorRandomError1() throws IllegalArgumentException {
    new PokemonImpl("Pikachu", new TypeSet("electric"), "/Users/dan/Documents/Documents/NORTHEASTERN/CS5004/CS5004_Final_Project/images/pikachu.png",
        0);
  }

  /**
   * Tests Constructor method throws IllegalArgumentException when provided indexScale
   * value < 1
   * @throws IllegalArgumentException when indexScale < 1 or indexScale > 3
   */
  @Test (expected = IllegalArgumentException.class)
  public void testContructorRandomError2() throws IllegalArgumentException {
    new PokemonImpl("Pikachu", new TypeSet("electric"), "/Users/dan/Documents/Documents/NORTHEASTERN/CS5004/CS5004_Final_Project/images/pikachu.png",
        4);
  }

  /**
   * Tests getName() method of the PokemonImpl class
   */
  @Test
  public void testGetName() {
    Assert.assertEquals("Bulbasaur", p1.getName());
    Assert.assertEquals("Pikachu", p2.getName());
  }

  /**
   * Tests getTypeSet() method of the PokemonImpl class
   */
  @Test
  public void testGetTypeSet() {
    Assert.assertEquals(Type.GRASS, p1.getTypeSet().getType());
    Assert.assertEquals(Type.ELECTRIC, p2.getTypeSet().getType());
  }

  /**
   * Tests getStatsSet() method of the PokemonImpl class
   */
  @Test
  public void testGetStatsSet() {
    //p1
    Assert.assertEquals(100, p1.getStatsSet().getCurrentHealth());
    Assert.assertEquals(80, p1.getStatsSet().getCurrentAttack());
    Assert.assertEquals(131, p1.getStatsSet().getCurrentDefense());
    Assert.assertEquals(42, p1.getStatsSet().getCurrentSpeed());

    //p2
    System.out.println(p2.getStatsSet().getCurrentHealth());
    Assert.assertTrue(p2.getStatsSet().getCurrentHealth() <= 2 * 100);
    Assert.assertTrue(p2.getStatsSet().getCurrentAttack() < 2 * 100);
    Assert.assertTrue(p2.getStatsSet().getCurrentDefense() < 2 * 100);
    Assert.assertTrue(p2.getStatsSet().getCurrentSpeed() < 2 * 100);
  }

  /**
   * Tests getStatus() method of the PokemonImpl class. By default,
   * Pokemon's status is hold.
   */
  @Test
  public void testGetStatus() {
    Assert.assertEquals(Status.HOLD, p1.getStatus());
    Assert.assertEquals(Status.HOLD, p2.getStatus());
  }

  /**
   * Tests getSkillSet() method of the PokemonImpl class
   */
  @Test
  public void testGetSkillSet() {
    //p1
    ArrayList<Skill> skills = new ArrayList<>();
    skills.add(new SkillImpl(new TypeSet(Type.NORMAL), "Tackle", 30,
        0.0, 0.0, 0.0,
        0.0, 0.0, 0.0));
    skills.add(new SkillImpl(new TypeSet(Type.NORMAL), "Harden", 0,
        0.0, 0.2, 0.0,
        0.0, 0.0, 0.0));
    skills.add(new SkillImpl(new TypeSet(Type.GRASS), "Grass Knot", 30,
        0.0, 0.0, 0.0,
        0.0, 0.0, -0.1));
    skills.add(new SkillImpl(new TypeSet(Type.GRASS), "Leaf Blade", 70,
        0.0, 0.0, 0.2,
        0.0, 0.0, 0.0));
    for(Skill sk : p1.getSkillSet()) {
      skills.remove(sk);
    }
    Assert.assertEquals(0, skills.size());

    //p2
    Assert.assertEquals(4, p2.getSkillSet().size());
    ArrayList<Type> types = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();
    for(Skill sk : p2.getSkillSet()) {
      if(!(types.contains(sk.getType().getType()))) {
        types.add(sk.getType().getType());
      }
      if(!(names.contains(sk.getName()))) {
        names.add(sk.getName());
      }
    }
    Assert.assertTrue(types.size() <= 2);
    Assert.assertEquals(4, names.size());
//    System.out.println(names);
  }

  /**
   * Tests method getImageURL() of class PokemonImpl
   */
  @Test
  public void testGetImageURL() {
    Assert.assertEquals("/Users/dan/Documents/Documents/NORTHEASTERN/"
            + "CS5004/CS5004_Final_Project/images/bulbasaur.png", p1.getImageURL());
    Assert.assertEquals("/Users/dan/Documents/Documents/NORTHEASTERN/CS5004/"
        + "CS5004_Final_Project/images/pikachu.png", p2.getImageURL());
  }

  /**
   * Tests method setStatus() of class PokemonImpl
   */
  @Test
  public void testSetStatus() {
    p1.setStatus(Status.BATTLING);
    p2.setStatus(Status.FAINTED);
    Assert.assertEquals(Status.BATTLING, p1.getStatus());
    Assert.assertEquals(Status.FAINTED, p2.getStatus());
  }

  /**
   * Tests method damageCalc() of class PokemonImpl. Tests cases where
   * no damage is done, typing matchup is neutral, typing matchup is strong, and
   * typing matchup is weak
   */
  @Test
  public void testDamageCalc() {
    p1.setStatus(Status.BATTLING);
    p3.setStatus(Status.BATTLING);
    int tackleDamage = (int)((double)30 * (double)((double)80 / (double)100));
//    System.out.println(tackleDamage);
    Assert.assertEquals(tackleDamage, p1.damageCalc(p1.getSkill("Tackle"), p3));

    int leafBladeDamage = (int)((double)70 * ((double)80 / (double)100) * 0.7);
    Assert.assertEquals(leafBladeDamage, p1.damageCalc(p1.getSkill("Leaf Blade"), p3));

    int flamethrowerDamage = (int)((double)90 * ((double)100 / (double)131) * 1.3);
    Assert.assertEquals(flamethrowerDamage, p3.damageCalc(p3.getSkill("Flamethrower"), p1));

    Assert.assertEquals(0, p1.damageCalc(p1.getSkill("Harden"), p3));
  }

  /**
   * Tests method damageCalc() of class PokemonImpl throws IllegalArgumentException
   * when supplied a Skill that the Pokemon does not have
   * @throws IllegalArgumentException when supplied a Skill that the Pokemon does not have
   */
  @Test (expected = IllegalArgumentException.class)
  public void testDamageCalcArgError() throws IllegalArgumentException {
    p1.setStatus(Status.BATTLING);
    p3.setStatus(Status.BATTLING);
    p3.damageCalc(p3.getSkill("Ember"), p1);
  }

  /**
   * Tests method damageCalc() of class PokemonImpl throws IllegalStateException
   * when the Pokemon involved are not battling
   * @throws IllegalStateException
   */
  @Test (expected = IllegalStateException.class)
  public void testDamageCalcStateError() throws IllegalStateException {
    p3.setStatus(Status.BATTLING);
    p3.damageCalc(p3.getSkill("Flamethrower"), p1);
  }

  /**
   * Tests method statChange() of class PokemonImpl
   */
  @Test
  public void testStatChange() {
    p1.setStatus(Status.BATTLING);
    p3.setStatus(Status.BATTLING);
    ArrayList<String> statChangeOutput1 = p1.statChange(0.1, 0.0,
        1.0);
    ArrayList<String> statChangeOutput2 = p3.statChange(-0.1, -0.5,
        -0.2);

    Assert.assertEquals((int)(80 * 1.1), p1.getStatsSet().getCurrentAttack());
    Assert.assertEquals(131, p1.getStatsSet().getCurrentDefense());
    Assert.assertEquals((int)(42 * 2.0), p1.getStatsSet().getCurrentSpeed());
    Assert.assertEquals(90, p3.getStatsSet().getCurrentAttack());
    Assert.assertEquals(50, p3.getStatsSet().getCurrentDefense());
    Assert.assertEquals(80, p3.getStatsSet().getCurrentSpeed());

    Assert.assertEquals("Bulbasaur's attack rose!", statChangeOutput1.get(0));
    Assert.assertEquals("Bulbasaur's speed rose!", statChangeOutput1.get(1));

    Assert.assertEquals("Charmander's attack fell!", statChangeOutput2.get(0));
    Assert.assertEquals("Charmander's defense fell!", statChangeOutput2.get(1));
    Assert.assertEquals("Charmander's speed fell!", statChangeOutput2.get(2));
  }

  /**
   * Tests method statChange() of class PokemonImpl throws IllegalStateException
   * when the Pokemon object is not battling
   * @throws IllegalStateException when this.status != Status.BATTLING
   */
  @Test (expected = IllegalStateException.class)
  public void testStatChangeStateError() throws IllegalStateException {
    p1.statChange(0.1, 0.0, 1.0);
  }

  /**
   * Tests method takeDamge() of the PokemonImpl class
   */
  @Test
  public void testTakeDamage() {
    p1.setStatus(Status.BATTLING);
    ArrayList<String> takeDamageOutput1 = p1.takeDamage(80);
    Assert.assertEquals(20, p1.getStatsSet().getCurrentHealth());

    ArrayList<String> takeDamageOutput2 = p1.takeDamage(50);
    Assert.assertEquals(0, p1.getStatsSet().getCurrentHealth());
    Assert.assertEquals(Status.FAINTED, p1.getStatus());

    Assert.assertEquals(0, takeDamageOutput1.size());
    Assert.assertEquals("Bulbasaur fainted.", takeDamageOutput2.get(0));
  }

  /**
   * Tests method takeDamge() of the PokemonImpl class throws IllegalArgumentException
   * when provided negative damage
   * @throws IllegalArgumentException when damage parameter < 0
   */
  @Test (expected = IllegalArgumentException.class)
  public void testTakeDamgeArgError() throws IllegalArgumentException {
    p1.setStatus(Status.BATTLING);
    ArrayList<String> takeDamageOutput1 = p1.takeDamage(-50);
  }

  /**
   * Tests method takeDamge() of the PokemonImpl class throws IllegalStateException
   * when the object does not have Battling status
   * @throws IllegalStateException when the Pokemon.status != Status.BATTLING
   */
  @Test (expected = IllegalStateException.class)
  public void testTakeDamageStateError() throws IllegalStateException {
    ArrayList<String> takeDamageOutput1 = p1.takeDamage(50);
  }

  /**
   * Tests method attack() of the PokemonImpl class
   */
  @Test
  public void testAttack() {
    p1.setStatus(Status.BATTLING);
    p3.setStatus(Status.BATTLING);
    int attack1Damage = p1.damageCalc(p1.getSkill("Leaf Blade"), p3);
    int attack2Damage = p3.damageCalc(p3.getSkill("Flamethrower"), p1);
    ArrayList<String> attack1 = p1.attack(p1.getSkill("Leaf Blade"), p3);
    ArrayList<String> attack2 = p3.attack(p3.getSkill("Flamethrower"), p1);

    Assert.assertEquals(100 - attack1Damage, p3.getStatsSet().getCurrentHealth());
    Assert.assertEquals(100 - attack2Damage, p1.getStatsSet().getCurrentHealth());
    Assert.assertEquals((int)(42 * 1.2), p1.getStatsSet().getCurrentSpeed());

    Assert.assertEquals(2, attack1.size());
    Assert.assertEquals(1, attack2.size());
    Assert.assertEquals("Bulbasaur used Leaf Blade", attack1.get(0));
    Assert.assertEquals("Bulbasaur's speed rose!", attack1.get(1));
    Assert.assertEquals("Charmander used Flamethrower", attack2.get(0));
  }

  /**
   * Tests method attack() of the PokemonImpl class throws IllegalArgumentException
   * when the input attack Skill is not in this.skills list
   * @throws IllegalArgumentException when the input attack Skill is not in this.skills list
   */
  @Test (expected = IllegalArgumentException.class)
  public void testAttackArgError() throws IllegalArgumentException {
    p1.setStatus(Status.BATTLING);
    p3.setStatus(Status.BATTLING);
    p1.attack(p1.getSkill("Water Gun"), p3);
  }

  /**
   * Tests method attack() of the PokemonImpl class throws IllegalStateException
   * when this or the enemy Pokemon are not Battling
   * @throws IllegalStateException when this or the enemy Pokemon are not Battling
   */
  @Test (expected = IllegalStateException.class)
  public void testAttackStateError() throws IllegalStateException {
    p1.attack(p1.getSkill("Tackle"), p3);
  }
}
