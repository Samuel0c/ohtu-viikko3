package ohtu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Tapahtumankuuntelija implements ActionListener {

    private JButton nollaa;
    private JButton undo;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private Map<JButton, Komento> komennot;
    private Komento edellinen;

    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa, JButton undo, JTextField tuloskentta, JTextField syotekentta) {
        this.komennot = new HashMap<>();
        this.komennot.put(plus, new Plus(this));
        this.komennot.put(miinus, new Miinus(this));
        this.komennot.put(nollaa, new Nollaa(this));
        this.nollaa = nollaa;
        this.undo = undo;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Komento komento = komennot.get(ae.getSource());
        int laskunTulos;

        if (komento == null) {
            laskunTulos = this.edellinen.peru();
            this.edellinen = null;
        } else {
            laskunTulos = komento.suorita();
            this.edellinen = komento;
        }
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);

        nollaa.setEnabled(laskunTulos != 0);
        undo.setEnabled(this.edellinen != null);
    }

    public int getSyote() {
        try {
            return Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
            return 0;
        }
    }

    public int getTulos() {
        try {
            return Integer.parseInt(this.tuloskentta.getText());
        } catch (Exception e) {
            return 0;
        }
    }

}
