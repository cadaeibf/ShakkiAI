/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka.Nappulat;

import shakkiai_ohjelmakoodi.pelilogiikka.Pelaaja;

/**
 * Sotilasnappula.
 * @author anterova
 */
public class Sotilas implements Nappula {
    private Pelaaja pelaaja;
    private boolean eiLiikkunut;
    
    public Sotilas() {}
    
    public Sotilas(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        eiLiikkunut = true;
    }
    
    /**
     * Metodi, jolla muutetaan tieto siitä, onko sotilas liikkunut.
     */
    public void liikuta() {
        this.eiLiikkunut = false;
    }
    
    
    /**
     * Metodilla selvitetään, onko kyseinen sotilas liikkunut aiemmin kyseisen 
     * pelin aikana. Tätä tietoa käytetään hyväksi tilanteissa, joissa halutaan
     * tehdä sotilaan erikoisavausliike.
     * @return totuusarvo siitä, onko kyseinen sotilas liikkunut kyseisen pelin 
     * aikana
     */
    public boolean eiLiikkunut() {
        return eiLiikkunut;
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
        return "So" + pelaaja.getPelaajaNro();
    }
    
}
