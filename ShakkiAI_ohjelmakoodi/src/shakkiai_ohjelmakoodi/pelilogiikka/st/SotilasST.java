/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka.st;

import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Sotilas;

/**
 *
 * @author anterova
 */
public class SotilasST implements Siirrontarkastaja {
    
    public SotilasST() {}

    @Override
    public boolean tarkista(Kentta kentta, int xa, int ya, int xl, int yl) {
        Sotilas sotilas = (Sotilas) kentta.nappulaKoordinaatissa(xa, ya);
        
        if(sotilas.omistajanPelinumero() == 1) {
            return tarkistaValkoinen(sotilas, kentta, xa, ya, xl, yl);
        }
        
        return tarkistaMusta(sotilas, kentta, xa, ya, xl, yl);
    }

    private boolean tarkistaValkoinen(Sotilas sotilas, Kentta kentta, int xa, int ya, int xl, int yl) {
        if(ya == yl) {
            if(xl - xa == 1 && kentta.nappulaKoordinaatissa(xl, yl) == null) return true;
            if(avausSiirtoValkoinen(sotilas, kentta, xa, ya, xl, yl)) return true;
        }
        if( (ya - yl)*(ya - yl) == 1 ) {
            if(kentta.nappulaKoordinaatissa(xl, yl) == null) return false;
            if(kentta.nappulaKoordinaatissa(xl, yl).omistajanPelinumero() == 1) return false;
            
            if(xl - xa == 1) return true;
        }
        
        return false;
    }
    
    private boolean avausSiirtoValkoinen(Sotilas sotilas, Kentta kentta, int xa, int ya, int xl, int yl) {
        if(!sotilas.eiLiikkunut()) return false;
        if(kentta.nappulaKoordinaatissa(xa+1, ya) != null) return false;
        if(kentta.nappulaKoordinaatissa(xl, yl) != null) return false;
        if(ya != yl) return false;
        
        if( xl - xa == 2 ) {
            sotilas.liikuta();
            return true;
        }
        
        return false;
    }

    private boolean tarkistaMusta(Sotilas sotilas, Kentta kentta, int xa, int ya, int xl, int yl) {
        if(ya == yl) {
            if(xl - xa == -1 && kentta.nappulaKoordinaatissa(xl, yl) == null) return true;
            if(avausSiirtoMusta(sotilas, kentta, xa, ya, xl, yl)) return true;
        }
        if( (ya - yl)*(ya - yl) == 1 ) {
            if(kentta.nappulaKoordinaatissa(xl, yl) == null) return false;
            if(kentta.nappulaKoordinaatissa(xl, yl).omistajanPelinumero() == 2) return false;
            
            if(xl - xa == -1) return true;
        }
        
        return false;
    }

    private boolean avausSiirtoMusta(Sotilas sotilas, Kentta kentta, int xa, int ya, int xl, int yl) {
        if(!sotilas.eiLiikkunut()) return false;
        if(kentta.nappulaKoordinaatissa(xa-1, ya) != null) return false;
        if(kentta.nappulaKoordinaatissa(xl, yl) != null) return false;
        if(ya != yl) return false;
        
        if( xl - xa == -2 ) {
            sotilas.liikuta();
            return true;
        }
        
        return false;
    }
    
}
