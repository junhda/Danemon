package Model;

import java.util.ArrayList;

/**
 * Class TypeSet defines a Type, as well as which types that Type is strong and weak against
 */
public class TypeSet {
  private Type type;
  private ArrayList<Type> strength;
  private ArrayList<Type> weakness;

  /**
   * Constructor for the TypeSet class taking in a Type object
   * @param type Type: Type defining the TypeSet
   */
  public TypeSet(Type type) {
    this.type = type;
    this.strength = new ArrayList<>();
    this.weakness = new ArrayList<>();

    // add elements to strength and weakness lists
    if(type == Type.WATER) {
      // strengths
      this.strength.add(Type.FIRE);
      this.strength.add(Type.ROCK);
      //weaknesses
      this.weakness.add(Type.GRASS);
      this.weakness.add(Type.ELECTRIC);
    } else if(type == Type.GRASS) {
      // strengths
      this.strength.add(Type.WATER);
      this.strength.add(Type.ROCK);
      //weaknesses
      this.weakness.add(Type.FIRE);
      this.weakness.add(Type.BUG);
    } else if(type == Type.FIRE) {
      // strengths
      this.strength.add(Type.GRASS);
      this.strength.add(Type.BUG);
      //weaknesses
      this.weakness.add(Type.ROCK);
      this.weakness.add(Type.WATER);
    } else if(type == Type.ELECTRIC) {
      // strengths
      this.strength.add(Type.WATER);
      //weaknesses
      this.weakness.add(Type.ROCK);
    } else if(type == Type.ROCK) {
      // strengths
      this.strength.add(Type.FIRE);
      this.strength.add(Type.ELECTRIC);
      this.strength.add(Type.BUG);
      //weaknesses
      this.weakness.add(Type.GRASS);
      this.weakness.add(Type.WATER);
    } else if(type == Type.BUG) {
      // strengths
      this.strength.add(Type.GRASS);
      //weaknesses
      this.weakness.add(Type.ROCK);
      this.weakness.add(Type.FIRE);
    }
  }

  /**
   * Constructor for the TypeSet class taking in a String object (case sensitive)
   * @param type String: string representation of a type (case sensitive)
   * @throws IllegalArgumentException when the input argument does not match an allowable type:
   *  normal, water, grass, fire, rock, electric, bug. This is case sensitive
   */
  public TypeSet(String type) throws IllegalArgumentException {
    ArrayList<String> types = new ArrayList<>();
    types.add("normal");
    types.add("water");
    types.add("grass");
    types.add("fire");
    types.add("rock");
    types.add("electric");
    types.add("bug");

    if(!types.contains(type)) {
      throw new IllegalArgumentException("Please enter an available type");
    }
    this.strength = new ArrayList<>();
    this.weakness = new ArrayList<>();

    // add elements to strength and weakness lists
    if(type == "water") {
      this.type = Type.WATER;
      // strengths
      this.strength.add(Type.FIRE);
      this.strength.add(Type.ROCK);
      //weaknesses
      this.weakness.add(Type.GRASS);
      this.weakness.add(Type.ELECTRIC);
    } else if(type == "grass") {
      this.type = Type.GRASS;
      // strengths
      this.strength.add(Type.WATER);
      this.strength.add(Type.ROCK);
      //weaknesses
      this.weakness.add(Type.FIRE);
      this.weakness.add(Type.BUG);
    } else if(type == "fire") {
      this.type = Type.FIRE;
      // strengths
      this.strength.add(Type.GRASS);
      this.strength.add(Type.BUG);
      //weaknesses
      this.weakness.add(Type.ROCK);
      this.weakness.add(Type.WATER);
    } else if(type == "electric") {
      this.type = Type.ELECTRIC;
      // strengths
      this.strength.add(Type.WATER);
      //weaknesses
      this.weakness.add(Type.ROCK);
    } else if(type == "rock") {
      this.type = Type.ROCK;
      // strengths
      this.strength.add(Type.FIRE);
      this.strength.add(Type.ELECTRIC);
      this.strength.add(Type.BUG);
      //weaknesses
      this.weakness.add(Type.GRASS);
      this.weakness.add(Type.WATER);
    } else if(type == "bug") {
      this.type = Type.BUG;
      // strengths
      this.strength.add(Type.GRASS);
      //weaknesses
      this.weakness.add(Type.ROCK);
      this.weakness.add(Type.FIRE);
    } else if(type == "normal") {
      this.type = Type.NORMAL;
    }
  }

  /**
   * Method getType() returns the type property of this TypeSet
   * @return Type: type property of this TypeSet
   */
  public Type getType() {
    return this.type;
  }

  /**
   * Method getStrength() returns the strength property of this TypeSet
   * @return ArrayList<Type>: strength property of this TypeSet
   */
  public ArrayList<Type> getStrength() {
    ArrayList<Type> strengths = new ArrayList<>();
    for(Type t : this.strength) {
      strengths.add(t);
    }
    return strengths;
  }

  /**
   * Method getWeakness() returns the getWeakness property of this TypeSet
   * @return ArrayList<Type>: getWeakness property of this TypeSet
   */
  public ArrayList<Type> getWeakness() {
    ArrayList<Type> weaks = new ArrayList<>();
    for(Type t : this.weakness) {
      weaks.add(t);
    }
    return weaks;
  }
}
