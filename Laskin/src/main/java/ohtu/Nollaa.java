package ohtu;

public class Nollaa implements Komento {
    
    private Tapahtumankuuntelija t;
    private int edellinen;

    public Nollaa(Tapahtumankuuntelija t) {
        this.t = t;
    }

    @Override
    public Integer suorita() {
        this.edellinen = t.getTulos();
        return 0;
    }

    @Override
    public Integer peru() {
        return this.edellinen;
    }
    
}
