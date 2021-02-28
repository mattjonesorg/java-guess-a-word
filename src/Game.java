import java.util.Scanner;

public class Game {

    private int numberOfGuesses;
    private String unguessedCharacters;
    private ChosenWord chosenWord;
    private PossibleWords wordsBank;
    Scanner scanner;

    //Contstructor
    public void Game(){
        scanner = new Scanner(System.in);
        wordsBank = new PossibleWords();
    }

    public void startNewGame(){

        // The abc letters to guess
        this.unguessedCharacters = "abcdefghijklmnopqrstuvwxyz";

        numberOfGuesses = 0;

        // Getting a new random word to guess
        this.chosenWord = new ChosenWord(wordsBank.getRandomWord());

        inputUserLetterGuess();
    }

    // Handling a guess from the user, guessedChar is the guessed char
    private void handleUserLetterGuess(char guessedChar){

        // Increasing number of guesses
        numberOfGuesses++;

        // Removing the guessed letter, so that the user can't guess it again
        removeOptionalCharGuess(guessedChar);

        // Running the guessing logic
        chosenWord.charGuess(guessedChar);
    }

    private void removeOptionalCharGuess(char guessedChar){
        // Replacing the guessed char with empty char, so it can no longer be guessed
        unguessedCharacters = unguessedCharacters.replace(Character.toString(guessedChar), "");
    }

    private void inputUserLetterGuess() {

        System.out.println(this.chosenWord);
        System.out.println("Enter a single character:");
        char guessedLetter = scanner.nextLine().charAt(0);

        // Validating return value
        if (guessedLetter == null){
            exit();
            return;
        }

        // Handling the user guess
        handleUserLetterGuess(guessedLetter);

        // Display results of the guess
        displayUserGuessResults(guessedLetter);
    }

    // Displays the results of the guess to the user
    private void displayUserGuessResults(char guessedLetter){
        // Displaying result

        System.out.printf("After you guessed '%s':  %s", guessedLetter, chosenWord.toString());

        // Checking if the word is completely exposed
        if (chosenWord.isEntireWordGuessed()){
            System.out.printf("Congratulations!  You guessed the word in %s guesses", numberOfGuesses);
       } else {
            inputUserLetterGuess();
            button.setText("Continue guessing");
        }
    }

    // Closing the frame on forced exit
    private void exit() {
        frame.dispose();
    }
}