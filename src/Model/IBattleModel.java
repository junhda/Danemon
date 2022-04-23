package Model;

import java.util.ArrayList;

/**
 * Interface IBattleModel defines methods required for Battle Model classes.
 */
public interface IBattleModel {

  /**
   * Method getPlayer() returns the IPlayer object controlled by the user
   * @return IPlayer: object controlled by the user
   */
  public IPlayer getUser();

  /**
   * Method getEnemy() returns the IPlayer object controlled by computer
   * to combat the user.
   * @return IPlayer: object controlled by the computer
   */
  public IPlayer getEnemy();

  /**
   * Method getDifficulty() returns the difficulty setting for the Battle Game
   * @return int: Difficulty level
   */
  public int getDifficulty();

  /**
   * Method getMovePriority() returns an ordered ArrayList of Players that dictates which Player's
   * battling Pokemon attacks first and second
   * @return ArrayList<IPlayer>: order list of which IPlayer goes first then second
   * @throws IllegalStateException when isGameOver() == true
   */
  public ArrayList<IPlayer> getMovePriority()
      throws IllegalStateException;

  /**
   * Method performAction() has the IPlayer p battling Pokemon perform an attacking skill. Return
   * string list that captures the events that occur due to the attack
   * @param actor IPlayer: player whose Pookemon is to perform an attack
   * @param enemy IPlayer: player whose Pokemon is to be attacked
   * @param action Skill: attack skill to perform
   * @return ArrayList<String>: Responses as a result of the action being performed
   * @throws IllegalStateException when isGameOver() == true
   */
  public ArrayList<String> performAction(IPlayer actor, IPlayer enemy, Skill action) throws
      IllegalStateException;

  /**
   * Method isGameOver() determines if the battle is over and has been won, which
   * happens when one IPlayer's party has all fainted.
   * @return Boolean: true if a IPlayer has been eliminated, false if not
   */
  public boolean isGameOver();

  /**
   * Method getWinner() returns the IPlayer that won the battle.
   * @return IPlayer: IPlayer that won the battle
   * @throws IllegalStateException when isGameOver() == false
   */
  public IPlayer getWinner() throws IllegalStateException;
}
