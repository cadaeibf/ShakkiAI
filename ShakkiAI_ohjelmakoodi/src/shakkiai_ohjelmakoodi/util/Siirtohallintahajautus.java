/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.util;

import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Kuningas;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Kuningatar;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Lahetti;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Ratsu;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Sotilas;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Torni;
import shakkiai_ohjelmakoodi.pelilogiikka.st.KuningasST;
import shakkiai_ohjelmakoodi.pelilogiikka.st.KuningatarST;
import shakkiai_ohjelmakoodi.pelilogiikka.st.LahettiST;
import shakkiai_ohjelmakoodi.pelilogiikka.st.RatsuST;
import shakkiai_ohjelmakoodi.pelilogiikka.st.Siirrontarkastaja;
import shakkiai_ohjelmakoodi.pelilogiikka.st.SotilasST;
import shakkiai_ohjelmakoodi.pelilogiikka.st.TorniST;

/**
 * Siirtohallinnan hajautusrakenne eri luokkien siirrontarkastajien pitämiseen
 * @author anterova
 */
public class Siirtohallintahajautus {
    Hajautuslinkki[] siirtohallintahajautus;

    public Siirtohallintahajautus() {
        siirtohallintahajautus = new Hajautuslinkki[6];
        siirtohallintahajautus[0] = new Hajautuslinkki(new Sotilas().getClass(), new SotilasST());
        siirtohallintahajautus[1] = new Hajautuslinkki(new Torni().getClass(), new TorniST());
        siirtohallintahajautus[2] = new Hajautuslinkki(new Ratsu().getClass(), new RatsuST());
        siirtohallintahajautus[3] = new Hajautuslinkki(new Lahetti().getClass(), new LahettiST());
        siirtohallintahajautus[4] = new Hajautuslinkki(new Kuningatar().getClass(), new KuningatarST());
        siirtohallintahajautus[5] = new Hajautuslinkki(new Kuningas().getClass(), new KuningasST());
    }
    
    public Siirrontarkastaja hae(Class luokka) {
        for (int i = 0; i < 6; i++) {
            if(siirtohallintahajautus[i].osoite() == luokka) return siirtohallintahajautus[i].arvo();
        }
        return null;
    }
}
