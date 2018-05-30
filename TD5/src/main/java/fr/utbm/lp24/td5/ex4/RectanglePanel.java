package fr.utbm.lp24.td5.ex4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * The panel where the rectangles will be drawn, it extends the JPanel class and for a matter of simplicity, it
 * implements MouseListener to handle the mouse events, and the MouseMotionListener interface to handle mouse
 * movements
 * @author Alexandre Lombard
 */
public class RectanglePanel extends JPanel implements MouseListener, MouseMotionListener {

    private List<Rectangle> rectangles = new ArrayList<>();

    /** We can be in two states: either we are currently drawing a rectangle, or we aren't */
    private boolean currentlyDrawing = false;

    /** The coordinates of the first click in the panel */
    private Point firstClickCoordinates;

    /** The current coordinates of the mouse */
    private Point currentMouseCoordinates;

    /**
     * Panel constructor
     */
    public RectanglePanel() {
        // We define here the preferred size for the panel: it will be the size applied by the containing JFrame
        // if possible (according to the layout settings)
        this.setPreferredSize(new Dimension(800, 600));

        // Note: don't forget to register this class as a listener for the mouse events
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // The drawing behaviour of the application is located in this function

        // First we draw all current rectangles of the list
        for(Rectangle r : this.rectangles) {
            g.setColor(r.getColor());
            g.drawRect(r.getX(), r.getY(), r.getWidth(), r.getHeight());
        }

        // If we are currently drawing, we draw a rectangle between the first click coordinates and the
        // current mouse coordinates
        if(this.currentlyDrawing) {
            Point topLeft = new Point(
                    (int) (Math.min(firstClickCoordinates.getX(), currentMouseCoordinates.getX())),
                    (int) (Math.min(firstClickCoordinates.getY(), currentMouseCoordinates.getY())));
            Point bottomRight = new Point(
                    (int) (Math.max(firstClickCoordinates.getX(), currentMouseCoordinates.getX())),
                    (int) (Math.max(firstClickCoordinates.getY(), currentMouseCoordinates.getY())));
            int width = (int) (bottomRight.getX() - topLeft.getX());
            int height = (int) (bottomRight.getY() - topLeft.getY());

            g.setColor(Color.RED);
            g.drawRect((int) topLeft.getX(), (int) topLeft.getY(), width, height);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // We log some text to visualize the behavior of the application
        Logger.getLogger(getClass().getName()).info("Mouse clicked: " + e.getPoint());

        // If we were'nt drawing, a click start the drawing mode. We store the coordinates of the click
        if(!this.currentlyDrawing) {
            this.firstClickCoordinates = e.getPoint();
            this.currentlyDrawing = true;

            Logger.getLogger(getClass().getName()).info("Starting drawing rectangle...");
        } else {
            // Otherwise, we create the rectangle object and we store it in the rectangle collection
            // The rectangle goes from <i>firstClickCoordinates</i> to the current coordinates
            // We compute height and width accordingly
            Point topLeft = new Point(
                    (int) (Math.min(firstClickCoordinates.getX(), currentMouseCoordinates.getX())),
                    (int) (Math.min(firstClickCoordinates.getY(), currentMouseCoordinates.getY())));
            Point bottomRight = new Point(
                    (int) (Math.max(firstClickCoordinates.getX(), currentMouseCoordinates.getX())),
                    (int) (Math.max(firstClickCoordinates.getY(), currentMouseCoordinates.getY())));
            int width = (int) (bottomRight.getX() - topLeft.getX());
            int height = (int) (bottomRight.getY() - topLeft.getY());

            this.rectangles.add(new Rectangle(
                    (int) topLeft.getX(),
                    (int) topLeft.getY(),
                    width,
                    height,
                    new Color((float) Math.random(), (float) Math.random(), (float) Math.random())));

            // We reset the state "currently drawing" to false (we have finished drawing the rectangle)
            this.currentlyDrawing = false;

            Logger.getLogger(getClass().getName()).info("Finished drawing rectangle");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Here we update the mouse coordinates
        this.currentMouseCoordinates = e.getPoint();

        // This call will force Swing to redraw the panel (so paintComponent will be called)
        this.repaint();
    }
}
