/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.ai;

import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;
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
    
    public Siirronvalitsija(int peliNro) {
        omaPelinumero = peliNro;
    }
    
    public Siirto teeSiirto(Kentta kentta) {
        alustaPaikallisetMuuttujat(kentta);
        valitseSiirto(kentta, 0, omaPelinumero);
        return parasSiirto;
    }

    private void alustaPaikallisetMuuttujat(Kentta kentta) {
        parasArvo = Double.MIN_VALUE;
        alkuarvo = kentta.arvo(omaPelinumero) - kentta.arvo(vaihdaPelinumero(omaPelinumero));
        nykyinenArvo = alkuarvo;
        
    }

    private void valitseSiirto(Kentta kentta, int syvyys, int pelinumero) {
        if(syvyys == 3) {
            nykyinenArvo += kentta.arvo(omaPelinumero) - kentta.arvo(vaihdaPelinumero(omaPelinumero));
            return;
        }
        
        Siirto siirto;
        Nappulahallinta nappulahallinta = new Nappulahallinta(pelinumero, kentta);
        
        while(nappulahallinta.nappuloitaJaljella()) {
            Siirrettava siirrettava = nappulahallinta.seuraava();

            while(siirrettava.siirtojaJaljella()) {
                Kentta kentta2 = kentta.kopioi();
                siirto = siirrettava.seuraavaSiirto();

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
    
}
