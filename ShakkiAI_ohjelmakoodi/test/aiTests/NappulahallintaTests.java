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
import shakkiai_ohjelmakoodi.pelilogiikka.Siirto;

/**
 *
 * @author anterova
 */
public class NappulahallintaTests {
    private Kentta kentta;
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
        kentta = new Kentta(new Ihmispelaaja(1), new Ihmispelaaja(2));
        nappulahallinta = new Nappulahallinta(1, kentta);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void siirrettaviaAlussaOikeaMaara() {
        int siirrettavia = 0;
        Siirrettava siirrettava;
        while(nappulahallinta.nappuloitaJaljella()) {
            siirrettavia++;
            siirrettava = nappulahallinta.seuraava();
        }
        assertEquals(16, siirrettavia);
    }
    
}