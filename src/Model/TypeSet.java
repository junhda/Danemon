package Model;

import java.util.ArrayList;

public class TypeSet {
  private Type type;
  private ArrayList<Type> strength;
  private ArrayList<Type> weakness;

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

  public TypeSet(String type) {
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
    }
  }

  public Type getType() {
    return this.type;
  }

  public ArrayList<Type> getStrength() {
    return this.strength;
  }

  public ArrayList<Type> getWeakness() {
    return this.weakness;
  }
}
