package domain;

public class Cirkel {
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

    public boolean equals(Cirkel cirkel) {
        if (cirkel == null) {
            return false;
        }
        if (this.middelpunt == cirkel.getMiddelpunt() && this.radius == cirkel.getRadius()) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "Cirkel: middelpunt: " + middelpunt.toString() + " - straal: " + radius;
    }
}
