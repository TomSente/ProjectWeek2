package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Driehoek extends Vorm{
    private Punt punt1;
    private Punt punt2;
    private Punt punt3;

    public Driehoek (Punt punt1,Punt punt2, Punt punt3)
    {
        if(punt1==null||punt2==null||punt3==null)
        {
            throw new DomainException("hoekpunten mogen niet leeg zijn");
        }
        if(punt1.equals(punt2)||punt1.equals(punt3)||punt2.equals(punt3))
        {
            throw new DomainException("Geen 2 punten mogen dezelfde zijn");
        }
        else if (liggenOp1Lijn(punt1, punt2, punt3))
        {
            throw new DomainException("De 3 punten mogen niet op 1 lijn liggen");
        }
        else
        {
            this.punt1=punt1;
            this.punt2=punt2;
            this.punt3=punt3;
        }
    }

    @Override
    public boolean equals(Object o)
    {
        boolean result=false;
        if(o instanceof Driehoek)
        {
            Driehoek d = (Driehoek) o;
            if(d.getHoekPunt1().equals(this.getHoekPunt1())&&d.getHoekPunt2().equals(this.getHoekPunt2())&&d.getHoekPunt3().equals(this.getHoekPunt3()))
            {
                result=true;
            }
        }
        return result;
    }

    public Punt getHoekPunt1() {
        return punt1;
    }

    public Punt getHoekPunt2() {
        return punt2;
    }

    public Punt getHoekPunt3() {
        return punt3;
    }

    public boolean liggenOp1Lijn(Punt punt1, Punt punt2, Punt punt3)
    {
        return ((punt2.getX() - punt1.getX()) * (punt3.getY() - punt1.getY())) == ((punt3.getX() - punt1.getX()) * (punt2.getY()) - punt1.getY());
    }

    public void sorteerHoekPunten()
    {
        ArrayList<Punt> punten = new ArrayList<Punt>();
        punten.add(punt1);
        punten.add(punt2);
        punten.add(punt3);
        punten.sort(new Comparator<Punt>() {
            @Override
            public int compare(Punt p1, Punt p2) {
                if (Integer.compare(p1.getX(), p2.getX()) != 0) {
                    return Integer.compare(p1.getX(), p2.getX());
                } else {
                    return Integer.compare(p1.getY(), p2.getY());
                }
            }
        });




    }

    public String toString()
    {
        return "Deze driehoek heeft als hoekpunten "+punt1.toString()+" "+punt2.toString()+" "+punt3.toString();
    }





}
