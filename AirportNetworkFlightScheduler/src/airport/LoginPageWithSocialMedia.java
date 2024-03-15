package airport;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPageWithSocialMedia extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton loginWithGoogleButton;
    private JButton loginWithFacebookButton;

    public LoginPageWithSocialMedia() {
        setTitle("Login Page");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel usernameLabel = new JLabel("Username:");
        panel.add(usernameLabel);

        usernameField = new JTextField();
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        panel.add(loginButton);

        loginWithGoogleButton = new JButton(new ImageIcon("google_icon.png")); // Change path to your Google icon image
        loginWithGoogleButton.setToolTipText("Login with Google");
        panel.add(loginWithGoogleButton);

        loginWithFacebookButton = new JButton(new ImageIcon("facebook_icon.png")); // Change path to your Facebook icon image
        loginWithFacebookButton.setToolTipText("Login with Facebook");
        panel.add(loginWithFacebookButton);

        add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Dummy authentication, replace with your own authentication logic
        if (username.equals("admin") && password.equals("password")) {
            JOptionPane.showMessageDialog(this, "Login Successful");
        } else {
            JOptionPane.showMessageDialog(this, "Login Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginPageWithSocialMedia();
        });
    }
}

