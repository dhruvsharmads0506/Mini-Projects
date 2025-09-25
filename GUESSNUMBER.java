import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuessNumberGame extends JFrame implements ActionListener {
    private int myNumber;
    private JTextField inputField;
    private JLabel messageLabel;
    private JButton guessButton, resetButton;

    public GuessNumberGame() {
        // Window setup
        setTitle("Guess the Number Game");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 10, 10));

        // Generate random number (1-100)
        myNumber = (int) (Math.random() * 100 + 1);

        // UI Components
        JLabel instructionLabel = new JLabel("Guess my number (1-100):", SwingConstants.CENTER);
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 16));

        inputField = new JTextField();
        inputField.setHorizontalAlignment(JTextField.CENTER);

        messageLabel = new JLabel("Enter your guess!", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        JPanel buttonPanel = new JPanel();
        guessButton = new JButton("Guess");
        resetButton = new JButton("Reset");
        buttonPanel.add(guessButton);
        buttonPanel.add(resetButton);

        // Add listeners
        guessButton.addActionListener(this);
        resetButton.addActionListener(this);

        // Add components
        add(instructionLabel);
        add(inputField);
        add(messageLabel);
        add(buttonPanel);

        setLocationRelativeTo(null); // Center window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guessButton) {
            try {
                int userGuess = Integer.parseInt(inputField.getText());

                if (userGuess == myNumber) {
                    messageLabel.setText("🎉 WOOHOO! Correct Number!");
                    messageLabel.setForeground(Color.GREEN);
                } else if (userGuess > myNumber) {
                    messageLabel.setText("Your number is too large ⬆️");
                    messageLabel.setForeground(Color.RED);
                } else {
                    messageLabel.setText("Your number is too small ⬇️");
                    messageLabel.setForeground(Color.BLUE);
                }
            } catch (NumberFormatException ex) {
                messageLabel.setText("❌ Please enter a valid number!");
                messageLabel.setForeground(Color.ORANGE);
            }
        } else if (e.getSource() == resetButton) {
            myNumber = (int) (Math.random() * 100 + 1);
            inputField.setText("");
            messageLabel.setText("Enter your guess!");
            messageLabel.setForeground(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        new GuessNumberGame();
    }
}

