package domain;

public class HangMan {
    private Speler speler;
    private TekeningHangMan tekeningHangMan;
    private WoordenLijst woordenlijst;
    private HintWoord hintwoord;
    private boolean gewonnen;

    public HangMan(Speler s, WoordenLijst w){
        speler = s;
        woordenlijst = w;

    }

    public Speler getSpeler() {
        return speler;
    }

    public TekeningHangMan getTekening() {
        return tekeningHangMan;
    }

    public String getHint(){
        return hintwoord;
    }

    public boolean isGameOver(){
        return true;
    }

    public boolean isGewonnen(){
        return this.gewonnen;
    }

    public boolean raad(char c){
        return true;
    }
}
