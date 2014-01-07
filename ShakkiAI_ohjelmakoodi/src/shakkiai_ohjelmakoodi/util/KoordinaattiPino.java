/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.util;

/**
 * Koordinaattisolmuista koostuva pino;
 * @author anterova
 */
public class KoordinaattiPino {
    private KoordinaattiSolmu seuraava;

    public KoordinaattiPino() {
    }
    
    public void push(int x, int y) {
        KoordinaattiSolmu pushattava = new KoordinaattiSolmu(x, y);
        if(seuraava == null) seuraava = pushattava;
        else {
            pushattava.asetaSeuraava(seuraava);
            seuraava = pushattava;
        }
    }
    
    public int[] pop() {
        if(seuraava == null) return null;
        
        KoordinaattiSolmu popattava = seuraava;
        
        if(seuraava.seuraava() == null) seuraava = null;
        else seuraava = seuraava.seuraava();
        
        return popattava.koordinaatit();
    }
    
    public boolean onTyhja() {
        return seuraava == null;
    }
    
}
