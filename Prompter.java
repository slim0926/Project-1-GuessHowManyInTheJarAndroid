import java.io.*;
import java.util.List;

public class Prompter {
  private Console mConsole;
  private Player mPlayer;
  
  public Prompter() {
    mConsole = System.console();
    mPlayer = new Player();
  }
  
  public void adminHeading() {
    System.out.println("\nADMINISTRATOR");
    System.out.println("=======================");
  }
  
  public String promptForItem() {
    adminHeading(); 
    String itemName = mConsole.readLine("Name the items in the jar: ");
    return itemName;
  }
  
  public int promptForValidNum() {
    String strValidNum = "";
    int validNum = 0;
    boolean isValidNum = false;
    do {
      strValidNum = mConsole.readLine("Enter your number here: ");
      try {
        validNum = Integer.parseInt(strValidNum);
        isValidNum = true;
        if (validNum <= 0) {
          System.out.println("Zero or negative numbers are not allowed! Please try again.\n");
          isValidNum = false;
        }
      } catch(NumberFormatException nfe) {
      	System.out.println("That's not a valid number! Please try again.\n");
      }
    } while (!isValidNum);
    return validNum;
  }
  
  public int promptForMaxNum() {
    System.out.println("Give the maximum number of items that the jar can hold. ");
    return promptForValidNum();
  }
  
  public void playerHeading() {
    System.out.println("\nPLAYER");
    System.out.println("================");
  }
  
  public void play(String itemName, int maxNum, int answer) {
    playerHeading();
    System.out.printf("Welcome! Guess how many %s are in the jar.\n", itemName);
    displayMaxNum(maxNum);
    promptForPlayerName();
    promptForGuess(answer, maxNum);
  }
  
  public void promptForPlayerName() {
    String playerName = mConsole.readLine("\nFirst, what's your name? ");
    mPlayer.setPlayerName(playerName);
    System.out.printf("Ok, let's go, %s!\n", playerName);
  }
  
  public void displayMaxNum(int maxNum) {
    System.out.printf("The maximum number of items that can be in the jar is %d.\n", maxNum);
    System.out.printf("So, please pick a number between 1 and %d.\n", maxNum);
  }
  
  public void promptForGuess(int answer, int maxNum) {
    boolean isHit;
    String strGuess;
    int guess;
    int guessCount = 0;
    do {
      isHit = false;
      System.out.println("\nWhat is your guess?");
      guess = promptForValidNum();
      guessCount++;
      if (guess == answer) {
        isHit = true;
        mPlayer.setScore(guessCount);
        System.out.printf("You win after %d guess(es). The right answer is indeed %d.\n" +
                          "Your score is %d.\n", 
                          guessCount, answer, mPlayer.getScore());
        if (guessCount > 6) {
          System.out.println("Sorry. You took too many tries to get a score.");
        }
      } else {
        if (guess < answer) {
          System.out.println("Your guess is too low.");
        } else if (guess > answer && guess <= maxNum) {
          System.out.println("Your guess is too high.");
        } else {
          displayMaxNum(maxNum);
        }
      }
    } while (!isHit);
  }
  
  public boolean promptForReplay() {
    boolean playAgain = false;
    String strPlayAgain = "";
    strPlayAgain = mConsole.readLine("\nIs there another player who wants to play? Please type yes or no: ");
    if (strPlayAgain.equalsIgnoreCase("yes")) {
      playAgain = true;
    } else {
      mPlayer.setWinnerAndScore();
      List<String> winners = mPlayer.getWinner();
      
      for (String winner : winners) {
        System.out.println("The winner is " + winner);
      }
        
      System.out.println("With a high score of " + mPlayer.getHighestScore());
      System.out.println("Goodbye. Thanks for playing!");
      
    }
    return playAgain;
  }
    
}
  