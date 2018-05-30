package fr.utbm.lp24.td5.ex3.buttons;

import fr.utbm.lp24.td5.ex3.Operator;

import javax.swing.*;

public class OperatorButton extends JButton {

    private Operator operator;

    public OperatorButton(Operator operator) {
        this.operator = operator;

        // According to the operator we set the text of the button (note: there are ways to do it which are way more
        // cleans, like storing the operator inside the enum values, but the focus is not put on this here, so this
        // approach is enough)
        switch (this.operator) {
            case NONE:
                break;
            case ADD:
                this.setText("+");
                break;
            case SUBTRACT:
                this.setText("-");
                break;
            case MULTIPLY:
                this.setText("x");
                break;
            case DIVIDE:
                this.setText("/");
                break;
        }
    }

    public Operator getOperator() {
        return this.operator;
    }
}
