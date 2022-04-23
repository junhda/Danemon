package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Class Player defines methods and properties inherited by all Player objects.
 */
public class Player implements IPlayer {
  private ArrayList<Pokemon> party;
  private Pokemon battlingPokemon;

  /**
   * Method createParty() creates an ArrayList of 4 Pokemon for a Player
   * to yse for battling. Level will dictate the upper bound for stats of the
   * Pokemon in the party
   * @param level int: Level parameter dictates potential strength of Pokemon
   * @return ArrayList<Pokemon> with 4 Pokemon objects
   */
  @Override
  public ArrayList<Pokemon> createParty(int level) {
    ArrayList<Pokemon> party = new ArrayList<>();
    Pokedex dex = new Pokedex();
    int pokedexSize = dex.getPokedex().size();
    Random rand = new Random();
    //create parties of 4 Pokemon
    HashMap<String, String> pokemonEntry;
    String name, type, image;
    for(int i = 0; i <= 4; i++) {
      // pokedex is 1 based index
      pokemonEntry = dex.getPokedex().get(rand.nextInt(pokedexSize) + 1);
      name = pokemonEntry.get("name");
      type = pokemonEntry.get("type");
      image = pokemonEntry.get("image");

      party.add(new PokemonImpl(name, new TypeSet(type), image, level));
    }

    return party;
  }

  /**
   * Constructor for the Player class.
   * Initializes Player's party with 4 distinct Pokemon objects, but does not yet set
   * the battling Pokemon
   * @param level
   */
  public Player(int level) {
    this.party = createParty(level);
//    this.setNextBattlingPokemon();
  }

  /**
   * Method getParty() returns a copy of the full ArrayList
   * of Pokemon of the Player
   * @return ArrayList<Pokemon> representing the Player's party
   */
  @Override
  public ArrayList<Pokemon> getParty() {
    return this.party;
  }

  /**
   * Method getActiveParty() returns a copy ArrayList
   * of the non-fainted Pokemon in the Player's party
   * @return ArrayList<Pokemon> of non-fainted Pokemon in the Player's party
   */
  @Override
  public ArrayList<Pokemon> getActiveParty() {
    ArrayList<Pokemon> activeParty = new ArrayList<>();
    for(Pokemon p : this.party) {
      if(p.getStatus() != Status.FAINTED) {
        activeParty.add(p);
      }
    }

    return activeParty;
  }

  /**
   * Method getBattlingPokemon() returns the Pokemon actively
   * battling for the Player
   * @return Pokemon: battling Pokemon
   */
  @Override
  public Pokemon getBattlingPokemon() {
    return this.battlingPokemon;
  }

  public ArrayList<Skill> getAttackSkills() throws IllegalStateException {
    if(!this.isAlive()) {
      throw new IllegalStateException("The Player has lost!");
    }
    return this.battlingPokemon.getSkillSet();
  }

  /**
   * Method setNextBattlingPokemon() updates the Player's battling Pokemon with
   * the next ready Pokemon in their party.
   * @return ArrayList<String>: list of String outputs of the actions that occurred.
   *  Potential outputs include withdrawing the previous battling Pokemon that fainted
   *  and releasing the next battling Pokemon
   * @throws IllegalStateException when the isAlive() == false
   */
  @Override
  public ArrayList<String> setNextBattlingPokemon() throws IllegalStateException {
    if(!this.isAlive()) {
      throw new IllegalStateException("The Player has lost!");
    }
    if(this.battlingPokemon.getStatus() != Status.FAINTED) {
      throw new IllegalStateException("The Battling Pokemon hasn't given up yet!");
    }

    ArrayList<String> output = new ArrayList<>();

    //find next available Pokemon in party for battle
    Pokemon nextBattler = null;
    int partyCount = 0;
    while(nextBattler == null && partyCount < this.party.size()) {
      if(this.party.get(partyCount).getStatus() == Status.HOLD) {
        nextBattler = this.party.get(partyCount);
      }
      partyCount++;
    }

    //update the battling pokemon property
    if(this.battlingPokemon == null) {
      nextBattler.setStatus(Status.BATTLING);
      this.battlingPokemon = nextBattler;
      output.add("Go " + this.battlingPokemon.getName() + "!");
    } else {
      // swap out Fainted battling Pokemon
      // "store" the battling pokemon
      output.add("Come back " + this.battlingPokemon.getName() + "!");

      // release the new battling pokemon
      nextBattler.setStatus(Status.BATTLING);
      this.battlingPokemon = nextBattler;
      output.add("Go " + this.battlingPokemon.getName() + "!");
    }

    return output;
  }

  /**
   * Method isAlive() checks if the IPlayer has a party with non-fainted Pokemon
   * @return boolean: true if there is at least 1 non fainted pokemon in the party
   *      else false
   */
  @Override
  public boolean isAlive() {
    int aliveCount = 0;
    for(Pokemon p : this.party) {
      if(p.getStatus() != Status.FAINTED) {
        aliveCount++;
      }
    }

    if(aliveCount > 0) {
      return true;
    } else {
      return false;
    }
  }

}
