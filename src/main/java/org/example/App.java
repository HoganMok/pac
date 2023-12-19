package org.example;
import javax.swing.JFrame;
public class App {
    JFrame frame;
    App(){
        frame = new JFrame("PAC-MAN");
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
