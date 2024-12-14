
import javax.swing.*;
import java.awt.*;

public class App extends JFrame{
    JFrame f;

    App(){
        f=new JFrame();
        f.setTitle("Stopwatch");
        f.setSize(500,500);
        f.setLayout(new BorderLayout());
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setVisible(true);

        Display time_panel=new Display();
        f.add(time_panel);
    }
    public static void main(String[] args) throws Exception {
        new App();    
    }
}