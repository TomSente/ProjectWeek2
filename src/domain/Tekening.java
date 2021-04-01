package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

import java.util.ArrayList;

public class Tekening implements Drawable{
    private String naam;
    private ArrayList<Vorm> vormen;
    public static final int MIN_X = 0;
    public static final int MAX_X = 399;
    public static final int MIN_Y = 0;
    public static final int MAX_Y = 399;


    public Tekening(String naam) {
        if (!isValidNaam(naam)) {
            throw new DomainException("Naam mag niet leeg zijn.");
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
        if (vorm == null) throw new IllegalArgumentException("De vorm mag niet null zijn.");
        if (vorm.getOmhullende().getMinimumX() < MIN_X ||
        vorm.getOmhullende().getMaximumX() > MAX_X || vorm.getOmhullende().getMinimumY() < MIN_Y || vorm.getOmhullende().getMaximumY() > MAX_Y)
        {
            throw new DomainException("Vorm mag niet buiten de tekening liggen.");
        }
        if (this.bevat(vorm))
        {
            throw new DomainException("Deze vorm staat al in de tekening.");
        }
        vormen.add(vorm);
    }

    public int getAantalVormen() {
        return vormen.size();
    }

    public void verwijder(Vorm vorm) {
        vormen.remove(vorm);
    }

    public boolean bevat(Vorm vorm) {
        for (Vorm vorm2 : vormen) {
            if (vorm2.equals(vorm)) {
                return true;
            }
        }
        return false;

    }

    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof Tekening) {
            Tekening t = (Tekening) o;
            if (this.zelfdeVormen(t)) {
                result = true;
            }
        }
        return result;
    }

    public boolean zelfdeVormen(Tekening t) {
        if (this.getAantalVormen()!=t.getAantalVormen()) {
            return false;
        }
        int counter = this.getAantalVormen();
        for (Vorm v1 : this.vormen) {
            for (Vorm v2 : t.vormen) {
                if (v1.equals(v2)) {
                    counter -= 1;
                }
            }
        }
        return counter == 0;
    }

    public String toString() {
        String result = this.getNaam() + ":\n";
        for (Vorm v : this.vormen) {
            result += v.toString() + "\n\n";
        }
        return result;
    }

    public void teken(Pane root)
    {
        for(Vorm v : vormen)
        {
            if(v.isZichtbaar())
            {
                v.teken(root);
            }
        }
    }

    public Vorm getVorm(int i)
    {
        if(i<0||i>=vormen.size())
        {
            throw new DomainException("");
        }
        return this.vormen.get(i);
    }



}
