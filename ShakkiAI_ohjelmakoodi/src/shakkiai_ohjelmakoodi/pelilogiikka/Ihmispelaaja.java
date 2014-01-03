/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka;

import shakki_ohjelmakoodi.util.Lukija;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Kuningas;

/**
 * Luokka ns. ihmispelaajalle.
 * @author anterova
 */
public class Ihmispelaaja implements Pelaaja {
    private int pelaajaNro;
    private Kuningas kuningas;
    private Lukija lukija;
    
    public Ihmispelaaja(int pelaajaNro) {
        this.pelaajaNro = pelaajaNro;
        lukija = new Lukija();
    }
    
    public void setKuningas(Kuningas kuningas) {
        this.kuningas = kuningas;
    }

    @Override
    public int getPelaajaNro() {
        return pelaajaNro;
    }

    @Override
    public Siirto valitseSiirto(Kentta kentta) {
        System.out.println("Mistä:");
        System.out.print("\tx: ");
        int xa = lukija.lueKoordinaatti("x");
        System.out.print("\ty: ");
        int ya = lukija.lueKoordinaatti("y");
        System.out.println("");
        
        System.out.println("Mihin:");
        System.out.print("\tx: ");
        int xl = lukija.lueKoordinaatti("x");
        System.out.print("\ty: ");
        int yl = lukija.lueKoordinaatti("y");
        System.out.println("");
        
        return new Siirto(xa, ya, xl, yl);
    }

    @Override
    public Kuningas getKuningas() {
        return kuningas;
    }
    
}
