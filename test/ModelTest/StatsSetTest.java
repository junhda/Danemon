package ModelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import Model.StatsSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;

/**
 * Class StatsSetTest tests the methods of the StatsSet class
 */
public class StatsSetTest {
  private StatsSet t1, t2;

  /**
   * Sets up 2 TypeSet objects for method testing
   * Tests the Constructor method for StatsSet class
   */
  @Before
  public void setUp() {
    this.t1 = new StatsSet(100, 50, 40, 30);
    this.t2 = new StatsSet(30, 100, 0, 1000);
  }

  /**
   * Tests Constructor Method with explicit stat entries throws IllegalArgumentException
   * when supplied a negative health value
   * @throws IllegalArgumentException
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructorHealthError() throws IllegalArgumentException {
    new StatsSet(-1, 100, 100, 100);
  }

  /**
   * Tests Constructor Method with explicit stat entries throws IllegalArgumentException
   * when supplied a negative attack value
   * @throws IllegalArgumentException
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructorAttackError() throws IllegalArgumentException {
    new StatsSet(100, -10, 100, 100);
  }

  /**
   * Tests Constructor Method with explicit stat entries throws IllegalArgumentException
   * when supplied a negative defense value
   * @throws IllegalArgumentException
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructorDefenseError() throws IllegalArgumentException {
    new StatsSet(100, 100, -4, 100);
  }

  /**
   * Tests Constructor Method with explicit stat entries throws IllegalArgumentException
   * when supplied a negative speed value
   * @throws IllegalArgumentException
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructorSpeedError() throws IllegalArgumentException {
    new StatsSet(100, 100, 100, -100);
  }

  /**
   * Tests getHealth() method of StatsSet class
   */
  @Test
  public void testGetHealth() {
    Assert.assertEquals(100, t1.getHealth());
    Assert.assertEquals(30, t2.getHealth());
  }

  /**
   * Tests getCurrentHealth() method of StatsSet class
   */
  @Test
  public void testGetCurrentHealth() {
    Assert.assertEquals(100, t1.getCurrentHealth());
    Assert.assertEquals(30, t2.getCurrentHealth());
  }

  /**
   * Tests getAttack() method of StatsSet class
   */
  @Test
  public void testGetAttack() {
    Assert.assertEquals(50, t1.getAttack());
    Assert.assertEquals(100, t2.getAttack());
  }

  /**
   * Tests getCurrentAttack() method of StatsSet class
   */
  @Test
  public void testGetCurrentAttack() {
    Assert.assertEquals(50, t1.getCurrentAttack());
    Assert.assertEquals(100, t2.getCurrentAttack());
  }

  /**
   * Tests getDefense() method of StatsSet class
   */
  @Test
  public void testGetDefense() {
    Assert.assertEquals(40, t1.getDefense());
    Assert.assertEquals(0, t2.getDefense());
  }

  /**
   * Tests getCurrentDefense() method of StatsSet class
   */
  @Test
  public void testGetCurrentDefense() {
    Assert.assertEquals(40, t1.getCurrentDefense());
    Assert.assertEquals(0, t2.getCurrentDefense());
  }

  /**
   * Tests getSpeed() method of StatsSet class
   */
  @Test
  public void testGetSpeed() {
    Assert.assertEquals(30, t1.getSpeed());
    Assert.assertEquals(1000, t2.getSpeed());
  }

  /**
   * Tests getCurrentSpeed() method of StatsSet class
   */
  @Test
  public void testGetCurrentSpeed() {
    Assert.assertEquals(30, t1.getCurrentSpeed());
    Assert.assertEquals(1000, t2.getCurrentSpeed());
  }

  /**
   * Tests setCurrentHealth() method of the StatsSet class
   */
  @Test
  public void testSetCurrentHealth() {
    t1.setCurrentHealth(80);
    Assert.assertEquals(80, t1.getCurrentHealth());
    t2.setCurrentHealth(120);
    Assert.assertEquals(120, t2.getCurrentHealth());
    t1.setCurrentHealth(-20);
    Assert.assertEquals(0, t1.getCurrentHealth());
  }

  /**
   * Tests setCurrentAttack() method of the StatsSet class
   */
  @Test
  public void testSetCurrentAttack() {
    t1.setCurrentAttack(80);
    Assert.assertEquals(80, t1.getCurrentAttack());
    t2.setCurrentAttack(120);
    Assert.assertEquals(120, t2.getCurrentAttack());
    t1.setCurrentAttack(-20);
    Assert.assertEquals(0, t1.getCurrentAttack());
  }

  /**
   * Tests setCurrentDefense() method of the StatsSet class
   */
  @Test
  public void testSetCurrentDefense() {
    t1.setCurrentDefense(80);
    Assert.assertEquals(80, t1.getCurrentDefense());
    t2.setCurrentDefense(120);
    Assert.assertEquals(120, t2.getCurrentDefense());
    t1.setCurrentDefense(-20);
    Assert.assertEquals(0, t1.getCurrentDefense());
  }

  /**
   * Tests setCurrentSpeed() method of the StatsSet class
   */
  @Test
  public void testSetCurrentSpeed() {
    t1.setCurrentSpeed(80);
    Assert.assertEquals(80, t1.getCurrentSpeed());
    t2.setCurrentSpeed(120);
    Assert.assertEquals(120, t2.getCurrentSpeed());
    t1.setCurrentSpeed(-20);
    Assert.assertEquals(0, t1.getCurrentSpeed());
  }


  /**
   * Tests the StatsSet Constructor method that randomly assigns stat values.
   * Requires that the getter methods of the StatsSet class are properly functioning.
   */
  @Test
  public void testConstructorRandom() {
    StatsSet tester;
    // tests 100 iterations of random creation StatsSet
    for(int i = 100; i < 200; i++) {
      tester = new StatsSet(i);

      assertTrue(tester.getHealth() >= 100 * (i - 1));
      assertTrue(tester.getHealth() < 100 * (i - 1) + 100);
      assertTrue(tester.getCurrentHealth() >= 100 * (i - 1));
      assertTrue(tester.getCurrentHealth() < 100 * (i - 1) + 100);

      assertTrue(tester.getAttack() >= 100 * (i - 1));
      assertTrue(tester.getAttack() < 100 * (i - 1) + 100);
      assertTrue(tester.getCurrentAttack() >= 100 * (i - 1));
      assertTrue(tester.getCurrentAttack() < 100 * (i - 1) + 100);

      assertTrue(tester.getDefense() >= 100 * (i - 1));
      assertTrue(tester.getDefense() < 100 * (i - 1) + 100);
      assertTrue(tester.getCurrentDefense() >= 100 * (i - 1));
      assertTrue(tester.getCurrentDefense() < 100 * (i - 1) + 100);

      assertTrue(tester.getSpeed() >= 100 * (i - 1));
      assertTrue(tester.getSpeed() < 100 * (i - 1) + 100);
      assertTrue(tester.getCurrentSpeed() >= 100 * (i - 1));
      assertTrue(tester.getCurrentSpeed() < 100 * (i - 1) + 100);
    }
  }

  /**
   * Tests the StatsSet Constructor method that randomly assigns stat values
   * throws IllegalArgumentException when provided a non-positive parameter
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructorRandomError() throws IllegalArgumentException {
    new StatsSet(0);
  }
}
