package Model;

import java.util.Random;

/**
 * Class StatsSet defines a set of Health, Attack, Defense and Speed stats
 * for StatsSet objects
 */
public class StatsSet {
  private int health;
  private int attack;
  private int defense;
  private int speed;
  private int currentHealth;
  private int currentAttack;
  private int currentDefense;
  private int currentSpeed;

  /**
   * Constructor for the StatsSet class which takes in a scalar that acts
   * as an upper bound for randomly assigned health, attack, defense, and speed stats
   * @param scalar Int: upper bound for stat values
   * @throws IllegalArgumentException when scalar is <= 0
   */
  public StatsSet(int scalar) throws IllegalArgumentException {
    if(scalar <= 0) {
      throw new IllegalArgumentException("Requires a positive scalar parameter");
    }
    Random rand = new Random();
    //scalar will act as the upper bound for randomness
    this.health = 100 * (scalar - 1) + rand.nextInt(100);
    this.attack = 100 * (scalar - 1) + rand.nextInt(100);
    this.defense = 100 * (scalar - 1) + rand.nextInt(100);
    this.speed = 100 * (scalar - 1) + rand.nextInt(100);
    this.currentHealth = this.health;
    this.currentAttack = this.attack;
    this.currentDefense = this.defense;
    this.currentSpeed = this.speed;
  }

  /**
   * Constructor for the StatsSet class where each stat is specifically designated
   * @param health Int: health stat value
   * @param attack Int: attack stat value
   * @param defense Int: defense stat value
   * @param speed Int: speed stat value
   * @throws IllegalArgumentException when a supplied stat value is less than 0
   */
  public StatsSet(int health, int attack, int defense, int speed) throws IllegalArgumentException {
    if(health < 0 || attack < 0 || defense < 0 || speed < 0) {
      throw new IllegalArgumentException("Stats must be assigned a non-negative value");
    }
    this.health = health;
    this.attack = attack;
    this.defense = defense;
    this.speed = speed;
    this.currentHealth = this.health;
    this.currentAttack = this.attack;
    this.currentDefense = this.defense;
    this.currentSpeed = this.speed;
  }

  /**
   * Method getHealth() returns this object's health property
   * @return Int: health property
   */
  public int getHealth(){
    return this.health;
  }

  /**
   * Method getCurrentHealth() returns this object's currentHealth property
   * @return Int: currentHealth property
   */
  public int getCurrentHealth() {
    return this.currentHealth;
  }

  /**
   * Method getAttack() returns this object's attack property
   * @return Int: attack property
   */
  public int getAttack(){
    return this.attack;
  }

  /**
   * Method currentAttack() returns this object's currentAttack property
   * @return Int: currentAttack property
   */
  public int getCurrentAttack() {
    return this.currentAttack;
  }

  /**
   * Method getDefense() returns this object's defense property
   * @return Int: defense property
   */
  public int getDefense(){
    return this.defense;
  }

  /**
   * Method getCurrentDefense() returns this object's currentDefense property
   * @return Int: currentDefense property
   */
  public int getCurrentDefense() {
    return this.currentDefense;
  }

  /**
   * Method getSpeed() returns this object's speed property
   * @return Int: speed property
   */
  public int getSpeed(){
    return this.speed;
  }

  /**
   * Method getCurrentSpeed() returns this object's currentSpeed property
   * @return Int: currentSpeed property
   */
  public int getCurrentSpeed() {
    return this.currentSpeed;
  }

  // current stats setter methods

  /**
   * Method setCurrentHealth() sets this object's currentHealth property to
   * the input value
   * @param val Int: new currentHealth value
   */
  public void setCurrentHealth(int val) {
    if(val < 0) {
      val = 0;
    }
    this.currentHealth = val;
  }

  /**
   * Method setCurrentAttack() sets this object's currentAttack property to
   * the input value
   * @param val Int: new currentAttack value
   */
  public void setCurrentAttack(int val) {
    if(val < 0) {
      val = 0;
    }
    this.currentAttack = val;
  }

  /**
   * Method setCurrentDefense() sets this object's currentDefense property to
   * the input value
   * @param val Int: new currentDefense value
   */
  public void setCurrentDefense(int val) {
    if(val < 0) {
      val = 0;
    }
    this.currentDefense = val;
  }

  /**
   * Method setCurrentSpeed() sets this object's currentSpeed property to
   * the input value
   * @param val Int: new currentSpeed value
   */
  public void setCurrentSpeed(int val) {
    if(val < 0) {
      val = 0;
    }
    this.currentSpeed = val;
  }

  /**
   * Method statReset() resets this object's currentAttack, currentDefense,
   * and currentSpeed values to match the attack, defense, and speed values, respectively
   */
  public void statReset() {
    this.currentAttack = this.attack;
    this.currentDefense = this.defense;
    this.currentSpeed = this.speed;
  }
}
