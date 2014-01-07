/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.ai;

import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;
import shakkiai_ohjelmakoodi.util.SiirrettavaPino;

/**
 * Luokka pitää kirjaa pelin toisen osapuolen pelinappuloiden koordinaateista
 * siirtomahdollisuuksien vertailun tehokkuuden parantamiseksi.
 * @author anterova
 */
public class Nappulahallinta {
    private int peliNro;
    private int[][] koordinaatit;
    private SiirrettavaPino siirrettavat;
    
    
    public Nappulahallinta(int peliNro) {
        this.peliNro = peliNro;
        koordinaatit = new int[16][2];
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
    
    /**
     * Metodi vaihtaa annetut koordinaatit nappulahallinnassa annetuiksi.
     * @param xa vaihdettavan nappulan x-koordinaatti ennen vaihdosta
     * @param ya vaihdettavan nappulan y-koordinaatti ennen vaihdosta
     * @param xl vaihdettavan nappulan x-koordinaatti vaihdoksen jälkeen
     * @param yl vaihdettavan nappulan y-koordinaatti vaihdoksen jälkeen
     */
    public void vaihda(int xa, int ya, int xl, int yl) {
        for (int i = 0; i < 16; i++) {
            if(koordinaatit[i][0] == xa && koordinaatit[i][1] == ya) {
                koordinaatit[i][0] = xl;
                koordinaatit[i][1] = yl;
            }
        }
    }
    
    /**
     * Metodi muodostaa senhetkisen pelitilanteen mukaisen pinon siirrettäviä.
     * @param kentta pelin senhetkinen tilanne
     */
    public void muodostaSiirrettavaPino(Kentta kentta) {
        siirrettavat = new SiirrettavaPino();
        for (int i = 0; i < 16; i++) {
            if(koordinaatit[i][0] != -1) siirrettavat.push(new Siirrettava(kentta, koordinaatit[i][0], koordinaatit[i][1]));
        }
    }
    
    /**
     * Metodi palauttaa tiedon siitä onko siirrettäväpinossa pelinappuloita 
     * jäljellä
     * @return totuusarvo siitä onko siirrettäväpinossa pelinappuloita jäljellä
     */
    public boolean nappuloitaJaljella() {
        return !siirrettavat.onTyhja();
    }
    
    /**
     * Metodi palauttaa seuraavan siirrettävän pinosta
     * @return seuraava siirrettävä pinosta, tai null, jos pino on tyhjä
     */
    public Siirrettava seuraava() {
        if(siirrettavat.onTyhja()) return null;
        return siirrettavat.pop();
    }
}
