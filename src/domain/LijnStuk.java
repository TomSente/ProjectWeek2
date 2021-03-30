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
        return "Lijn: startpunt: " + startPunt.toString() + "- eindpunt: " + eindPunt.toString()+"\n"+
                "Omhullende: "+getOmhullende().toString();
    }

    @Override
   public Omhullende getOmhullende(){
        int x =0;
        int x1=0;
        if(startPunt.getX()<eindPunt.getX()){
            x = startPunt.getX();
            x1 = eindPunt.getX();
        }
        else{x = eindPunt.getX();
        x =  startPunt.getX();}
        int y =0;
        int y1 =0;
        if(startPunt.getY()<eindPunt.getY())
        {
            y = startPunt.getY();
            y1 = eindPunt.getY();
        }else {y = eindPunt.getY(); y1= startPunt.getY();}
        int breedte = x1-x;
        int hoogte = y1-y;
        Punt linksboven = new Punt(x,y);
        Omhullende o = new Omhullende(linksboven,breedte,hoogte);
        return o;
    }
}
