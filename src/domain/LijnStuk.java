package domain;

public class LijnStuk extends Vorm {
    private Punt startPunt, eindPunt;

    public LijnStuk(Punt startPunt, Punt eindPunt) {
        if (startPunt == null || eindPunt == null) {
            throw new DomainException("Het lijnstuk moet een start- en eindpunt hebben.");
        }
        if (startPunt.equals(eindPunt)) {
            throw new DomainException("Start- en eindpunt mogen niet aan elkaar gelijk zijn.");
        }
        setStartEnEindPunt(startPunt, eindPunt);
    }

    private void setStartEnEindPunt(Punt startPunt, Punt eindPunt) {
        this.startPunt = startPunt;
        this.eindPunt = eindPunt;
    }

    public Punt getStartPunt() {
        return startPunt;
    }

    public Punt getEindPunt() {
        return eindPunt;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof LijnStuk) {
            LijnStuk lijnStuk = (LijnStuk) o;
            return lijnStuk.startPunt.equals(this.startPunt) && lijnStuk.eindPunt.equals(this.eindPunt) || lijnStuk.startPunt.equals(this.eindPunt) && lijnStuk.eindPunt.equals(this.startPunt);
        }
       return false;

    }

    public String toString() {
        return "Lijn: startpunt: " + startPunt.toString() + "- eindpunt: " + eindPunt.toString();
    }
}
