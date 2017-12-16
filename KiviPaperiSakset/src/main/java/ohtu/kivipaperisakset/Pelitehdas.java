package ohtu.kivipaperisakset;

public class Pelitehdas {

    public static PeliToteutus luo(String pelivalinta) {
        if (pelivalinta.endsWith("a")) {
            return new PeliToteutus(new Ihminen(), new Ihminen());
        } else if (pelivalinta.endsWith("b")) {
            return new PeliToteutus(new Ihminen(), new Tekoaly());
        } else if (pelivalinta.endsWith("c")) {
            return new PeliToteutus(new Ihminen(), new TekoalyParannettu(20));
        }
        return null;
    }

}
