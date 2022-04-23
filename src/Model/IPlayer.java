package Model;

import java.util.ArrayList;

/**
 * IPlayer interface defines methods required in IPlayer classes.
 */
public interface IPlayer {

  /**
   * Method createParty() creates an ArrayList of 4 Pokemon for a Player
   * to yse for battling. Level will dictate the upper bound for stats of the
   * Pokemon in the party
   * @param level int: Level parameter dictates potential strength of Pokemon
   * @return ArrayList<Pokemon> with 4 Pokemon objects
   */
  public ArrayList<Pokemon> createParty(int level);

  /**
   * Method setNextBattlingPokemon() updates the Player's battling Pokemon with
   * the next ready Pokemon in their party.
   * @return ArrayList<String>: list of String outputs of the actions that occurred.
   *  Potential outputs include withdrawing the previous battling Pokemon that fainted
   *  and releasing the next battling Pokemon
   * @throws IllegalStateException when the isAlive() == false
   */
  public ArrayList<String> setNextBattlingPokemon() throws IllegalStateException;

  /**
   * Method getParty() returns a copy of the full ArrayList
   * of Pokemon of the Player
   * @return ArrayList<Pokemon> representing the Player's party
   */
  public ArrayList<Pokemon> getParty();

  /**
   * Method getActiveParty() returns a copy ArrayList
   * of the non-fainted Pokemon in the Player's party
   * @return ArrayList<Pokemon> of non-fainted Pokemon in the Player's party
   */
  public ArrayList<Pokemon> getActiveParty();

  /**
   * Method getBattlingPokemon() returns the Pokemon actively
   * battling for the Player
   * @return Pokemon: battling Pokemon
   */
  public Pokemon getBattlingPokemon();

  /**
   * Method getAttackSkills() returns the ArrayList of Skills of the battling Pokemon
   * @return ArrayList<Skill>: </Skill>ArrayList of Skills of the battling Pokemon
   * @throws IllegalStateException when the isAlive() == false
   */
  public ArrayList<Skill> getAttackSkills() throws IllegalStateException;

  /**
   * Method isAlive() checks if the IPlayer has a party with non-fainted Pokemon
   * @return boolean: true if there is at least 1 non fainted pokemon in the party
   *      else false
   */
  public boolean isAlive();
}
