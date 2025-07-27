import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        while (playAgain) {
            int target = rand.nextInt(100) + 1;  // Random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess a number between 1 and 100. You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == target) {
                    System.out.println("✅ Correct! You guessed it in " + attempts + " attempts.");
                    totalScore += (maxAttempts - attempts + 1) * 10;  // Score decreases with more attempts
                    guessedCorrectly = true;
                    break;
                } else if (guess > target) {
                    System.out.println("📉 Too high!");
                } else {
                    System.out.println("📈 Too low!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all your attempts. The correct number was: " + target);
            }

            System.out.println("🎯 Your current score: " + totalScore);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = sc.next().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("👋 Thanks for playing! Final score: " + totalScore);
        sc.close();
    }
}
