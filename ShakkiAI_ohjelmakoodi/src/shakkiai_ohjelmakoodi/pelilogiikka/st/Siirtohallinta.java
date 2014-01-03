/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka.st;

import java.util.HashMap;
import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Kuningatar;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Lahetti;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Ratsu;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Sotilas;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Torni;

/**
 * Luokka tarkistaa, onko annetut siirrot laillisia spesifimpien 
 * Siirrontarkastajien avulla.
 * @author anterova
 */
public class Siirtohallinta implements Siirrontarkastaja {
    private HashMap<Class, Siirrontarkastaja> siirtohallinta;
    
    public Siirtohallinta() {
        siirtohallinta = new HashMap();
        luoSiirtohallinta();
    }
    
    
    
    private void luoSiirtohallinta() {
        siirtohallinta.put(new Sotilas().getClass(), new SotilasST());
        siirtohallinta.put(new Torni().getClass(), new TorniST());
        siirtohallinta.put(new Ratsu().getClass(), new RatsuST());
        siirtohallinta.put(new Lahetti().getClass(), new LahettiST());
        siirtohallinta.put(new Kuningatar().getClass(), new KuningatarST());
    }

    @Override
    public boolean tarkista(Kentta kentta, int pelaajaNumero, int xa, int ya, int xl, int yl) {
        if(epakelvotKoordinaatit(xa,xl,ya,yl)) return false;
        if(alkuJaLoppuKoordinaatitSamat(xa, ya, xl, yl)) return false;
        if(alkuKoordinaatitEivatOsoitaNappulaan(kentta, xa, ya)) return false;
        if(kentta.nappulaKoordinaatissa(xa, ya).omistajanPelinumero() != pelaajaNumero) return false;
        
        return siirtohallinta.get(kentta.nappulaKoordinaatissa(xa, ya).getClass()).tarkista(kentta, pelaajaNumero, xa, ya, xl, yl);
    }
    
    private boolean alkuKoordinaatitEivatOsoitaNappulaan(Kentta kentta, int xa, int ya) {
        return kentta.nappulaKoordinaatissa(xa, ya) == null;
    }
    
    private boolean alkuJaLoppuKoordinaatitSamat(int xa, int ya, int xl, int yl) {
        return (xa == xl && ya == yl);
    }

    private boolean epakelvotKoordinaatit(int xa, int xl, int ya, int yl) {
        if(xa < 0 || xa > 7) return true;
        if(ya < 0 || ya > 7) return true;
        if(xl < 0 || xl > 7) return true;
        if(yl < 0 || yl > 7) return true;
        
        return false;
    }
    
}
