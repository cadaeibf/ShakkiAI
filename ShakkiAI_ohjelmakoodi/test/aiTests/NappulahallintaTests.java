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
import shakkiai_ohjelmakoodi.pelilogiikka.Ihmispelaaja;
import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Sotilas;
import shakkiai_ohjelmakoodi.pelilogiikka.Siirto;

/**
 *
 * @author anterova
 */
public class NappulahallintaTests {
    private Nappulahallinta nappulahallinta;
    
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
        nappulahallinta = new Nappulahallinta(1);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void arvoAlussaOikein() {
        assertEquals(39, nappulahallinta.arvo(new Kentta(new Ihmispelaaja(1), new Ihmispelaaja(2))));
    }
    
    @Test
    public void arvoOikeinKunNappulaSyoty() {
        Kentta kentta = new Kentta(new Ihmispelaaja(1), new Ihmispelaaja(2));
        kentta.haeRuutu(1, 0).poistaNappula();
        kentta.haeRuutu(1, 0).setNappula(new Sotilas(new Ihmispelaaja(2)));
        nappulahallinta.paivita(kentta);
        assertEquals(38, nappulahallinta.arvo(kentta));
    }
    
    @Test
    public void arvoSailyyOikeanaKunNappulaaLiikutetaan() {
        Kentta kentta = new Kentta(new Ihmispelaaja(1), new Ihmispelaaja(2));
        kentta.teeSiirto(new Siirto(1, 0, 3, 0));
        nappulahallinta.siirra(1, 0, 3, 0);
        assertEquals(39, nappulahallinta.arvo(kentta));
    }
}