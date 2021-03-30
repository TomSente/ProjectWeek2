package domain;

public class Rechthoek {
    private int breedte;
    private int hoogte;
    private Punt linkerBovenHoek;

    public Rechthoek(Punt punt, int breedte, int hoogte){
        if(punt == null){throw new DomainException("Linkerbovenhoek mag niet leeg zijn!");}
        if(breedte <=0){throw new DomainException("Breedte moet groter zijn dan 0");}
        if(hoogte <=0){throw new DomainException("hoogte moet groter zijn dan 0");}
        setBreedte(breedte);
        setHoogte(hoogte);
        setLinkerBovenHoek(punt);
    }
    private void setBreedte(int breedte){this.breedte = breedte;}
    private void setHoogte(int hoogte){this.hoogte = hoogte;}
    private void setLinkerBovenHoek(Punt hoekPunt){this.linkerBovenHoek = hoekPunt;}

    public int getBreedte() {
        return breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public Punt getLinkerBovenhoek() {
        return linkerBovenHoek;
    }

    public boolean equals(Rechthoek rechthoek){
        if(rechthoek == null) return false;
        return breedte == rechthoek.breedte && hoogte == rechthoek.hoogte && linkerBovenHoek == rechthoek.linkerBovenHoek;
    }

    public String toString(){
        return "Rechthoek: linkerbovenhoek "+linkerBovenHoek+ " - breedte: "+breedte+" - hoogte: "+hoogte + getOmhullende().toString();

    }
    public Omhullende getOmhullende()
    {
        Omhullende o = new Omhullende(linkerBovenHoek,breedte,hoogte);
        return  o;
    }
}
