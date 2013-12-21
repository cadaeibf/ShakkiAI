/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka;

import shakkiai_ohjelmakoodi.pelilogiikka.st.Siirtohallinta;

/**
 * Luokka, joka hallinnoi pelilogiikkaa.
 * @author anterova
 */
public class Peli {
    private Kentta kentta;
    private int pelivuoro;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Siirtohallinta siirtohallinta;
    private boolean peliKaynnissa;
    
    public Peli() {
        pelaaja1 = new Pelaaja(1);
        pelaaja2 = new Pelaaja(2);
        kentta = new Kentta(pelaaja1, pelaaja2);
        pelivuoro = 1;
        siirtohallinta = new Siirtohallinta();
        peliKaynnissa = true;
    }
    
    public void pelaaVuoro(int xa, int ya, int xl, int yl) {
        if(siirtohallinta.tarkista(kentta, xa, ya, xl, yl)) {
            kentta.teeSiirto(xa, ya, xl, yl);
            tarkistaTilanne();
            vaihdaPelivuoro();
        } else System.out.println("Epäkelpo siirto!");
    }
    
    private void vaihdaPelivuoro() {
        if(pelivuoro == 1) pelivuoro = 2;
        else pelivuoro = 1;
    }

    public boolean peliKaynnissa() {
        return peliKaynnissa;
    }
    
    public void tulostaKentta() {
        System.out.println(kentta);
        System.out.println("");
    }
    
    public int pelivuoro() {
        return this.pelivuoro;
    }
    
    private void tarkistaTilanne() {
        
    }
    
}
