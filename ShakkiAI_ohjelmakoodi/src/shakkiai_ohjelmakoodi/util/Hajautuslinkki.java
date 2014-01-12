/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.util;

import shakkiai_ohjelmakoodi.pelilogiikka.st.Siirrontarkastaja;

/**
 * Siirtohallintahajautuksen yksittäinen tietokohde, jonka osoitteen tyyppi on 
 * javaluokka, ja arvo sitä vastaava siirrontarkastaja
 * @author anterova
 */
public class Hajautuslinkki {
    private Class osoite;
    private Siirrontarkastaja arvo;

    public Hajautuslinkki(Class osoite, Siirrontarkastaja arvo) {
        this.osoite = osoite;
        this.arvo = arvo;
    }
    
    public Class osoite() {
        return osoite;
    }
    
    public Siirrontarkastaja arvo() {
        return arvo;
    }
}
