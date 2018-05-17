package spellchecker;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * ICS 23 Summer 2004
 * Project #5: Lost for Words
 *
 * Implement your word checker here. A word checker has two responsibilities:
 * given a word list, answer the questions "Is the word 'x' in the wordlist?"
 * and "What are some suggestions for the misspelled word 'x'?"
 *
 * WordChecker uses a class called WordList that I haven't provided the source
 * code for.  WordList has only one method that you'll ever need to call:
 *
 *     public boolean lookup(String word)
 *
 * which returns true if the given word is in the WordList and false if not.
 */

public class WordChecker {

    private WordList wordList;

	/**
     * Constructor that initializes a new WordChecker with a given WordList.
     *
     * @param wordList Initial word list to check against.
     * @see WordList
     */
	public WordChecker(WordList wordList) {
        this.wordList = wordList;
	}
	

	/**
     * Returns true if the given word is in the WordList passed to the
     * constructor, false otherwise.
     *
     * @param word Word to check against the internal word list
     * @return bollean indicating if the word was found or not.
     */
	public boolean wordExists(String word) {
        return wordList.lookup(word);
    }


	/**
     * Returns an ArrayList of Strings containing the suggestions for the
     * given word.  If there are no suggestions for the given word, an empty
     * ArrayList of Strings (not null!) should be returned.
     *
     * @param word String to check against
     * @return A list of plausible matches
     */
	public List<String> getSuggestions(String word) {
        List<String> suggestions = new ArrayList<>();
        checkSwappingEachAdjacentPair(word, suggestions);
        checkInsertingLetterInEachPositionOfTheString(word, suggestions);
        checkDeletingEachCharacterFromTheWord(word, suggestions);
        checkReplacingEachLetterWithAnother(word, suggestions);
        return suggestions;
	}

    private void checkSwappingEachAdjacentPair(String word, List<String> suggestions) {
        for (int i = 0; i < word.length() - 1; i++) {
            String suggestion = word.replace(Character.toString(word.charAt(i)), "*")
                                 .replace(Character.toString(word.charAt(i)), Character.toString(word.charAt(i + 1)))
                                 .replace("*", Character.toString(word.charAt(i + 1)));
            if (wordExists(suggestion) && !suggestions.contains(suggestion)) {
                suggestions.add(suggestion);
            }
        }
    }

    private void checkInsertingLetterInEachPositionOfTheString(String word, List<String> suggestions) {
        for (int position = 0; position < word.length(); position++) {
            for (char letter = 'A'; letter <= 'Z'; letter++) {
                StringBuilder stringBuilder = new StringBuilder(word);
                stringBuilder.insert(position, letter);
                String suggestion = stringBuilder.toString();
                if (wordExists(suggestion) && !suggestions.contains(suggestion)) {
                    suggestions.add(suggestion);
                }
            }
        }
    }

    private void checkDeletingEachCharacterFromTheWord(String word, List<String> suggestions) {
        for (int position = 0; position < word.length(); position++) {
            StringBuilder stringBuilder = new StringBuilder(word);
            stringBuilder.deleteCharAt(position);
            String suggestion = stringBuilder.toString();
            if (wordExists(suggestion) && !suggestions.contains(suggestion)) {
                suggestions.add(suggestion);
            }
        }
    }

    private void checkReplacingEachLetterWithAnother(String word, List<String> suggestions) {
        for (int position = 0; position < word.length(); position++) {
            for (char letter = 'A'; letter <= 'Z'; letter++) {
                StringBuilder stringBuilder = new StringBuilder(word);
                stringBuilder.setCharAt(position, letter);
                String suggestion = stringBuilder.toString();
                if (wordExists(suggestion) && !suggestions.contains(suggestion)) {
                    suggestions.add(suggestion);
                }
            }
        }
    }
}
