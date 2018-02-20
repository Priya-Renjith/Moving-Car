import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * This class creates a JPanel object and initializes the X and Y coordinates. It calls the repaint
 * method to draw an image of a car.
 * 
 * @author Priya Renjith
 */

public class MyPanel extends JPanel {

  int x, y;

  public MyPanel() {

    x = 10;
    y = 30;

    repaint();
  }

  /**
   * This method draws a car image on the JPanel object.
   */
  public void paintComponent(Graphics g) {

    super.paintComponent(g);

    g.setColor(Color.RED);
    g.fillRect(x, y, 100, 20);
    g.drawArc(x + 5, y + 15, 20, 20, 20, 360);
    g.drawArc(x + 75, y + 15, 20, 20, 20, 360);
    g.drawLine(x + 20, y, x + 30, y - 10);
    g.drawLine(x + 75, y, x + 55, y - 10);
    g.drawLine(x + 30, y - 10, x + 55, y - 10);
    g.drawString("0", 40, 15);
    g.drawString("1", 82, 15);
    g.drawString("3", 136, 15);
  }

  /**
   * This method is invoked from Mycar.java.
   * 
   * @param t time parameter
   * @param p position parameter
   * @param s speed parameter parameter p is increased by 6 times and X coordinate is shifted by p
   *        value. It calls repaint method to draw the car image using the updated X coordinate.
   */

  public void moveCar(int t, int p, int s) {

    p = p * 6;
    x += p;

    repaint();
  }
}

