package Model;
import java.util.ArrayList;

public interface Pokemon {

  /**
   * Method getName() returns the name property of the Pokemon object
   * @return String: Pokemon name
   */
  public String getName();

  /**
   * Method getTypeSet() returns the TypeSet object property of the
   * Pokemon object
   * @return TypeSet: Pokemon TypeSet
   */
  public TypeSet getTypeSet();

  /**
   * Method getStatsSet() returns the StatsSet object property of the
   * Pokemon object
   * @return StatsSet: Pokemon StatsSet
   */
  public StatsSet getStatsSet();

  /**
   * Method getStatus() returns the Status property of the Pokemon object
   * @return Status: Pokemon Status
   */
  public Status getStatus();

  /**
   * Method getSkillSet() returns an ArrayList filled with the Skills
   * that the Pokemon object has
   * @return ArrayList<Skill>: list of Skill objects the Pokemon has
   */
  public ArrayList<Skill> getSkillSet();

  /**
   * Method getSkill() returns the Skill owned by the Pokemon with the matching
   * parameter skill name. If the Pokemon does not know that skill, return null
   * @param skill String: name of the skill to search for
   * @return Skill: skill with matching name as the input. Returns null if not found
   */
  public Skill getSkill(String skill);

  /**
   * Method getImageURL() returns the imageURL property of the Pokemon object
   * @return String: Pokemon Image URL
   */
  public String getImageURL();

  /**
   * Method setStatus() udpdates the Status property of the Pokemon object
   * to the parameter input value
   * @param s Status: status object for the Pokemon
   */
  public void setStatus(Status s);

  /**
   * Method damageCalc() calculates and returns an integer value for the damage that
   * this Pokemon would inflict on an enemy Pokemon using a given attack.
   * Damage considers the user attack, enemy defense, and type matching between the attack
   * Skill and the enemy Pokemon
   * @param attack Skill: attack to use against the enemy Pokemon
   * @param enemy Pokemon: Pokemon getting attacked by this Pokemon
   * @return Int: damage value this Pokemon inflicts to enemy Pokemon with the attack Skill
   * @throws IllegalStateException when the input attack Skill is not in this.skills list
   * @throws IllegalArgumentException when this or enemy Pokemon have status Status.FAINTED
   */
  public int damageCalc(Skill attack, Pokemon enemy) throws IllegalStateException,
      IllegalArgumentException;

  /**
   * Method statChange() applies stat changes to this Pokemon's currentStats.
   * Attack, defense, and speed stats may be affected.
   * @param attackChange double: percent change to this Pokemon's attack stat
   * @param defenseChange double: percent change to this Pokemon's defense stat
   * @param speedChange double: percent change to this Pokemon's speed stat
   * @return ArrayList<String>: list of String values that represent the stat changes that happened
   *    when running statChange()
   * @throws IllegalStateException when this Pokemon is not Battling
   */
  public ArrayList<String> statChange(double attackChange, double defenseChange,
      double speedChange) throws IllegalStateException;

  /**
   * Method attack() uses an attack Skill to inflict damage and apply stat buffs / debuffs
   * to this and the enemy Pokemon
   * @param attack Skill: attack Skill this Pokemon uses to attack
   * @param enemy Pokemon: enemy Pokemon struck by the attack Skill
   * @return ArrayList<String>: list of strings representing the actions that occur as a result
   *  of the attack. Potential items include: attack used, enemy pokemon has fainted,
   *  the user has been buffed / debuffed, or the enemy has been buffed / debuffed
   * @throws IllegalStateException when this or the enemy Pokemon are not Battling
   * @throws IllegalArgumentException when the input attack Skill is not in this.skills list
   */
  public ArrayList<String> attack(Skill attack, Pokemon enemy) throws IllegalArgumentException,
      IllegalStateException;

  /**
   * Method takeDamage() applies damage to this Pokemon. If the currentHealth of this Pokemon
   * goes down to 0, then the Pokemon's status changes to fainted
   * @param damage Int: amount of damage to do to this Pokemon
   * @return ArrayList<String>: list of Strings that represent actions that have occurred
   * @throws IllegalArgumentException when damage value is negative
   * @throws IllegalStateException when the Pokemon is not actively battling
   */
  public ArrayList<String> takeDamage(int damage) throws IllegalArgumentException,
      IllegalStateException;

}
