package ModelTest;

import Model.Battle;
import Model.IPlayer;
import Model.Player;
import Model.Pokemon;
import Model.PokemonImpl;
import Model.Skill;

import Model.Status;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;

/**
 * Class BattleTest contains JUnit tests for testing methods of the Battle class
 */
public class BattleTest {
  private Battle b1, b2, b3;

  /**
   * Initializes 3 Battle objects for further method testing
   */
  @Before
  public void setUp() {
    this.b1 = new Battle(1);
    this.b2 = new Battle(2);
    this.b3 = new Battle(3);
  }

  /**
   * Tests constructor method throws IllegalArgumentException when difficulty level < 1
   * @throws IllegalArgumentException when difficulty level < 1 or > 3
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructorArgErr1() throws IllegalArgumentException {
    new Battle(0);
  }

  /**
   * Tests constructor method throws IllegalArgumentException when difficulty level > 3
   * @throws IllegalArgumentException when difficulty level < 1 or > 3
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructorArgErr2() throws IllegalArgumentException {
    new Battle(4);
  }

  /**
   * Tests getDifficulty method of the Battle class
   */
  @Test
  public void testGetDifficulty() {
    Assert.assertEquals(1, b1.getDifficulty());
    Assert.assertEquals(2, b2.getDifficulty());
    Assert.assertEquals(3, b3.getDifficulty());
  }

  /**
   * Tests getUser() method of the Battle class. Also checks that the user Player has been
   * initialized with the correct level of Pokemon.
   */
  @Test
  public void testGetUser() {
    IPlayer user1 = b1.getUser();
    IPlayer user2 = b2.getUser();
    IPlayer user3 = b3.getUser();
    Assert.assertTrue(user1 instanceof Player);
    Assert.assertTrue(user2 instanceof Player);
    Assert.assertTrue(user3 instanceof Player);

    ArrayList<Pokemon> party1 = user1.getParty();
    ArrayList<Pokemon> party2 = user2.getParty();
    ArrayList<Pokemon> party3 = user3.getParty();

    // confirm that each party has 4 pokemon
    Assert.assertEquals(4, party1.size());
    Assert.assertEquals(4, party2.size());
    Assert.assertEquals(4, party3.size());

    for(Pokemon p : party1) {
      //confirm stat limits for b1's user's Pokemon
      Assert.assertTrue(p.getStatsSet().getHealth() >= 0);
      Assert.assertTrue(p.getStatsSet().getHealth() < 300);
      Assert.assertTrue(p.getStatsSet().getAttack() >= 0);
      Assert.assertTrue(p.getStatsSet().getAttack() < 300);
      Assert.assertTrue(p.getStatsSet().getDefense() >= 0);
      Assert.assertTrue(p.getStatsSet().getDefense() < 300);
      Assert.assertTrue(p.getStatsSet().getSpeed() >= 0);
      Assert.assertTrue(p.getStatsSet().getSpeed() < 300);
    }

    for(Pokemon p : party2) {
      //confirm stat limits for b2's user's Pokemon
      Assert.assertTrue(p.getStatsSet().getHealth() >= 0);
      Assert.assertTrue(p.getStatsSet().getHealth() < 200);
      Assert.assertTrue(p.getStatsSet().getAttack() >= 0);
      Assert.assertTrue(p.getStatsSet().getAttack() < 200);
      Assert.assertTrue(p.getStatsSet().getDefense() >= 0);
      Assert.assertTrue(p.getStatsSet().getDefense() < 200);
      Assert.assertTrue(p.getStatsSet().getSpeed() >= 0);
      Assert.assertTrue(p.getStatsSet().getSpeed() < 200);
    }

    for(Pokemon p : party3) {
      //confirm stat limits for b3's user's Pokemon
      Assert.assertTrue(p.getStatsSet().getHealth() >= 0);
      Assert.assertTrue(p.getStatsSet().getHealth() < 100);
      Assert.assertTrue(p.getStatsSet().getAttack() >= 0);
      Assert.assertTrue(p.getStatsSet().getAttack() < 100);
      Assert.assertTrue(p.getStatsSet().getDefense() >= 0);
      Assert.assertTrue(p.getStatsSet().getDefense() < 100);
      Assert.assertTrue(p.getStatsSet().getSpeed() >= 0);
      Assert.assertTrue(p.getStatsSet().getSpeed() < 100);
    }
  }

