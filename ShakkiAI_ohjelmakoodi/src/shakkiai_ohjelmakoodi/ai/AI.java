/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.ai;

import java.util.logging.Level;
import java.util.logging.Logger;
import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;
import shakkiai_ohjelmakoodi.pelilogiikka.Pelaaja;
import shakkiai_ohjelmakoodi.pelilogiikka.Siirto;

/**
 * Tekoäly-luokka, joka koittaa valita oman siirtonsa kentän silloisen tilanteen 
 * mukaan.
 * @author anterova
 */
public class AI implements Pelaaja {
    private int pelaajaNro;
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
    public Siirto teeSiirto(Kentta kentta) {
        System.out.print("Valitaan siirtoa...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
        }
        Siirto siirto = siirronvalitsija.teeSiirto(kentta);
        System.out.println(" siirto valittu\n");
        
        return siirto;
    }
    
}
