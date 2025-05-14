//Programmer: Marcel Rodriguez
//Date: 6/29/2023
//Purpose: The user plays a guessing game. Program thinks of an integer and allows the user to make guesses until the guess is right. Tells if the answer is higher or lower after a guess. Asks to play the game again.

import java.util.Scanner;
import java.util.*;

public class MRGuess {
   public static final int MAX_NUMBER=100;
   public static int totalGames = 0;
   public static int totalGuesses = 0;
   public static double gameGuesses = 0;
   public static int bestGame = Integer.MAX_VALUE;
   public static boolean playAgain = true;
   public static Scanner scanner = new Scanner(System.in);
   
   public static void main(String[] args) {
      startGame();
     
      while (playAgain) {
         playGame();
         reportResults();
         wantPlayAgain();
      }
      scanner.close();
   }
   //introduce the game to the user
   public static void startGame() {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println("MAX_NUMBER and will allow you to guess until");
      System.out.println("you get it. For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");   
   }
   //play the guessing game
   public static void playGame() {
      Scanner scanner = new Scanner(System.in);
      Random rand = new Random();

      totalGames++;
      int randomNumber = rand.nextInt(100) + 1; // 1-100
      int guesses = 0;

      System.out.println("I'm thinking of a number between 1 and 100...");

      int guess = 0;
      while (guess != randomNumber) {
          System.out.print("Your guess? ");
          guess = scanner.nextInt();
          guesses++;

          if (guess == randomNumber) {
              System.out.printf("You got it right in %d guesses\n", guesses);
          } else {
              System.out.println(guess < randomNumber ? "It's higher." : "It's lower.");
          }
      }

      totalGuesses += guesses; //Update number of guesses
      bestGame = Math.min(bestGame, guesses); //Updates best game result

}  //report results of the game 
   public static void reportResults() {
      gameGuesses = totalGuesses / totalGames;
      
      System.out.println("Overall results:");
      System.out.println("  total games = " + totalGames);
      System.out.println("  total guesses = " + totalGuesses);
      System.out.println("  guesses/game = " + gameGuesses);
      System.out.println("  best game = " + bestGame);
      
   }
   public static void wantPlayAgain() {
      Scanner scanner = new Scanner(System.in);            
      System.out.print("Do you want to play again? ");
      String input = scanner.next().toLowerCase();
      
      playAgain = input.startsWith("y"); //playaAgain variable based on user input
      
   }

}