  /**
   * Tests getEnemy() method of the Battle class. Also checks that the enemy Player has been
   * initialized with the correct level of Pokemon.
   */
  @Test
  public void testGetEnemy() {
    IPlayer enemy1 = b1.getEnemy();
    IPlayer enemy2 = b2.getEnemy();
    IPlayer enemy3 = b3.getEnemy();
    Assert.assertTrue(enemy1 instanceof Player);
    Assert.assertTrue(enemy2 instanceof Player);
    Assert.assertTrue(enemy3 instanceof Player);

    ArrayList<Pokemon> party1 = enemy1.getParty();
    ArrayList<Pokemon> party2 = enemy2.getParty();
    ArrayList<Pokemon> party3 = enemy3.getParty();

    // confirm that each party has 4 pokemon
    Assert.assertEquals(4, party1.size());
    Assert.assertEquals(4, party2.size());
    Assert.assertEquals(4, party3.size());

    for(Pokemon p : party3) {
      //confirm stat limits for b3's enemy's Pokemon
      Assert.assertTrue(p.getStatsSet().getHealth() >= 0);
      Assert.assertTrue(p.getStatsSet().getHealth() < 300);
      Assert.assertTrue(p.getStatsSet().getAttack() >= 0);
      Assert.assertTrue(p.getStatsSet().getAttack() < 300);
      Assert.assertTrue(p.getStatsSet().getDefense() >= 0);
      Assert.assertTrue(p.getStatsSet().getDefense() < 300);
      Assert.assertTrue(p.getStatsSet().getSpeed() >= 0);
      Assert.assertTrue(p.getStatsSet().getSpeed() < 300);
    }

    for(Pokemon p : party2) {
      //confirm stat limits for b2's enemy's Pokemon
      Assert.assertTrue(p.getStatsSet().getHealth() >= 0);
      Assert.assertTrue(p.getStatsSet().getHealth() < 200);
      Assert.assertTrue(p.getStatsSet().getAttack() >= 0);
      Assert.assertTrue(p.getStatsSet().getAttack() < 200);
      Assert.assertTrue(p.getStatsSet().getDefense() >= 0);
      Assert.assertTrue(p.getStatsSet().getDefense() < 200);
      Assert.assertTrue(p.getStatsSet().getSpeed() >= 0);
      Assert.assertTrue(p.getStatsSet().getSpeed() < 200);
    }

    for(Pokemon p : party1) {
      //confirm stat limits for b1's enemy's Pokemon
      Assert.assertTrue(p.getStatsSet().getHealth() >= 0);
      Assert.assertTrue(p.getStatsSet().getHealth() < 100);
      Assert.assertTrue(p.getStatsSet().getAttack() >= 0);
      Assert.assertTrue(p.getStatsSet().getAttack() < 100);
      Assert.assertTrue(p.getStatsSet().getDefense() >= 0);
      Assert.assertTrue(p.getStatsSet().getDefense() < 100);
      Assert.assertTrue(p.getStatsSet().getSpeed() >= 0);
      Assert.assertTrue(p.getStatsSet().getSpeed() < 100);
    }
  }

