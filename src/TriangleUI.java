/*
 * TriangleUI.java
 *
 * Version 2.0.0
 *
 * Created 9/9/16 by Andrew Shubin
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TriangleUI {

    /*
     *   SWING code heavily influenced by sample code at:
     *   https://www.tutorialspoint.com/swing/swing_quick_guide.htm
     */

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel inputPanel;
    
    public TriangleUI() {
        prepareGUI();
        showGUI();
    }
    
    private void prepareGUI() {
        mainFrame = new JFrame("A Triangle Identifier");
        mainFrame.setSize(700, 300);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(new GridLayout(3,1));

        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);

        statusLabel.setSize(275,50);

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4,3));

        mainFrame.add(headerLabel);
        mainFrame.add(inputPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showGUI() {
        headerLabel.setText("Welcome. Please enter 3 triangle side-lengths:");

        JButton submitButton = new JButton("Identify!");

        JTextField sideA = new JTextField();
        JTextField sideB = new JTextField();
        JTextField sideC = new JTextField();

        JLabel labelA = new JLabel("Side A: ", JLabel.RIGHT);
        JLabel labelB = new JLabel("Side B: ", JLabel.RIGHT);
        JLabel labelC = new JLabel("Side C: ", JLabel.RIGHT);

        submitButton.setActionCommand("submit");

        inputPanel.add(labelA);
        inputPanel.add(sideA);
        inputPanel.add(new JLabel("")); // These are placeholders
        inputPanel.add(labelB);
        inputPanel.add(sideB);
        inputPanel.add(new JLabel(""));
        inputPanel.add(labelC);
        inputPanel.add(sideC);
        inputPanel.add(new JLabel(""));
        inputPanel.add(new JLabel(""));
        inputPanel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();

                if (command.equals("submit")) {
                    String aString = sideA.getText();
                    String bString = sideB.getText();
                    String cString = sideC.getText();

                    if (UseTriangle.inputIsValid(aString, bString, cString)) {
                        String id = UseTriangle.idTriangle(Double.parseDouble(aString),
                                                                Double.parseDouble(bString),
                                                                Double.parseDouble(cString));
                        statusLabel.setText(id);
                    }
                    else {
                        statusLabel.setText("The input is invalid. Please use numbers only.");
                    }
                }
                else {
                    statusLabel.setText("App encountered an error... :(");
                }
            }
        });

        mainFrame.setVisible(true);
    }

}
