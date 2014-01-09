/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka;

import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Nappula;

/**
 * Luokka kuvaa shakkikentän yksittäisiä ruutuja. Ruutu voi osoitttaa
 * nappula-rajapinnan toteuttavaan olioon, tai ei mihinkään.
 * @author anterova
 */
public class Ruutu {
    private Nappula nappula;
    
    public Ruutu(){
    }
    
    /**
     * Metodi selvittää, onko ruutu tyhjä, eli osoittaako se mihinkään Nappulaan.
     * @return 
     */
    public boolean onTyhja() {
        return nappula == null;
    }
    
    /**
     * Metodi asettaa ruudulle nappulan, eli muuttaa sen osoittaman nappulan 
     * parametrina saaduksi nappulaksi.
     * @param nappula uusi ruudun osoittama Nappula
     */
    public void setNappula(Nappula nappula) {
        this.nappula = nappula;
    }
    
    /**
     * Metodi poistaa Nappulan Ruudulta.
     */
    public void poistaNappula() {
        this.nappula = null;
    }
    
    public Nappula getNappula() {
        return nappula;
    }
    
    public Ruutu kopio() {
        Ruutu kopio = new Ruutu();
        if(!onTyhja()) kopio.setNappula(nappula.kopioi());
        return kopio;
    }
    
    @Override
    public String toString() {
        if(nappula == null) return "[ ]";
        return nappula.toString();
    }
    
    
}