  @Test
  public void testBattleStart() {
    //check that initially, neither player has a battling Pokemon
    Assert.assertEquals(null, b1.getUser().getBattlingPokemon());
    Assert.assertEquals(null, b1.getEnemy().getBattlingPokemon());
    Assert.assertEquals(null, b2.getUser().getBattlingPokemon());
    Assert.assertEquals(null, b2.getEnemy().getBattlingPokemon());
    Assert.assertEquals(null, b3.getUser().getBattlingPokemon());
    Assert.assertEquals(null, b3.getEnemy().getBattlingPokemon());

    ArrayList<String> battleStartOutput1 = b1.battleStart();
    ArrayList<String> battleStartOutput2 = b2.battleStart();
    ArrayList<String> battleStartOutput3 = b3.battleStart();

    //check that the correct Pokemon is now the battling Pokemon from each Player
    Pokemon user1Battling = b1.getUser().getParty().get(0);
    Pokemon enemy1Battling = b1.getEnemy().getParty().get(0);
    Pokemon user2Battling = b2.getUser().getParty().get(0);
    Pokemon enemy2Battling = b2.getEnemy().getParty().get(0);
    Pokemon user3Battling = b3.getUser().getParty().get(0);
    Pokemon enemy3Battling = b3.getEnemy().getParty().get(0);

    Assert.assertEquals(user1Battling, b1.getUser().getBattlingPokemon());
    Assert.assertEquals(enemy1Battling, b1.getEnemy().getBattlingPokemon());
    Assert.assertEquals(user2Battling, b2.getUser().getBattlingPokemon());
    Assert.assertEquals(enemy2Battling, b2.getEnemy().getBattlingPokemon());
    Assert.assertEquals(user3Battling, b3.getUser().getBattlingPokemon());
    Assert.assertEquals(enemy3Battling, b3.getEnemy().getBattlingPokemon());

    //check number of string results from battleStart()
    Assert.assertEquals(2, battleStartOutput1.size());
    Assert.assertEquals(2, battleStartOutput2.size());
    Assert.assertEquals(2, battleStartOutput3.size());

    //check strings that resulted from battleStart()
    Assert.assertEquals("Go " + user1Battling.getName() + "!", battleStartOutput1.get(0));
    Assert.assertEquals("Go " + enemy1Battling.getName() + "!", battleStartOutput1.get(1));
    Assert.assertEquals("Go " + user2Battling.getName() + "!", battleStartOutput2.get(0));
    Assert.assertEquals("Go " + enemy2Battling.getName() + "!", battleStartOutput2.get(1));
    Assert.assertEquals("Go " + user3Battling.getName() + "!", battleStartOutput3.get(0));
    Assert.assertEquals("Go " + enemy3Battling.getName() + "!", battleStartOutput3.get(1));
  }

  /**
   * Tests method getMovePriority() of the Battle class
   */
  @Test
  public void testGetMovePriority() {
    //start the battles and get the battling Pokemon
    b1.battleStart();
    b2.battleStart();
    b3.battleStart();
    Pokemon user1Battling = b1.getUser().getBattlingPokemon();
    Pokemon enemy1Battling = b1.getEnemy().getBattlingPokemon();
    Pokemon user2Battling = b2.getUser().getBattlingPokemon();
    Pokemon enemy2Battling = b2.getEnemy().getBattlingPokemon();
    Pokemon user3Battling = b3.getUser().getBattlingPokemon();
    Pokemon enemy3Battling = b3.getEnemy().getBattlingPokemon();

    //get the move priority lists
    ArrayList<IPlayer> b1Prio = b1.getMovePriority();
    ArrayList<IPlayer> b2Prio = b2.getMovePriority();
    ArrayList<IPlayer> b3Prio = b3.getMovePriority();

    //check that the Player priority is returned correctly based on each player's respective
    // battling Pokemon's currentSpeed stat
    if(user1Battling.getStatsSet().getCurrentSpeed() >=
        enemy1Battling.getStatsSet().getCurrentSpeed()) {
      Assert.assertEquals(b1.getUser(), b1Prio.get(0));
      Assert.assertEquals(b1.getEnemy(), b1Prio.get(1));
    } else {
      Assert.assertEquals(b1.getEnemy(), b1Prio.get(0));
      Assert.assertEquals(b1.getUser(), b1Prio.get(1));
    }

    if(user2Battling.getStatsSet().getCurrentSpeed() >=
        enemy2Battling.getStatsSet().getCurrentSpeed()) {
      Assert.assertEquals(b2.getUser(), b2Prio.get(0));
      Assert.assertEquals(b2.getEnemy(), b2Prio.get(1));
    } else {
      Assert.assertEquals(b2.getEnemy(), b2Prio.get(0));
      Assert.assertEquals(b2.getUser(), b2Prio.get(1));
    }

    if(user3Battling.getStatsSet().getCurrentSpeed() >=
        enemy3Battling.getStatsSet().getCurrentSpeed()) {
      Assert.assertEquals(b3.getUser(), b3Prio.get(0));
      Assert.assertEquals(b3.getEnemy(), b3Prio.get(1));
    } else {
      Assert.assertEquals(b3.getEnemy(), b3Prio.get(0));
      Assert.assertEquals(b3.getUser(), b3Prio.get(1));
    }
  }

