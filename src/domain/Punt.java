package domain;

public class Punt {
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
            if(this.getX()==p.getX()&& this.getX()==this.getY())
            {
                result=true;
            }
        }
        return result;
    }

    public String toString(){
        return "(" + x + "," + y + ")";
    }

}
