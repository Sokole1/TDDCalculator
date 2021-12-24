package main.ui;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {

    public static final int WIDTH = 840;
    public static final int HEIGHT = 1380;

    private ButtonPanel buttonPanel;

    public CalculatorFrame() {
        super("Calculator");
        initializeGraphics();
    }

    // MODIFIES: this
    // EFFECTS:  draws the JFrame window where this CalculatorFrame will operate, and populates the tools to be used
    //           to manipulate this drawing
    private void initializeGraphics() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);

        Display display = new Display();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(display, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new ButtonPanel(display), gbc);
        pack();
        setVisible(true);
    }
}
