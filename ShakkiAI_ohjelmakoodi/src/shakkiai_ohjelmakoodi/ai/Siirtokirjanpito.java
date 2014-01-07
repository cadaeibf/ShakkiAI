/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.ai;

import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;
import shakkiai_ohjelmakoodi.pelilogiikka.st.Siirtohallinta;
import shakkiai_ohjelmakoodi.util.KoordinaattiJono;
import shakkiai_ohjelmakoodi.util.KoordinaattiSolmu;

/**
 * Luokka pitää kirjaa Nappulahallinnan nappuloiden mahdollisista siirroista 
 * tallentamalla lailliset maalikoordinaatit linkitettyinä listoina nappulahallinnan
 * pelinappuloita vastaavaan taulukkoon.
 * @author anterova
 */
public class Siirtokirjanpito {
    private KoordinaattiJono[] siirtokirjanpito;
    private KoordinaattiSolmu osoitin;
    private Siirtohallinta siirtohallinta;
    
    public Siirtokirjanpito(int pelaajaNro) {
        siirtokirjanpito = new KoordinaattiJono[16];
        if(pelaajaNro == 1) keraaValkoisenSiirrot();
        else keraaMustanSiirrot();
        for (int i = 0; i < 16; i++) {
            siirtokirjanpito[i] = new KoordinaattiJono();
        }
        siirtohallinta = new Siirtohallinta();
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
    
    /**
     * Metodi selvittää seuraavan mahdollisen siirron maalikoordinaatit annetulle
     * pelinappulalle
     * @param nappulanIndeksi annetun pelinappulan indeksi taulukossa
     * @return seuraavan mahdollisen siirron maalikoodinaatit tai null, jos seuraavaa
     * mahdollista siirtoa ei ole
     */
    public int[] seuraavatKoodinaatit(int nappulanIndeksi) {
        if(siirtokirjanpito[nappulanIndeksi].tyhja()) return null;
        return siirtokirjanpito[nappulanIndeksi].seuraava().koordinaatit();
    }
    
    public void paivita(Nappulahallinta nappulahallinta, Kentta kentta) {
        
    }
    
}
