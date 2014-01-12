/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.main;

import shakkiai_ohjelmakoodi.pelilogiikka.Peli;

/**
 * Luokka, joka toimii rajapintana käyttäjän ja ohjelman välillä.
 * @author anterova
 */
public class Kayttoliittyma {
    private Peli peli;

    public Kayttoliittyma() {
        peli = new Peli();
    }
    
    /**
     * Metodi käynnistää ohjelman ajon käyttöliittymäluokan osalta.
     */
    public void kaynnista() {
        while(peli.peliKaynnissa()) {
            peli.tulostaKentta();
            peli.pelaaVuoro();
        }
        peli.tulostaKentta();
        peli.loppuTulostus();
    }
}