package View;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 * Interface IView contains methods required in Danemon View classes
 */
public interface IView {
  /**
   * Method getButton() returns the JButton object with the same associated name
   * @param name string name of the JButton property in the IView class
   * @return JButton with matching string name
   * @throws IllegalArgumentException when the provided button name does not exist in the IView
   */
  public JButton getButton(String name) throws IllegalArgumentException;

  /**
   * Sets actionListeners on each button of the View
   * @param clicks ActionListener: method for button clicks
   */
  public void setListeners(ActionListener clicks);

  /**
   * Method closeStartPanel() will remove the starting JPanel from the frame
   */
  public void closeStartPanel();

  /**
   * Method refreshFrame() will update the frame with the latest content that has been added
   */
  public void refreshFrame();

  /**
   * Method createImagePanel() sets the imagePanel with the Battling Pokemon, their names and their
   * current health out of overall health.
   * @param userPokemonURL String: absolute url to image of the user's battling Pokemon
   * @param userPokemonName String: name of the user's battling Pokemon
   * @param userPokemonHealth String: overall health of the user's battling Pokemon
   * @param userPokemonCurrentHealth String: current health of the user's battling Pokemon
   * @param enemyPokemonURL String: absolute url to image of the enemy's battling Pokemon
   * @param enemyPokemonName String: name of the enemy's battling Pokemon
   * @param enemyPokemonHealth String: overall health of the enemy's battling Pokemon
   * @param enemyPokemonCurrentHealth String: current health of the enemy's battling Pokemon
   */
  public void createImagePanel(String userPokemonURL, String userPokemonName,
      String userPokemonHealth, String userPokemonCurrentHealth, String userParty,
      String enemyPokemonURL, String enemyPokemonName, String enemyPokemonHealth,
      String enemyPokemonCurrentHealth, String enemyParty);

  /**
   * Method createTextPanel() updates the actionPanel to display only the text passed in
   * @param text String: text to display in actionPanel
   * @throws IllegalArgumentException when text is null or empty
   */
  public void createTextPanel(String text) throws IllegalArgumentException;

  /**
   * Method createAttackMenu() sets the actionPanel() to include 4 buttons for the user battling
   * Pokemon's attack options
   * @param titles ArrayList<String>: list of attack names for the user's Pokemon. Expects 4 names
   * @throws IllegalArgumentException when 4 attack names aren't provided
   */
  public void createAttackMenu(ArrayList<String> titles) throws IllegalArgumentException;
}
