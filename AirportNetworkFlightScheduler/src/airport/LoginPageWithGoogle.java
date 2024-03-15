package airport;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

public class LoginPageWithGoogle extends JFrame {
    private JFXPanel webViewPanel;

    public LoginPageWithGoogle() {
        setTitle("Login Page with Google");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        webViewPanel = new JFXPanel();
        panel.add(webViewPanel, BorderLayout.CENTER);

        add(panel);

        // Initialize JavaFX
        Platform.runLater(this::initializeWebView);

        setVisible(true);
    }

    private void initializeWebView() {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load(getClass().getResource("/google_login.html").toExternalForm());

        webView.setPrefSize(400, 250);
        webViewPanel.setScene(new Scene(webView));

        JSObject jsWindow = (JSObject) webEngine.executeScript("window");
        jsWindow.setMember("javaConnector", new JavaConnector());

        // Handle closing the window
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Platform.exit();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginPageWithGoogle();
        });
    }

    public class JavaConnector {
        public void onGoogleSignIn(String googleIdToken) {
            // Here, you would handle the Google Sign-In token
            // Validate the token and proceed with authentication
            JOptionPane.showMessageDialog(null, "Google Sign-In Successful!\nToken: " + googleIdToken);
        }
    }
}

