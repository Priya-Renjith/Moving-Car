import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

// creates a panel, paints a moving car in the panel.
public class MyPanel extends JPanel {

  int x, y;

  public MyPanel() {

    x = 10;
    y = 30;

    repaint();
  }

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

  // method to move the car from one point to another
  // parameter 'p' increased by 6 folds to show the actual movement of car
  public void moveCar(int t, int p, int s) {

    p = p * 6;
    x += p;

    repaint();
  }
}

