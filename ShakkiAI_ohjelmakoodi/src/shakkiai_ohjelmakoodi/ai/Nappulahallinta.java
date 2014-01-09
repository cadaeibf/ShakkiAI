/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.ai;

import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;
import shakkiai_ohjelmakoodi.util.SiirrettavaPino;

/**
 * Luokka pitää kirjaa pelin toisen osapuolen pelinappuloiden koordinaateista
 * siirtomahdollisuuksien vertailun tehokkuuden parantamiseksi.
 * @author anterova
 */
public class Nappulahallinta {
    private SiirrettavaPino siirrettavat;
    
    
    public Nappulahallinta(int peliNro, Kentta kentta) {
        siirrettavat = new SiirrettavaPino();
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(kentta.nappulaKoordinaatissa(i, j) != null) { 
                    if(kentta.nappulaKoordinaatissa(i, j).omistajanPelinumero() == peliNro) siirrettavat.push(new Siirrettava(kentta, i, j));
                }
            }
        }
    }
    
    /**
     * Metodi palauttaa tiedon siitä onko siirrettäväpinossa pelinappuloita 
     * jäljellä
     * @return totuusarvo siitä onko siirrettäväpinossa pelinappuloita jäljellä
     */
    public boolean nappuloitaJaljella() {
        return !siirrettavat.onTyhja();
    }
    
    /**
     * Metodi palauttaa seuraavan siirrettävän pinosta
     * @return seuraava siirrettävä pinosta, tai null, jos pino on tyhjä
     */
    public Siirrettava seuraava() {
        if(siirrettavat.onTyhja()) return null;
        return siirrettavat.pop();
    }
}
