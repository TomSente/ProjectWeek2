package domain;

import java.util.ArrayList;

public class Tekening {
    private String naam;
    ArrayList<Vorm> vormen;
    public static final int MIN_X = 0;
    public static final int MAX_X = 399;
    public static final int MIN_Y = 0;
    public static final int MAX_Y = 399;


    public Tekening(String naam) {
        if (isValidNaam(naam) == false ) {
            throw new IllegalArgumentException("Naam mag niet leeg zijn.");
        }
        vormen = new ArrayList<>();
        this.naam = naam;
    }

    public static boolean isValidNaam(String naam) {
        return naam != null && !naam.isEmpty();
    }

    public String getNaam() {
        return naam;
    }

    public void voegToe(Vorm vorm) {
        if(vorm == null)throw new IllegalArgumentException("De vorm mag niet null zijn.");
        vormen.add(vorm);
    }

    public int getAantalVormen() {
        return vormen.size();
    }

    public void verwijder(Vorm vorm) {
        for (Vorm v: vormen) {
            if (v.equals(vorm)) {
                vormen.remove(v);
            }
        }
    }

    public boolean bevat(Vorm vorm) {
        for (Vorm vorm2: vormen) {
            if (vorm2.equals(vorm)) {
                return true;
            }
        }return false;

    }

    public boolean equals(Tekening tekening) {
        if (tekening == null) {
            return false;
        }
        if (this.vormen.size() != tekening.vormen.size()) {
            return false;
        }
        for (Vorm vorm: tekening.vormen) {
            if (!this.bevat(vorm)) {
                return false;
            }
        }
        for (Vorm vorm: this.vormen) {
            if (!tekening.bevat(vorm)) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "Tekening";

    }
}
