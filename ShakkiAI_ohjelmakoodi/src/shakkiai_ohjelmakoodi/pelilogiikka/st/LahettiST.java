/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka.st;

import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;

/**
 * Siirrontarkastaja, joka tarkistaa Lahetti-luokan Nappuloiden siirrot.
 * @author anterova
 */
public class LahettiST implements Siirrontarkastaja {

    public LahettiST() {
    }

    
    
    @Override
    public boolean tarkista(Kentta kentta, int pelaajaNumero, int xa, int ya, int xl, int yl) {
        if(epaKelvotKoordinaatit(xa, ya, xl, yl)) return false;
        if(reitillaNappuloita(kentta, xa, ya, xl, yl)) return false;
        if(maaliruudussaOmia(kentta.nappulaKoordinaatissa(xa, ya).omistajanPelinumero(), kentta, xl, yl)) return false;
        
        return true;
    }

    private boolean epaKelvotKoordinaatit(int xa, int ya, int xl, int yl) {
        int horisontaalisiirtyma = xl - xa;
        if(horisontaalisiirtyma < 0) horisontaalisiirtyma *= -1;
        
        int vertikaalisiirtyma = yl - ya;
        if(vertikaalisiirtyma < 0) vertikaalisiirtyma *= -1;
        
        return horisontaalisiirtyma != vertikaalisiirtyma;
    }

    private boolean reitillaNappuloita(Kentta kentta, int xa, int ya, int xl, int yl) {
        if(xa < xl) {
            if(ya < yl) {
                for (int i = 1; i < xl - xa; i++) {
                    if(kentta.nappulaKoordinaatissa(xa + i, ya + i) != null) return true;
                }
            } else {
                for (int i = 1; i < xl - xa; i++) {
                    if(kentta.nappulaKoordinaatissa(xa + i, ya - i) != null) return true;
                }
            }
        } else {
            if(ya < yl) {
                for (int i = 1; i < xa - xl; i++) {
                    if(kentta.nappulaKoordinaatissa(xa - i, ya + i) != null) return true;
                }
            } else {
                for (int i = 1; i < xa - xl; i++) {
                    if(kentta.nappulaKoordinaatissa(xa - i, ya - i) != null) return true;
                }
            }
        }
        
        return false;
    }

    private boolean maaliruudussaOmia(int omistajanPelinumero, Kentta kentta, int xl, int yl) {
        if(kentta.nappulaKoordinaatissa(xl, yl) == null) return false;
        
        return omistajanPelinumero == kentta.nappulaKoordinaatissa(xl, yl).omistajanPelinumero();
    }
    
}
