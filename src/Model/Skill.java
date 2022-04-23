package Model;

import Model.Pokemon;
import Model.TypeSet;
import java.util.ArrayList;

public interface Skill {

  /**
   * Method getType() returns the TypeSet associated with the Pokemon Skill
   * @return TypeSet: Type of the Skill
   */
  public TypeSet getType();

  /**
   * Method getName() returns the name property of the Pokemon Skill
   * @return String: name of the Skill
   */
  public String getName();

  /**
   * Method getPower() returns the power property of the Pokemon Skill
   * @return Int: power of the Skill
   */
  public int getPower();

  /**
   * Method getUserAttackChange() returns the userAttackChange property of the Pokemon Skill
   * @return Int: power of the Skill
   */
  public double getUserAttackChange();

  /**
   * Method getUserDefenseChange() returns the UserDefenseChange property of the Pokemon Skill
   * @return Int: power of the Skill
   */
  public double getUserDefenseChange();

  /**
   * Method getUserSpeedChange() returns the UserSpeedChange property of the Pokemon Skill
   * @return Int: power of the Skill
   */
  public double getUserSpeedChange();

  /**
   * Method getEnemyAttackChange() returns the EnemyAttackChange property of the Pokemon Skill
   * @return Int: power of the Skill
   */
  public double getEnemyAttackChange();

  /**
   * Method getEnemyDefenseChange() returns the EnemyDefenseChange property of the Pokemon Skill
   * @return Int: power of the Skill
   */
  public double getEnemyDefenseChange();

  /**
   * Method getEnemySpeedChange() returns the EnemySpeedChange property of the Pokemon Skill
   * @return Int: power of the Skill
   */
  public double getEnemySpeedChange();

//  /**
//   * Method damageCalc() returns a damage calculation of the Skill
//   * given the user Pokemon's attack, the enemy Pokemon's defense, and
//   * the type match-up between the Skill and the enemy Pokemon
//   * @param user Pokemon: user of the Skill
//   * @param enemy Pokemon: Pokemon getting attacked by the Skill
//   * @return Int: damage value of the Skill against the enemy Pokemon
//   */
//  public int damageCalc(Pokemon user, Pokemon enemy);
//
//  public void affectStats(Pokemon user, Pokemon enemy);

}