  /**
   * Tests method isGameOver() method of the Battle class
   */
  @Test
  public void testIsGameOver() {
    //check that the games are not initially over
    Assert.assertFalse(b1.isGameOver());
    Assert.assertFalse(b2.isGameOver());
    Assert.assertFalse(b3.isGameOver());

    //start battles, still not over
    b1.battleStart();
    b2.battleStart();
    b3.battleStart();
    Assert.assertFalse(b1.isGameOver());
    Assert.assertFalse(b2.isGameOver());
    Assert.assertFalse(b3.isGameOver());

    //user has lost
    ArrayList<Pokemon> b1UserParty = b1.getUser().getParty();
    b1UserParty.get(0).setStatus(Status.FAINTED);
    b1UserParty.get(1).setStatus(Status.FAINTED);
    b1UserParty.get(2).setStatus(Status.FAINTED);
    b1UserParty.get(3).setStatus(Status.FAINTED);
    Assert.assertTrue(b1.isGameOver());

    //enemy has lost
    ArrayList<Pokemon> b2EnemyParty = b2.getEnemy().getParty();
    b2EnemyParty.get(0).setStatus(Status.FAINTED);
    b2EnemyParty.get(1).setStatus(Status.FAINTED);
    b2EnemyParty.get(2).setStatus(Status.FAINTED);
    b2EnemyParty.get(3).setStatus(Status.FAINTED);
    Assert.assertTrue(b2.isGameOver());
  }

  /**
   * Tests getWinner() method of the Battle class returns the correct winning Player
   */
  @Test
  public void testGetWinner() {
    b1.battleStart();
    b2.battleStart();
    b3.battleStart();
    //user has lost
    ArrayList<Pokemon> b1UserParty = b1.getUser().getParty();
    b1UserParty.get(0).setStatus(Status.FAINTED);
    b1UserParty.get(1).setStatus(Status.FAINTED);
    b1UserParty.get(2).setStatus(Status.FAINTED);
    b1UserParty.get(3).setStatus(Status.FAINTED);
    Assert.assertEquals(b1.getEnemy(), b1.getWinner());

    //enemy has lost
    ArrayList<Pokemon> b2EnemyParty = b2.getEnemy().getParty();
    b2EnemyParty.get(0).setStatus(Status.FAINTED);
    b2EnemyParty.get(1).setStatus(Status.FAINTED);
    b2EnemyParty.get(2).setStatus(Status.FAINTED);
    b2EnemyParty.get(3).setStatus(Status.FAINTED);
    Assert.assertEquals(b2.getUser(), b2.getWinner());
  }

  /**
   * Tests getWinner() method of the Battle class throws IllegalStateException
   * when the battle is not yet over
   * @throws IllegalStateException when isGameOver() == false
   */
  @Test (expected = IllegalStateException.class)
  public void testGetWinnerStateErr() throws IllegalStateException {
    b1.battleStart();
    b1.getWinner();
  }

  /**
   * Tests performAction() method of the Battle class throws IllegalStateException
   * when the battle is already over
   * @throws IllegalStateException when isGameOver() == true
   */
  @Test (expected = IllegalStateException.class)
  public void testPerformActionStateErr() throws IllegalStateException {
    b1.battleStart();
    //make user the loser
    ArrayList<Pokemon> b1UserParty = b1.getUser().getParty();
    b1UserParty.get(0).setStatus(Status.FAINTED);
    b1UserParty.get(1).setStatus(Status.FAINTED);
    b1UserParty.get(2).setStatus(Status.FAINTED);
    b1UserParty.get(3).setStatus(Status.FAINTED);

    b1.performAction(b1.getEnemy(), b1.getUser(), b1.getEnemy().getAttackSkills().get(0));
  }

