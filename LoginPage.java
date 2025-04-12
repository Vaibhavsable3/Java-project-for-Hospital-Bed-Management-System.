import java.awt.*;
import javax.swing.*;
// Login Page Class
class LoginPage extends JFrame {
private JTextField nameField, phoneField, emailField;
public LoginPage() {
setTitle("Hospital Management System - Login");
setSize(600, 400);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
JPanel panel = new JPanel();
panel.setLayout(new GridBagLayout());
panel.setBackground(new Color(70, 130, 180)); // Steel Blue Background
setContentPane(panel);
// Fonts and Colors
Font titleFont = new Font("Serif", Font.BOLD, 40);
Font labelFont = new Font("SansSerif", Font.PLAIN, 18);
Color fieldColor = new Color(240, 248, 255);
Color buttonColor = new Color(30, 144, 255);
Color textColor = Color.WHITE;
// Title Label
JLabel titleLabel = new JLabel("Welcome to KJ's Hospital");
titleLabel.setFont(titleFont);
titleLabel.setForeground(Color.WHITE);
// Input Fields
nameField = new JTextField(15);
phoneField = new JTextField(15);
emailField = new JTextField(15);
stylizeField(nameField, fieldColor);
stylizeField(phoneField, fieldColor);
stylizeField(emailField, fieldColor);
// Labels
JLabel nameLabel = createLabel("Name:", labelFont, Color.WHITE);
JLabel phoneLabel = createLabel("Phone Number:", labelFont, Color.WHITE);
JLabel emailLabel = createLabel("Email Address:", labelFont, Color.WHITE);
// Login Button
JButton loginButton = new JButton("Login");
loginButton.setFont(new Font("SansSerif", Font.BOLD, 18));
loginButton.setBackground(buttonColor);
loginButton.setForeground(textColor);
loginButton.setFocusPainted(false);
loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
loginButton.addActionListener(e -> validateLogin());
// Layout
GridBagConstraints gbc = new GridBagConstraints();
gbc.insets = new Insets(10, 10, 10, 10);
gbc.gridx = 0;
gbc.gridy = 0;
gbc.gridwidth = 2;
panel.add(titleLabel, gbc);
gbc.gridwidth = 1;
gbc.gridx = 0;
gbc.gridy = 1;
panel.add(nameLabel, gbc);
gbc.gridx = 1;
panel.add(nameField, gbc);
gbc.gridx = 0;
gbc.gridy = 2;
panel.add(phoneLabel, gbc);
gbc.gridx = 1;
panel.add(phoneField, gbc);
gbc.gridx = 0;
gbc.gridy = 3;
panel.add(emailLabel, gbc);
gbc.gridx = 1;
panel.add(emailField, gbc);
gbc.gridx = 0;
gbc.gridy = 4;
gbc.gridwidth = 2;
panel.add(loginButton, gbc);
setVisible(true);
}
private JLabel createLabel(String text, Font font, Color color) {
JLabel label = new JLabel(text);
label.setFont(font);
label.setForeground(color);
return label;
}
private void stylizeField(JTextField field, Color bgColor) {
field.setFont(new Font("SansSerif", Font.PLAIN, 16));
field.setBackground(bgColor);
field.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
field.setOpaque(true);
}
private void validateLogin() {
String name = nameField.getText().trim();
String phone = phoneField.getText().trim();
String email = emailField.getText().trim();
if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
JOptionPane.showMessageDialog(this, "All fields must be filled!", "Error",
JOptionPane.ERROR_MESSAGE);
} 
else if (!phone.matches("\\d{10}")) {
JOptionPane.showMessageDialog(this, "Phone number must be 10 digits!", "Error",
JOptionPane.ERROR_MESSAGE);
} 
else if (!email.matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$")) {
JOptionPane.showMessageDialog(this, "Email must be a valid Gmail address (e.g.,example@gmail.com)", "Error", JOptionPane.ERROR_MESSAGE);
}
else {
JOptionPane.showMessageDialog(this, "Welcome, " + name + "! You are successfully loggedin.", "Success", JOptionPane.INFORMATION_MESSAGE);
dispose();
SwingUtilities.invokeLater(HospitalBedManagementGUI::new);
}
}
public static void main(String[] args) {
SwingUtilities.invokeLater(LoginPage::new);
}
}