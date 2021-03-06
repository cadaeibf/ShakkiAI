/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka;

import shakkiai_ohjelmakoodi.ai.Nappulahallinta;
import shakkiai_ohjelmakoodi.ai.Siirrettava;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Kuningas;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Nappula;

/**
 *
 * @author anterova
 */
public class Matintarkastaja {

    public Matintarkastaja() {
    }
    
    public boolean shakki(Kentta kentta, int pelaajaNro) {
        int[] koordinaatit = haeKuninkaanKoordinaatit(kentta, pelaajaNro);
        return kentta.ruutuUhattu(pelaajaNro, koordinaatit[0], koordinaatit[1]);
    }
    
    public boolean matti(Kentta kentta, int pelaajaNro) {
        if(!shakki(kentta, pelaajaNro)) return false;
        
        Nappulahallinta nappulahallinta = new Nappulahallinta(pelaajaNro, kentta);
        Siirrettava siirrettava;
        Siirto siirto;
        Kentta kentta2;
        
        while(nappulahallinta.nappuloitaJaljella()) {
            siirrettava = nappulahallinta.seuraava();
            
            while(siirrettava.siirtojaJaljella()) {
                siirto = siirrettava.seuraavaSiirto();
                kentta2 = kentta.kopioi();
                kentta2.teeSiirto(siirto);
                if(!shakki(kentta2,pelaajaNro)) return false;
            }
        }
        
        
        return true;
    }
    
    private int[] haeKuninkaanKoordinaatit(Kentta kentta, int pelaajaNro) {
        int[] koordinaatit = new int[2];
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(!kentta.haeRuutu(i, j).onTyhja()) {
                    Nappula nappula = kentta.nappulaKoordinaatissa(i, j);
                    if(nappula.omistajanPelinumero() == pelaajaNro 
                            && nappula.getClass() == new Kuningas().getClass()) {
                        koordinaatit[0] = i;
                        koordinaatit[1] = j;
                        return koordinaatit;
                    }
                }
            }
        }
        
        return null;
    } 
    
}
