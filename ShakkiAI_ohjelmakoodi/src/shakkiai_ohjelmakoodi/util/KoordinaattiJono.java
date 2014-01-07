/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.util;

/**
 *
 * @author Cadaei
 */
public class KoordinaattiJono {
    private KoordinaattiSolmu seuraava;

    public KoordinaattiJono() {
    }
    
    public void lisaa(KoordinaattiSolmu lisattava) {
        if(seuraava == null) {
            seuraava = lisattava;
            return;
        }
        KoordinaattiSolmu conductor = seuraava;
        while(conductor.seuraava() != null) conductor = conductor.seuraava();
        conductor.asetaSeuraava(lisattava);
    }
    
    public KoordinaattiSolmu seuraava() {
        if(seuraava == null) return null;
        KoordinaattiSolmu conductor = seuraava;
        if(conductor.seuraava() == null) seuraava = null;
        else seuraava = conductor.seuraava();
        return conductor;
    }
    
    public boolean tyhja() {
        return seuraava == null;
    }
    
}
