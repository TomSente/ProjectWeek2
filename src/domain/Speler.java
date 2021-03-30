package domain;

public class Speler {
    private String naam;
    private int score;

    public Speler(String naam, int score)
    {
        setNaam(naam);
        setScore(score);
    }

    public Speler(String naam)
    {
        setNaam(naam);
        setScore(0);
    }


    public void setNaam(String naam) {
        if(naam==null||naam.trim().isEmpty())
        {
            throw new DomainException("Naam mag niet leeg zijn");
        }
        this.naam = naam;
    }

    public void setScore(int score)
    {
        if(score<0)
        {
            throw new DomainException("Score mag niet negatief zijn");
        }
        this.score = score;
    }

    public String getNaam() {
        return naam;
    }

    public int getScore() {
        return score;
    }

    public void addToScore(int i )
    {
        if(this.score+i<0)
        {
            throw new DomainException("resulterende score mag niet negatief zijn");
        }
        this.score+=i;
    }

    @Override
    public boolean equals(Object o)
    {
        boolean result=false;
        if(o instanceof Speler)
        {
            Speler s = (Speler) o;
            if(this.getNaam().equals(s.getNaam()) && this.getScore()==(s.getScore()))
            {
                result=true;
            }
        }
        return result;
    }


    public String toString()
    {
        return this.getNaam()+" heeft een score van "+this.getScore();
    }


}

