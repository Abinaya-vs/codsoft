import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 7;
        int score = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between " + minRange + " and " + maxRange + ".");
        
        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            while (!guessedCorrectly && attempts < attemptsLimit) {
                System.out.print("Enter your guess (attempt " + (attempts + 1) + "/" + attemptsLimit + "): ");
                int userGuess = scanner.nextInt();
                
                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Please enter a number within the range.");
                    continue;
                }
                
                attempts++;
                
                if (userGuess == randomNumber) {
                    guessedCorrectly = true;
                    score += attemptsLimit - attempts + 1;
                    System.out.println("Congratulations! You've guessed the number " + randomNumber + " correctly in " + attempts + " attempts.");
                    System.out.println("Your current score: " + score);
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've exceeded the number of attempts. The correct number was: " + randomNumber);
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes") || playAgainResponse.equals("y");
        }
        
        System.out.println("Thanks for playing! Your final score: " + score);
        scanner.close();
    }
}
