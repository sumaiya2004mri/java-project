import java.util.Scanner;
import java.util.Random;

public class Number_guessing_game
{
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        Random ran= new Random();
        boolean playagain= true;

        System.out.println("Welcome to the game <3");

        while (playagain)
        {
            int number_to_guess = ran.nextInt(100)+1;
            int attempts_left=7;
            boolean has_guessed_correctly= false;

            System.out.println("I am thinking of a number between 1 to 100");
            System.out.println("Left attempts" + attempts_left+ "Goodluck!");
            
            while (attempts_left>0)
            {
                System.out.println("Enter your guess");
                int player_guess= sc.nextInt();
                attempts_left--;

                if (player_guess == number_to_guess)
                {
                    System.out.println("Correct!!!!!!!");
                    has_guessed_correctly= true;
                    break;
                }
                else if (player_guess > number_to_guess)
                {
                    System.out.println("Too high!");
                }
                else
                {
                    System.out.println("Too low!");
                }

                System.out.println("Attempts left"+ attempts_left);
            }

            if (!has_guessed_correctly)
            {
                System.out.println("Out of attepmts!! The correct one is " + number_to_guess);
            }

            System.out.println("Do you want to play again? (Y/N)" );
            sc.nextLine(); // fix for input bug
            String answer = sc.nextLine();
            playagain = answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y");

        }

        System.out.println("Thanks for playing");
        sc.close();

    }
}