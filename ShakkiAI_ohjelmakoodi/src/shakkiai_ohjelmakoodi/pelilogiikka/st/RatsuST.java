/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka.st;

import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;

/**
 *
 * @author anterova
 */
public class RatsuST implements Siirrontarkastaja {

    public RatsuST() {
    }

    @Override
    public boolean tarkista(Kentta kentta, int xa, int ya, int xl, int yl) {
        if(epaKelvotKoordinaatit(xa, ya, xl, yl)) return false;
        if(maaliRuudussaOmanPelaajanNappula(kentta.nappulaKoordinaatissa(xa, ya).omistajanPelinumero(), kentta, xl, yl)) return false;
        
        return true;
    }

    private boolean epaKelvotKoordinaatit(int xa, int ya, int xl, int yl) {
        return !( (xa-xl)*(xa-xl) + (ya-yl)*(ya-yl) == 5);
    }

    private boolean maaliRuudussaOmanPelaajanNappula(int omistajanPelinumero, Kentta kentta, int xl, int yl) {
        if(kentta.nappulaKoordinaatissa(xl, yl) == null) return false;
        return kentta.nappulaKoordinaatissa(xl, yl).omistajanPelinumero() == omistajanPelinumero;
    }
    
    
}
