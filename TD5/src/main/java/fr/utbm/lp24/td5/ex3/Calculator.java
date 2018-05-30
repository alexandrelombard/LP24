package fr.utbm.lp24.td5.ex3;

import fr.utbm.lp24.td5.ex3.panels.NumberPanel;
import fr.utbm.lp24.td5.ex3.panels.OperatorPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main calculator class (JFrame)
 * @author Alexandre Lombard
 */
public class Calculator extends JFrame {

    // region UI components
    /** The label which will display the result */
    private JLabel resultLabel;
    /** The panel with the numbers */
    private JPanel numbersPanel;
    /** The panel with the operators */
    private JPanel operatorsPanel;
    /** The clear button */
    private JButton clearButton;
    // endregion

    public Calculator() {
        // We create the controller here
        CalculatorController controller = new CalculatorController(this);

        this.setLayout(new BorderLayout());

        this.resultLabel = new JLabel("0");
        this.resultLabel.setPreferredSize(new Dimension(300, 50));
        this.resultLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.numbersPanel = new NumberPanel(controller);
        this.operatorsPanel = new OperatorPanel(controller);
        this.clearButton = new JButton("Clear");
        this.clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.clear();
            }
        });

        // Everything is initialized, don't forget to add the components to the frame
        this.getContentPane().add(this.resultLabel, BorderLayout.NORTH);
        this.getContentPane().add(this.numbersPanel, BorderLayout.CENTER);
        this.getContentPane().add(this.operatorsPanel, BorderLayout.EAST);
        this.getContentPane().add(this.clearButton, BorderLayout.SOUTH);

        this.pack();
    }

    public void setResultLabelValue(float value) {
        this.resultLabel.setText(Float.toString(value));
    }

    public static void main(String[] args) throws ClassNotFoundException,
            UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        // The next line allow you to have a native look & feel: instead of having a weird blue color, the buttons
        // will have the style of your OS
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        Calculator calculator = new Calculator();
        calculator.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        calculator.setVisible(true);
    }

}
