package ModelTest;

import Model.Skill;
import Model.SkillImpl;
import Model.TypeSet;
import Model.Type;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;

/**
 * Class SkillTest has JUnit tests to test the methods of SkillImpl class
 */
public class SkillTest {
  private SkillImpl skill1, skill2;

  /**
   * Initializes 2 SkillImpl objects for further method testing.
   * Tests usability of the SkillImpl class constructor method
   */
  @Before
  public void setUp() {
    skill1 = new SkillImpl(new TypeSet(Type.WATER), "Hydropump", 120,
        0.0, 0.0, 0.9,
        0.0, 0.0, 0.0);
    skill2 = new SkillImpl(new TypeSet(Type.NORMAL), "Stat Mixer", 0,
        1.1, -0.9, 0.1,
        -0.442, 1.19, 0.0);
  }

  /**
   * Tests that the SkillImpl class constructor throws IllegalArgumentException when
   * provided a negative power value
   * @throws IllegalArgumentException when power value is negative
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructorError() throws IllegalArgumentException {
    new SkillImpl(new TypeSet(Type.WATER), "Hydropump", -120,
        0.0, 0.0, 0.9,
        0.0, 0.0, 0.0);
  }

  /**
   * Tests method getType() of the SkillImpl class
   */
  @Test
  public void testGetType() {
    Assert.assertEquals(Type.WATER, skill1.getType().getType());
    Assert.assertEquals(Type.NORMAL, skill2.getType().getType());
  }

  /**
   * Tests method getName() of the SkillImpl class
   */
  @Test
  public void testGetName() {
    Assert.assertEquals("Hydropump", skill1.getName());
    Assert.assertEquals("Stat Mixer", skill2.getName());
  }

  /**
   * Tests method getPower() of the SkillImpl class
   */
  @Test
  public void testGetPower() {
    Assert.assertEquals(120, skill1.getPower());
    Assert.assertEquals(0, skill2.getPower());
  }

  /**
   * Tests method getUserAttackChange() of the SkillImpl class
   */
  @Test
  public void testGetUserAttackChange() {
    Assert.assertEquals(0.0, skill1.getUserAttackChange(), 0.00001);
    Assert.assertEquals(1.1, skill2.getUserAttackChange(), 0.00001);
  }

  /**
   * Tests method getUserDefenseChange() of the SkillImpl class
   */
  @Test
  public void testGetUserDefenseChange() {
    Assert.assertEquals(0.0, skill1.getUserDefenseChange(), 0.00001);
    Assert.assertEquals(-0.9, skill2.getUserDefenseChange(), 0.00001);
  }

  /**
   * Tests method getUserSpeedChange() of the SkillImpl class
   */
  @Test
  public void testUserSpeedChange() {
    Assert.assertEquals(0.9, skill1.getUserSpeedChange(), 0.00001);
    Assert.assertEquals(0.1, skill2.getUserSpeedChange(), 0.00001);
  }

  /**
   * Tests method getEnemyAttackChange() of the SkillImpl class
   */
  @Test
  public void testGetEnemyAttackChange() {
    Assert.assertEquals(0.0, skill1.getEnemyAttackChange(), 0.00001);
    Assert.assertEquals(-0.442, skill2.getEnemyAttackChange(), 0.00001);
  }

  /**
   * Tests method getEnemyDefenseChange() of the SkillImpl class
   */
  @Test
  public void testGetEnemyDefenseChange() {
    Assert.assertEquals(0.0, skill1.getEnemyDefenseChange(), 0.00001);
    Assert.assertEquals(1.19, skill2.getEnemyDefenseChange(), 0.00001);
  }

  /**
   * Tests method getEnemySpeedChange() of the SkillImpl class
   */
  @Test
  public void testGetEnemySpeedChange() {
    Assert.assertEquals(0.0, skill1.getEnemySpeedChange(), 0.00001);
    Assert.assertEquals(0.0, skill2.getEnemySpeedChange(), 0.00001);
  }
}
