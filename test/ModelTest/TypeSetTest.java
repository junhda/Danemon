package ModelTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import Model.TypeSet;
import Model.Type;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Class TypeSetTest contains JUnit tests for testing methods of the TypeSet class
 */
public class TypeSetTest {
  private TypeSet normal1, normal2, water1, water2, grass1, grass2, fire1, fire2,
      rock1, rock2, bug1, bug2, electric1, electric2;

  /**
   * Initialize TypeSet objects for further testing
   */
  @Before
  public void setUp() {
    this.normal1 = new TypeSet(Type.NORMAL);
    this.water1 = new TypeSet(Type.WATER);
    this.grass1 = new TypeSet(Type.GRASS);
    this.fire1 = new TypeSet(Type.FIRE);
    this.rock1 = new TypeSet(Type.ROCK);
    this.bug1 = new TypeSet(Type.BUG);
    this.electric1 = new TypeSet(Type.ELECTRIC);

    this.normal2 = new TypeSet("normal");
    this.water2 = new TypeSet("water");
    this.grass2 = new TypeSet("grass");
    this.fire2 = new TypeSet("fire");
    this.rock2 = new TypeSet("rock");
    this.bug2 = new TypeSet("bug");
    this.electric2 = new TypeSet("electric");
  }

  /**
   * Tests constructor method throws IllegalArgumentException when supplied an invalid type
   * @throws IllegalArgumentException when the input argument does not match an allowable type:
   *  normal, water, grass, fire, rock, electric, bug. This is case sensitive
   */
  @Test (expected = IllegalArgumentException.class)
  public void testStringConstructorNonValidType() throws IllegalArgumentException {
    new TypeSet("blue");
  }

  /**
   * Tests constructor method throws IllegalArgumentException when supplied a valid type with
   * incorrect case
   * @throws IllegalArgumentException when the input argument does not match an allowable type:
   *  normal, water, grass, fire, rock, electric, bug. This is case sensitive
   */
  @Test (expected = IllegalArgumentException.class)
  public void testStringConstructorCases() throws IllegalArgumentException {
    new TypeSet("Water");
  }

  /**
   * Tests the getType() method of the TypeSet class
   */
  @Test
  public void testGetType() {
    assertEquals(Type.NORMAL, normal1.getType());
    assertEquals(Type.NORMAL, normal2.getType());

    assertEquals(Type.WATER, water1.getType());
    assertEquals(Type.WATER, water2.getType());

    assertEquals(Type.FIRE, fire1.getType());
    assertEquals(Type.FIRE, fire2.getType());

    assertEquals(Type.GRASS, grass1.getType());
    assertEquals(Type.GRASS, grass2.getType());

    assertEquals(Type.ROCK, rock1.getType());
    assertEquals(Type.ROCK, rock2.getType());

    assertEquals(Type.BUG, bug1.getType());
    assertEquals(Type.BUG, bug2.getType());

    assertEquals(Type.ELECTRIC, electric1.getType());
    assertEquals(Type.ELECTRIC, electric2.getType());
  }

  /**
   * Tests the getStrength() method of the TypeSet class
   */
  @Test
  public void testGetStrength() {
    ArrayList<Type> normalStrength = new ArrayList<>();
    ArrayList<Type> waterStrength = new ArrayList<>();
    waterStrength.add(Type.FIRE);
    waterStrength.add(Type.ROCK);
    ArrayList<Type> grassStrength = new ArrayList<>();
    grassStrength.add(Type.WATER);
    grassStrength.add(Type.ROCK);
    ArrayList<Type> fireStrength = new ArrayList<>();
    fireStrength.add(Type.GRASS);
    fireStrength.add(Type.BUG);
    ArrayList<Type> rockStrength = new ArrayList<>();
    rockStrength.add(Type.FIRE);
    rockStrength.add(Type.BUG);
    rockStrength.add(Type.ELECTRIC);
    ArrayList<Type> bugStrength = new ArrayList<>();
    bugStrength.add(Type.GRASS);
    ArrayList<Type> electricStrength = new ArrayList<>();
    electricStrength.add(Type.WATER);

    //normal strengths
    for(int i = 0; i < normal1.getStrength().size(); i++) {
      assertTrue(normalStrength.contains(normal1.getStrength().get(i)));
    }
    for(int i = 0; i < normal2.getStrength().size(); i++) {
      assertTrue(normalStrength.contains(normal2.getStrength().get(i)));
    }

    //water strengths
    for(int i = 0; i < water1.getStrength().size(); i++) {
      assertTrue(waterStrength.contains(water1.getStrength().get(i)));
    }
    for(int i = 0; i < water2.getStrength().size(); i++) {
      assertTrue(waterStrength.contains(water2.getStrength().get(i)));
    }

    //fire strengths
    for(int i = 0; i < fire1.getStrength().size(); i++) {
      assertTrue(fireStrength.contains(fire1.getStrength().get(i)));
    }
    for(int i = 0; i < fire2.getStrength().size(); i++) {
      assertTrue(fireStrength.contains(fire2.getStrength().get(i)));
    }

    //grass strengths
    for(int i = 0; i < grass1.getStrength().size(); i++) {
      assertTrue(grassStrength.contains(grass1.getStrength().get(i)));
    }
    for(int i = 0; i < grass2.getStrength().size(); i++) {
      assertTrue(grassStrength.contains(grass2.getStrength().get(i)));
    }

    //rock strengths
    for(int i = 0; i < rock1.getStrength().size(); i++) {
      assertTrue(rockStrength.contains(rock1.getStrength().get(i)));
    }
    for(int i = 0; i < rock2.getStrength().size(); i++) {
      assertTrue(rockStrength.contains(rock2.getStrength().get(i)));
    }

    //bug strengths
    for(int i = 0; i < bug1.getStrength().size(); i++) {
      assertTrue(bugStrength.contains(bug1.getStrength().get(i)));
    }
    for(int i = 0; i < bug2.getStrength().size(); i++) {
      assertTrue(bugStrength.contains(bug2.getStrength().get(i)));
    }

    //electric strengths
    for(int i = 0; i < electric1.getStrength().size(); i++) {
      assertTrue(electricStrength.contains(electric1.getStrength().get(i)));
    }
    for(int i = 0; i < electric2.getStrength().size(); i++) {
      assertTrue(electricStrength.contains(electric2.getStrength().get(i)));
    }
  }

