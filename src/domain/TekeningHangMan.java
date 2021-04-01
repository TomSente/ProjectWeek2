package domain;

public class TekeningHangMan extends Tekening {

    public TekeningHangMan()
    {
        super("Hangman");
    }

    public int getAantalOnzichtbaar()
    {
        int counter =0;
        for(int i=0;i<this.getAantalVormen();i++)
        {
            if(this.getVorm(i).isZichtbaar())
            {
                counter+=1;
            }
        }
        return counter;
    }

    public void zetVolgendeZichtbaar()
    {
        for(int i=0;i<this.getAantalVormen();i++)
        {
            if(!this.getVorm(i).isZichtbaar())
            {
                this.getVorm(i).setZichtbaar(true);
                return;
            }
        }
    }

}

