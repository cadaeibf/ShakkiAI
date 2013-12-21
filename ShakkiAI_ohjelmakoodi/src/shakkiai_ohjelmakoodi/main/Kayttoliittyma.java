/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.main;

import java.util.Scanner;
import shakkiai_ohjelmakoodi.pelilogiikka.Peli;

/**
 * Luokka, joka toimii rajapintana käyttäjän ja ohjelman välillä.
 * @author anterova
 */
public class Kayttoliittyma {
    private Scanner lukija;
    private Peli peli;

    public Kayttoliittyma() {
        lukija = new Scanner(System.in);
        peli = new Peli();
    }
    
    /**
     * Metodi käynnistää ohjelman ajon käyttöliittymäluokan osalta.
     */
    public void kaynnista() {
        while(peli.peliKaynnissa()) pelaaVuoro();
        
        System.out.println("");
        System.out.println("PELI LOPPU");
    }
    
    private void pelaaVuoro() {
        peli.tulostaKentta();
        
        if(peli.pelivuoro() == 1) pelaaVuoro1();
        else pelaaVuoro1();
    }
    
    private void pelaaVuoro1() {
        System.out.println("Mistä:");
        System.out.print("\tx: ");
        int xa = lueKoordinaatti("x");
        System.out.print("\ty: ");
        int ya = lueKoordinaatti("y");
        System.out.println("");
        
        System.out.println("Mihin:");
        System.out.print("\tx: ");
        int xl = lueKoordinaatti("x");
        System.out.print("\ty: ");
        int yl = lueKoordinaatti("y");
        System.out.println("");
        
        peli.pelaaVuoro(xa, ya, xl, yl);
    }
    
    private int lueKoordinaatti(String koordinaatinNimi) {
        int koordinaatti = -1;
        
        while(koordinaatti == -1) {
            try {
                koordinaatti = Integer.parseInt(lukija.nextLine());
            } catch (Exception e) {
                System.out.println("Epäkelpo koordinaatti!");
                System.out.print("\t" + koordinaatinNimi + ": ");
            }
        }
        
        return koordinaatti;
    }
    
}
