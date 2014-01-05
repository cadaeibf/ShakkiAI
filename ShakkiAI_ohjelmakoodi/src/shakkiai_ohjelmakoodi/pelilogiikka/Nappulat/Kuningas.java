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
    private boolean uhattu;

    public Kuningas() {
    }

    public Kuningas(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        uhattu = false;
    }
    
    /**
     * Metodi muuttaa tiedon siitä, onko kuningas uhattu, eli voitaisiinko se
     * syödä seuraavalla vuorolla.
     */
    public void uhkaa() {
        uhattu = true;
    }
    
    /**
     * Metodi muuttaa tiedon siitä, onko kuningas uhattu, eli voitaisiinko se
     * syödä seuraavalla vuorolla.
     */
    public void suojaa() {
        uhattu = false;
    }
    
    /**
     * Metodi, jolla selvitetään, onko kuningas uhattu.
     * @return totuusarvo siitä onko kuningas uhattu, eli voitaisiinko se syödä 
     * seuraavalla vuorolla
     */
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

    @Override
    public int arvo() {
        return 0;
    }
    
}
