import java.util.Random;

public class PossibleWords {
    private final String[] possibleWords;

    public PossibleWords(){
        possibleWords = new String[]{ "Trustworthy", "Loyal", "Helpful", "Friendly", "Courteous", "Kind", "Obedient", "Cheerful", "Thrifty", "Brave", "Clean", "Reverent", "Owasippe", "Philmont", "Betz", "Napowan"};
    }

    // Returns a random word from the existing words
    public String getRandomWord() {
        Random rand = new Random();
        return possibleWords[rand.nextInt(possibleWords.length)]; // Word from a random index
    }
}