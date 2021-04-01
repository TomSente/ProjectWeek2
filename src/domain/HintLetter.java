package domain;

public class HintLetter {
    private char letter;
    private boolean isGeraden;

    public HintLetter(char letter) {
        this.letter = letter;
        isGeraden = false;
    }

    public char getLetter() {
        return letter;
    }

    public boolean raad(char letter) {
        if (Character.toLowerCase(this.letter) == Character.toLowerCase(letter)) {
            if (isGeraden) {
                return false;
            } else {
                isGeraden = true;
                return true;
            }
        }
        return false;
    }

    public char toChar() {
        if (isGeraden) {
            return letter;
        }
        return '_';
    }

    public boolean isGeraden() {
        return isGeraden;

    }

}
