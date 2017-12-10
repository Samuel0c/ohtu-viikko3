package ohtu;

public class Plus implements Komento {
    
    private Tapahtumankuuntelija t;
    private int edellinen;

    public Plus(Tapahtumankuuntelija t) {
        this.t = t;
    }

    @Override
    public Integer suorita() {
        this.edellinen = t.getTulos();
        return this.edellinen + t.getSyote();
    }

    @Override
    public Integer peru() {
        return this.edellinen;
    }


}
