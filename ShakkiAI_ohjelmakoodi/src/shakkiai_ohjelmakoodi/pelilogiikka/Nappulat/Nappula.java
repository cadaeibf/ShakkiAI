/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka.Nappulat;

import shakkiai_ohjelmakoodi.pelilogiikka.Pelaaja;

/**
 * Rajapinta pelinappuloille.
 * @author anterova
 */
public interface Nappula {
    
    /**
     * Metodi, joka palauttaa Pelaajan, jonka nappula on kyseessä
     * @return kyseisen nappulan omistajan.
     */
    public Pelaaja getPelaaja();
    
    /**
     * Metodi, jonka avulla voidaan selvittää, kumman osapuolen nappula on kyseessä.
     * @return kyseisen nappulan omistajan pelinumeron.
     */
    public int omistajanPelinumero();
    
    public int arvo();
    
    public Nappula kopioi();
}
