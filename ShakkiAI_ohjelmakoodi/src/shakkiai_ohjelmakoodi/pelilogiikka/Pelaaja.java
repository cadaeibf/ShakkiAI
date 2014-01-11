/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka;


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
    
    public Siirto teeSiirto(Kentta kentta);
    
}
