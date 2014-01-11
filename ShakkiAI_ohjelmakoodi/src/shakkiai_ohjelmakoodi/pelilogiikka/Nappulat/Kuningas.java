/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka.Nappulat;

import shakkiai_ohjelmakoodi.pelilogiikka.Pelaaja;

/**
 * Kuningasnappulan toteutus.
 * @author anterova
 */
public class Kuningas implements Nappula {
    private Pelaaja pelaaja;

    public Kuningas() {
    }

    public Kuningas(Pelaaja pelaaja) {
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
        return "Kg" + pelaaja.getPelaajaNro();
    }

    @Override
    public int arvo() {
        return 0;
    }

    @Override
    public Nappula kopioi() {
        Kuningas kopio = new Kuningas(this.pelaaja);
        
        return kopio;
    }
    
}
