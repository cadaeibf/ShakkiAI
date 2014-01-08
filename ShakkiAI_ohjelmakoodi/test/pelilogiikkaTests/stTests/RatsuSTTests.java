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
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Ratsu;
import shakkiai_ohjelmakoodi.main.Ihmispelaaja;
import shakkiai_ohjelmakoodi.pelilogiikka.st.RatsuST;

/**
 *
 * @author anterova
 */
public class RatsuSTTests {
    private RatsuST ratsuSt;
    private Kentta kentta;
    
    public RatsuSTTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ratsuSt = new RatsuST();
        kentta = new Kentta(new Ihmispelaaja(1), new Ihmispelaaja(2));
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void sallittuSiirto() {
        assertTrue(ratsuSt.tarkista(kentta, 1, 0, 1, 2, 0));
    }
    
    @Test
    public void ratsuEiHypiOmienPaalle() {
        assertFalse(ratsuSt.tarkista(kentta, 1, 0, 1, 1, 3));
    }
    
    @Test
    public void ratsuHyppiiVihollistenPaalle() {
        kentta.haeRuutu(4, 0).setNappula(new Ratsu(new Ihmispelaaja(1)));
        assertTrue(ratsuSt.tarkista(kentta, 1, 4, 0, 6, 1));
    }
}