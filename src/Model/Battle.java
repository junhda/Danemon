package Model;
import java.util.ArrayList;

/**
 * Class Battle contains methods and properties related to Battle model objects.
 * Models a Pokemon battle.
 */
public class Battle implements IBattleModel {
  private IPlayer user;
  private IPlayer enemy;
  private int difficulty;

  /**
   * Constructor for the Battle class
   * @param level int: Difficulty level
   * @throws IllegalArgumentException when difficulty level < 0 or > 3
   */
  public Battle(int level) throws IllegalArgumentException {
    if(level < 1 || level > 3) {
      throw new IllegalArgumentException("Invalid difficulty setting");
    }
    this.difficulty = level;

    if(level == 1) {
      this.user = new Player(3);
      this.enemy = new Player(1);
    } else if(level == 2) {
      this.user = new Player(2);
      this.enemy = new Player(2);
    } else {
      this.user = new Player(1);
      this.enemy = new Player(3);
    }
  }

  /**
   * Method getUser() returns the IPlayer object controlled by the user
   * @return IPlayer: object controlled by the user
   */
  @Override
  public IPlayer getUser() {
    return this.user;
  }

  /**
   * Method getEnemy() returns the IPlayer object controlled by computer
   * to combat the user.
   * @return IPlayer: object controlled by the computer
   */
  @Override
  public IPlayer getEnemy() {
    return this.enemy;
  }

  /**
   * Method getDifficulty() returns the difficulty setting for the Battle Game
   * @return int: Difficulty level
   */
  @Override
  public int getDifficulty() {
    return this.difficulty;
  };

  /**
   * Method battleStart() initializes the battle by setting User and Enemy
   * players
   * @return
   */
  public ArrayList<String> battleStart() {
    ArrayList<String> output = new ArrayList<>();
    ArrayList<String> userOutput = this.user.setNextBattlingPokemon();
    ArrayList<String> enemyOutput = this.enemy.setNextBattlingPokemon();

    for(String s : userOutput) {
      output.add(s);
    }
    for(String s : enemyOutput) {
      output.add(s);
    }

    return output;
  }

  /**
   * Method getMovePriority() returns an ordered ArrayList of IPlayers that dictates which Player's
   * battling Pokemon attacks first and second
   * @return ArrayList<IPlayer>: order list of which IPlayer goes first then second
   * @throws IllegalStateException when isGameOver() == true
   */
  @Override
  public ArrayList<IPlayer> getMovePriority()
      throws IllegalStateException {
    if(this.isGameOver() == true) {
      throw new IllegalStateException("The battle is over!");
    }
    ArrayList<IPlayer> order = new ArrayList<>();
    int userPokemonSpeed = this.user.getBattlingPokemon().getStatsSet().getCurrentSpeed();
    int enemyPokemonSpeed = this.enemy.getBattlingPokemon().getStatsSet().getCurrentSpeed();

    if(userPokemonSpeed >= enemyPokemonSpeed) {
      order.add(this.user);
      order.add(this.enemy);
    } else {
      order.add(this.enemy);
      order.add(this.user);
    }

    return order;
  }

  /**
   * Method performAction() has the IPlayer p battling Pokemon perform an attacking skill. Return
   * string list that captures the events that occur due to the attack
   * @param actor IPlayer: player whose Pookemon is to perform an attack
   * @param enemy IPlayer: player whose Pokemon is to be attacked
   * @param action Skill: attack skill to perform
   * @return ArrayList<String>: Responses as a result of the action being performed
   * @throws IllegalStateException when isGameOver() == true
   */
  @Override
  public ArrayList<String> performAction(IPlayer actor, IPlayer enemy, Skill action) throws
      IllegalStateException {
    if(this.isGameOver() == true) {
      throw new IllegalStateException("The battle is over!");
    }
    ArrayList<String> strings = new ArrayList<>();

    //perform the action
    ArrayList<String> attack = actor.getBattlingPokemon().attack(action,
        enemy.getBattlingPokemon());

    //add action's string list to the output for return
    for(String s : attack) {
      strings.add(s);
    }

    // check if the game is now over. If so, announce the winner!
    // else, move on
    if(this.isGameOver() == true) {
      IPlayer winner = this.getWinner();
      if(winner.equals(this.user)) {
        strings.add("Congratulations, you've won!");
      } else {
        strings.add("You've lost! Better luck next time~");
      }
    } else {
      //check if enemy battling Pokemon is fainted. If so, have the enemy withdraw
      //and send out their next battling Pokemon
      if(enemy.getBattlingPokemon().getStatus() == Status.FAINTED) {
        ArrayList<String> nextPokemon = enemy.setNextBattlingPokemon();
        for(String s : nextPokemon) {
          strings.add(s);
        }
      }

    }

    return strings;
  }

  /**
   * Method isGameOver() determines if the battle is over and has been won, which
   * happens when one IPlayer's party has all fainted.
   * @return Boolean: true if a IPlayer has been eliminated, false if not
   */
  @Override
  public boolean isGameOver() {
    if(this.user.isAlive() == false || this.enemy.isAlive() == false) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Method getWinner() returns the IPlayer that won the battle.
   * @return IPlayer: IPlayer that won the battle
   * @throws IllegalStateException when isGameOver() == false
   */
  @Override
  public IPlayer getWinner() throws IllegalStateException {
    if(this.isGameOver() == false) {
      throw new IllegalStateException("The battle is not over!");
    }
    if(this.user.isAlive() == false) {
      return this.enemy;
    } else {
      return this.user;
    }
  }
}
