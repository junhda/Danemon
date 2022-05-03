package View;

import java.util.ArrayList;
import java.awt.Font;
import java.awt.Container;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;

/**
 * Class View initializes a Java Swing GUI for displaying a Pokemon battle game
 */
public class View implements IView {
  private JFrame frame;
  private JPanel startPanel;
  private JPanel imagePanel;
  private JPanel actionPanel;
  private JButton button1;
  private JButton button2;
  private JButton button3;
  private JButton button4;
  private JButton difficultyButton1;
  private JButton difficultyButton2;
  private JButton difficultyButton3;
  private Font textFont;

  /**
   * Constructor for the View class. Initializes propeties of a View object, opens a Java Swing
   * application to an initial Page where user selects a difficulty rating for the game
   */
  public View() {
//    this.label = new JLabel("Danemon Battler");

    frame = new JFrame("Danemon Battler");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null);
    frame.setBounds(100, 100, 720, 760);
    frame.setResizable(false);

    Container c = frame.getContentPane();
    Border br = BorderFactory.createLineBorder(Color.black);
    textFont = new Font("Arial", Font.BOLD, 25);

    //setup Panels
    startPanel = new JPanel();
    startPanel.setLayout(null);
    imagePanel = new JPanel();
    imagePanel.setLayout(null);
    actionPanel = new JPanel();
    actionPanel.setLayout(null);

    //setup startPanel
    startPanel.setBackground(Color.BLACK);
    startPanel.setBounds(10,10,700, 710);
    startPanel.setBorder(br);

    //setup Buttons
    button1 = new JButton("");
    button2 = new JButton("");
    button3 = new JButton("");
    button4 = new JButton("");
    difficultyButton1 = new JButton("Easy");
    difficultyButton2 = new JButton("Medium");
    difficultyButton3 = new JButton("Hard");

    button1.setLayout(null);
    button2.setLayout(null);
    button3.setLayout(null);
    button4.setLayout(null);
    difficultyButton1.setLayout(null);
    difficultyButton2.setLayout(null);
    difficultyButton3.setLayout(null);

    button1.setFont(textFont);
    button2.setFont(textFont);
    button3.setFont(textFont);
    button4.setFont(textFont);
    difficultyButton1.setFont(textFont);
    difficultyButton2.setFont(textFont);
    difficultyButton3.setFont(textFont);

    button1.setActionCommand("attack1");
    button2.setActionCommand("attack2");
    button3.setActionCommand("attack3");
    button4.setActionCommand("attack4");
    difficultyButton1.setActionCommand("easy");
    difficultyButton2.setActionCommand("medium");
    difficultyButton3.setActionCommand("hard");

    //setup difficultButtons
    difficultyButton1.setBounds(285, 295, 130, 40);
    difficultyButton2.setBounds(285, 345, 130, 40);
    difficultyButton3.setBounds(285, 395, 130, 40);

    //add difficultyButtons to startPanel
    startPanel.add(difficultyButton1);
    startPanel.add(difficultyButton2);
    startPanel.add(difficultyButton3);

