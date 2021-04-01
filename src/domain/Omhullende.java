package domain;

public class Omhullende {
    private Punt positieLinksBoven;
    private int breedte;
    private int hoogte;

    public Omhullende(Punt positieLinksBoven, int breedte, int hoogte){
        if(positieLinksBoven == null){throw new DomainException("Positie linksboven mag niet leeg zijn!");}
        if(breedte <0){throw new DomainException("Breedte moet groter zijn dan 0");}
        if(hoogte <0){throw new DomainException("hoogte moet groter zijn dan 0");}
        setBreedte(breedte);
        setHoogte(hoogte);
        setPositieLinksBoven(positieLinksBoven);
    }
    private void setBreedte(int breedte){this.breedte = breedte;}
    private void setHoogte(int hoogte){this.hoogte = hoogte;}
    private void setPositieLinksBoven(Punt hoekPunt){this.positieLinksBoven = hoekPunt;}

    public int getBreedte() {
        return breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public Punt getLinkerBovenhoek() {
        return positieLinksBoven;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Omhullende){
            Omhullende omhullende= (Omhullende) o;
            if(omhullende == null) return false;

            return breedte == omhullende.breedte && hoogte == omhullende.hoogte && positieLinksBoven.equals(omhullende.positieLinksBoven) ;
        }
        return false;
    }
    public String toString()
    {
        return "Omhullende: "+positieLinksBoven+ " - "+breedte+" - "+hoogte;

    }
    public int getMaximumX()
    {
        return positieLinksBoven.getX()+breedte;
    }
    public int getMinimumX()
    {
        return positieLinksBoven.getX();
    }
    public int getMaximumY()
    {
        return positieLinksBoven.getY()+hoogte;
    }
    public int getMinimumY()
    {
        return positieLinksBoven.getY();
    }
}
