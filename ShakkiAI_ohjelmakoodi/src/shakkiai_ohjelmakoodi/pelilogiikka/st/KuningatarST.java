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
public class KuningatarST implements Siirrontarkastaja {

    public KuningatarST() {
    }
    
    @Override
    public boolean tarkista(Kentta kentta, int xa, int ya, int xl, int yl) {
        if(epaKelvotKoordinaatit(xa, ya, xl, yl)) return false;
        if(kulkuradallaEsteita(kentta, xa, ya, xl, yl)) return false;
        if(maaliruudussaOmia(kentta.nappulaKoordinaatissa(xa, ya).omistajanPelinumero(), kentta, xl, yl)) return false;
        
        return true;
    }

    private boolean epaKelvotKoordinaatit(int xa, int ya, int xl, int yl) {
        if(kulkurataSuorassaLinjassa(xa, ya, xl, yl)) return false;
        if(kulkurataDiagonaaleilla(xa, ya, xl, yl)) return false;
        
        return true;
    }

    private boolean kulkurataSuorassaLinjassa(int xa, int ya, int xl, int yl) {
        return (xa == xl || ya == yl);
    }

    private boolean kulkurataDiagonaaleilla(int xa, int ya, int xl, int yl) {
        int horisontaalisiirtyma = xl - xa;
        if(horisontaalisiirtyma < 0) horisontaalisiirtyma *= -1;
        
        int vertikaalisiirtyma = yl - ya;
        if(vertikaalisiirtyma < 0) vertikaalisiirtyma *= -1;
        
        return horisontaalisiirtyma == vertikaalisiirtyma;
    }

    private boolean kulkuradallaEsteita(Kentta kentta, int xa, int ya, int xl, int yl) {
        if(xa == xl || ya == yl) return suorallaKulkuradallaEsteita(kentta, xa, ya, xl, yl);
        else return diagonaaliKulkuradallaEsteita(kentta, xa, ya, xl, yl);
    }

    private boolean suorallaKulkuradallaEsteita(Kentta kentta, int xa, int ya, int xl, int yl) {
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

    private boolean diagonaaliKulkuradallaEsteita(Kentta kentta, int xa, int ya, int xl, int yl) {
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
                for (int i = 1; i < xl - xa; i++) {
                    if(kentta.nappulaKoordinaatissa(xa - i, ya + i) != null) return true;
                }
            } else {
                for (int i = 1; i < xl - xa; i++) {
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
