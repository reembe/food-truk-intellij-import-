import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class DragPanel extends JPanel{

    private ImageIcon image = new ImageIcon(getClass( ).getResource("/Bowl-1.png (4).png"));
    private ImageIcon image1 = new ImageIcon(getClass().getResource("/Sugar.png"));
    private ImageIcon flour = new ImageIcon(getClass().getResource("/Wheat_Flour.png"));
    private ImageIcon rice = new ImageIcon(getClass().getResource("/Rice.png"));

    private ImageIcon egg = new ImageIcon(getClass().getResource("/Egg.png"));

    private ImageIcon pan = new ImageIcon(getClass().getResource("/pan-1.png.png"));

    private ImageIcon pancake = new ImageIcon(getClass().getResource("/Pancakes.png"));

    private ImageIcon ricepudding = new ImageIcon(getClass().getResource("/Rice_Pudding.png"));

    private ImageIcon key = new ImageIcon(getClass().getResource("/Rusty_Key.png"));


    private ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/gamebackground.jpg"));

    private final int WIDTH = image.getIconWidth();
    private final int HEIGHT = image.getIconHeight();
    private Point imageCorner;
    private Point prevPt;
    private Point otherImage;
    private Point flourp;
    private Point ricep;
    private Point eggp;
    private Point panp;
    private Point keyp;
    private JLabel seconds_left = new JLabel();

    private String currentScreen = "menu";
    private int seconds = 125;
    private boolean keyPicked;
    private boolean sugargain;
    private boolean flourgain;
    private boolean ricegain;
    private boolean egggain;
    private int ricemade;
    private int panmade;
    private int orders;
    private JLabel title1 = new JLabel();
    private JLabel title3= new JLabel();
    private JLabel title2= new JLabel();
    private JLabel title4= new JLabel();
    private JLabel title5= new JLabel();
    private JLabel title6= new JLabel();
    private JLabel title= new JLabel();
    private JLabel intro= new JLabel();
    private JLabel intro1= new JLabel();
    private JLabel intro11= new JLabel();
    private JLabel intro3= new JLabel();
    private JLabel intro4= new JLabel();
    private JLabel intro5= new JLabel();
    private JLabel intro6= new JLabel();
   private ImageIcon winscreen = new ImageIcon(getClass().getResource("/winscreennew (1).jpg"));
    private ImageIcon losescreen = new ImageIcon(getClass().getResource("/losescreenew (1).jpg"));



    private  Timer timer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if (seconds == 0)
            {
                timer.stop();
                if (keyPicked == true){
                    backgroundImage = winscreen;
                    remove(seconds_left);

                    imageCorner = new Point(100000,10000);
                    otherImage = new Point(50000,40000);
                    flourp = new Point(50000, 20000);
                    ricep = new Point(50000, 50000);
                    eggp = new Point(425000, 21000);
                    panp = new Point(900000, 46000);
                    keyp = new Point(70000, 54000);

                }
                else{
                    backgroundImage = losescreen;
                    remove(seconds_left);

                    imageCorner = new Point(100000,10000);
                    otherImage = new Point(50000,40000);
                    flourp = new Point(50000, 20000);
                    ricep = new Point(50000, 50000);
                    eggp = new Point(425000, 21000);
                    panp = new Point(900000, 46000);
                    keyp = new Point(70000, 54000);

                }
                repaint();


            }

        }


    });




    public DragPanel() throws IOException, FontFormatException {


        File font_file = new File("C:\\Users\\reemy\\IdeaProjects\\untitled17\\src\\joystix.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, font_file);
        Font sizedFont = font.deriveFont(40f);



        imageCorner = new Point(0,0);
        otherImage = new Point(500,400);
        flourp = new Point(500, 200);
        ricep = new Point(500, 500);
        eggp = new Point(425, 210);
        panp = new Point(900, 460);
        keyp = new Point(70, 540);

        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);

        seconds_left.setBounds(500,0,200,100);
        seconds_left.setBackground(new Color(25,25,25));
        seconds_left.setForeground(new Color(233,220,245));
        seconds_left.setFont(sizedFont);
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));
        timer.start();

        JLabel title = new JLabel();
        title.setText("Orders:");
        title.setBounds(1150,15,10000,100);
        title.setForeground(Color.black);
        title.setFont(sizedFont);

        JLabel title1 = new JLabel();
        title1.setText("10x Rice Pudding");
        title1.setBounds(1150,45,10000,100);
        title1.setForeground(Color.black);
        title1.setFont(sizedFont);

        JLabel title2 = new JLabel();
        title2.setText("10x Pancakes");
        title2.setBounds(1150,75,10000,100);
        title2.setForeground(Color.black);
        title2.setFont(sizedFont);

        JLabel title3 = new JLabel();
        title3.setText("1x Rice Pudding");
        title3.setBounds(1150,105,10000,100);
        title3.setForeground(Color.black);
        title3.setFont(sizedFont);

        JLabel title4 = new JLabel();
        title4.setText("7x Pancakes");
        title4.setBounds(1150,135,10000,100);
        title4.setForeground(Color.black);
        title4.setFont(sizedFont);

        JLabel title5 = new JLabel();
        title5.setText("3x Rice Pudding");
        title5.setBounds(1150,165,10000,100);
        title5.setForeground(Color.black);
        title5.setFont(sizedFont);

        JLabel title6 = new JLabel();
        title6.setText("3x Pancakes");
        title6.setBounds(1150,195,10000,100);
        title6.setForeground(Color.black);
        title6.setFont(sizedFont);

        JLabel intro = new JLabel();
        intro.setText("Recipes:");
        intro.setBounds(1100,320,1000,100);
        intro.setForeground(Color.black);
        intro.setFont(sizedFont);

        JLabel intro1 = new JLabel();
        intro1.setText("-Pancake- ");
        intro1.setBounds(1150,400,1000,100);
        intro1.setForeground(Color.BLACK);
        intro1.setFont(sizedFont);

        JLabel intro11 = new JLabel();
        intro11.setText("flour + egg");
        intro11.setBounds(1150,450,10000,100);
        intro11.setForeground(Color.BLACK);
        intro11.setFont(sizedFont);


        JLabel intro3 = new JLabel();
        intro3.setText("-Rice pudding- ");
        intro3.setBounds(1100,600,10000,100);
        intro3.setForeground(Color.BLACK);
        intro3.setFont(sizedFont);

        JLabel intro4 = new JLabel();
        intro4.setText("egg + sugar");
        intro4.setBounds(1150,650,10000000,100);
        intro4.setForeground(Color.BLACK);
        intro4.setFont(sizedFont);

        JLabel intro5 = new JLabel();
        intro5.setText("+ rice");
        intro5.setBounds(1150,700,10000000,100);
        intro5.setForeground(Color.BLACK);
        intro5.setFont(sizedFont);

        JLabel intro6 = new JLabel();
        intro6.setText("submit orders at window!");
        intro6.setBounds(1100,800,10000000,100);
        intro6.setForeground(Color.BLACK);
        intro6.setFont(sizedFont);

        this.setLayout(null);

        this.add(seconds_left);
        this.add(title);
        this.add(title1);
        this.add(title2);
        this.add(title3);
        this.add(title4);
        this.add(title5);
        this.add(title6);
        this.add(intro);
        this.add(intro1);
        this.add(intro11);
        this.add(intro3);
        this.add(intro4);
        this.add(intro5);
        this.add(intro6);

