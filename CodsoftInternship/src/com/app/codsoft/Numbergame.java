package com.app.codsoft;


import java.util.Random;
import java.util.Scanner;

public class Numbergame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;
        int totalScore = 0;

        while (playAgain) {
            playAgain = playGame(random, scanner);
            totalScore++;
        }

        System.out.println(" total score across all rounds is " + totalScore + ". Thanks for playing!");
        scanner.close();
    }

    private static boolean playGame(Random random, Scanner scanner) {
    //min num
        int lowerLimit = 1;
        int upperLimit = 100;
        int targetNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;

        // max number 
        int maxAttempts = 5;
        int attempts = 0;

        System.out.println("Guess the number between " + lowerLimit + " and " + upperLimit + ".");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You guessed the number " + targetNumber +
                        " correctly in " + attempts + " attempts.");
                break;
            } else if (userGuess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        System.out.print("Do you want to play again? (yes/no): ");
        String playAgainInput = scanner.next().toLowerCase();
        return playAgainInput.equals("yes");
    }
}