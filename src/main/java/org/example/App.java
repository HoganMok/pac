package org.example;
import javax.swing.JFrame;
import java.awt.*;

public class App {
    JFrame frame;
    Game game;
    App(){
        frame = new JFrame("PAC-MAN");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        game = new Game();
        frame.add(game);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
