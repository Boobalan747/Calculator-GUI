package calc_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame implements ActionListener {
	
	  JTextField textField;
	    double num1, num2, result;
	    char operator;

	    public CalculatorGUI() {
	        // Frame settings
	        setTitle("Calculator");
	        setSize(400, 500);
	        setLocationRelativeTo(null); // Center the window
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new BorderLayout());

	        // Display field
	        textField = new JTextField();
	        textField.setEditable(false);
	        textField.setFont(new Font("Arial", Font.BOLD, 30));
	        add(textField, BorderLayout.NORTH);

	        // Buttons
	        JPanel buttonPanel = new JPanel();
	        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));

	        String[] buttons = {
	            "7", "8", "9", "/",
	            "4", "5", "6", "*",
	            "1", "2", "3", "-",
	            "0", "C", "=", "+"
	        };

	        for (String text : buttons) {
	            JButton button = new JButton(text);
	            button.setFont(new Font("Arial", Font.BOLD, 24));
	            button.addActionListener(this);
	            buttonPanel.add(button);
	        }

	        add(buttonPanel, BorderLayout.CENTER);
	        setVisible(true);
	    }

	    public void actionPerformed(ActionEvent e) {
	        String input = e.getActionCommand();

	        if (input.charAt(0) >= '0' && input.charAt(0) <= '9') {
	            textField.setText(textField.getText() + input);
	        } else if (input.equals("C")) {
	            textField.setText("");
	        } else if (input.equals("=")) {
	            num2 = Double.parseDouble(textField.getText());
	            switch (operator) {
	                case '+': result = num1 + num2; break;
	                case '-': result = num1 - num2; break;
	                case '*': result = num1 * num2; break;
	                case '/': 
	                    if (num2 == 0) {
	                        textField.setText("Error");
	                        return;
	                    }
	                    result = num1 / num2; 
	                    break;
	            }
	            textField.setText("" + result);
	        } else {
	            num1 = Double.parseDouble(textField.getText());
	            operator = input.charAt(0);
	            textField.setText("");
	        }
	    }

	    public static void main(String[] args) {
	        new CalculatorGUI();
	    }

}
