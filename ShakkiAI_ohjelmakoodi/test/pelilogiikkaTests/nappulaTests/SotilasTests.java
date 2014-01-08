package pelilogiikkaTests.nappulaTests;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Sotilas;
import shakkiai_ohjelmakoodi.main.Ihmispelaaja;

/**
 *
 * @author Cadaei
 */
public class SotilasTests {
    private Sotilas sotilas;
    
    public SotilasTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        sotilas = new Sotilas(new Ihmispelaaja(1));
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void liikutaToimii() {
        sotilas.liikuta();
        assertFalse(sotilas.eiLiikkunut());
    }
    
    @Test
    public void getPelaajaToimii() {
        assertEquals(sotilas.getPelaaja().getPelaajaNro(), 1);
    }
    
}