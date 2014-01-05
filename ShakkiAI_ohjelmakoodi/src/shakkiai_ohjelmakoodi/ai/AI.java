/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.ai;

import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Kuningas;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Nappula;
import shakkiai_ohjelmakoodi.pelilogiikka.Pelaaja;
import shakkiai_ohjelmakoodi.pelilogiikka.Siirto;
import shakkiai_ohjelmakoodi.pelilogiikka.st.Siirtohallinta;

/**
 * Tekoäly-luokka, joka koittaa valita oman siirtonsa kentän silloisen tilanteen 
 * mukaan.
 * @author anterova
 */
public class AI implements Pelaaja {
    private int pelaajaNro;
    private Kuningas kuningas;
    private Nappulahallinta omat;
    private Nappulahallinta vastustajan;
    private Siirtohallinta siirtohallinta;
    
    public AI(int pelaajaNro) {
        this.pelaajaNro = pelaajaNro;
        omat = new Nappulahallinta(pelaajaNro);
        siirtohallinta = new Siirtohallinta();
        
        if(pelaajaNro == 1) {
            vastustajan = new Nappulahallinta(2);
        } else vastustajan = new Nappulahallinta(1);
    }
    
    @Override
    public int getPelaajaNro() {
        return pelaajaNro;
    }

    @Override
    public void setKuningas(Kuningas kuningas) {
        this.kuningas = kuningas;
    }

    @Override
    public Kuningas getKuningas() {
        return kuningas;
    }

    @Override
    public Siirto teeSiirto(Kentta kentta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Siirto valitseSiirto(Kentta kentta, int syvyys, Siirto paras) {
        if(syvyys == 2) return null;
        
        Nappula nappula;
        int[] koordinaatit = new int[2];
        
        while(omat.nappuloitaJaljella()) {
            koordinaatit = omat.seuraavanKoordinaatit();
            nappula = kentta.nappulaKoordinaatissa(koordinaatit[0], koordinaatit[1]);
        }
        
        return null;
    }
    
    
}
