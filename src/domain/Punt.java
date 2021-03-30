package domain;

public class Punt implements Comparable<Punt> {
    private int x;
    private int y;

    public Punt(int X, int Y){
        x = X;
        y = Y;
    }


    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean equals(Punt punt){
        if(punt == null ) return false;
        return x == punt.x && y == punt.y;

    }

    @Override
    public boolean equals(Object o)
    {
        boolean result=false;
        if(o instanceof Punt)
        {
            Punt p = (Punt) o;
            if(this.getX()==p.getX()&& this.getY()==p.getY())
            {
                result=true;
            }
        }
        return result;
    }


    public String toString(){
        return "(" + x + "," + y + ")";
    }

    @Override
    public int compareTo(Punt o)
    {
        if(this.getX()>o.getX()&&this.getY()>o.getY())
        {
            return 1;
        }
        if(this.getX()==o.getX()&& this.getY()==o.getY())
        {
            return 0;
        }
        if(this.getX()<o.getX()&&this.getY()<o.getY())
        {
            return -1;
        }
        return 0;
    }
}
/**
//punt1.compareTo(punt2)
//punt1>punt2 --> 1
//punt1==punt2 -->0
//punt1<punt2 -->-1
*/