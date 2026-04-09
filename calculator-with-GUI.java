import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame implements ActionListener {

    JTextField textField;
    String operator;
    double num1, num2;

    CalculatorGUI() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text Field
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        add(textField, BorderLayout.NORTH);

        // Buttons Panel (GridLayout)
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0","C","=","+"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            textField.setText(textField.getText() + command);
        } 
        else if (command.equals("C")) {
            textField.setText("");
        } 
        else if (command.equals("=")) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case "+": textField.setText("" + (num1 + num2)); break;
                case "-": textField.setText("" + (num1 - num2)); break;
                case "*": textField.setText("" + (num1 * num2)); break;
                case "/": 
                    if (num2 != 0)
                        textField.setText("" + (num1 / num2));
                    else
                        textField.setText("Error");
                    break;
            }
        } 
        else {
            num1 = Double.parseDouble(textField.getText());
            operator = command;
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
