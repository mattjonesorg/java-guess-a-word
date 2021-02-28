package org.troop618oaklawn;
import java.util.Scanner;


public class GuessAWord {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // Starts a new game
        Game game = new Game(sc);

        boolean playAgain = true;
        while(playAgain) {

            game.startNewGame();
            
            System.out.println("Do you want to play again? (y/n)");
            char playAgainInput = sc.nextLine().toLowerCase().charAt(0);
            if( playAgainInput == 'y') {
                playAgain = true;
            }
            else {
                playAgain = false;
            }
        }



    }
}