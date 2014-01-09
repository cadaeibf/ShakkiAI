/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka.Nappulat;

import shakkiai_ohjelmakoodi.pelilogiikka.Pelaaja;

/**
 * Kuningatarnappulan toteutus.
 * @author anterova
 */
public class Kuningatar implements Nappula {
    private Pelaaja pelaaja;

    public Kuningatar() {
    }

    public Kuningatar(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }

    @Override
    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    @Override
    public int omistajanPelinumero() {
        return pelaaja.getPelaajaNro();
    }
    
    @Override
    public String toString() {
        return "Qn" + pelaaja.getPelaajaNro();
    }

    @Override
    public int arvo() {
        return 9;
    }

    @Override
    public Nappula kopioi() {
        return new Kuningatar(this.pelaaja);
    }
    
}
