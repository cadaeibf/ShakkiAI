/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.ai;

import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;

/**
 * Luokka pitää kirjaa pelin toisen osapuolen pelinappuloiden koordinaateista
 * siirtomahdollisuuksien vertailun tehokkuuden parantamiseksi.
 * @author anterova
 */
public class Nappulahallinta {
    private int peliNro;
    private int[][] koordinaatit;
    private int osoitin;
    
    public Nappulahallinta(int peliNro) {
        this.peliNro = peliNro;
        koordinaatit = new int[16][2];
        osoitin = 0;
        if(peliNro == 1) keraaValkoiset();
        else keraaMustat();
    }

    private void keraaValkoiset() {
        for (int i = 0; i < 8; i++) {
            koordinaatit[i][0] = 1;
            koordinaatit[i+7][0] = 0;
            koordinaatit[i][1] = i;
            koordinaatit[i+7][1] = i;
        }
    }

    private void keraaMustat() {
        for (int i = 0; i < 8; i++) {
            koordinaatit[i][0] = 6;
            koordinaatit[i+7][0] = 7;
            koordinaatit[i][1] = i;
            koordinaatit[i+7][1] = i;
        }
    }
    
    /**
     * Metodi tarkistaa annetusta kentästä, että onko omia pelinappuloita syöty
     * ja poistaa syödyt nappulat hallinnasta muuttamalla kyseisen nappulan 
     * x-koordinaatin arvoksi -1
     * @param kentta nykyinen pelitilanne
     */
    public void paivita(Kentta kentta) {
        int x,y;
        
        for (int i = 0; i < 16; i++) {
            x = koordinaatit[i][0];
            y = koordinaatit[i][1];
            if(x != -1 && kentta.nappulaKoordinaatissa(x, y).omistajanPelinumero() != peliNro) {
                koordinaatit[i][0] = -1;
            }
        }
    }
    
    /**
     * Metodi päivittää tehdyn siirron mukaiset koordinaatit hallintaan
     * @param xa siirretyn pelinappulan x-koordinaatti alussa
     * @param ya siirretyn pelinappulan y-koordinaatti alussa
     * @param xl siirretyn pelinappulan x-koordinaatti lopussa
     * @param yl siirretyn pelinappulan y-koordinaatti lopussa
     */
    public void siirra(int xa, int ya, int xl, int yl) {
        int x,y;
        
        for (int i = 0; i < 16; i++) {
            x = koordinaatit[i][0];
            y = koordinaatit[i][1];
            if(x == xa && y == ya) {
                koordinaatit[i][0] = xl;
                koordinaatit[i][1] = yl;
                return;
            }
        }
    }
    
    private void kasvataOsoitinta() {
        osoitin++;
        if(osoitin == 16) osoitin = 0;
    }
    
    /**
     * Metodi hakee nappulahallinnasta seuraavan nappulan koordinaatit
     * @return 
     */
    public int[] seuraavanKoordinaatit() {
        int[] seuraavanKoordinaatit = new int[2];
        
        while(true) {
            seuraavanKoordinaatit[0] = this.koordinaatit[osoitin][0];
            
            if(seuraavanKoordinaatit[0] != -1) {
                seuraavanKoordinaatit[1] = this.koordinaatit[osoitin][1];
                kasvataOsoitinta();
                break;
            }
            
            kasvataOsoitinta();
            if(osoitin == 0) break;
        }
        
        return seuraavanKoordinaatit;
    }
    
    /**
     * Metodi pelinappuloiden suhteellisen yhteisarvon selvittämiseksi.
     * @param kentta nykyinen pelitilanne
     * @return yksittäisten pelinappuloiden suhteellisten arvojen summa
     */
    public int arvo(Kentta kentta) {
        int arvo = 0;
        
        for (int i = 0; i < 16; i++) {
            if(koordinaatit[i][0] != -1) {
                arvo += kentta.nappulaKoordinaatissa(koordinaatit[i][0], koordinaatit[i][1]).arvo();
            }
        }
        
        return arvo;
    }
    
    public boolean nappuloitaJaljella() {
        return osoitin == 0;
    }
}
