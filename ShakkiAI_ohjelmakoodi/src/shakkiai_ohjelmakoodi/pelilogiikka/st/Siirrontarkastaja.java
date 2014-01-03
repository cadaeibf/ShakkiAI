/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka.st;

import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;

/**
 * Rajapinta apuluokille, jotka tarkastavat annetun siirron laillisuuden
 * @author anterova
 */
public interface Siirrontarkastaja {
    
    /**
     * Metodi tarkistaa, onko annettu siirto laillinen.
     * @param kentta nykyinen pelitilanne
     * @param xa siirron lähtöruudun rivinumero
     * @param ya siirron lähtöruudun sarakenumero
     * @param xl siirron maaliruudun rivinumero
     * @param yl siirron maaliruudun sarakenumero
     * @return totuusarvo siitä, onko siirto laillinen
     */
    public boolean tarkista(Kentta kentta, int pelaajaNumero, int xa, int ya, int xl, int yl);
    
}
