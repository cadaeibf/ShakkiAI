/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki_ohjelmakoodi.ai;

import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Kuningas;
import shakkiai_ohjelmakoodi.pelilogiikka.Pelaaja;
import shakkiai_ohjelmakoodi.pelilogiikka.Siirto;

/**
 * Tekoäly-luokka, joka koittaa valita oman siirtonsa kentän silloisen tilanteen 
 * mukaan.
 * @author anterova
 */
public class AI implements Pelaaja {
    private int pelaajaNro;
    private Kuningas kuningas;
    
    public AI(int pelaajaNro) {
        this.pelaajaNro = pelaajaNro;
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
    public Siirto valitseSiirto(Kentta kentta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
