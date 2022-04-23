package Model;
import java.util.HashMap;

/**
 * Class Pokedex creates a final Hashmap with the different varieties of
 * Pokemon that can be created
 * TODO: add image URLS
 */
final public class Pokedex {
  final private HashMap<Integer, HashMap<String, String>> pokedex;

  /**
   * Constructor for Pokedex class. Offers name, type, and url to a PNG
   * image for 14 different Pokemon.
   * Pokemon are numbered on a 1 based index.
   */
  public Pokedex() {
    // init variables
    int entryNumber = 1;
    this.pokedex = new HashMap<>();

    //pokemon 1 - Bulbasaur
    HashMap<String, String> bulbasaur = new HashMap<>();
    bulbasaur.put("name", "Bulbasaur");
    bulbasaur.put("type", "GRASS");
    bulbasaur.put("image", "");
    this.pokedex.put(entryNumber, bulbasaur);
    entryNumber++;

    //pokemon 2 - Charmander
    HashMap<String, String> charmander = new HashMap<>();
    charmander.put("name", "Charmander");
    charmander.put("type", "FIRE");
    charmander.put("image", "");
    this.pokedex.put(entryNumber, charmander);
    entryNumber++;

    //pokemon 3 - Squirtle
    HashMap<String, String> squirtle = new HashMap<>();
    squirtle.put("name", "Squirtle");
    squirtle.put("type", "WATER");
    squirtle.put("image", "");
    this.pokedex.put(entryNumber, squirtle);
    entryNumber++;

    //pokemon 4 - Pikachu
    HashMap<String, String> pikachu = new HashMap<>();
    pikachu.put("name", "Pikachu");
    pikachu.put("type", "ELECTRIC");
    pikachu.put("image", "");
    this.pokedex.put(entryNumber, pikachu);
    entryNumber++;

    //pokemon 5 - Geodude
    HashMap<String, String> geodude = new HashMap<>();
    geodude.put("name", "Geodude");
    geodude.put("type", "ROCK");
    geodude.put("image", "");
    this.pokedex.put(entryNumber, geodude);
    entryNumber++;

    //pokemon 6 - Jigglypuff
    HashMap<String, String> jigglypuff = new HashMap<>();
    jigglypuff.put("name", "Jigglypuff");
    jigglypuff.put("type", "NORMAL");
    jigglypuff.put("image", "");
    this.pokedex.put(entryNumber, jigglypuff);
    entryNumber++;

    //pokemon 7 - Butterfree
    HashMap<String, String> butterfree = new HashMap<>();
    butterfree.put("name", "Butterfree");
    butterfree.put("type", "BUG");
    butterfree.put("image", "");
    this.pokedex.put(entryNumber, butterfree);
    entryNumber++;

    //pokemon 8 - Scyther
    HashMap<String, String> scyther = new HashMap<>();
    scyther.put("name", "Scyther");
    scyther.put("type", "BUG");
    scyther.put("image", "");
    this.pokedex.put(entryNumber, scyther);
    entryNumber++;

    //pokemon 9 - Gyarados
    HashMap<String, String> gyarados = new HashMap<>();
    gyarados.put("name", "Gyarados");
    gyarados.put("type", "WATER");
    gyarados.put("image", "");
    this.pokedex.put(entryNumber, gyarados);
    entryNumber++;

    //pokemon 10 - Arcanine
    HashMap<String, String> arcanine = new HashMap<>();
    arcanine.put("name", "Arcanine");
    arcanine.put("type", "FIRE");
    arcanine.put("image", "");
    this.pokedex.put(entryNumber, arcanine);
    entryNumber++;

    //pokemon 11 - Jolteon
    HashMap<String, String> jolteon = new HashMap<>();
    jolteon.put("name", "Jolteon");
    jolteon.put("type", "ELECTRIC");
    jolteon.put("image", "");
    this.pokedex.put(entryNumber, jolteon);
    entryNumber++;

    //pokemon 12 - Vileplume
    HashMap<String, String> vileplume = new HashMap<>();
    vileplume.put("name", "Vileplume");
    vileplume.put("type", "GRASS");
    vileplume.put("image", "");
    this.pokedex.put(entryNumber, vileplume);
    entryNumber++;

    //pokemon 13 - Rhydon
    HashMap<String, String> rhydon = new HashMap<>();
    rhydon.put("name", "Rhydon");
    rhydon.put("type", "ROCK");
    rhydon.put("image", "");
    this.pokedex.put(entryNumber, rhydon);
    entryNumber++;

    //pokemon 14 - Snorlax
    HashMap<String, String> snorlax = new HashMap<>();
    snorlax.put("name", "Snorlax");
    snorlax.put("type", "NORMAL");
    snorlax.put("image", "");
    this.pokedex.put(entryNumber, snorlax);
//    entryNumber++;

  }

  /**
   * Method getPokedex() returns the Pokedex hashmap.
   * @return HashMap<Integer, HashMap<String, String>>: lsit of available Pokemon
   */
  public HashMap<Integer, HashMap<String, String>> getPokedex() {
    return this.pokedex;
  }
}
