/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka.st;

import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Torni;

/**
 *
 * @author anterova
 */
public class TorniST implements Siirrontarkastaja {

    public TorniST() {
    }
    
    

    @Override
    public boolean tarkista(Kentta kentta, int xa, int ya, int xl, int yl) {
        Torni torni = (Torni) kentta.haeRuutu(xa, ya).getNappula();
        
        if(maaliRuudussaOmanPelaajanNappula(torni.omistajanPelinumero(), kentta, xl, yl)) return false;
        if(kulkurataEiSuorassaLinjassa(xa, ya, xl, yl)) return false;
        if(kulkuradallaEsteita(kentta, xa, ya, xl, yl)) return false;
        
        
        return true;
    }
    
    private boolean maaliRuudussaOmanPelaajanNappula(int pelaajaNro, Kentta kentta, int xl, int yl) {
        if(kentta.nappulaKoordinaatissa(xl, yl) == null) return false;
        return (kentta.nappulaKoordinaatissa(xl, yl).omistajanPelinumero() == pelaajaNro);
    }

    private boolean kulkurataEiSuorassaLinjassa(int xa, int ya, int xl, int yl) {
        return (xa != xl && ya != yl);
    }

    private boolean kulkuradallaEsteita(Kentta kentta, int xa, int ya, int xl, int yl) {
        if(xa == xl) {
            if(ya < yl) {
                for (int i = ya + 1; i < yl; i++) {
                    if(kentta.nappulaKoordinaatissa(xa, i) != null) return true;
                }
            } else {
                for (int i = yl + 1; i < ya; i++) {
                    if(kentta.nappulaKoordinaatissa(xa, i) != null) return true;
                }
            }
        } else {
            if(xa < xl) {
                for (int i = xa + 1; i < xl; i++) {
                    if(kentta.nappulaKoordinaatissa(i, ya) != null) return true;
                }
            } else {
                for (int i = xl + 1; i < xa; i++) {
                    if(kentta.nappulaKoordinaatissa(i, ya) != null) return true;
                }
            }
        }
        
        return false;
    }
    
}