  /**
   * Tests performAction() method of the Battle class. Looks at 3 potential cases:
   * 1: attack is performed, but enemy pokemon does not faint
   * 2: attack is performed, and the enemy pokemon faints
   * 3: attack is performed, enemy faints, and the game ends
   */
  @Test
  public void testPerformAction() {
    b1.battleStart();
    ArrayList<String> attack1 = b1.performAction(b1.getUser(), b1.getEnemy(),
        b1.getUser().getAttackSkills().get(0));

    //create the expected string outputs
    ArrayList<String> attack1Expected = new ArrayList<>();
    Skill attack1Skill = b1.getUser().getAttackSkills().get(0);
    //string for skill used
    attack1Expected.add(b1.getUser().getBattlingPokemon().getName() + " used " +
            b1.getUser().getAttackSkills().get(0).getName());
    //string if enemy pokemon fainted
    if(b1.getEnemy().getParty().get(0).getStatus() == Status.FAINTED) {
      attack1Expected.add(b1.getEnemy().getParty().get(0).getName() + " fainted.");
    }
    //strings for buff / debuff stats from attacking and attacked pokemon
    ArrayList<String> attack1UserStatChange = b1.getUser().getBattlingPokemon().statChange(
        attack1Skill.getUserAttackChange(), attack1Skill.getUserDefenseChange(),
        attack1Skill.getUserSpeedChange());
    attack1Expected.addAll(attack1UserStatChange);
    if(b1.getEnemy().getParty().get(0).getStatus() != Status.FAINTED) {
      ArrayList<String> attack1EnemyStatChange = b1.getEnemy().getBattlingPokemon().statChange(
          attack1Skill.getEnemyAttackChange(), attack1Skill.getEnemyDefenseChange(),
          attack1Skill.getEnemySpeedChange());
      attack1Expected.addAll(attack1EnemyStatChange);
    }

    //string if enemy pokemon fainted
    if(b1.getEnemy().getParty().get(0).getStatus() == Status.FAINTED) {
      attack1Expected.add("Come back " + b1.getEnemy().getParty().get(0).getName() + "!");
      attack1Expected.add("Go " + b1.getEnemy().getParty().get(1).getName() + "!");
    }

    //test attack1
    for(int i = 0; i < attack1.size(); i++) {
      Assert.assertEquals(attack1Expected.get(i), attack1.get(i));
      System.out.println("Expected: " + attack1Expected.get(i));
      System.out.println("Actual: " + attack1.get(i));
    }

    //set the enemy player to battling with their last Pokemon
    b1.getEnemy().getParty().get(0).setStatus(Status.FAINTED);
    b1.getEnemy().getParty().get(1).setStatus(Status.FAINTED);
    b1.getEnemy().getParty().get(2).setStatus(Status.FAINTED);

    //set battling pokemon to their last Pokemon
    b1.getEnemy().setNextBattlingPokemon();

    ArrayList<String> attack2 = b1.performAction(b1.getUser(), b1.getEnemy(),
        b1.getUser().getAttackSkills().get(0));

    //create the expected string outputs
    ArrayList<String> attack2Expected = new ArrayList<>();
    Skill attack2Skill = b1.getUser().getAttackSkills().get(0);
    //string for skill used
    attack2Expected.add(b1.getUser().getBattlingPokemon().getName() + " used " +
        attack2Skill.getName());
    //string if enemy pokemon fainted
    if(b1.getEnemy().getParty().get(3).getStatus() == Status.FAINTED) {
      attack2Expected.add(b1.getEnemy().getParty().get(3).getName() + " fainted.");
    }
    //strings for buff / debuff stats from attacking and attacked pokemon
    ArrayList<String> attack2UserStatChange = b1.getUser().getBattlingPokemon().statChange(
        attack2Skill.getUserAttackChange(), attack2Skill.getUserDefenseChange(),
        attack2Skill.getUserSpeedChange());
    attack2Expected.addAll(attack2UserStatChange);
    if(b1.getEnemy().getParty().get(3).getStatus() != Status.FAINTED) {
      ArrayList<String> attack2EnemyStatChange = b1.getEnemy().getBattlingPokemon().statChange(
          attack2Skill.getEnemyAttackChange(), attack2Skill.getEnemyDefenseChange(),
          attack2Skill.getEnemySpeedChange());
      attack2Expected.addAll(attack2EnemyStatChange);
    }

    //string if enemy pokemon fainted
    if(b1.getEnemy().getParty().get(3).getStatus() == Status.FAINTED) {
      attack2Expected.add("Congratulations, you've won!");
    }

    //test attack1
    for(int i = 0; i < attack2.size(); i++) {
      Assert.assertEquals(attack2Expected.get(i), attack2.get(i));
      System.out.println("Expected: " + attack2Expected.get(i));
      System.out.println("Actual: " + attack2.get(i));
    }
  }
}
