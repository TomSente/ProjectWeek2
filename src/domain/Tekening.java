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
        if (!isValidNaam(naam)) {
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
        for (Vorm v: vormen) {
            if (v.equals(vorm)){
                throw new IllegalArgumentException("Deze vorm staat al in de tekening.");
            }
        }
        vormen.add(vorm);
    }

    public int getAantalVormen() {
        return vormen.size();
    }

    public void verwijder(Vorm vorm) {
        vormen.remove(vorm);
    }

    public ArrayList<Vorm> getVormen() {
        return vormen;
    }

    public boolean bevat(Vorm vorm) {
        for (Vorm vorm2: vormen) {
            if (vorm2.equals(vorm)) {
                return true;
            }
        }
        return false;

    }

    public boolean equals(Object o) {
        boolean result=false;
        if(o instanceof Tekening)
        {
            Tekening t = (Tekening) o;
            if(this.naam.equals(t.getNaam())&&this.zelfdeVormen(t))
            {
                result=true;
            }
        }
        return result;
    }

    public boolean zelfdeVormen(Tekening t)
    {
        int counter=this.getVormen().size();
        for (Vorm v1 :this.getVormen())
        {
            for(Vorm v2 :t.getVormen())
            {
                if(v1.equals(v2))
                {
                    counter-=1;
                }
            }
        }
        return counter==0;
    }

    public String toString() {
        String result = this.getNaam()+":\n";
        for (Vorm v :this.getVormen())
        {
            result += v.toString()+"\n\n";
        }
        return result;
    }


}
