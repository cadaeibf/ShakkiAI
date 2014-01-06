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
    private int[] koordinaatit;
    private KoordinaattiSolmu seuraava;

    public KoordinaattiSolmu(int x, int y) {
        koordinaatit = new int[2];
        koordinaatit[0] = x;
        koordinaatit[1] = y;
    }
    
    public void setSeuraava(KoordinaattiSolmu seuraava) {
        this.seuraava = seuraava;
    }
    
    public KoordinaattiSolmu seuraava() {
        return seuraava;
    }
    
    public int[] koordinaatit() {
        return this.koordinaatit;
    }
    
}
