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
    private Nappulahallinta omat;
    private Nappulahallinta vastustajan;
    private int omaPelinumero;
    private int parasArvo;
    private Siirto parasSiirto;
    private int syvyys;
    private int nykyinenArvo;
    
    public Siirronvalitsija(int peliNro) {
        omaPelinumero = peliNro;
        if(peliNro == 1) {
            omat = new Nappulahallinta(1);
            vastustajan = new Nappulahallinta(2);
        } else {
            omat = new Nappulahallinta(2);
            vastustajan = new Nappulahallinta(1);
        }
    }
    
    public Siirto teeSiirto(Kentta kentta) {
        alustaPaikallisetMuuttujat(kentta);
        valitseSiirto(kentta, 0, omaPelinumero, omat, vastustajan);
        return parasSiirto;
    }

    private void alustaPaikallisetMuuttujat(Kentta kentta) {
        parasArvo = Integer.MIN_VALUE;
        parasSiirto = null;
        nykyinenArvo = omat.arvo(kentta) - vastustajan.arvo(kentta);
        
    }

    private void valitseSiirto(Kentta kentta, int syvyys, int pelinumero, Nappulahallinta omat, Nappulahallinta vastustajan) {
        if(syvyys == 6) {
            nykyinenArvo += omat.arvo(kentta) - vastustajan.arvo(kentta);
            return;
        }
        Siirto siirto = new Siirto(0,0,0,0);
        
        if(pelinumero == omaPelinumero) {
            while(omat.nappuloitaJaljella()) {
                Siirrettava siirrettava = omat.seuraava();
                
                while(siirrettava.siirtojaJaljella()) {
                    Kentta kentta2 = kentta;
                    siirto = siirrettava.seuraavaSiirto();
                    kentta2.teeSiirto(siirto);
                    
                    Nappulahallinta omat2 = omat;
                    Nappulahallinta vastustajan2 = vastustajan;
                    
                    omat2.siirra(siirto.xAlku(), siirto.yAlku(), siirto.xLoppu(), siirto.yLoppu());
                    vastustajan2.paivita(kentta2);
                    
                    valitseSiirto(kentta2, syvyys+1, vaihdaPelinumero(pelinumero), omat2, vastustajan2);
                }
            }
        } else {
            while(vastustajan.nappuloitaJaljella()) {
                Siirrettava siirrettava = vastustajan.seuraava();
                
                while(siirrettava.siirtojaJaljella()) {
                    Kentta kentta2 = kentta;
                    siirto = siirrettava.seuraavaSiirto();
                    kentta2.teeSiirto(siirto);
                    
                    Nappulahallinta omat2 = omat;
                    Nappulahallinta vastustajan2 = vastustajan;
                    
                    omat2.paivita(kentta2);
                    vastustajan2.siirra(siirto.xAlku(), siirto.yAlku(), siirto.xLoppu(), siirto.yLoppu());
                    
                    valitseSiirto(kentta2, syvyys+1, vaihdaPelinumero(pelinumero), omat2, vastustajan2);
                }
            }
        }
        
        if(syvyys == 1) {
            if(nykyinenArvo > parasArvo) {
                parasArvo = nykyinenArvo;
                parasSiirto = siirto;
            }
            nykyinenArvo = 0;
        }
    }
    
    private int vaihdaPelinumero(int peliNumero) {
        if(peliNumero == 1) return 2;
        return 1;
    }
    
}