  /**
   * Tests the getWeakness() method of the TypeSet class
   */
  @Test
  public void testGetWeakness() {
    ArrayList<Type> normalWeakness = new ArrayList<>();
    ArrayList<Type> waterWeakness = new ArrayList<>();
    waterWeakness.add(Type.GRASS);
    waterWeakness.add(Type.ELECTRIC);
    ArrayList<Type> grassWeakness = new ArrayList<>();
    grassWeakness.add(Type.FIRE);
    grassWeakness.add(Type.BUG);
    ArrayList<Type> fireWeakness = new ArrayList<>();
    fireWeakness.add(Type.WATER);
    fireWeakness.add(Type.ROCK);
    ArrayList<Type> rockWeakness = new ArrayList<>();
    rockWeakness.add(Type.WATER);
    rockWeakness.add(Type.GRASS);
    ArrayList<Type> bugWeakness = new ArrayList<>();
    bugWeakness.add(Type.ROCK);
    bugWeakness.add(Type.FIRE);
    ArrayList<Type> electricWeakness = new ArrayList<>();
    electricWeakness.add(Type.ROCK);

    //normal Weakness
    for(int i = 0; i < normal1.getWeakness().size(); i++) {
      assertTrue(normalWeakness.contains(normal1.getWeakness().get(i)));
    }
    for(int i = 0; i < normal2.getWeakness().size(); i++) {
      assertTrue(normalWeakness.contains(normal2.getWeakness().get(i)));
    }

    //water Weakness
    for(int i = 0; i < water1.getWeakness().size(); i++) {
      assertTrue(waterWeakness.contains(water1.getWeakness().get(i)));
    }
    for(int i = 0; i < water2.getWeakness().size(); i++) {
      assertTrue(waterWeakness.contains(water2.getWeakness().get(i)));
    }

    //fire Weakness
    for(int i = 0; i < fire1.getWeakness().size(); i++) {
      assertTrue(fireWeakness.contains(fire1.getWeakness().get(i)));
    }
    for(int i = 0; i < fire2.getWeakness().size(); i++) {
      assertTrue(fireWeakness.contains(fire2.getWeakness().get(i)));
    }

    //grass Weakness
    for(int i = 0; i < grass1.getWeakness().size(); i++) {
      assertTrue(grassWeakness.contains(grass1.getWeakness().get(i)));
    }
    for(int i = 0; i < grass2.getWeakness().size(); i++) {
      assertTrue(grassWeakness.contains(grass2.getWeakness().get(i)));
    }

    //rock Weakness
    for(int i = 0; i < rock1.getWeakness().size(); i++) {
      assertTrue(rockWeakness.contains(rock1.getWeakness().get(i)));
    }
    for(int i = 0; i < rock2.getWeakness().size(); i++) {
      assertTrue(rockWeakness.contains(rock2.getWeakness().get(i)));
    }

    //bug Weakness
    for(int i = 0; i < bug1.getWeakness().size(); i++) {
      assertTrue(bugWeakness.contains(bug1.getWeakness().get(i)));
    }
    for(int i = 0; i < bug2.getWeakness().size(); i++) {
      assertTrue(bugWeakness.contains(bug2.getWeakness().get(i)));
    }

    //electric Weakness
    for(int i = 0; i < electric1.getWeakness().size(); i++) {
      assertTrue(electricWeakness.contains(electric1.getWeakness().get(i)));
    }
    for(int i = 0; i < electric2.getWeakness().size(); i++) {
      assertTrue(electricWeakness.contains(electric2.getWeakness().get(i)));
    }
  }

}
