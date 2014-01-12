/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.ai;

import java.sql.Time;
import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;
import shakkiai_ohjelmakoodi.pelilogiikka.Matintarkastaja;
import shakkiai_ohjelmakoodi.pelilogiikka.Siirto;

/**
 * Luokka, joka valitsee tekoälyn siirron muodostamalla pelipuun
 * @author anterova
 */
public class Siirronvalitsija {
    private int omaPelinumero;
    private double parasArvo;
    private Siirto parasSiirto;
    private double nykyinenArvo;
    private double alkuarvo;
    private Matintarkastaja matintarkastaja;
    
    public Siirronvalitsija(int peliNro) {
        matintarkastaja = new Matintarkastaja();
        omaPelinumero = peliNro;
    }
    
    public Siirto teeSiirto(Kentta kentta) {
        alustaPaikallisetMuuttujat(kentta);
        valitseSiirto(kentta, 0, omaPelinumero);
        
        return parasSiirto;
    }

    private void alustaPaikallisetMuuttujat(Kentta kentta) {
        parasArvo = Double.NEGATIVE_INFINITY;
        alkuarvo = kentta.arvo(omaPelinumero) - kentta.arvo(vaihdaPelinumero(omaPelinumero));
        nykyinenArvo = alkuarvo;
        parasSiirto = null;
    }

    private void valitseSiirto(Kentta kentta, int syvyys, int pelinumero) {
        if(matintarkastaja.matti(kentta, omaPelinumero)) {
            nykyinenArvo += laskeMattipainotus(syvyys);
            return;
        }
        if(matintarkastaja.matti(kentta, vaihdaPelinumero(omaPelinumero))) {
            nykyinenArvo -= laskeMattipainotus(syvyys);
            return;
        }
        if(syvyys == 4) {
            nykyinenArvo += kentta.arvo(omaPelinumero) - kentta.arvo(vaihdaPelinumero(omaPelinumero));
            return;
        }
        
        Siirrettava siirrettava;
        Siirto siirto;
        Nappulahallinta nappulahallinta = new Nappulahallinta(pelinumero, kentta);
        
        while(nappulahallinta.nappuloitaJaljella()) {
            siirrettava = nappulahallinta.seuraava();

            while(siirrettava.siirtojaJaljella()) {
                Kentta kentta2 = kentta.kopioi();
                siirto = siirrettava.seuraavaSiirto();
                
                if(parasSiirto == null) parasSiirto = siirto;

                kentta2.teeSiirto(siirto);

                valitseSiirto(kentta2, syvyys+1, vaihdaPelinumero(pelinumero));
                if(syvyys == 0) {
                    if(nykyinenArvo > parasArvo) {
                        parasArvo = nykyinenArvo;
                        parasSiirto = siirto;
                    }
                    nykyinenArvo = alkuarvo;
                }
            }
        }
        
    }
    
    private int vaihdaPelinumero(int peliNumero) {
        if(peliNumero == 1) return 2;
        return 1;
    }
    private double laskeMattipainotus(int syvyys) {
        if(syvyys == 0) return 0;
        return (double) 20 / (1 + (double) syvyys);
    }
    
}
