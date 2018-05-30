package fr.utbm.lp24.td5.ex3.buttons;

import javax.swing.*;

/**
 * Represents a number button
 * @author Alexandre Lombard
 */
public class NumberButton extends JButton {

    private int value;

    /**
     * Constructor initializing the value attribute that will be the number value of this
     * @param value the value
     */
    public NumberButton(int value) {
        this.value = value;

        // Set text according to the value
        this.setText(Integer.toString(this.value));
    }

    public int getValue() {
        return this.value;
    }

}
