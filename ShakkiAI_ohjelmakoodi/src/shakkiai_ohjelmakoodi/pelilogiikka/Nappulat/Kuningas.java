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
public class Kuningas implements Nappula {
    private Pelaaja pelaaja;
    private boolean uhattu;

    public Kuningas() {
    }

    public Kuningas(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        uhattu = false;
    }
    
    public void uhkaa() {
        uhattu = true;
    }
    
    public void suojaa() {
        uhattu = false;
    }
    
    public boolean uhattu() {
        return uhattu;
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
    
}
