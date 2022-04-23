package Model;

import java.util.Random;

public class StatsSet {
  private int health;
  private int attack;
  private int defense;
  private int speed;
  private int currentHealth;
  private int currentAttack;
  private int currentDefense;
  private int currentSpeed;

  public StatsSet(int scalar) {
    Random rand = new Random();
    //scalar will act as the upper bound for randomness
    this.health = rand.nextInt(scalar);
    this.attack = rand.nextInt(scalar);
    this.defense = rand.nextInt(scalar);
    this.speed = rand.nextInt(scalar);

  }

  public StatsSet(int health, int attack, int defense, int speed) {
    this.health = health;
    this.attack = attack;
    this.defense = defense;
    this.speed = speed;
  }

  // property getter methods

  public int getHealth(){
    return this.health;
  }

  public int getCurrentHealth() {
    return this.currentHealth;
  }

  public int getAttack(){
    return this.attack;
  }

  public int getCurrentAttack() {
    return this.currentAttack;
  }

  public int getDefense(){
    return this.defense;
  }

  public int getCurrentDefense() {
    return this.currentDefense;
  }

  public int getSpeed(){
    return this.speed;
  }

  public int getCurrentSpeed() {
    return this.currentSpeed;
  }

  // current stats setter methods
  public void setCurrentHealth(int val) {
    this.currentHealth = val;
  }

  public void setCurrentAttack(int val) {
    this.currentAttack = val;
  }

  public void setCurrentDefense(int val) {
    this.currentDefense = val;
  }

  public void setCurrentSpeed(int val) {
    this.currentSpeed = val;
  }

  public void statReset() {
    this.currentAttack = this.attack;
    this.currentDefense = this.defense;
    this.currentSpeed = this.speed;
  }
}
