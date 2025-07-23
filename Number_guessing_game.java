import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Number_guessing_game {
    private int numberToGuess;
    private int attemptsLeft;
    private Random random;

    public Number_guessing_game() {
        random = new Random();
        resetGame();

        JFrame frame = new JFrame("Number Guessing Game");
        JTextField inputField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        JLabel messageLabel = new JLabel("Guess a number between 1 and 100");
        JLabel attemptsLabel = new JLabel("Attempts left: " + attemptsLeft);

        JPanel panel = new JPanel();
        panel.add(messageLabel);
        panel.add(inputField);
        panel.add(guessButton);
        panel.add(attemptsLabel);

        guessButton.addActionListener(e -> {
            try {
                int guess = Integer.parseInt(inputField.getText());
                attemptsLeft--;

                if (guess == numberToGuess) {
                    messageLabel.setText("Correct! 🎉");
                    guessButton.setEnabled(false);
                } else if (attemptsLeft == 0) {
                    messageLabel.setText("Out of attempts! Number was " + numberToGuess);
                    guessButton.setEnabled(false);
                } else if (guess < numberToGuess) {
                    messageLabel.setText("Too low!");
                } else {
                    messageLabel.setText("Too high!");
                }
                attemptsLabel.setText("Attempts left: " + attemptsLeft);
                inputField.setText("");

            } catch (NumberFormatException ex) {
                messageLabel.setText("Please enter a valid number.");
            }
        });

        int restart = JOptionPane.showConfirmDialog(frame, panel, "Play the Game", JOptionPane.DEFAULT_OPTION);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    private void resetGame() {
        numberToGuess = random.nextInt(100) + 1;
        attemptsLeft = 7;
    }

    public static void main(String[] args) {
        new Number_guessing_game();
    }
}
