import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyFrame extends JFrame{

    private DragPanel dragPanel = new DragPanel();
    private Menu menu = new Menu();
    public static String currentScreen = "menu";

    private ImageIcon image1 = new ImageIcon(getClass().getResource("/scroll.png"));

    private JButton button;
    private JButton button2;
    private JButton button3;
    public MyFrame() throws IOException, FontFormatException {
        button = new JButton("");
        button.addActionListener(this::actionPerformed);
        button.setIcon(image1);
        button.setBounds(1200,500,300,200);
        button.setBackground(Color.white);
        button.setForeground(Color.black);
        button.setBorder(BorderFactory.createEmptyBorder());
        this.add(button);

        button2 = new JButton("");
        button2.addActionListener(this::actionPerformed);
        button2.setIcon(image1);
        button2.setBounds(1200,700,300,200);
        button2.setBackground(Color.white);
        button2.setForeground(Color.black);
        button2.setBorder(BorderFactory.createEmptyBorder());
        this.add(button2);

        button3 = new JButton("");
        button3.addActionListener(this::actionPerformed);
        button3.setIcon(image1);
        button3.setBounds(1200,300,300,200);
        button3.setBackground(Color.white);
        button3.setForeground(Color.black);
        button3.setBorder(BorderFactory.createEmptyBorder());
        this.add(button3);



        if (currentScreen == "menu"){
            this.add(menu);
        }
        if (currentScreen == "game"){

            this.add(dragPanel);}

        this.setTitle("Food Truk");
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);





        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==button3) {

            this.remove(button);
            this.remove(button2);
            this.remove(button3);
            currentScreen= "game";
            this.add(dragPanel);
            this.repaint();
            this.revalidate();

        }

        if(e.getSource()==button) {
            this.remove(button);
            this.remove(button2);
            this.remove(button3);
//            this.remove(backgrounds);
            this.revalidate();
//            try {
//                InstructionsScreen();
//            } catch (IOException e1) {
//                // TODO Auto-generated catch block
//                e1.printStackTrace();
//            }
        }

        if(e.getSource()==button2) {
            System.exit(0);

        }
//        if(e.getSource() == instructionsscreenbutton)
//        {
//            this.setVisible(false);
//            try {
//                Game game = new Game();
//            } catch (FontFormatException | IOException e1) {
//                // TODO Auto-generated catch block
//                e1.printStackTrace();
//            }
//
//
//        }
    }


}