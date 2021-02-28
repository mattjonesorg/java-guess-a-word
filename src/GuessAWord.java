public class GuessAWord {

    public static void main(String[] args)
    {
        // Starts a new game
        Game game = new Game();

        bool playAgain = true;
        while(playAgain) {

            game.startNewGame();
            
            System.out.println("Do you want to play again? (y/n)");
            char playAgain = sc.nextLine().charAt(0);
            if( playAgain.toLowerCase() == 'y') {
                playAgain = true;
            }
            else {
                playAgain = false;
            }
        }



    }
}