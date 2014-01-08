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
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Torni;
import shakkiai_ohjelmakoodi.main.Ihmispelaaja;
import shakkiai_ohjelmakoodi.pelilogiikka.st.TorniST;

/**
 *
 * @author anterova
 */
public class TorniSTTests {
    TorniST torniSt;
    Kentta kentta;
    
    public TorniSTTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        torniSt = new TorniST();
        kentta = new Kentta(new Ihmispelaaja(1), new Ihmispelaaja(2));
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void torniEiHypiYliOmien() {
        assertFalse(torniSt.tarkista(kentta, 1, 0, 0, 3, 0));
    }
    
    @Test
    public void sallittuSiirto() {
        kentta.haeRuutu(2, 2).setNappula(new Torni(new Ihmispelaaja(1)));
        assertTrue(torniSt.tarkista(kentta, 1, 2, 2, 2, 4));
    }
    
    @Test
    public void torniEiMeneOmienPaalle() {
        assertFalse(torniSt.tarkista(kentta, 1, 0, 0, 1, 0));
    }
}