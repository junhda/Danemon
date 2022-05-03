package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interface IController includes methods required for all Danemon Controller classes
 */
public interface IController extends ActionListener {

  /**
   * Method actionPerformed() will listen for Button clicks from the provided view
   * and conduct appropriate response actions against the Model and View
   * @param e ActionEvent: click event on a JButton
   */
  public void actionPerformed(ActionEvent e);

  /**
   * Method startGame() will close the initial difficulty choice of the Danemon view
   * and begin the game
   */
  public void startGame();

  /**
   * Method setView() will update the Danemon View object to match the latest state of the game
   * @throws IllegalArgumentException when param value is < 0 or > 3
   */
  public void setView(int attackOption) throws IllegalArgumentException;
}
