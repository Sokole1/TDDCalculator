package main.ui;

import main.exceptions.InvalidInput;
import main.model.Calculator;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {

    private final int WIDTH = CalculatorFrame.WIDTH;
    private final int HEIGHT = 200;
    private final String ERROR_MESSAGE = "INVALID INPUT";

    private String inputs = "";
    private JLabel inputLabel;


    public Display() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new GridBagLayout());
        initializeLabel();
    }

    // MODIFIES: this
    // EFFECTS: initialize inputLabel
    private void initializeLabel() {
        inputLabel = new JLabel();
        inputLabel.setText(inputs);
        inputLabel.setFont(new Font("Consolas", Font.BOLD, 50));
        add(inputLabel);
    }

    // MODIFIES: this
    // EFFECTS: update the display based on the symbol provided
    public void addSymbol(String s) {
        if (inputs.equals(ERROR_MESSAGE)) {
            inputs = "";
        }
        switch (s) {
            case "-":
                inputs += "_";
                break;
            case "AC":
                inputs = "";
                break;
            case "del":
                if (!inputs.equals("")) {
                    inputs = inputs.substring(0, inputs.length() - 1);
                }
                break;
            case "=":
                try {
                    inputs = Calculator.calculate(inputs);
                } catch (InvalidInput e) {
                    inputs = ERROR_MESSAGE;
                }
                break;
            default:
                inputs += s;

        }
        inputLabel.setText(inputs.replaceAll("_", "-"));
        repaint();
    }
}
