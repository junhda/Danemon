package View;

import javax.swing.*;

public class image extends JFrame {
  JFrame frame;
  JLabel displayField;
  ImageIcon image;

  public image() {

    frame = new JFrame("Image Display Test");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    try{
      image = new ImageIcon(getClass().getResource("/Users/dan/Documents/Documents\\ -\\ Daniel’s\\ MacBook\\ Pro/NORTHEASTERN/CS5004/CS5004_Final_Project/images/406919-143snorlax.png"));
      displayField = new JLabel(image);
      frame.add(displayField);
    } catch(Exception e) {
      System.out.println("Image cannot be found");
    }
    frame.setSize(400, 400);
//    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    image i = new image();
  }
}
