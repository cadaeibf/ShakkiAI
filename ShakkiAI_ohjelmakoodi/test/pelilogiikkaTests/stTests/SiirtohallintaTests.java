/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pelilogiikkaTests.stTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;
import shakkiai_ohjelmakoodi.main.Ihmispelaaja;
import shakkiai_ohjelmakoodi.pelilogiikka.st.Siirtohallinta;

/**
 *
 * @author anterova
 */
public class SiirtohallintaTests {
    private Siirtohallinta siirtohallinta;
    private Kentta kentta;
    
    public SiirtohallintaTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        siirtohallinta = new Siirtohallinta();
        kentta = new Kentta(new Ihmispelaaja(1), new Ihmispelaaja(2));
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void epakelpoKoordinaatti() {
        assertFalse(siirtohallinta.tarkista(kentta, 1, -1, 42, 3, 5));
    }
    
    @Test
    public void sotilasTesti1() {
        assertTrue(siirtohallinta.tarkista(kentta, 1, 1, 1, 2, 1));
    }
    
    @Test
    public void torniTesti1() {
        assertFalse(siirtohallinta.tarkista(kentta, 1, 0, 0, 2, 0));
    }
    
}