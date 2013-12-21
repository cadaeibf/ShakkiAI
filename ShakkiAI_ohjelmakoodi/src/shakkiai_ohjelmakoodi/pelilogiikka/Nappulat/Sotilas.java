/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka.Nappulat;

import shakkiai_ohjelmakoodi.pelilogiikka.Pelaaja;

/**
 *
 * @author anterova
 */
public class Sotilas implements Nappula {
    private Pelaaja pelaaja;
    private boolean eiLiikkunut;
    
    public Sotilas() {}
    
    public Sotilas(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        eiLiikkunut = true;
    }
    
    public void liikuta() {
        this.eiLiikkunut = false;
    }
    
    public boolean eiLiikkunut() {
        return eiLiikkunut;
    }
    
    @Override
    public Pelaaja getPelaaja() {
        return pelaaja;
    }
    
    @Override
    public int omistajanPelinumero() {
        return pelaaja.getPelaajaNro();
    }
    
    @Override
    public String toString() {
        return "So" + pelaaja.getPelaajaNro();
    }
    
}
