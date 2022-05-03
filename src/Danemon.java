
import View.IView;
import View.View;
import Controller.IController;
import Controller.Controller;

/**
 * Class Danemon will initialize and start the Danemon game
 */
public class Danemon {

  /**
   * Begins the Danemon game.
   * @param args None expected
   */
  public static void main(String[] args) {
    IView view = new View();
    IController controller = new Controller(view);
  }
}
