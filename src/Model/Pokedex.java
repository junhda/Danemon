package Model;
import java.util.HashMap;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

/**
 * Class Pokedex creates a final Hashmap with the different varieties of
 * Pokemon that can be created
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
    File thisFile = new File("Pokedex.java");
    Path p1 = Paths.get(thisFile.getAbsolutePath());
    Path p2 = p1.getParent();

    //pokemon 1 - Bulbasaur
    HashMap<String, String> bulbasaur = new HashMap<>();
    bulbasaur.put("name", "Bulbasaur");
    bulbasaur.put("type", "grass");
    bulbasaur.put("image", p2.toString() + "/danemons_resized/bulbasaur.jpeg");
    this.pokedex.put(entryNumber, bulbasaur);
    entryNumber++;

    //pokemon 2 - Charmander
    HashMap<String, String> charmander = new HashMap<>();
    charmander.put("name", "Charmander");
    charmander.put("type", "fire");
    charmander.put("image", p2.toString() + "/danemons_resized/charmander.jpeg");
    this.pokedex.put(entryNumber, charmander);
    entryNumber++;

    //pokemon 3 - Squirtle
    HashMap<String, String> squirtle = new HashMap<>();
    squirtle.put("name", "Squirtle");
    squirtle.put("type", "water");
    squirtle.put("image", p2.toString() + "/danemons_resized/squirtle.jpeg");
    this.pokedex.put(entryNumber, squirtle);
    entryNumber++;

    //pokemon 4 - Pikachu
    HashMap<String, String> pikachu = new HashMap<>();
    pikachu.put("name", "Pikachu");
    pikachu.put("type", "electric");
    pikachu.put("image", p2.toString() + "/danemons_resized/pikachu.jpg");
    this.pokedex.put(entryNumber, pikachu);
    entryNumber++;

    //pokemon 5 - Geodude
    HashMap<String, String> geodude = new HashMap<>();
    geodude.put("name", "Geodude");
    geodude.put("type", "rock");
    geodude.put("image", p2.toString() + "/danemons_resized/geodude.jpeg");
    this.pokedex.put(entryNumber, geodude);
    entryNumber++;

    //pokemon 6 - Jigglypuff
    HashMap<String, String> jigglypuff = new HashMap<>();
    jigglypuff.put("name", "Jigglypuff");
    jigglypuff.put("type", "normal");
    jigglypuff.put("image", p2.toString() + "/danemons_resized/jigglypuff.jpeg");
    this.pokedex.put(entryNumber, jigglypuff);
    entryNumber++;

    //pokemon 7 - Butterfree
    HashMap<String, String> butterfree = new HashMap<>();
    butterfree.put("name", "Butterfree");
    butterfree.put("type", "bug");
    butterfree.put("image", p2.toString() + "/danemons_resized/butterfree.jpeg");
    this.pokedex.put(entryNumber, butterfree);
    entryNumber++;

    //pokemon 8 - Scyther
    HashMap<String, String> scyther = new HashMap<>();
    scyther.put("name", "Scyther");
    scyther.put("type", "bug");
    scyther.put("image", p2.toString() + "/danemons_resized/scyther.jpeg");
    this.pokedex.put(entryNumber, scyther);
    entryNumber++;

    //pokemon 9 - Gyarados
    HashMap<String, String> gyarados = new HashMap<>();
    gyarados.put("name", "Gyarados");
    gyarados.put("type", "water");
    gyarados.put("image", p2.toString() + "/danemons_resized/gyarados.jpeg");
    this.pokedex.put(entryNumber, gyarados);
    entryNumber++;

    //pokemon 10 - Arcanine
    HashMap<String, String> arcanine = new HashMap<>();
    arcanine.put("name", "Arcanine");
    arcanine.put("type", "fire");
    arcanine.put("image", p2.toString() + "/danemons_resized/arcanine.jpeg");
    this.pokedex.put(entryNumber, arcanine);
    entryNumber++;

    //pokemon 11 - Jolteon
    HashMap<String, String> jolteon = new HashMap<>();
    jolteon.put("name", "Jolteon");
    jolteon.put("type", "electric");
    jolteon.put("image", p2.toString() + "/danemons_resized/jolteon.jpg");
    this.pokedex.put(entryNumber, jolteon);
    entryNumber++;

    //pokemon 12 - Vileplume
    HashMap<String, String> vileplume = new HashMap<>();
    vileplume.put("name", "Vileplume");
    vileplume.put("type", "grass");
    vileplume.put("image", p2.toString() + "/danemons_resized/vileplume.jpeg");
    this.pokedex.put(entryNumber, vileplume);
    entryNumber++;

    //pokemon 13 - Rhydon
    HashMap<String, String> rhydon = new HashMap<>();
    rhydon.put("name", "Rhydon");
    rhydon.put("type", "rock");
    rhydon.put("image", p2.toString() + "/danemons_resized/rhydon.jpeg");
    this.pokedex.put(entryNumber, rhydon);
    entryNumber++;

    //pokemon 14 - Snorlax
    HashMap<String, String> snorlax = new HashMap<>();
    snorlax.put("name", "Snorlax");
    snorlax.put("type", "normal");
    snorlax.put("image", p2.toString() + "/danemons_resized/snorlax.jpeg");
    this.pokedex.put(entryNumber, snorlax);
//    entryNumber++;

  }

  /**
   * Method getPokedex() returns a Pokedex hashmap copy.
   * @return HashMap<Integer, HashMap<String, String>>: lsit of available Pokemon
   */
  public HashMap<Integer, HashMap<String, String>> getPokedex() {
    HashMap<Integer, HashMap<String, String>> pokedexCopy = new HashMap<>();
    for(Integer num : this.pokedex.keySet()) {
      HashMap<String, String> attributes = new HashMap<>();
      for(String key : this.pokedex.get(num).keySet()) {
        attributes.put(key, this.pokedex.get(num).get(key));
      }
      pokedexCopy.put(num, attributes);
    }
    return pokedexCopy;
  }
}
