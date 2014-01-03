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
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Lahetti;
import shakkiai_ohjelmakoodi.pelilogiikka.Ihmispelaaja;
import shakkiai_ohjelmakoodi.pelilogiikka.st.LahettiST;

/**
 *
 * @author anterova
 */
public class LahettiSTTests {
    LahettiST lahettiSt;
    Kentta kentta;
    Lahetti lahetti;
    
    
    public LahettiSTTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        lahettiSt = new LahettiST();
        
        Ihmispelaaja pelaaja1 = new Ihmispelaaja(1);
        
        kentta = new Kentta(pelaaja1, new Ihmispelaaja(2));
        lahetti = new Lahetti(pelaaja1);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void laillinenSiirto1() {
        kentta.haeRuutu(3, 3).setNappula(lahetti);
        
        assertTrue(lahettiSt.tarkista(kentta, 1, 3, 3, 2, 2));
    }
    
    @Test
    public void laillinenSiirto2() {
        kentta.haeRuutu(3, 3).setNappula(lahetti);
        
        assertTrue(lahettiSt.tarkista(kentta, 1, 3, 3, 2, 4));
    }
    
    @Test
    public void laillinenSiirto3() {
        kentta.haeRuutu(3, 3).setNappula(lahetti);
        
        assertTrue(lahettiSt.tarkista(kentta, 1, 3, 3, 4, 4));
    }
    
    @Test
    public void laillinenSiirto4() {
        kentta.haeRuutu(3, 3).setNappula(lahetti);
        
        assertTrue(lahettiSt.tarkista(kentta, 1, 3, 3, 4, 2));
    }
    
    @Test
    public void laillinenSiirto5() {
        kentta.haeRuutu(3, 3).setNappula(lahetti);
        
        assertTrue(lahettiSt.tarkista(kentta, 1, 3, 3, 5, 5));
    }
    
    @Test
    public void epaKelvotKoordinaatit1() {
        kentta.haeRuutu(3, 3).setNappula(lahetti);
        
        assertFalse(lahettiSt.tarkista(kentta, 1, 3, 3, 4, 5));
    }
    
    @Test
    public void lahettiEiHypiOmienYli() {
        assertFalse(lahettiSt.tarkista(kentta, 1, 0, 2, 2, 4));
    }
    
    @Test
    public void lahettiEiMeneOmienPaalle() {
        assertFalse(lahettiSt.tarkista(kentta, 1, 0, 2, 1, 1));
    }
    
    @Test
    public void lahettiEiHypiVihollistenYli() {
        kentta.haeRuutu(5, 3).setNappula(lahetti);
        
        assertFalse(lahettiSt.tarkista(kentta, 1, 5, 3, 7, 1));
    }
    
    @Test
    public void lahettiSyoVihollisia() {
        kentta.haeRuutu(5, 3).setNappula(lahetti);
        
        assertTrue(lahettiSt.tarkista(kentta, 1, 5, 3, 6, 2));
    }
}