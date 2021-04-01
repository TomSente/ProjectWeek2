package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Cirkel extends Vorm implements Drawable {
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

    public int getRadius() {
        return radius;
    }
    public Punt getMiddelPunt() {return middelpunt; }

    @Override
    public boolean equals(Object o)
    {
        boolean result=false;
        if(o instanceof Cirkel)
        {
            Cirkel c = (Cirkel) o;
            if(this.getMiddelPunt().equals(c.getMiddelPunt())&&this.getRadius()==c.getRadius())
            {
                result=true;
            }
        }
        return result;
    }
    @Override
    public Omhullende getOmhullende()
    {
        int x = middelpunt.getX()-radius;
        int y = middelpunt.getY()-radius;
        Punt p = new Punt(x,y);
        Omhullende uitvoer = new Omhullende(p,radius*2,radius*2);
        return uitvoer;

    }



    public String toString() {
        return "Cirkel: middelpunt: " + middelpunt.toString() + " - straal: " + radius+"\n"+
                "Omhullende: "+getOmhullende().toString();
    }

    @Override
    public Color getKleur() {
        return super.getKleur();
    }

    public void teken(Pane root)
    {

        Circle cirkel = new Circle(this.getMiddelPunt().getX(), this.getMiddelPunt().getY(), this.getRadius());
        cirkel.setFill(this.getKleur());
        cirkel.setStroke(Color.BLACK);
        root.getChildren().add(cirkel);
    }

}