    //add startPanel to frame
    c.add(startPanel);
    //open frame
    frame.setVisible(true);
  }

  /**
   * Sets actionListeners on each button of the View
   * @param clicks ActionListener: method for button clicks
   */
  @Override
  public void setListeners(ActionListener clicks) {
    this.button1.addActionListener(clicks);
    this.button2.addActionListener(clicks);
    this.button3.addActionListener(clicks);
    this.button4.addActionListener(clicks);
    this.difficultyButton1.addActionListener(clicks);
    this.difficultyButton2.addActionListener(clicks);
    this.difficultyButton3.addActionListener(clicks);
  }

  /**
   * Method getButton() returns the JButton object with the same associated name
   * @param name string name of the JButton property in the View class
   * @return JButton with matching string name
   * @throws IllegalArgumentException when the provided button name does not exist in the View.
   *  Expects button1, button2, button3, button4, difficultyButton1, difficultyButton2,
   *  or difficultyButton3
   */
  public JButton getButton(String name) throws IllegalArgumentException {
    if(name == "button1") {
      return this.button1;
    } else if(name == "button2") {
      return this.button2;
    } else if(name == "button3") {
      return this.button3;
    } else if(name == "button4") {
      return this.button4;
    } else if(name == "difficultyButton1") {
      return this.difficultyButton1;
    } else if(name == "difficultyButton2") {
      return this.difficultyButton2;
    } else if(name == "difficultyButton3") {
      return this.difficultyButton3;
    } else {
      throw new IllegalArgumentException("Invalid button requested");
    }
  }

  /**
   * Method closeStartPanel() will remove the starting JPanel from the frame
   */
  public void closeStartPanel() {
    Container c = frame.getContentPane();
    c.remove(startPanel);
  }

  /**
   * Method refreshFrame() will update the frame with the latest content that has been added
   */
  public void refreshFrame() {
    frame.repaint();
  }

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
      String enemyPokemonCurrentHealth, String enemyParty) {
    Border br = BorderFactory.createLineBorder(Color.black);
    Container c = frame.getContentPane();
    //remove existing imagePanel from frame
    c.remove(imagePanel);

    //add elements to the imagePanel
    imagePanel = new JPanel();
    imagePanel.setBackground(Color.GREEN);
    imagePanel.setBounds(10,10,700, 500);
    imagePanel.setBorder(br);

    //user Pokemon Image
    try{
      ImageIcon image1 = new ImageIcon(userPokemonURL);
      JLabel displayField1 = new JLabel(image1);
      displayField1.setLayout(null);
      displayField1.setBounds(60, 250, 200, 200);
      imagePanel.add(displayField1);
    } catch(Exception e) {
      System.out.println("Image cannot be found");
    }

    //User Pokemon display field
    JLabel userName = new JLabel(userPokemonName + ": " + userPokemonCurrentHealth + " / " +
        userPokemonHealth, SwingConstants.CENTER);
    userName.setLayout(null);
    userName.setFont(this.textFont);
    userName.setBounds(320, 300, 320, 30);
    imagePanel.add(userName);
    JLabel userPartySize = new JLabel("Remaining Pokemon: " + userParty);
    userPartySize.setLayout(null);
    userPartySize.setFont(this.textFont);
    userPartySize.setBounds(320, 330, 320, 30);
    imagePanel.add(userPartySize);

    //enemy Pokemon Image
    try{
      ImageIcon image2 = new ImageIcon(enemyPokemonURL);
      JLabel displayField2 = new JLabel(image2);
      displayField2.setLayout(null);
      displayField2.setBounds(440, 40, 200, 200);
      imagePanel.add(displayField2);
    } catch(Exception e) {
      System.out.println("Image cannot be found");
    }

    //enemy Pokemon display field
    JLabel enemyName = new JLabel(enemyPokemonName + ": " + enemyPokemonCurrentHealth + " / " +
        enemyPokemonHealth, SwingConstants.CENTER);
    enemyName.setLayout(null);
    enemyName.setFont(this.textFont);
    enemyName.setBounds(60, 60, 320, 30);
    imagePanel.add(enemyName);
    JLabel enemyPartySize = new JLabel("Remaining Pokemon: " + enemyParty);
    enemyPartySize.setLayout(null);
    enemyPartySize.setFont(this.textFont);
    enemyPartySize.setBounds(60, 90, 320, 30);
    imagePanel.add(enemyPartySize);

    //add imagePanel to frame
    c.add(imagePanel);
  }

  /**
   * Method createTextPanel() updates the actionPanel to display only the text passed in
   * @param text String: text to display in actionPanel
   * @throws IllegalArgumentException when text is null or empty
   */
  public void createTextPanel(String text) throws IllegalArgumentException {
    if(text == null || text.length() == 0) {
      throw new IllegalArgumentException("Text is required.");
    }
    Border br = BorderFactory.createLineBorder(Color.black);
    Container c = frame.getContentPane();
    //remove existing actionPanel
    c.remove(actionPanel);

    // create actionPanel
    actionPanel = new JPanel();
    actionPanel.setBackground(Color.LIGHT_GRAY);
    actionPanel.setBounds(10,520,700, 200);
    actionPanel.setBorder(br);

    //text panel next to Buttons
    JLabel label = new JLabel(text, SwingConstants.CENTER);
    label.setLayout(null);
    label.setBounds(10, 10, 680, 180);
    label.setFont(textFont);

    // add text to panel
    actionPanel.add(label);

    //update frame with the new Panel
    c.add(actionPanel);
  }

  /**
   * Method createAttackMenu() sets the actionPanel() to include 4 buttons for the user battling
   * Pokemon's attack options
   * @param titles ArrayList<String>: list of attack names for the user's Pokemon. Expects 4 names
   * @throws IllegalArgumentException when 4 attack names aren't provided
   */
  public void createAttackMenu(ArrayList<String> titles) throws IllegalArgumentException {
    if(titles.size() != 4) {
      throw new IllegalArgumentException("Expected 4 attack skills");
    }
    Border br = BorderFactory.createLineBorder(Color.black);
    Container c = frame.getContentPane();
    //remove existing actionPanel
    c.remove(actionPanel);

    // create actionPanel
    actionPanel = new JPanel();
    actionPanel.setBackground(Color.LIGHT_GRAY);
    actionPanel.setBounds(10,520,700, 200);
    actionPanel.setBorder(br);

    //text panel next to Buttons
    JLabel text = new JLabel("What will you do?", SwingConstants.CENTER);
    text.setLayout(null);
    text.setBounds(10, 10, 230, 180);
    text.setFont(textFont);

    // create attack buttons
    button1.setText(titles.get(0));
    button2.setText(titles.get(1));
    button3.setText(titles.get(2));
    button4.setText(titles.get(3));

    button1.setBounds(250, 10, 215, 85);
    button2.setBounds(475, 10, 215, 85);
    button3.setBounds(250, 105, 215, 85);
    button4.setBounds(475, 105, 215, 85);

    // add text and buttons to panel
    actionPanel.add(text);
    actionPanel.add(button1);
    actionPanel.add(button2);
    actionPanel.add(button3);
    actionPanel.add(button4);

    //update frame with the new Panel
    c.add(actionPanel);
  }
}
