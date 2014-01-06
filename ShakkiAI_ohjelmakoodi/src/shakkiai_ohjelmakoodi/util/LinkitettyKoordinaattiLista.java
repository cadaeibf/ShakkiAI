/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.util;

/**
 * Linkitetty lista, joka koostuu koordinaateista.
 * @author anterova
 */
public class LinkitettyKoordinaattiLista {
    private KoordinaattiSolmu head;

    public LinkitettyKoordinaattiLista() {
    }
    
    public void lisaa(KoordinaattiSolmu lisattava) {
        if(head == null) {
            head = lisattava;
            return;
        }
        KoordinaattiSolmu conductor = head;
        while(conductor.seuraava() != null) conductor = conductor.seuraava();
        conductor.setSeuraava(lisattava);
    }
    
    public KoordinaattiSolmu head() {
        return this.head;
    }
    
    public void tyhjenna() {
        head = null;
    }
    
}
