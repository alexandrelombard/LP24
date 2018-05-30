package fr.utbm.lp24.td5.ex3.panels;

import fr.utbm.lp24.td5.ex3.CalculatorController;
import fr.utbm.lp24.td5.ex3.Operator;
import fr.utbm.lp24.td5.ex3.buttons.OperatorButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The panel containing the operators
 * @author Alexandre Lombard
 */
public class OperatorPanel extends JPanel {

    public OperatorPanel(CalculatorController controller) {
        this.setLayout(new GridLayout(0, 1));

        final OperatorButton add = new OperatorButton(Operator.ADD);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.selectOperator(Operator.ADD);
            }
        });

        final OperatorButton subtract = new OperatorButton(Operator.SUBTRACT);
        subtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.selectOperator(Operator.SUBTRACT);
            }
        });

        final OperatorButton multiply = new OperatorButton(Operator.MULTIPLY);
        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.selectOperator(Operator.MULTIPLY);
            }
        });

        final OperatorButton divide = new OperatorButton(Operator.DIVIDE);
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.selectOperator(Operator.DIVIDE);
            }
        });

        this.add(add);
        this.add(subtract);
        this.add(multiply);
        this.add(divide);
    }

}
