package ModelTest;

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
 * Class PlayerTest include JUnit tests for testing methods of the Player class
 */
public class PlayerTest {
  private Player p1, p2, p3;

  /**
   * Initializes 3 Player objects for further method testing
   */
  @Before
  public void setUp() {
    p1 = new Player(1);
    p2 = new Player(2);
    p3 = new Player(3);
  }

  /**
   * Tests constructor method throws IllegalArgumentException when
   * provided Level < 1
   * @throws IllegalArgumentException when level < 1 or level > 3
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructorArgError1() throws IllegalArgumentException {
    new Player(0);
  }

  /**
   * Tests constructor method throws IllegalArgumentException when
   * provided Level > 3
   * @throws IllegalArgumentException when level < 1 or level > 3
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructorArgError2() throws IllegalArgumentException {
    new Player(4);
  }

  /**
   * Tests createParty() method of the Player class. This method is primarily used
   * as part of the Player object constructor. Testing this effectively tests the
   * constructor method.
   *
   * Requires an output of 4 distinct Pokemon objects - but does not require 4 distinct
   * Pokemon
   */
  @Test
  public void testCreateParty() {
    ArrayList<Pokemon> party1 = p1.createParty(1);
    ArrayList<Pokemon> party2 = p1.createParty(2);
    ArrayList<Pokemon> party3 = p1.createParty(3);

    Assert.assertEquals(4, party1.size());
    Assert.assertEquals(4, party2.size());
    Assert.assertEquals(4, party3.size());

    for(Pokemon p : party1) {
      System.out.println(p.getName());
      Assert.assertTrue(p.getStatsSet().getHealth() >= 0);
      Assert.assertTrue(p.getStatsSet().getHealth() < 100);
      Assert.assertTrue(p.getStatsSet().getAttack() >= 0);
      Assert.assertTrue(p.getStatsSet().getAttack() < 100);
      Assert.assertTrue(p.getStatsSet().getDefense() >= 0);
      Assert.assertTrue(p.getStatsSet().getDefense() < 100);
      Assert.assertTrue(p.getStatsSet().getSpeed() >= 0);
      Assert.assertTrue(p.getStatsSet().getSpeed() < 100);
    }
    System.out.println();
    for(Pokemon p : party2) {
      System.out.println(p.getName());
      Assert.assertTrue(p.getStatsSet().getHealth() >= 0);
      Assert.assertTrue(p.getStatsSet().getHealth() < 200);
      Assert.assertTrue(p.getStatsSet().getAttack() >= 0);
      Assert.assertTrue(p.getStatsSet().getAttack() < 200);
      Assert.assertTrue(p.getStatsSet().getDefense() >= 0);
      Assert.assertTrue(p.getStatsSet().getDefense() < 200);
      Assert.assertTrue(p.getStatsSet().getSpeed() >= 0);
      Assert.assertTrue(p.getStatsSet().getSpeed() < 200);
    }
    System.out.println();
    for(Pokemon p : party3) {
      System.out.println(p.getName());
      Assert.assertTrue(p.getStatsSet().getHealth() >= 0);
      Assert.assertTrue(p.getStatsSet().getHealth() < 300);
      Assert.assertTrue(p.getStatsSet().getAttack() >= 0);
      Assert.assertTrue(p.getStatsSet().getAttack() < 300);
      Assert.assertTrue(p.getStatsSet().getDefense() >= 0);
      Assert.assertTrue(p.getStatsSet().getDefense() < 300);
      Assert.assertTrue(p.getStatsSet().getSpeed() >= 0);
      Assert.assertTrue(p.getStatsSet().getSpeed() < 300);
    }
  }

  /**
   * Tests createParty() method throws IllegalArgumentException when
   * provided Level < 1
   * @throws IllegalArgumentException when level < 1 or level > 3
   */
  @Test (expected = IllegalArgumentException.class)
  public void testCreatePartyArgError1() throws IllegalArgumentException {
    p1.createParty(0);
  }

