package domain;

public class Driehoek extends Vorm{
    private Punt punt1;
    private Punt punt2;
    private Punt punt3;

    public Driehoek (Punt punt1,Punt punt2, Punt punt3)
    {
        if(punt1.equals(punt2)||punt1.equals(punt3)||punt2.equals(punt3))
        {
            throw new DomainException("geen 2 punten mogen dezelfde zijn");
        }
        else if (liggenOp1Lijn(punt1, punt2, punt3))
        {
            throw new DomainException("de 3 punten mogen niet op 1 lijn liggen");
        }
        else
        {
            this.punt1=punt1;
            this.punt2=punt2;
            this.punt3=punt3;
        }
    }

    public Punt getPunt1() {
        return punt1;
    }

    public Punt getPunt2() {
        return punt2;
    }

    public Punt getPunt3() {
        return punt3;
    }

    public boolean liggenOp1Lijn(Punt punt1, Punt punt2, Punt punt3)
    {
        return ((punt2.getX() - punt1.getX()) * (punt3.getY() - punt1.getY())) == ((punt3.getX() - punt1.getX()) * (punt2.getY()) - punt1.getY());
    }





}
