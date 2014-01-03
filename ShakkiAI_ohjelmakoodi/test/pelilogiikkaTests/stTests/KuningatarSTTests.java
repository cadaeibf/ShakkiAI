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
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Kuningatar;
import shakkiai_ohjelmakoodi.pelilogiikka.Ihmispelaaja;
import shakkiai_ohjelmakoodi.pelilogiikka.st.KuningatarST;

/**
 *
 * @author anterova
 */
public class KuningatarSTTests {
    private KuningatarST kuningatarSt;
    private Kentta kentta;
    private Kuningatar kuningatar;
    
    public KuningatarSTTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kuningatarSt = new KuningatarST();
        
        Ihmispelaaja pelaaja1 = new Ihmispelaaja(1);
        kentta = new Kentta(pelaaja1, new Ihmispelaaja(2));
        kuningatar = new Kuningatar(pelaaja1);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void laillinenSiirto1() {
        kentta.haeRuutu(3, 3).setNappula(kuningatar);
        
        assertTrue(kuningatarSt.tarkista(kentta, 1, 3, 3, 2, 2));
    }
    
    @Test
    public void laillinenSiirto2() {
        kentta.haeRuutu(3, 3).setNappula(kuningatar);
        
        assertTrue(kuningatarSt.tarkista(kentta, 1, 3, 3, 3, 5));
    }
    
    @Test
    public void laillinenSiirto3() {
        kentta.haeRuutu(3, 3).setNappula(kuningatar);
        
        assertTrue(kuningatarSt.tarkista(kentta, 1, 3, 3, 4, 4));
    }
    
    @Test
    public void laillinenSiirto4() {
        kentta.haeRuutu(3, 3).setNappula(kuningatar);
        
        assertTrue(kuningatarSt.tarkista(kentta, 1, 3, 3, 2, 3));
    }
    
    @Test
    public void kuningatarEiHypiOmienYli() {
        assertFalse(kuningatarSt.tarkista(kentta, 1, 0, 4, 2, 4));
    }
    
    @Test
    public void kuningatarEiSyoOmia() {
        assertFalse(kuningatarSt.tarkista(kentta, 1, 0, 4, 1, 4));
    }
    
    @Test
    public void kuningatarEiHypiVihollistenYli() {
        kentta.haeRuutu(3, 3).setNappula(kuningatar);
        
        assertFalse(kuningatarSt.tarkista(kentta, 1, 3, 3, 7, 7));
    }
    
    @Test
    public void laillinenSyonti() {
        kentta.haeRuutu(3, 3).setNappula(kuningatar);
        
        assertTrue(kuningatarSt.tarkista(kentta, 1, 3, 3, 6, 3));
    }
    
}