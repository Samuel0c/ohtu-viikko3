package ohtu.kivipaperisakset;

abstract class Peli {

    abstract void pelaa();

    public boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

}