//        if (((120 - seconds) < 40) && (panmade == 10)){
//            panmade = 0;
//            this.remove(title1);
//            this.add(title3);
//            orders++;
//        }
//        if (((120 - seconds) < 40) && (ricemade == 10)){
//            ricemade = 0;
//            this.remove(title2);
//            this.add(title4);
//            orders++;
//        }
//        if (((120 - seconds) < 80) && (panmade == 7)){
//            panmade = 0;
//            this.remove(title3);
//            this.add(title5);
//            orders++;
//        }
//        if (((120 - seconds) < 80) && (ricemade == 1)){
//            ricemade = 0;
//            this.remove(title4);
//            this.add(title6);
//            orders++;
//        }
//        if (((120 - seconds) < 120) && (panmade == 3)){
//            panmade = 0;
//            this.remove(title1);
//            this.add(title3);
//            orders++;
//        }
//        if (((120 - seconds) < 120) && (ricemade == 3)){
//            ricemade = 0;
//            this.remove(title1);
//            this.add(title3);
//            orders++;
//        }
//        if (seconds < 85 ){
//            this.remove(title1);
//            this.remove(title2);
//            this.add(title3);
//            this.add(title4);
//            panmade = 0;
//            ricemade = 0;
//        }
//        if (seconds < 45){
//            this.remove(title1);
//            this.remove(title2);
//            this.add(title3);
//            this.add(title4);
//            panmade = 0;
//            ricemade = 0;
//        }
//        if (seconds == 0){
//            this.remove(title1);
//            this.remove(title2);
//            this.add(title3);
//            this.add(title4);
//            panmade = 0;
//            ricemade = 0;
//        }
//        repaint();




    }

    public void checkCollision() {

        if((imageCorner.getY()  < otherImage.getY()
                && imageCorner.getY() > otherImage.getY() - 10)
                && ((imageCorner.getX()  < otherImage.getX())
                && (imageCorner.getX()  > otherImage.getX() - 10) )){

            image = new ImageIcon(getClass().getResource("/Bowl-1.png (5).png"));
            sugargain = true;
        }
        if((imageCorner.getY()  < flourp.getY()
                && imageCorner.getY() > flourp.getY() - 10)
                && ((imageCorner.getX()  < flourp.getX())
                && (imageCorner.getX()  > flourp.getX() - 10) )){

            image = new ImageIcon(getClass().getResource("/Bowl-1.png (5).png"));
            flourgain = true;
        }
        if((imageCorner.getY()  < ricep.getY()
                && imageCorner.getY() > ricep.getY() - 10)
                && ((imageCorner.getX()  < ricep.getX())
                && (imageCorner.getX()  > ricep.getX() - 10) )){

            image = new ImageIcon(getClass().getResource("/Bowl-1.png (5).png"));
            ricegain = true;
        }

        if((imageCorner.getY()  < eggp.getY()
                && imageCorner.getY() > eggp.getY() - 10)
                && ((imageCorner.getX()  < eggp.getX())
                && (imageCorner.getX()  > eggp.getX() - 10) )){

            image = new ImageIcon(getClass().getResource("/Bowl-1.png (5).png"));
            egggain = true;
        }

        if((imageCorner.getY()  < keyp.getY()
                && imageCorner.getY() > keyp.getY() - 10)
                && ((imageCorner.getX()  < keyp.getX())
                && (imageCorner.getX()  > keyp.getX() - 10) )){

            image = new ImageIcon(getClass().getResource("/Rusty_Key.png"));
            keyPicked = true;
            keyp = new Point(1000000000, 3000000);
            repaint();
        }

        if((imageCorner.getY()  < panp.getY()
                && imageCorner.getY() > panp.getY() - 10)
                && ((imageCorner.getX()  < panp.getX())
                && (imageCorner.getX()  > panp.getX() - 10) )){

            if(egggain == true && flourgain == true){
                image = new ImageIcon(getClass().getResource("/Pancakes.png"));
                egggain = false;
                sugargain = false;
                ricegain = false;
                flourgain = false;
                panmade++;


            }

            if (egggain == true && sugargain == true && ricegain == true){
                image = new ImageIcon(getClass().getResource("/Rice_Pudding.png"));
                egggain = false;
                sugargain = false;
                ricegain = false;
                flourgain = false;
                ricemade++;

            }
        }
        if((imageCorner.getY()  < keyp.getY()
                && imageCorner.getY() > keyp.getY() - 10)
                && ((imageCorner.getX()  < keyp.getX())
                && (imageCorner.getX()  > keyp.getX() - 10) )){

            image = new ImageIcon(getClass().getResource("/Rusty_Key.png"));
            keyPicked = true;
        }

        if((imageCorner.getY()  < 200
                && imageCorner.getY() > 40)
                && ((imageCorner.getX()  < 700)
                && (imageCorner.getX()  > 500) )){

            image = new ImageIcon(getClass( ).getResource("/Bowl-1.png (4).png"));

        }

    }



    public void paintComponent(Graphics g){
        super.paintComponent(g);
        backgroundImage.paintIcon(this, g, 0,0);
        image1.paintIcon(this, g, (int)otherImage.getX(), (int)otherImage.getY());
        image.paintIcon(this, g, (int)imageCorner.getX(), (int)imageCorner.getY());
        flour.paintIcon(this, g, (int)flourp.getX(), (int)flourp.getY());
        rice.paintIcon(this, g, (int)ricep.getX(), (int)ricep.getY());
        egg.paintIcon(this, g, (int)eggp.getX(), (int)eggp.getY());
        pan.paintIcon(this, g, (int)panp.getX(), (int)panp.getY());
        key.paintIcon(this, g, (int)keyp.getX(), (int)keyp.getY());


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
