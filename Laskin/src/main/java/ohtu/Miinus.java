package ohtu;

public class Miinus implements Komento {

    private Tapahtumankuuntelija t;
    private int edellinen;

    public Miinus(Tapahtumankuuntelija t) {
        this.t = t;
    }

    @Override
    public Integer suorita() {
        this.edellinen = t.getTulos();
        return this.edellinen - t.getSyote();
    }

    @Override
    public Integer peru() {
        return this.edellinen;
    }

}
