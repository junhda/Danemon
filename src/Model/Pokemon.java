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

  public ArrayList<String> takeDamage(int damage) throws IllegalArgumentException,
      IllegalStateException;

}
