import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class DragPanel extends JPanel{

    private ImageIcon image = new ImageIcon(getClass( ).getResource("/Bowl-1.png (4).png"));
    private ImageIcon image1 = new ImageIcon(getClass().getResource("/Sugar.png"));

    private ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/gamebackground.jpg"));

    private final int WIDTH = image.getIconWidth();
    private final int HEIGHT = image.getIconHeight();
    private Point imageCorner;
    private Point prevPt;
    private Point otherImage;
    private JLabel seconds_left = new JLabel();

    private String currentScreen = "menu";
    private int seconds =10;

    private  Timer timer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if (seconds ==0)
            {
                timer.stop();

            }

        }
    });




    public DragPanel() throws IOException, FontFormatException {
       // backgroundImage = new ImageIcon("endingtruck,jpg").getImage();

//        File font_file = new File("joystix.ttf");
//        Font font = Font.createFont(Font.TRUETYPE_FONT, font_file);
//        Font sizedFont = font.deriveFont(40f);



        imageCorner = new Point(0,0);
        otherImage = new Point(300,200);
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);

        seconds_left.setBounds(1250,650,200,200);
        seconds_left.setBackground(new Color(25,25,25));
        seconds_left.setForeground(new Color(233,220,245));
        seconds_left.setFont(new Font("WEST JAVA",Font.BOLD,100));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));
        timer.start();

        this.add(seconds_left);



    }

    public void checkCollision() {
        if((imageCorner.getY()  < otherImage.getY() && imageCorner.getY() > otherImage.getY() - 10) && ((imageCorner.getX()  < otherImage.getX()) && (imageCorner.getX()  > otherImage.getX() - 10) )){

            image = new ImageIcon(getClass().getResource("/Bowl-1.png (5).png"));


        }
    }



    public void paintComponent(Graphics g){
        super.paintComponent(g);
        backgroundImage.paintIcon(this, g, 0,0);
        image1.paintIcon(this, g, (int)otherImage.getX(), (int)otherImage.getY());
        image.paintIcon(this, g, (int)imageCorner.getX(), (int)imageCorner.getY());


    }

    private class ClickListener extends MouseAdapter{

        public void mousePressed(MouseEvent e){
            prevPt = e.getPoint();
        }

    }

    private class DragListener extends MouseMotionAdapter{
        public void mouseDragged(MouseEvent e){
            Point currentPt = e.getPoint();

            imageCorner.translate(

                    ((int)(currentPt.getX() - prevPt.getX())),
            (int)(currentPt.getY() - prevPt.getY()));
            prevPt = currentPt;
            repaint();
            checkCollision();

        }
    }
}
