/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka.Nappulat;

import shakkiai_ohjelmakoodi.pelilogiikka.Pelaaja;

/**
 *
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
    
}
