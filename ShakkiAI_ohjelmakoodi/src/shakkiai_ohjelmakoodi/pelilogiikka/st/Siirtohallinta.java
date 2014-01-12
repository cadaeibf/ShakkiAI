/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka.st;

import java.util.HashMap;
import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;
import shakkiai_ohjelmakoodi.pelilogiikka.Matintarkastaja;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Kuningas;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Kuningatar;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Lahetti;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Ratsu;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Sotilas;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Torni;
import shakkiai_ohjelmakoodi.pelilogiikka.Siirto;
import shakkiai_ohjelmakoodi.util.Siirtohallintahajautus;

/**
 * Luokka tarkistaa, onko annetut siirrot laillisia spesifimpien 
 * Siirrontarkastajien avulla.
 * @author anterova
 */
public class Siirtohallinta implements Siirrontarkastaja {
    private Siirtohallintahajautus siirtohallinta;
    private Matintarkastaja matintarkastaja;
    
    public Siirtohallinta() {
        siirtohallinta = new Siirtohallintahajautus();
        matintarkastaja = new Matintarkastaja();
    }

    @Override
    public boolean tarkista(Kentta kentta, int pelaajaNumero, int xa, int ya, int xl, int yl) {
        if(epakelvotKoordinaatit(xa,xl,ya,yl)) return false;
        if(alkuJaLoppuKoordinaatitSamat(xa, ya, xl, yl)) return false;
        if(alkuKoordinaatitEivatOsoitaNappulaan(kentta, xa, ya)) return false;
        if(kentta.nappulaKoordinaatissa(xa, ya).omistajanPelinumero() != pelaajaNumero) return false;
        if(!siirtohallinta.hae(kentta.nappulaKoordinaatissa(xa, ya).getClass()).tarkista(kentta, pelaajaNumero, xa, ya, xl, yl)) return false;
        
        return kuningasEiJouduUhatuksi(kentta, pelaajaNumero, xa, ya, xl, yl);
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

    private boolean kuningasEiJouduUhatuksi(Kentta kentta, int pelaajaNumero, int xa, int ya, int xl, int yl) {
        Kentta kentta2 = kentta.kopioi();
        kentta2.teeSiirto(new Siirto(xa, ya, xl, yl));
        return !(matintarkastaja.shakki(kentta2, pelaajaNumero));
    }
    
}
