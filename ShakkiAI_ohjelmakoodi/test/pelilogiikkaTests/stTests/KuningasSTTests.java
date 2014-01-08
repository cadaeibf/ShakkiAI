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
import shakkiai_ohjelmakoodi.main.Ihmispelaaja;
import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Kuningas;
import shakkiai_ohjelmakoodi.pelilogiikka.Pelaaja;
import shakkiai_ohjelmakoodi.pelilogiikka.st.KuningasST;

/**
 *
 * @author anterova
 */
public class KuningasSTTests {
    Kentta kentta;
    KuningasST kuningasSt;
    Pelaaja pelaaja1;
    Pelaaja pelaaja2;
    
    public KuningasSTTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pelaaja1 = new Ihmispelaaja(1);
        pelaaja2 = new Ihmispelaaja(2);
        
        kentta = new Kentta(pelaaja1, pelaaja2);
        kuningasSt = new KuningasST();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void laillinenSiirto() {
        kentta.haeRuutu(2, 2).setNappula(new Kuningas(pelaaja1));
        assertTrue(kuningasSt.tarkista(kentta, 1, 2, 2, 3, 2));
    }
    
    @Test
    public void kuningasEiAstuUhattuunRuutuun1() {
        kentta.haeRuutu(4, 4).setNappula(new Kuningas(pelaaja1));
        assertFalse(kuningasSt.tarkista(kentta, 1, 4, 4, 5, 4));
    }
    
    @Test
    public void kuningasEiAstuUhattuunRuutuun2() {
        kentta.haeRuutu(5, 4).setNappula(new Kuningas(pelaaja1));
        assertFalse(kuningasSt.tarkista(kentta, 1, 5, 4, 6, 4));
    }
    
}