/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka;

import java.util.Scanner;
import shakkiai_ohjelmakoodi.pelilogiikka.st.Siirtohallinta;

/**
 *
 * @author anterova
 */
public class Peli {
    private Kentta kentta;
    private int pelivuoro;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Scanner lukija;
    private Siirtohallinta siirtohallinta;
    
    public Peli() {
        pelaaja1 = new Pelaaja(1);
        pelaaja2 = new Pelaaja(2);
        kentta = new Kentta(pelaaja1, pelaaja2);
        pelivuoro = 1;
        lukija = new Scanner(System.in);
        siirtohallinta = new Siirtohallinta();
    }
    
    public void pelaa() {
        while(peliKaynnissa()) {
            pelaaVuoro();
        }
        System.out.println("");
        System.out.println("PELI LOPPU");
    }
    
    public void pelaaVuoro() {
        if(pelivuoro == 1) {
            pelivuoro = 2;
            pelaaVuoro1();
        } else {
            pelivuoro = 1;
            pelaaVuoro1();
        }
    }

    private void pelaaVuoro1() {
        System.out.println(kentta);
        System.out.println("");
        
        System.out.println("Mistä:");
        System.out.print("\tx: ");
        int xa = Integer.parseInt(lukija.nextLine());
        System.out.print("\ty: ");
        int ya = Integer.parseInt(lukija.nextLine());
        
        System.out.println("");
        System.out.println("Mihin:");
        System.out.print("\tx: ");
        int xl = Integer.parseInt(lukija.nextLine());
        System.out.print("\ty: ");
        int yl = Integer.parseInt(lukija.nextLine());
        
        while(!siirtohallinta.tarkista(kentta, xa, ya, xl, yl)) {
            System.out.println("Epäkelpo siirto!");
            System.out.println("");
            
            System.out.println("Mistä:");
            System.out.print("\tx: ");
            xa = Integer.parseInt(lukija.nextLine());
            System.out.print("\ty: ");
            ya = Integer.parseInt(lukija.nextLine());

            System.out.println("");
            System.out.println("Mihin:");
            System.out.print("\tx: ");
            xl = Integer.parseInt(lukija.nextLine());
            System.out.print("\ty: ");
            yl = Integer.parseInt(lukija.nextLine());
        }
        kentta.teeSiirto(xa, ya, xl, yl);
        
        System.out.println("");
    }

    private void pelaaVuoro2() {
        System.out.println(kentta);
        System.out.println("");
        
        System.out.println("Mistä:");
        System.out.print("\tx: ");
        int xa = Integer.parseInt(lukija.nextLine());
        System.out.print("\ty: ");
        int ya = Integer.parseInt(lukija.nextLine());
        
        System.out.println("");
        System.out.println("Mihin:");
        System.out.print("\tx: ");
        int xl = Integer.parseInt(lukija.nextLine());
        System.out.print("\ty: ");
        int yl = Integer.parseInt(lukija.nextLine());
        
        if(siirtohallinta.tarkista(kentta, xa, ya, xl, yl)) kentta.teeSiirto(xa, ya, xl, yl);
        
        System.out.println("");
    }

    private boolean peliKaynnissa() {
        return true;
    }
    
}
