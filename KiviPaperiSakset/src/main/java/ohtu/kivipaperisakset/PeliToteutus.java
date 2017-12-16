package ohtu.kivipaperisakset;

public class PeliToteutus extends Peli {

    private final Pelaaja pelaaja1;
    private final Pelaaja pelaaja2;
    private final Tuomari tuomari;
    private String ekanSiirto;
    private String tokanSiirto;

    public PeliToteutus(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.pelaaja1 = pelaaja1;
        this.pelaaja2 = pelaaja2;
        this.tuomari = new Tuomari();
    }

    private void siirto() {
        ekanSiirto = this.pelaaja1.annaSiirto();
        tokanSiirto = this.pelaaja2.annaSiirto();

        System.out.print("Ensimmäisen pelaajan siirto: " + ekanSiirto + " ");

        System.out.println("Toisen pelaajan siirto: " + tokanSiirto);
    }

    private void asetaSiirto() {
        pelaaja1.asetaSiirto(tokanSiirto);
        pelaaja2.asetaSiirto(ekanSiirto);
    }

    @Override
    public void pelaa() {
        this.siirto();
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();
            this.siirto();
            this.asetaSiirto();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

}
