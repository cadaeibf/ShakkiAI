/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.ai;

import shakkiai_ohjelmakoodi.util.KoordinaattiSolmu;
import shakkiai_ohjelmakoodi.util.LinkitettyKoordinaattiLista;

/**
 * Luokka pitää kirjaa Nappulahallinnan nappuloiden mahdollisista siirroista 
 * tallentamalla lailliset maalikoordinaatit linkitettyinä listoina nappulahallinnan
 * pelinappuloita vastaavaan taulukkoon.
 * @author anterova
 */
public class Siirtokirjanpito {
    private LinkitettyKoordinaattiLista[] siirtokirjanpito;
    private int osoitin;
    
    public Siirtokirjanpito(int pelaajaNro) {
        siirtokirjanpito = new LinkitettyKoordinaattiLista[16];
        osoitin = 0;
        if(pelaajaNro == 1) keraaValkoisenSiirrot();
        else keraaMustanSiirrot();
    }

    private void keraaValkoisenSiirrot() {
        
        //valkoisten sotilaiden mahdolliset aloitussiirrot
        for (int i = 0; i < 8; i++) {
            siirtokirjanpito[i].lisaa(new KoordinaattiSolmu(2, i));
            siirtokirjanpito[i].lisaa(new KoordinaattiSolmu(3, i));
        }
        
        //valkoisten ratsujen mahdolliset aloitussiirrot
        siirtokirjanpito[9].lisaa(new KoordinaattiSolmu(2, 0));
        siirtokirjanpito[9].lisaa(new KoordinaattiSolmu(2, 2));
        siirtokirjanpito[14].lisaa(new KoordinaattiSolmu(2, 5));
        siirtokirjanpito[14].lisaa(new KoordinaattiSolmu(2, 7));
    }

    private void keraaMustanSiirrot() {
        //valkoisten sotilaiden mahdolliset aloitussiirrot
        for (int i = 0; i < 8; i++) {
            siirtokirjanpito[i].lisaa(new KoordinaattiSolmu(5, i));
            siirtokirjanpito[i].lisaa(new KoordinaattiSolmu(4, i));
        }
        
        //valkoisten ratsujen mahdolliset aloitussiirrot
        siirtokirjanpito[9].lisaa(new KoordinaattiSolmu(5, 0));
        siirtokirjanpito[9].lisaa(new KoordinaattiSolmu(5, 2));
        siirtokirjanpito[14].lisaa(new KoordinaattiSolmu(5, 5));
        siirtokirjanpito[14].lisaa(new KoordinaattiSolmu(5, 7));
    }
    
}
