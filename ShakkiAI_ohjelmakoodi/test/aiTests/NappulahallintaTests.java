/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aiTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import shakkiai_ohjelmakoodi.ai.Nappulahallinta;
import shakkiai_ohjelmakoodi.ai.Siirrettava;
import shakkiai_ohjelmakoodi.main.Ihmispelaaja;
import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Sotilas;
import shakkiai_ohjelmakoodi.pelilogiikka.Siirto;

/**
 *
 * @author anterova
 */
public class NappulahallintaTests {
    private Kentta kentta;
    private Nappulahallinta omat;
    private Nappulahallinta vastustajan;
    
    public NappulahallintaTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        omat = new Nappulahallinta(1);
        vastustajan = new Nappulahallinta(2);
        kentta = new Kentta(new Ihmispelaaja(1), new Ihmispelaaja(2));
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void arvoAlussaOikein() {
        assertEquals(39, omat.arvo(kentta));
    }
    
    @Test
    public void arvoOikeinKunNappulaSyoty() {
        kentta.haeRuutu(1, 0).poistaNappula();
        kentta.haeRuutu(1, 0).setNappula(new Sotilas(new Ihmispelaaja(2)));
        omat.paivita(kentta);
        assertEquals(38, omat.arvo(kentta));
    }
    
    @Test
    public void arvoSailyyOikeanaKunNappulaaLiikutetaan() {
        kentta.teeSiirto(new Siirto(1, 0, 3, 0));
        omat.siirra(kentta, 1, 0, 3, 0);
        assertEquals(39, omat.arvo(kentta));
    }
    
    @Test
    public void siirrettaviaAlussaOikeaMaara() {
        int siirrettavia = 0;
        omat.muodostaSiirrettavaPino(kentta);
        Siirto siirto;
        
        while(omat.nappuloitaJaljella()) {
            siirrettavia++;
            Siirrettava siirrettava = omat.seuraava();
        }
        assertEquals(16, siirrettavia);
    }
    
    @Test
    public void siirtojaAlussaOikeaMaara() {
        int siirtoja = 0;
        omat.muodostaSiirrettavaPino(kentta);
        Siirrettava siirrettava;
        Siirto siirto;
        
        while(omat.nappuloitaJaljella()) {
            siirrettava = omat.seuraava();
            
            while(siirrettava.siirtojaJaljella()) {
                siirto = siirrettava.seuraavaSiirto();
                siirtoja++;
            }
        }
        
        assertEquals(20, siirtoja);
    }
    
}