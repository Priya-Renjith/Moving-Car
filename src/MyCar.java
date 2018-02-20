import java.io.File;
import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * This class creates a Jframe and JPanel object using Java Swing classes. It takes the XML input
 * file as the argument for its Main method. It reads an XML input file and parses its element node
 * state. For every state node within the XML file, it calls the method moveCar passing the values
 * of child nodes namely time, position and speed.
 * 
 * @author Priya Renjith
 * 
 */

public class MyCar {

  public static void main(String[] args) {

    try {

      int time, position, speed;

      // creating frame and panel for the moving car object
      JFrame myFrame = new JFrame("Moving Car");
      myFrame.setSize(400, 200);
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      MyPanel o = new MyPanel();
      myFrame.add(o);
      myFrame.setVisible(true);

      // reading the input XML file
      File inputFile = new File(args[0]);
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(inputFile);
      doc.getDocumentElement().normalize();

      System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
      NodeList nList = doc.getElementsByTagName("state");
      System.out.println("----------------------------");

      for (int temp = 0; temp < nList.getLength(); temp++) {
        Thread.sleep(4000);
        Node nNode = nList.item(temp);
        System.out.println("\nCurrent Element :" + nNode.getNodeName());

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
          Element eElement = (Element) nNode;

          System.out
              .println("Time : " + eElement.getElementsByTagName("time").item(0).getTextContent());

          time = Integer.parseInt(eElement.getElementsByTagName("time").item(0).getTextContent());

          System.out.println(
              "Position : " + eElement.getElementsByTagName("position").item(0).getTextContent());

          position =
              Integer.parseInt(eElement.getElementsByTagName("position").item(0).getTextContent());

          System.out.println(
              "Speed : " + eElement.getElementsByTagName("speed").item(0).getTextContent());

          speed = Integer.parseInt(eElement.getElementsByTagName("speed").item(0).getTextContent());

          o.moveCar(time, position, speed);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}

