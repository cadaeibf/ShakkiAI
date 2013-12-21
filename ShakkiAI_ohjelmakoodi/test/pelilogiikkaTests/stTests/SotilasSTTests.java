package pelilogiikkaTests.stTests;

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
import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Sotilas;
import shakkiai_ohjelmakoodi.pelilogiikka.Pelaaja;
import shakkiai_ohjelmakoodi.pelilogiikka.st.SotilasST;

/**
 *
 * @author Cadaei
 */
public class SotilasSTTests {
    private SotilasST sotilasSt;
    private Kentta kentta;
    
    public SotilasSTTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        sotilasSt = new SotilasST();
        kentta = new Kentta(new Pelaaja(1), new Pelaaja(2));
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void tavallinenSiirto1() {
        assertTrue(sotilasSt.tarkista(kentta, 1, 0, 2, 0));
    }
    
    @Test
    public void tavallinenSiirto2() {
        assertTrue(sotilasSt.tarkista(kentta, 6, 0, 5, 0));
    }
    
    @Test
    public void aloitusSiirto1() {
        assertTrue(sotilasSt.tarkista(kentta, 1, 0, 3, 0));
    }
    
    @Test
    public void aloitusSiirto2() {
        assertTrue(sotilasSt.tarkista(kentta, 6, 0, 4, 0));
    }
    
    @Test
    public void syomisSiirto1() {
        kentta.haeRuutu(5, 3).setNappula(new Sotilas(new Pelaaja(1)));
        assertTrue(sotilasSt.tarkista(kentta, 5, 3, 6, 4));
        
    }
    
    @Test
    public void syomisSiirto2() {
        kentta.haeRuutu(5, 3).setNappula(new Sotilas(new Pelaaja(1)));
        assertTrue(sotilasSt.tarkista(kentta, 6, 4, 5, 3));
        
    }
    
    @Test
    public void eiSyodaOmia() {
        kentta.haeRuutu(3, 2).setNappula(new Sotilas(new Pelaaja(1)));
        assertFalse(sotilasSt.tarkista(kentta, 1, 2, 2, 3));
    }
    
    @Test
    public void sotilasEiPeraanny() {
        kentta.haeRuutu(4, 4).setNappula(new Sotilas(new Pelaaja(1)));
        assertFalse(sotilasSt.tarkista(kentta, 4, 4, 3, 4));
    }
    
}