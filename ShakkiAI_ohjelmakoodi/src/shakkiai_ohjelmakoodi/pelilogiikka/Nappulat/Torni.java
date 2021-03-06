/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka.Nappulat;

import shakkiai_ohjelmakoodi.pelilogiikka.Pelaaja;

/**
 * 
 * Torninappulan toteutus.
 * @author anterova
 */
public class Torni implements Nappula {
    private Pelaaja pelaaja;

    public Torni() {
    }

    public Torni(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }

    @Override
    public Pelaaja getPelaaja() {
        return this.pelaaja;
    }
    
    @Override
    public int omistajanPelinumero() {
        return pelaaja.getPelaajaNro();
    }
    
    @Override
    public String toString() {
        return "To" + pelaaja.getPelaajaNro();
    }

    @Override
    public int arvo() {
        return 5;
    }

    @Override
    public Nappula kopioi() {
        return new Torni(this.pelaaja);
    }
    
}
