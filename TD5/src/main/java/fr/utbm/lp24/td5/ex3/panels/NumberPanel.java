package fr.utbm.lp24.td5.ex3.panels;

import fr.utbm.lp24.td5.ex3.CalculatorController;
import fr.utbm.lp24.td5.ex3.buttons.NumberButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel containing the numbers
 * @author Alexandre Lombard
 */
public class NumberPanel extends JPanel {

    public NumberPanel(CalculatorController controller) {
        this.setLayout(new GridLayout(0, 3));

        // We create the 10 buttons for numbers
        final NumberButton[] buttons = new NumberButton[10];
        for(int i = 0; i < 10; i++) {
            final NumberButton button = new NumberButton(i);

            // Everytime a number button is clicked, the "appendDigit" method of the controller will be called
            // with, as parameter, the value of the button
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.appendDigit(button.getValue());
                }
            });

            buttons[i] = button;
        }

        // Because of the order of the button, it would be useless to use loop, yet it's repetitive code
        this.add(buttons[7]);
        this.add(buttons[8]);
        this.add(buttons[9]);
        this.add(buttons[4]);
        this.add(buttons[5]);
        this.add(buttons[6]);
        this.add(buttons[1]);
        this.add(buttons[2]);
        this.add(buttons[3]);

        this.add(new JButton("."));
        // TODO Write the behavior for the click on the dot

        this.add(buttons[0]);

        // = button: on click, we compute the result
        JButton equalButton = new JButton("=");
        equalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.computeResult();
            }
        });
        // Note, an equivalent syntax to the previous instruction is:
        // equalButton.addActionListener(e -> controller.computeResult());
        // Much more concise: look for "lambda expressions" to learn more about this syntax

        this.add(equalButton);
    }

}
