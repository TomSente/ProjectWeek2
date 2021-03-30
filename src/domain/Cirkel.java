package domain;

public class Cirkel extends Vorm {
    private Punt middelpunt;
    private int radius;

    public Cirkel(Punt middelpunt, int radius) {
        if (middelpunt == null) {
            throw new IllegalArgumentException("Middelpunt mag niet leeg zijn.");
        }
        if (radius <= 0) {
            throw new IllegalArgumentException("Straal moet een positief getal zijn.");
        }
        setMiddelpunt(middelpunt);
        setRadius(radius);
    }

    private void setMiddelpunt(Punt middelpunt) {
        this.middelpunt = middelpunt;
    }

    private void setRadius(int radius) {
        this.radius = radius;
    }

    public Punt getMiddelpunt() {
        return middelpunt;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object o)
    {
        boolean result=false;
        if(o instanceof Cirkel)
        {
            Cirkel c = (Cirkel) o;
            if(this.getMiddelpunt().equals(c.getMiddelpunt())&&this.getRadius()==c.getRadius())
            {
                result=true;
            }
        }
        return result;
    }

    public String toString() {
        return "Cirkel: middelpunt: " + middelpunt.toString() + " - straal: " + radius;
    }
}
