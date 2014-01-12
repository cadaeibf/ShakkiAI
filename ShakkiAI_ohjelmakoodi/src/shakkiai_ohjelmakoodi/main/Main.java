/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.main;

import shakkiai_ohjelmakoodi.ai.AI;
import shakkiai_ohjelmakoodi.ai.Siirronvalitsija;
import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;

/**
 *
 * @author anterova
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         new Kayttoliittyma().kaynnista();
        
//        Siirronvalinta-algoritmin suorituskyvyn testausohjelma
//
//        Siirronvalitsija siirronvalitsija = new Siirronvalitsija(1);
//        Kentta kentta;
//        long alku, loppu;
//        long erotusSumma = 0;
//        int toistoja = 10;
//        
//        for (int i = 0; i < toistoja; i++) {
//            kentta = new Kentta(new AI(1), new AI(2));
//            
//            alku = System.nanoTime();
//            siirronvalitsija.teeSiirto(kentta);
//            loppu = System.nanoTime();
//            
//            erotusSumma += loppu - alku;
//            
//        }
//        System.out.println(erotusSumma / toistoja);
    }
}
