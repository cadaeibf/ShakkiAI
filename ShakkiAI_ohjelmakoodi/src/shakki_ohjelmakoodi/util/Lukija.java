/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki_ohjelmakoodi.util;

import java.util.Scanner;

/**
 * Apuluokka käyttäjän syötteen lukemiseen
 * @author anterova
 */
public class Lukija {
    private Scanner lukija;

    public Lukija() {
        lukija = new Scanner(System.in);
    }
    
    public int lueKoordinaatti(String koordinaatinNimi) {
        int koordinaatti = -1;
        
        while(true) {
            try {
                koordinaatti = Integer.parseInt(lukija.nextLine());
                break;
            } catch (Exception e) {
                virheIlmoitus(koordinaatinNimi);
            }
        }
        
        return koordinaatti;
    }
    
    private void virheIlmoitus(String koordinaatinNimi) {
        System.out.println("Epäkelpo koordinaatti!");
        System.out.print("\t" + koordinaatinNimi + ": ");
    }
}
