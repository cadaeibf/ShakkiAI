/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.util;

/**
 * Solmu koordinaatista, osa linkitettyä koordinaattilistaa.
 * @author anterova
 */
public class KoordinaattiSolmu {
    private int[] koordinaatti;
    private KoordinaattiSolmu seuraava;

    public KoordinaattiSolmu(int x, int y) {
        koordinaatti = new int[2];
        koordinaatti[0] = x;
        koordinaatti[1] = y;
    }
    
    public void setSeuraava(KoordinaattiSolmu seuraava) {
        this.seuraava = seuraava;
    }
    
    public KoordinaattiSolmu seuraava() {
        return seuraava;
    }
    
}
