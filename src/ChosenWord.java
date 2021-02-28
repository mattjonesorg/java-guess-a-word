public class ChosenWord {

    // The word to be guessed
    private String word; 

    // Array has a boolean for each character, and is set to true when the character is selected
    private boolean[] charsGuessed;  

    // Constructor is called to create this object.
    public ChosenWord(String word){
        this.word = word.toLowerCase();
        charsGuessed = new boolean[word.length()];
    }


    // Check if all the characters in the word have been guessed
    public boolean isEntireWordGuessed() {

        // Loop through the charsGuessed array
        for (boolean b : charsGuessed) {
            // ! means not, so this means if a character was not guessed, just return false, no need to check any more.
            if (!b)
                return false;
        }

        // If we made it here, all the characters were guessed, we can return true.
        return true;
    }


    // receives a char and checks if it appears in the word.
    public void guessCharacter(char guess) {
        // indexOf will return -1 if the character is not in the word
        int indexOfSelectedCharacter = word.indexOf(guess); 
        // Keep checking for the character until the character is shown the last time.
        while (indexOfSelectedCharacter >= 0) {
            // first, note that we have found the character at the specified index in our charsGuessed array
            charsGuessed[indexOfSelectedCharacter] = true; 
            // Next, find the next occurrence of the character
            // This will return -1 if the character is not found again.
            indexOfSelectedCharacter = word.indexOf(guess, indexOfSelectedCharacter + 1); 
        }
    }

    // Function that is used to show the word with blanks for characters that have not been selected.
    @Override
    public String toString(){
        StringBuilder formattedWord = new StringBuilder();

        // This loops through each character in the word.
        for(int index = 0; index < word.length(); index++){
            // Lookup the index of the current character in the charsGuessed word to see if it has been guessed.
            if (charsGuessed[index]){
                // The current character has been guessed, so output this character.
                formattedWord.append(word.charAt(index));
            } else {
                // The current character has not yet been guessed, so output an underscore.
                formattedWord.append('_');
            }
        }

        // return the string we have created.
        return formattedWord.toString();
    }
}