/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka;

import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Kuningas;

/**
 * Rajapinta pelaajille, jotka voivat olla joko ihmispelaajia, tai shakkibotteja.
 * @author anterova
 */
public interface Pelaaja {
    
    /**
     * Metodi pelaajanumeron selvittämiseksi
     * @return kyseisen pelaajan pelaajanumero
     */
    public int getPelaajaNro();
    
    public void setKuningas(Kuningas kuningas);
    
    public Kuningas getKuningas();
    
    public Siirto teeSiirto(Kentta kentta);
    
}
