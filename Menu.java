import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Menu extends JPanel {

    private ImageIcon image = new ImageIcon(getClass().getResource("/logoclear.png"));
    private ImageIcon image1 = new ImageIcon(getClass().getResource("/scroll.png"));

    private ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/mainmenutruck (1).jpg"));

    private final int WIDTH = image.getIconWidth();
    private final int HEIGHT = image.getIconHeight();
    private Point imageCorner;
    private Point prevPt;
    private Point otherImage;

    private String currentScreen = "menu";




    public Menu() {
        // backgroundImage = new ImageIcon("endingtruck,jpg").getImage();



        imageCorner = new Point(1000, 0);
        otherImage = new Point(1100, 350);





    }




    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        backgroundImage.paintIcon(this, g, 0, 0);
       // image1.paintIcon(this, g, (int) otherImage.getX(), (int) otherImage.getY());
        image.paintIcon(this, g, (int) imageCorner.getX(), (int) imageCorner.getY());


    }

    private class ClickListener extends MouseAdapter{

        public void mousePressed(MouseEvent e){
            prevPt = e.getPoint();
        }

    }
}