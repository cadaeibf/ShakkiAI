/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.ai;

import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;
import shakkiai_ohjelmakoodi.pelilogiikka.Siirto;
import shakkiai_ohjelmakoodi.pelilogiikka.st.Siirtohallinta;
import shakkiai_ohjelmakoodi.util.KoordinaattiPino;

/**
 *
 * @author anterova
 */
public class Siirrettava {
    private int[] lahtokoordinaatit;
    private KoordinaattiPino maalikoordinaatit;

    public Siirrettava(Kentta kentta, int x, int y) {
        int peliNro = kentta.nappulaKoordinaatissa(x, y).omistajanPelinumero();
        lahtokoordinaatit = new int[2];
        lahtokoordinaatit[0] = x;
        lahtokoordinaatit[1] = y;
        
        luoMaalikoordinaatit(kentta, peliNro, x, y);
    }

    private void luoMaalikoordinaatit(Kentta kentta, int peliNro, int xa, int ya) {
        Siirtohallinta siirtohallinta = new Siirtohallinta();
        maalikoordinaatit = new KoordinaattiPino();
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(siirtohallinta.tarkista(kentta, peliNro, xa, ya, i, j)) maalikoordinaatit.push(i, j);
            }
        }
    }
    
    /**
     * Metodi palauttaa seuraavan siirrettävän mahdollisen siirron tai null, 
     * jos mahdollisia siirtoja ei ole.
     * @return 
     */
    public Siirto seuraavaSiirto() {
        if(maalikoordinaatit.onTyhja()) return null;
        
        int[] seuraavatMaalikoordinaatit = maalikoordinaatit.pop();
        return new Siirto(lahtokoordinaatit[0], lahtokoordinaatit[1], seuraavatMaalikoordinaatit[0], seuraavatMaalikoordinaatit[1]);
    }
    
    /**
     * Metodi palauttaa tiedon siitä, onko kyseisellä siirrettavalla 
     * mahdollisia siirtoja jäljellä
     * @return tieto siitä, onko siirrettävällä mahdollisia siirtoja jäljellä
     */
    public boolean siirtojaJaljella() {
        return !maalikoordinaatit.onTyhja();
    }
    
}
