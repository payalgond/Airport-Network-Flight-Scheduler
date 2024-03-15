package airport;

import javax.swing.*;

public class login {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Page");
        frame.setSize(300, 150);
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

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 80, 80, 25);
        frame.add(loginButton);

        JLabel statusLabel = new JLabel();
        statusLabel.setBounds(100, 110, 160, 25);
        frame.add(statusLabel);

        loginButton.addActionListener(e -> {
            String username = userText.getText();
            String password = new String(passwordText.getPassword());
            if (username.equals("admin") && password.equals("password")) {
                statusLabel.setText("Login Successful");
            } else {
                statusLabel.setText("Login Failed");
            }
        });

        frame.setVisible(true);
    }
}

