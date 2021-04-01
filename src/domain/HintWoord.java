package domain;

import java.util.ArrayList;
import java.util.Arrays;

public class HintWoord {

    private HintLetter[] hintwoord;
    private String woord;
    private ArrayList<String> gevonden = new ArrayList<>();

    public HintWoord(String woord) {
        if (woord == null || woord.isEmpty()) {
            throw new DomainException("Woord mag niet leeg zijn.");
        }
        this.woord = woord;
        char[] hintwoordchar = woord.toCharArray();
        hintwoord = new HintLetter[hintwoordchar.length];
        for (int i = 0; i < hintwoord.length; i++) {
            hintwoord[i] = new HintLetter(hintwoordchar[i]);

        }
    }

    public boolean raad(char letter) {
        boolean geraden = false;

        for (HintLetter hintletter : hintwoord) {
            hintletter.raad(letter);
            if (hintletter.isGeraden()) {
                geraden = true;
                for (String a : gevonden) {
                    if (a.equals(String.valueOf(letter))) {
                        geraden = false;

                    } else {
                        geraden = true;
                    }
                }
                gevonden.add(String.valueOf(letter));
            }

        }
        return geraden;

       /*for (HintLetter hintletter : hintwoord) {
            hintletter.raad(letter);
        }
        for (HintLetter hintletter : hintwoord) {
            if (hintletter.isGeraden()) {
                return true;
            }

        }
        return false; */
    }


    public boolean isGeraden() {
        for (HintLetter hintletter : hintwoord) {
            if (!hintletter.isGeraden()) {
                return false;
            }
        }
        return true;
    }

    public String getWoord() {
        return woord;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < hintwoord.length - 1; i++) {
            result += hintwoord[i].toChar() + " ";
        }
        result += hintwoord[hintwoord.length - 1].toChar();
        return result;
    }
}
