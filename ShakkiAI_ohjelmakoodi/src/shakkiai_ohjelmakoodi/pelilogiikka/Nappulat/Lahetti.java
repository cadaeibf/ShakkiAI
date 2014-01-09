/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka.Nappulat;

import shakkiai_ohjelmakoodi.pelilogiikka.Pelaaja;

/**
 * Lähettinappulan toteutus.
 * @author anterova
 */
public class Lahetti implements Nappula {
    private Pelaaja pelaaja;

    public Lahetti() {
    }

    public Lahetti(Pelaaja pelaaja) {
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
        return "La" + pelaaja.getPelaajaNro();
    }

    @Override
    public int arvo() {
        return 3;
    }

    @Override
    public Nappula kopioi() {
        return new Lahetti(this.pelaaja);
    }
    
}
