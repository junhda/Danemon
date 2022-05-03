package ModelTest;

import Model.Pokedex;
import Model.Pokemon;
import Model.PokemonImpl;
import Model.TypeSet;

import java.util.HashMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import java.util.ArrayList;

/**
 * Class PokedexTest includes JUnit tests for testing the methods
 * in the Pokedex class
 */
public class PokedexTest {
  private Pokedex dex = new Pokedex();
  private ArrayList<HashMap<String, String>> dexList;

  /**
   * Sets up an ArrayList of the HashMap Pokedex entries that we expect for further method testing
   */
  @Before
  public void setUp() {
    this.dexList = new ArrayList<>();
    HashMap<String, String> p1 = new HashMap<>();
    p1.put("name", "Bulbasaur");
    p1.put("type", "grass");
    p1.put("image", "/Users/dan/Documents/Documents/NORTHEASTERN/"
        + "CS5004/CS5004_Final_Project/danemons_resized/bulbasaur.jpeg");
    this.dexList.add(p1);

    HashMap<String, String> p2 = new HashMap<>();
    p2.put("name", "Charmander");
    p2.put("type", "fire");
    p2.put("image", "/Users/dan/Documents/Documents/NORTHEASTERN/"
        + "CS5004/CS5004_Final_Project/danemons_resized/charmander.jpeg");
    this.dexList.add(p2);

    HashMap<String, String> p3 = new HashMap<>();
    p3.put("name", "Squirtle");
    p3.put("type", "water");
    p3.put("image", "/Users/dan/Documents/Documents/NORTHEASTERN/"
        + "CS5004/CS5004_Final_Project/danemons_resized/squirtle.jpeg");
    this.dexList.add(p3);

    HashMap<String, String> p4 = new HashMap<>();
    p4.put("name", "Pikachu");
    p4.put("type", "electric");
    p4.put("image", "/Users/dan/Documents/Documents/NORTHEASTERN/"
        + "CS5004/CS5004_Final_Project/danemons_resized/pikachu.jpg");
    this.dexList.add(p4);

    HashMap<String, String> p5 = new HashMap<>();
    p5.put("name", "Geodude");
    p5.put("type", "rock");
    p5.put("image", "/Users/dan/Documents/Documents/NORTHEASTERN/"
        + "CS5004/CS5004_Final_Project/danemons_resized/geodude.jpeg");
    this.dexList.add(p5);

    HashMap<String, String> p6 = new HashMap<>();
    p6.put("name", "Jigglypuff");
    p6.put("type", "normal");
    p6.put("image", "/Users/dan/Documents/Documents/NORTHEASTERN/"
        + "CS5004/CS5004_Final_Project/danemons_resized/jigglypuff.jpeg");
    this.dexList.add(p6);

    HashMap<String, String> p7 = new HashMap<>();
    p7.put("name", "Butterfree");
    p7.put("type", "bug");
    p7.put("image", "/Users/dan/Documents/Documents/NORTHEASTERN/"
        + "CS5004/CS5004_Final_Project/danemons_resized/butterfree.jpeg");
    this.dexList.add(p7);

    HashMap<String, String> p8 = new HashMap<>();
    p8.put("name", "Scyther");
    p8.put("type", "bug");
    p8.put("image", "/Users/dan/Documents/Documents/NORTHEASTERN/"
        + "CS5004/CS5004_Final_Project/danemons_resized/scyther.jpeg");
    this.dexList.add(p8);

    HashMap<String, String> p9 = new HashMap<>();
    p9.put("name", "Gyarados");
    p9.put("type", "water");
    p9.put("image", "/Users/dan/Documents/Documents/NORTHEASTERN/"
        + "CS5004/CS5004_Final_Project/danemons_resized/gyarados.jpeg");
    this.dexList.add(p9);

    HashMap<String, String> p10 = new HashMap<>();
    p10.put("name", "Arcanine");
    p10.put("type", "fire");
    p10.put("image", "/Users/dan/Documents/Documents/NORTHEASTERN/"
        + "CS5004/CS5004_Final_Project/danemons_resized/arcanine.jpeg");
    this.dexList.add(p10);

    HashMap<String, String> p11 = new HashMap<>();
    p11.put("name", "Jolteon");
    p11.put("type", "electric");
    p11.put("image", "/Users/dan/Documents/Documents/NORTHEASTERN/"
        + "CS5004/CS5004_Final_Project/danemons_resized/jolteon.jpg");
    this.dexList.add(p11);

    HashMap<String, String> p12 = new HashMap<>();
    p12.put("name", "Vileplume");
    p12.put("type", "grass");
    p12.put("image", "/Users/dan/Documents/Documents/NORTHEASTERN/"
        + "CS5004/CS5004_Final_Project/danemons_resized/vileplume.jpeg");
    this.dexList.add(p12);

    HashMap<String, String> p13 = new HashMap<>();
    p13.put("name", "Rhydon");
    p13.put("type", "rock");
    p13.put("image", "/Users/dan/Documents/Documents/NORTHEASTERN/"
        + "CS5004/CS5004_Final_Project/danemons_resized/rhydon.jpeg");
    this.dexList.add(p13);

    HashMap<String, String> p14 = new HashMap<>();
    p14.put("name", "Snorlax");
    p14.put("type", "normal");
    p14.put("image", "/Users/dan/Documents/Documents/NORTHEASTERN/"
        + "CS5004/CS5004_Final_Project/danemons_resized/snorlax.jpeg");
    this.dexList.add(p14);
  }

  /**
   * Tests the getPokdex() method of the Pokedex class
   */
  @Test
  public void testGetPokedex() {
    HashMap<Integer, HashMap<String, String>> pokedex = this.dex.getPokedex();
    Assert.assertEquals(14, pokedex.size());
    for(int i = 1; i <= 14; i++) {
      Assert.assertTrue(pokedex.get(i) != null);

      //match against dexList
      Assert.assertEquals(this.dexList.get(i - 1).get("name"), pokedex.get(i).get("name"));
      Assert.assertEquals(this.dexList.get(i - 1).get("type"), pokedex.get(i).get("type"));
      Assert.assertEquals(this.dexList.get(i - 1).get("image"), pokedex.get(i).get("image"));
    }


  }

  /**
   * Tests whether the Hashmap entries in the Pokedex are sufficient to create PokemonImpl objects
   */
  @Test
  public void testMakePokemonFromPokedex() {
    PokemonImpl tester;
    for(int i = 1; i <= dex.getPokedex().size(); i++) {
      String name = dex.getPokedex().get(i).get("name");
      TypeSet type = new TypeSet(dex.getPokedex().get(i).get("type"));
      String imageURL = dex.getPokedex().get(i).get("image");
      tester = new PokemonImpl(name, type, imageURL, 2);
      Assert.assertTrue(tester instanceof PokemonImpl);
    }
  }
}
