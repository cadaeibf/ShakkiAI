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
public class KuningasST implements Siirrontarkastaja {

    public KuningasST() {
    }

    @Override
    public boolean tarkista(Kentta kentta, int xa, int ya, int xl, int yl) {
        if(epaKelvotKoordinaatit(xa,ya,xl,yl)) return false;
        if(maaliruudussaOmia(kentta.nappulaKoordinaatissa(xa, ya).omistajanPelinumero(), kentta, xl, yl)) return false;
        if(kentta.ruutuUhattu(kentta.nappulaKoordinaatissa(xa, ya).omistajanPelinumero(), xl, yl)) return false;
        
        return true;
    }

    private boolean epaKelvotKoordinaatit(int xa, int ya, int xl, int yl) {
        int horisontaalisiirtyma = xl - xa;
        if(horisontaalisiirtyma < 0) horisontaalisiirtyma *= -1;
        
        int vertikaalisiirtyma = yl - ya;
        if(vertikaalisiirtyma < 0) vertikaalisiirtyma *= -1;
        
        return (horisontaalisiirtyma <= 1 && vertikaalisiirtyma <= 1);
    }

    private boolean maaliruudussaOmia(int omistajanPelinumero, Kentta kentta, int xl, int yl) {
        return omistajanPelinumero == kentta.nappulaKoordinaatissa(xl, yl).omistajanPelinumero();
    }
    
}
