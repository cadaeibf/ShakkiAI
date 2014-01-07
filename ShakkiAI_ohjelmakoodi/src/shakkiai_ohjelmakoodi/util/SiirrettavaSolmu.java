/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.util;

import shakkiai_ohjelmakoodi.ai.Siirrettava;

/**
 * Siirrettava-luokan alkioarvoinen solmu.
 * @author anterova
 */
public class SiirrettavaSolmu {
    private Siirrettava arvo;
    private SiirrettavaSolmu seuraava;

    public SiirrettavaSolmu(Siirrettava arvo) {
        this.arvo = arvo;
    }
    
    public void asetaSeuraava(SiirrettavaSolmu seuraava) {
        this.seuraava = seuraava;
    }
    
    public SiirrettavaSolmu seuraava() {
        if(seuraava == null) return null;
        
        return seuraava;
    }
    
    public Siirrettava arvo() {
        return arvo;
    }
    
}
