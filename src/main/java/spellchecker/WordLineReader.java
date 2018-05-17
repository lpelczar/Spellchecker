package spellchecker;

public class WordLineReader {
    private final String line;
    private int currentChar;
    private String nextWord;

    public WordLineReader(String var1) {
        this.line = var1;
        if (var1 == null) {
            this.nextWord = null;
        } else {
            this.currentChar = 0;
            this.readNextWord();
        }

    }

    public boolean hasNextWord() {
        return this.nextWord != null;
    }

    public String nextWord() {
        String var1 = this.nextWord;
        if (this.nextWord != null) {
            this.readNextWord();
        }

        return var1;
    }

    private void readNextWord() {
        for(this.nextWord = ""; this.currentChar < this.line.length() && !this.isWordStartingOrEndingLetter(this.line.charAt(this.currentChar)); ++this.currentChar) {
            ;
        }

        while(this.currentChar < this.line.length() && this.isWordLetter(this.line.charAt(this.currentChar))) {
            this.nextWord = this.nextWord + this.line.charAt(this.currentChar);
            ++this.currentChar;
        }

        if (this.nextWord.length() == 0) {
            this.nextWord = null;
        } else {
            if (!this.isWordStartingOrEndingLetter(this.nextWord.charAt(this.nextWord.length() - 1))) {
                this.nextWord = this.nextWord.substring(0, this.nextWord.length() - 1);
            }

        }
    }

    private boolean isWordStartingOrEndingLetter(char var1) {
        return var1 >= 'A' && var1 <= 'Z' || var1 >= 'a' && var1 <= 'z' || var1 >= '0' && var1 <= '9';
    }

    private boolean isWordLetter(char var1) {
        return this.isWordStartingOrEndingLetter(var1) || var1 == '-' || var1 == '\'';
    }
}