  /**
   * Tests createParty() method throws IllegalArgumentException when
   * provided Level > 3
   * @throws IllegalArgumentException when level < 1 or level > 3
   */
  @Test (expected = IllegalArgumentException.class)
  public void testCreatePartyArgError2() throws IllegalArgumentException {
    p1.createParty(4);
  }

  /**
   * Tests getParty() method of the Player class
   */
  @Test
  public void testGetParty() {
    ArrayList<Pokemon> party1 = p1.getParty();
    ArrayList<Pokemon> party2 = p2.getParty();
    ArrayList<Pokemon> party3 = p3.getParty();

    Assert.assertEquals(4, party1.size());
    Assert.assertEquals(4, party2.size());
    Assert.assertEquals(4, party3.size());

    for (Pokemon p : party1) {
      System.out.println(p.getName());
      Assert.assertTrue(p.getStatsSet().getHealth() >= 0);
      Assert.assertTrue(p.getStatsSet().getHealth() < 100);
      Assert.assertTrue(p.getStatsSet().getAttack() >= 0);
      Assert.assertTrue(p.getStatsSet().getAttack() < 100);
      Assert.assertTrue(p.getStatsSet().getDefense() >= 0);
      Assert.assertTrue(p.getStatsSet().getDefense() < 100);
      Assert.assertTrue(p.getStatsSet().getSpeed() >= 0);
      Assert.assertTrue(p.getStatsSet().getSpeed() < 100);
    }
    System.out.println();
    for (Pokemon p : party2) {
      System.out.println(p.getName());
      Assert.assertTrue(p.getStatsSet().getHealth() >= 0);
      Assert.assertTrue(p.getStatsSet().getHealth() < 200);
      Assert.assertTrue(p.getStatsSet().getAttack() >= 0);
      Assert.assertTrue(p.getStatsSet().getAttack() < 200);
      Assert.assertTrue(p.getStatsSet().getDefense() >= 0);
      Assert.assertTrue(p.getStatsSet().getDefense() < 200);
      Assert.assertTrue(p.getStatsSet().getSpeed() >= 0);
      Assert.assertTrue(p.getStatsSet().getSpeed() < 200);
    }
    System.out.println();
    for (Pokemon p : party3) {
      System.out.println(p.getName());
      Assert.assertTrue(p.getStatsSet().getHealth() >= 0);
      Assert.assertTrue(p.getStatsSet().getHealth() < 300);
      Assert.assertTrue(p.getStatsSet().getAttack() >= 0);
      Assert.assertTrue(p.getStatsSet().getAttack() < 300);
      Assert.assertTrue(p.getStatsSet().getDefense() >= 0);
      Assert.assertTrue(p.getStatsSet().getDefense() < 300);
      Assert.assertTrue(p.getStatsSet().getSpeed() >= 0);
      Assert.assertTrue(p.getStatsSet().getSpeed() < 300);
    }
  }

  /**
   * Tests that
   */
  @Test
  public void getActiveParty() {
    ArrayList<Pokemon> party1 = p1.getParty();
    ArrayList<Pokemon> party2 = p2.getParty();
    ArrayList<Pokemon> party3 = p3.getParty();

    party1.get(0).setStatus(Status.FAINTED);
    party1.get(1).setStatus(Status.FAINTED);

    party2.get(2).setStatus(Status.FAINTED);

    party3.get(0).setStatus(Status.FAINTED);
    party3.get(1).setStatus(Status.FAINTED);
    party3.get(2).setStatus(Status.FAINTED);
    party3.get(3).setStatus(Status.FAINTED);

    ArrayList<Pokemon> activeParty1 = p1.getActiveParty();
    ArrayList<Pokemon> activeParty2 = p2.getActiveParty();
    ArrayList<Pokemon> activeParty3 = p3.getActiveParty();

    Assert.assertEquals(2, activeParty1.size());
    Assert.assertEquals(3, activeParty2.size());
    Assert.assertEquals(0, activeParty3.size());

    Assert.assertEquals(party1.get(2), activeParty1.get(0));
    Assert.assertEquals(party1.get(3), activeParty1.get(1));

    Assert.assertEquals(party2.get(0), activeParty2.get(0));
    Assert.assertEquals(party2.get(1), activeParty2.get(1));
    Assert.assertEquals(party2.get(3), activeParty2.get(2));
  }

