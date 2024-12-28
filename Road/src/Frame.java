import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    public final static int FWIDTH = 1000;
    public final static int FHEIGTH = 600;


    Frame(){

        this.setTitle("Road");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(FWIDTH, FHEIGTH);
        this.setResizable(false);
        this.setContentPane(new Panel());
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }
}
