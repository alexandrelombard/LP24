package fr.utbm.lp24.td5.ex4;

import javax.swing.*;
import java.awt.*;

/**
 * Main JFrame of the application, which will hold the panel where the rectangles will be drawn
 * @author Alexandre Lombard
 */
public class Frame extends JFrame {

    /**
     * Frame constructor: initializing the frame
     */
    public Frame() {
        this.setLayout(new BorderLayout());
        this.setTitle("Exercise #4");

        // Note that in the following line I'm adding my own custom panel as a component of the user interface
        this.getContentPane().add(new RectanglePanel(), BorderLayout.CENTER);

        // The following line adjust the size of the frame following the size of the contained components
        this.pack();
    }

    /**
     * The main function of the application: creates and draw the Frame
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        final Frame frame = new Frame();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
