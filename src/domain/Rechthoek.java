package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Rechthoek extends Vorm implements Drawable {
    private int breedte;
    private int hoogte;
    private Punt linkerBovenHoek;

    public Rechthoek(Punt punt, int breedte, int hoogte){
        if(punt == null){throw new DomainException("Linkerbovenhoek mag niet leeg zijn!");}
        if(breedte <=0){throw new DomainException("Breedte moet groter zijn dan 0");}
        if(hoogte <=0){throw new DomainException("Hoogte moet groter zijn dan 0");}
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

    @Override
    public boolean equals(Object o){
        if (o instanceof Rechthoek) {
            Rechthoek r = (Rechthoek) o;
            return breedte == r.breedte && hoogte == r.hoogte && linkerBovenHoek == r.linkerBovenHoek;
        }return false;

    }

    public String toString(){
        return "Rechthoek: linkerbovenhoek "+linkerBovenHoek+ " - breedte: "+breedte+" - hoogte: "+hoogte +"\n" +getOmhullende().toString();

    }

    @Override
    public Color getKleur() {
        return super.getKleur();
    }

    @Override
    public Omhullende getOmhullende()
    {
        return new Omhullende(linkerBovenHoek,breedte,hoogte);
    }

    public void teken(Pane root)
    {
        Rectangle rechthoek = new Rectangle(this.getLinkerBovenhoek().getX(), this.getLinkerBovenhoek().getY(), this.getBreedte(), this.getHoogte());
        rechthoek.setFill(getKleur());
        rechthoek.setStroke(Color.BLACK);
        root.getChildren().add(rechthoek);
    }
}
