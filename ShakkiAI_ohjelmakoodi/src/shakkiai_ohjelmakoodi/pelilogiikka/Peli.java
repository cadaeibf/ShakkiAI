/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka;

import shakkiai_ohjelmakoodi.main.Ihmispelaaja;
import shakkiai_ohjelmakoodi.ai.AI;
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
    private Matintarkastaja matintarkastaja;
    private boolean peliKaynnissa;
    private Pelaaja voittaja;
    
    public Peli() {
        pelaaja1 = new AI(1);
        pelaaja2 = new Ihmispelaaja(2);
        kentta = new Kentta(pelaaja1, pelaaja2);
        pelivuoro = 1;
        siirtohallinta = new Siirtohallinta();
        matintarkastaja = new Matintarkastaja();
        peliKaynnissa = true;
    }
    
    public void pelaaVuoro() {
        Siirto siirto;
        
        while(true) {
            System.out.println("\nPelaajan " + pelivuoro + " vuoro\n");
            siirto = pelivuorossa().teeSiirto(kentta);
            
            if(siirtohallinta.tarkista(kentta, pelivuoro, siirto.xAlku(), siirto.yAlku(), siirto.xLoppu(), siirto.yLoppu())) {
                kentta.teeSiirto(siirto);
                tarkistaTilanne();
                vaihdaPelivuoro();
                break;
            } else System.out.println("Epäkelpo siirto!");
        }
    }
    
    private Pelaaja pelivuorossa() {
        if(pelivuoro == 1) return pelaaja1;
        else return pelaaja2;
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
        if(matintarkastaja.matti(kentta, 2)) {
            peliKaynnissa = false;
            voittaja = pelaaja1;
        } else if(matintarkastaja.matti(kentta, 1)) {
            peliKaynnissa = false;
            voittaja = pelaaja2;
        }
    }
    
    public void loppuTulostus() {
        System.out.println("\nPELI LOPPU, VOITTAJA PELAAJA " + voittaja.getPelaajaNro());
    }
    
}
