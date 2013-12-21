/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka;

import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Nappula;

/**
 *
 * @author anterova
 */
public class Ruutu {
    private Nappula nappula;
    
    public Ruutu(){
    }
    
    public boolean hasNappula() {
        return nappula != null;
    }
    
    public void setNappula(Nappula nappula) {
        this.nappula = nappula;
    }
    
    public Nappula getNappula() {
        return nappula;
    }
    
    @Override
    public String toString() {
        if(nappula == null) return "[ ]";
        return nappula.toString();
    }
    
    
}
