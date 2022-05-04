package Controller;

import Model.Battle;
import Model.IBattleModel;
import Model.Pokemon;
import Model.Skill;
import Model.IPlayer;
import View.View;
import View.IView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.stream.Collectors;


/**
 * Class Controller passes continued actions of the Danemon game between View and Model
 */
public class Controller implements IController, ActionListener {
  private IView view;
  private IBattleModel model;

  /**
   * Constructor method for the Controller class. Accepts a View object and constructs a new
   * Battle model object based on inputs from the View
   * @param v
   */
  public Controller(IView v) {
    this.view = v;
    this.model = null;
    v.setListeners(this);
  }

  /**
   * Method actionPerformed() will listen for Button clicks from the provided view
   * and conduct appropriate response actions against the Model and View
   * @param e ActionEvent: click event on a JButton
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      //cases for setting initial difficulty of the game
      case "easy":
        this.model = new Battle(1);
        this.startGame();
        break;
      case "medium":
        this.model = new Battle(2);
        this.startGame();
        break;
      case "hard":
        this.model = new Battle(3);
        this.startGame();
        break;

      //following cases occur during the game and the model is already set up
      case "attack1":
        this.setView(0);
        break;
      case "attack2":
        this.setView(1);
        break;
      case "attack3":
        this.setView(2);
        break;
      case "attack4":
        this.setView(3);
        break;
    }
  }

  /**
   * Helper method enemyAttackDecision() will randomly choose between one of their
   * battling Pokemon's attack moves.
   * @return Skill: attack skill for the enemy battling Pokemon to use
   */
  public Skill enemyAttackDecision() {
    Random rand = new Random();
    return this.model.getEnemy().getAttackSkills().get(rand.nextInt(4));
  }


  /**
   * Method startGame() will close the initial difficulty choice of the Danemon view
   * and begin the game
   */
  @Override
  public void startGame() {
    //add time lag for after pressing the difficulty button
//    try {
//      Thread.sleep(1000);
//    } catch (InterruptedException e) {
//      Thread.currentThread().interrupt();
//    }
    //start the battle in the Model
    ArrayList<String> start = this.model.battleStart();

    //update the view to display opening Pokemon choices and close difficulty choice
    this.view.closeStartPanel();
    this.attackView(start);

    //reset view to attack decision if game is not over
    List<String> attacks = this.model.getUser().getAttackSkills().stream().
        map(Skill::getName).collect(Collectors.toList());
    ArrayList<String> attacksArray = new ArrayList<>();
    attacksArray.addAll(attacks);
    this.view.createAttackMenu(attacksArray);
    this.view.refreshFrame();
  }

  /**
   * Method setView() will update the Danemon View object to match the latest state of the game
   * @throws IllegalArgumentException when param value is < 0 or > 3
   */
  @Override
  public void setView(int attackOption) throws IllegalArgumentException {
    if(attackOption < 0 || attackOption > 3) {
      throw new IllegalArgumentException("Expected value between 0 and 3");
    }

    Skill attackMove = this.model.getUser().getAttackSkills().get(attackOption);
    System.out.println("User attack choice: " + attackMove.getName());
    Skill enemyAttackMove = this.enemyAttackDecision();
    System.out.println("Enemy attack choice: " + enemyAttackMove.getName());
    ArrayList<IPlayer> playerOrder = this.model.getMovePriority();

    Pokemon currentUserPokemon = this.model.getUser().getBattlingPokemon();
    Pokemon currentEnemyPokemon = this.model.getEnemy().getBattlingPokemon();

    if(playerOrder.get(0) == this.model.getUser()) {
      //user attacks
      ArrayList<String> userAttack = this.model.performAction(playerOrder.get(0),
          playerOrder.get(1), attackMove);
      for(String s : userAttack) {
        System.out.println(s);
      }
      //insert view updates here
      this.attackView(userAttack);

      //enemy attacks
      if(this.model.getEnemy().getBattlingPokemon() == currentEnemyPokemon) {
        ArrayList<String> enemyAttack = this.model.performAction(playerOrder.get(1),
            playerOrder.get(0), enemyAttackMove);
        for(String s : enemyAttack) {
          System.out.println(s);
        }
        //insert view updates here
        this.attackView(enemyAttack);
      }

    } else {
      //enemy attacks
      ArrayList<String> enemyAttack = this.model.performAction(playerOrder.get(0),
          playerOrder.get(1), enemyAttackMove);
      for(String s : enemyAttack) {
        System.out.println(s);
      }
      //insert view updates here
      this.attackView(enemyAttack);

      //user attacks
      if(this.model.getUser().getBattlingPokemon() == currentUserPokemon) {
        ArrayList<String> userAttack = this.model.performAction(playerOrder.get(1),
            playerOrder.get(0), attackMove);
        for(String s : userAttack) {
          System.out.println(s);
        }
        //insert view updates here
        this.attackView(userAttack);
      }
    }

    //reset view to attack decision if game is not over
    if(this.model.isGameOver() == false) {
      List<String> attacks = this.model.getUser().getAttackSkills().stream().
          map(Skill::getName).collect(Collectors.toList());
      ArrayList<String> attacksArray = new ArrayList<>();
      attacksArray.addAll(attacks);
      this.view.createAttackMenu(attacksArray);
      this.view.refreshFrame();
    }
  }

  public void attackView(ArrayList<String> attackPrompts) {
    for(int i = 0; i < attackPrompts.size(); i++) {
      String attackPrompt = attackPrompts.get(i);
//      System.out.println("Attack View Method: " + attackPrompts.get(i));
      //pull out user info from model
      String userPokemonURL = this.model.getUser().getBattlingPokemon().getImageURL();
      String userPokemonName = this.model.getUser().getBattlingPokemon().getName();
      String userPokemonHealth = String.valueOf(this.model.getUser().getBattlingPokemon().
          getStatsSet().getHealth());
      String userPokemonCurrentHealth = String.valueOf(this.model.getUser().getBattlingPokemon().
          getStatsSet().getCurrentHealth());
      String userParty = String.valueOf(this.model.getUser().getActiveParty().size());

      //pull out enemy info from model
      String enemyPokemonURL = this.model.getEnemy().getBattlingPokemon().getImageURL();
      String enemyPokemonName = this.model.getEnemy().getBattlingPokemon().getName();
      String enemyPokemonHealth = String.valueOf(this.model.getEnemy().getBattlingPokemon().
          getStatsSet().getHealth());
      String enemyPokemonCurrentHealth = String.valueOf(this.model.getEnemy().getBattlingPokemon().
          getStatsSet().getCurrentHealth());
      String enemyParty = String.valueOf(this.model.getEnemy().getActiveParty().size());

      //update view to latest version of the Model
      this.view.createTextPanel(attackPrompt);
      this.view.createImagePanel(userPokemonURL, userPokemonName, userPokemonHealth,
          userPokemonCurrentHealth, userParty, enemyPokemonURL, enemyPokemonName,
          enemyPokemonHealth, enemyPokemonCurrentHealth, enemyParty);

      //refresh frame to latest state
      this.view.refreshFrame();

      //add time lag to show text
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }
}
