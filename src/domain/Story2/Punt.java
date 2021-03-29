package domain.Story2;

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

    public String toString(){
        return "(" + x + "," + y + ")";
    }

}
