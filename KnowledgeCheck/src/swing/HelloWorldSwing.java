package swing;

import javax.swing.*;

public class HelloWorldSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("HelloWorldSwing"); // 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //
        JLabel label = new JLabel("Hello World"); // 
        frame.add(label); // 
        //frame.getContentPane().add(label);  // korabban
        frame.pack(); // 
        //frame.setVisible(true); //
    }
}