  /**
   * Tests isAlive() method of the Player class
   */
  @Test
  public void testIsAlive() {
    ArrayList<Pokemon> party1 = p1.getParty();
    ArrayList<Pokemon> party2 = p2.getParty();
    ArrayList<Pokemon> party3 = p3.getParty();

    party1.get(0).setStatus(Status.FAINTED);
    party1.get(1).setStatus(Status.FAINTED);

    party2.get(2).setStatus(Status.FAINTED);

    party3.get(0).setStatus(Status.FAINTED);
    party3.get(1).setStatus(Status.FAINTED);
    party3.get(2).setStatus(Status.FAINTED);
    party3.get(3).setStatus(Status.FAINTED);

    Assert.assertTrue(p1.isAlive());
    Assert.assertTrue(p2.isAlive());
    Assert.assertFalse(p3.isAlive());
  }

  /**
   * Tests both getBattlingPokemon() and setNextBattlingPokemon() methods of the Player class
   */
  @Test
  public void testSetNextBattlingPokemon() {
    ArrayList<Pokemon> party1 = p1.getParty();
    Assert.assertEquals(null, p1.getBattlingPokemon());
    p1.setNextBattlingPokemon();
    Assert.assertEquals(party1.get(0), p1.getBattlingPokemon());

    party1.get(0).setStatus(Status.FAINTED);
    party1.get(1).setStatus(Status.FAINTED);

    p1.setNextBattlingPokemon();
    Assert.assertEquals(party1.get(2), p1.getBattlingPokemon());
  }

  /**
   * Test setNextBattlingPokemon() method throws IllegalStateException when
   * the Player has already lost
   * @throws IllegalStateException when the isAlive() == false or when the current battling
   *  Pokemon has not fainted
   */
  @Test (expected = IllegalStateException.class)
  public void testSetNextBattlingPokemonStateErr1() throws IllegalStateException {
    ArrayList<Pokemon> party3 = p3.getParty();

    party3.get(0).setStatus(Status.FAINTED);
    party3.get(1).setStatus(Status.FAINTED);
    party3.get(2).setStatus(Status.FAINTED);
    party3.get(3).setStatus(Status.FAINTED);

    p3.setNextBattlingPokemon();
  }

  /**
   * Test setNextBattlingPokemon() method throws IllegalStateException when
   * the current Battling Pokemon has not yet fainted
   * @throws IllegalStateException when the isAlive() == false or when the current battling
   *  Pokemon has not fainted
   */
  @Test (expected = IllegalStateException.class)
  public void testSetNextBattlingPokemonStateErr2() throws IllegalStateException {
    ArrayList<Pokemon> party3 = p3.getParty();

    p3.setNextBattlingPokemon();
    p3.setNextBattlingPokemon();
  }

  /**
   * Tests method getAttackSkills() from Player class
   */
  @Test
  public void testGetAttackSkills() {
    ArrayList<Pokemon> party3 = p3.getParty();

    p3.setNextBattlingPokemon();
    ArrayList<Skill> attacks = p3.getAttackSkills();

    Assert.assertEquals(4, attacks.size());
    for(int i = 0; i < 4; i++) {
      Assert.assertEquals(party3.get(0).getSkillSet().get(i), attacks.get(i));
    }
  }

  /**
   * Tests method getAttackSkills() from Player class throws IllegalStateException
   * when the isAlive() == false
   * @throws IllegalStateException when the isAlive() == false
   */
  @Test (expected = IllegalStateException.class)
  public void testGetAttackSkillsStateErr() throws IllegalStateException {
    ArrayList<Pokemon> party3 = p3.getParty();

    party3.get(0).setStatus(Status.FAINTED);
    party3.get(1).setStatus(Status.FAINTED);
    party3.get(2).setStatus(Status.FAINTED);
    party3.get(3).setStatus(Status.FAINTED);

    p3.getAttackSkills();
  }
}
