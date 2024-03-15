package airport;

import javax.swing.*;

public class RegistrationPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Registration Page");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 10, 80, 25);
        frame.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(100, 10, 160, 25);
        frame.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 40, 80, 25);
        frame.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(100, 40, 160, 25);
        frame.add(passwordText);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(10, 70, 120, 25);
        frame.add(confirmPasswordLabel);

        JPasswordField confirmPasswordText = new JPasswordField();
        confirmPasswordText.setBounds(140, 70, 120, 25);
        frame.add(confirmPasswordText);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(100, 110, 100, 25);
        frame.add(registerButton);

        JLabel statusLabel = new JLabel();
        statusLabel.setBounds(100, 140, 160, 25);
        frame.add(statusLabel);

        registerButton.addActionListener(e -> {
            String username = userText.getText();
            String password = new String(passwordText.getPassword());
            String confirmPassword = new String(confirmPasswordText.getPassword());

            if (!username.isEmpty() && !password.isEmpty() && password.equals(confirmPassword)) {
                statusLabel.setText("Registration Successful");
            } else {
                statusLabel.setText("Registration Failed");
            }
        });

        frame.setVisible(true);
    }
}

