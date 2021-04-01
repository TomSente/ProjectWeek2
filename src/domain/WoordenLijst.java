package domain;
import db.domain.DbException;

import java.util.*;
public class WoordenLijst{
    private List<String> woordenLijst = new ArrayList<String>();

    public void voegToe(String s) throws DomainException{
        if (s==null || s.equals("") || woordenLijst.contains(s)) throw new DomainException();
        else woordenLijst.add(s);
    }
    public List<String> getWoordenLijst()
    {
        return woordenLijst;
    }

    public int getAantalWoorden() {
        return woordenLijst.size();
    }

    public String getRandomWoord(){
        Random random = new Random();
        return (woordenLijst.get(random.nextInt(woordenLijst.size())));
    }
}
