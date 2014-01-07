/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.ai;

import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Siirronvalitsija siirronvalitsija;
    
    public AI(int pelaajaNro) {
        this.pelaajaNro = pelaajaNro;
        siirronvalitsija = new Siirronvalitsija(pelaajaNro);
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
        System.out.println("Valitaan siirto...");
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return siirronvalitsija.teeSiirto(kentta);
    }
    
}
