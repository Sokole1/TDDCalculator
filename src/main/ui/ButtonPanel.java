package main.ui;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    private final int WIDTH = CalculatorFrame.WIDTH;
    private final int HEIGHT = CalculatorFrame.HEIGHT - 200;
    private JButton[] myButtons;
    private Display display;

    public ButtonPanel(Display display) {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setLayout(new GridLayout(4, 4, 5, 5));
        this.display = display;
        initializeButtons();
    }

    // MODIFIES: this
    // EFFECTS: initializes array of buttons, sets up ActionListener, and adds each to panel
    private void initializeButtons() {
        myButtons = new JButton[]{
                new JButton("1"),
                new JButton("2"),
                new JButton("3"),
                new JButton("+"),
                new JButton("4"),
                new JButton("5"),
                new JButton("6"),
                new JButton("-"),
                new JButton("7"),
                new JButton("8"),
                new JButton("9"),
                new JButton("x"),
                new JButton("0"),
                new JButton("="),
                new JButton("del"),
                new JButton("AC")
        };

        for (JButton button : myButtons) {
            button.addActionListener(e ->
                    display.addSymbol(e.getActionCommand()));
            button.setFont(new Font("Consolas", Font.BOLD, 50));
            button.setFocusable(false);
            add(button);
        }
    }
}
