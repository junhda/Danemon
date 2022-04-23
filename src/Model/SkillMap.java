package Model;

import java.util.HashMap;

/**
 * Class SkillMap creates a Hashmap of the available Pokemon Skills broken out
 * by Type and then numbered on a 1-based index.
 */
final public class SkillMap {
  final private HashMap<Type, HashMap<Integer, Skill>> skillMap;

  /**
   * Constructor for the SkillMap class
   * Establishes Hashmap for all Pokemon Skills available
   */
  public SkillMap() {
    //init variables
    int skillCounter = 1;
    this.skillMap = new HashMap<>();

    //Normal Moves
    HashMap<Integer, Skill> normal = new HashMap<>();

    normal.put(skillCounter, new SkillImpl(new TypeSet(Type.NORMAL), "Tackle", 30,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
    skillCounter++;

    normal.put(skillCounter,  new SkillImpl(new TypeSet(Type.NORMAL), "Howl", 0,
        0.2, 0.0, 0.0, 0.0, 0.0, 0.0));
    skillCounter++;

    normal.put(skillCounter, new SkillImpl(new TypeSet(Type.NORMAL), "Leer", 0,
        0.0, 0.0, 0.0, 0.0, -0.2, 0.0));
    skillCounter++;

    normal.put(skillCounter, new SkillImpl(new TypeSet(Type.NORMAL), "Scary Face", 30,
        0.0, 0.0, 0.0, -0.2, 0.0, 0.0));
    skillCounter++;

    normal.put(skillCounter, new SkillImpl(new TypeSet(Type.NORMAL), "Tackle", 70,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
    skillCounter++;

    normal.put(skillCounter, new SkillImpl(new TypeSet(Type.NORMAL), "Harden", 30,
        0.0, 0.2, 0.0, 0.0, 0.0, 0.0));
//    skillCounter++;

    //Water Moves
    skillCounter = 1;

    HashMap<Integer, Skill> water = new HashMap<>();

    water.put(skillCounter, new SkillImpl(new TypeSet(Type.WATER), "Water Gun", 40,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
    skillCounter++;

    water.put(skillCounter, new SkillImpl(new TypeSet(Type.WATER), "Water Pulse", 60,
        0.0, 0.0, 0.0, 0.0, -0.2, 0.0));
//    skillCounter++;

    //Fire Moves
    skillCounter = 1;

    HashMap<Integer, Skill> fire = new HashMap<>();

    fire.put(skillCounter, new SkillImpl(new TypeSet(Type.FIRE), "Ember", 40,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
    skillCounter++;

    fire.put(skillCounter, new SkillImpl(new TypeSet(Type.FIRE), "Flamethrower", 90,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
//    skillCounter++;


    //Grass Moves
    skillCounter = 1;

    HashMap<Integer, Skill> grass = new HashMap<>();

    grass.put(skillCounter, new SkillImpl(new TypeSet(Type.GRASS), "Grass Knot", 30,
        0.0, 0.0, 0.0, 0.0, 0.0, -0.1));
    skillCounter++;

    grass.put(skillCounter, new SkillImpl(new TypeSet(Type.GRASS), "Leaf Blade", 70,
        0.0, 0.0, 0.2, 0.0, 0.0, 0.0));
//    skillCounter++;


    //Rock Moves
    skillCounter = 1;

    HashMap<Integer, Skill> rock = new HashMap<>();

    rock.put(skillCounter, new SkillImpl(new TypeSet(Type.ROCK), "Rock Throw", 30,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
    skillCounter++;

    rock.put(skillCounter, new SkillImpl(new TypeSet(Type.ROCK), "Earthquake", 100,
        0.0, -0.2, 0.0, 0.0, 0.0, 0.0));
//    skillCounter++;


    //Bug Moves
    skillCounter = 1;

    HashMap<Integer, Skill> bug = new HashMap<>();

    bug.put(skillCounter, new SkillImpl(new TypeSet(Type.BUG), "Silver Wind", 40,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
    skillCounter++;

    bug.put(skillCounter, new SkillImpl(new TypeSet(Type.BUG), "Megahorn", 110,
        -0.3, 0.0, 0.0, 0.0, 0.0, 0.0));
//    skillCounter++;

    //Electric Moves
    skillCounter = 1;

    HashMap<Integer, Skill> electric = new HashMap<>();

    electric.put(skillCounter, new SkillImpl(new TypeSet(Type.ELECTRIC), "Thundershock", 40,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
    skillCounter++;

    electric.put(skillCounter, new SkillImpl(new TypeSet(Type.ELECTRIC), "Shockwave", 60,
        0.2, 0.0, 0.0, 0.0, 0.0, 0.0));
//    skillCounter++;

    // add move hashmaps to skillmap
    this.skillMap.put(Type.NORMAL, normal);
    this.skillMap.put(Type.WATER, water);
    this.skillMap.put(Type.FIRE, fire);
    this.skillMap.put(Type.GRASS, grass);
    this.skillMap.put(Type.ROCK, rock);
    this.skillMap.put(Type.BUG, bug);
    this.skillMap.put(Type.ELECTRIC, electric);
  }

  /**
   * Method getSkillMap() returns the Hashmap of available Pokemon Skills
   * @return HashMap<Type, HashMap<Integer, Skill>>: hashmap of available Pokemon Skills
   */
  public HashMap<Type, HashMap<Integer, Skill>> getSkillMap() {
    return this.skillMap;
  }
}
