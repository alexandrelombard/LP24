package fr.utbm.lp24.td5.ex3;

/**
 * Main controller of the application (remember about the MVC design pattern), the main logic of the application
 * (i.e. the reaction to the events) is written here.
 * Please note how all the mechanics of the calculator are written here in high-level functions, instead of being
 * directly written in the buttons.
 * @author Alexandre Lombard
 */
public class CalculatorController {

    // Model of the application is pretty limited, so it is store in the controller. It is composed of the three
    // following attributes
    /** Stores the current result (cumulative) of previous operations */
    private float currentResult = 0;
    /** The currently selected operator */
    private Operator selectedOperator = Operator.NONE;
    /** The current value (i.e. the one being currently written) */
    private float currentValue = 0;

    // The controller has a reference to the view in order to update it
    private Calculator calculator;

    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    /**
     * Append a digit
     * @param value the digit
     */
    public void appendDigit(int value) {
        // Here we write the behavior when a digit is added
        if(this.currentValue == 0) {
            this.currentValue = value;
        } else {
            // We multiply the current value by 10 and we add the new value
            this.currentValue = this.currentValue * 10 + value;
        }

        // Note: adding a digit when no operator is selected will reset the result (so if a digit is pressed after equal
        // all previous results are reset)
        if(this.selectedOperator == Operator.NONE) {
            this.currentResult = 0;
        }

        // We update the UI
        this.calculator.setResultLabelValue(this.currentValue);
    }

    /**
     * Select an operator
     * @param operator the operator
     */
    public void selectOperator(Operator operator) {
        // We update the result according to the previously selected operator
        this.computeResult();

        // Here we write the behavior when a new operator is selected
        this.selectedOperator = operator;

        // We clear the current value
        this.currentValue = 0;

        // We update the user interface
        this.calculator.setResultLabelValue(0);
    }

    /**
     * Compute the result
     */
    public void computeResult() {
        // Here we write the behavior when the result should be computed (= has been clicked)
        switch (this.selectedOperator) {
            case NONE:  // None is equivalent to add (actually adding to 0)
            case ADD:
                this.currentResult += this.currentValue;
                break;
            case SUBTRACT:
                this.currentResult -= this.currentValue;
                break;
            case MULTIPLY:
                this.currentResult *= this.currentValue;
                break;
            case DIVIDE:
                this.currentResult /= this.currentValue;
                break;
        }

        this.selectedOperator = Operator.NONE;
        this.currentValue = 0;

        this.calculator.setResultLabelValue(this.currentResult);
    }

    public void clear() {
        this.currentResult = 0;
        this.currentValue = 0;
        this.selectedOperator = Operator.NONE;

        this.calculator.setResultLabelValue(0);
    }
}
