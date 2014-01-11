/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.main;

import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;
import shakkiai_ohjelmakoodi.util.Lukija;
import shakkiai_ohjelmakoodi.pelilogiikka.Pelaaja;
import shakkiai_ohjelmakoodi.pelilogiikka.Siirto;

/**
 * Luokka ns. ihmispelaajalle.
 * @author anterova
 */
public class Ihmispelaaja implements Pelaaja {
    private int pelaajaNro;
    private Lukija lukija;
    
    public Ihmispelaaja(int pelaajaNro) {
        this.pelaajaNro = pelaajaNro;
        lukija = new Lukija();
    }

    @Override
    public int getPelaajaNro() {
        return pelaajaNro;
    }

    @Override
    public Siirto teeSiirto(Kentta kentta) {
        System.out.println("Mistä:");
        System.out.print("\tx: ");
        int xa = lukija.lueKoordinaatti("x");
        System.out.print("\ty: ");
        int ya = lukija.lueKoordinaatti("y");
        System.out.println("");
        
        System.out.println("Mihin:");
        System.out.print("\tx: ");
        int xl = lukija.lueKoordinaatti("x");
        System.out.print("\ty: ");
        int yl = lukija.lueKoordinaatti("y");
        System.out.println("");
        
        return new Siirto(xa, ya, xl, yl);
    }
    
}
