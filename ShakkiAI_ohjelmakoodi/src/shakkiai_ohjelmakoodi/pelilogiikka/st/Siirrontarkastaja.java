/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka.st;

import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;

/**
 *
 * @author anterova
 */
public interface Siirrontarkastaja {
    
    public boolean tarkista(Kentta kentta, int xa, int ya, int xl, int yl);
    
}
