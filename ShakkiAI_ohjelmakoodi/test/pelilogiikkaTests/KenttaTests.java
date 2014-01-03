package pelilogiikkaTests;

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
import shakkiai_ohjelmakoodi.pelilogiikka.Ihmispelaaja;
import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Lahetti;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Ratsu;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Torni;
import shakkiai_ohjelmakoodi.pelilogiikka.Pelaaja;

/**
 *
 * @author Cadaei
 */
public class KenttaTests {
    private Kentta kentta;
    Pelaaja pelaaja1;
    Pelaaja pelaaja2;
    
    public KenttaTests() {
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
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void ruudunUhkausVasemmalta() {
        kentta.haeRuutu(3, 0).setNappula(new Torni(pelaaja2));
        assertTrue(kentta.ruutuUhattu(1, 3, 3));
    }
    
    @Test
    public void ruudunUhkausOikealta() {
        kentta.haeRuutu(3, 7).setNappula(new Torni(pelaaja2));
        assertTrue(kentta.ruutuUhattu(1, 3, 3));
    }
    
    @Test
    public void ruudunUhkausYlhaalta() {
        kentta.haeRuutu(2, 3).setNappula(new Torni(pelaaja2));
        assertTrue(kentta.ruutuUhattu(1, 4, 3));
    }
    
    @Test
    public void ruudunUhkausAlhaalta() {
        kentta.haeRuutu(5, 3).setNappula(new Torni(pelaaja2));
        assertTrue(kentta.ruutuUhattu(1, 3, 3));
    }
    
    @Test
    public void ruudunUhkausVasenYla() {
        kentta.haeRuutu(2, 2).setNappula(new Lahetti(pelaaja1));
        assertTrue(kentta.ruutuUhattu(2, 4, 4));
    }
    
    @Test
    public void ruudunUhkausOikeaYla() {
        kentta.haeRuutu(2, 6).setNappula(new Lahetti(pelaaja1));
        assertTrue(kentta.ruutuUhattu(2, 4, 4));
    }
    
    @Test
    public void ruudunUhkausOikeaAla() {
        kentta.haeRuutu(5, 5).setNappula(new Lahetti(pelaaja2));
        assertTrue(kentta.ruutuUhattu(1, 3, 3));
    }
    
    @Test
    public void ruudunUhkausVasenAla() {
        kentta.haeRuutu(5, 1).setNappula(new Lahetti(pelaaja2));
        assertTrue(kentta.ruutuUhattu(1, 3, 3));
    }
    
    @Test
    public void ruudunUhkausRatsulla1() {
        kentta.haeRuutu(4, 4).setNappula(new Ratsu(pelaaja2));
        assertTrue(kentta.ruutuUhattu(1, 2, 3));
    }
    
    @Test
    public void ruudunUhkausRatsulla2() {
        kentta.haeRuutu(4, 2).setNappula(new Ratsu(pelaaja2));
        assertTrue(kentta.ruutuUhattu(1, 2, 3));
    }
    
    @Test
    public void ruudunUhkausRatsulla3() {
        kentta.haeRuutu(3, 5).setNappula(new Ratsu(pelaaja2));
        assertTrue(kentta.ruutuUhattu(1, 2, 3));
    }
    
    @Test
    public void ruudunUhkausRatsulla4() {
        kentta.haeRuutu(1, 5).setNappula(new Ratsu(pelaaja2));
        assertTrue(kentta.ruutuUhattu(1, 2, 3));
    }
    
    @Test
    public void ruudunUhkausRatsulla5() {
        kentta.haeRuutu(4, 4).setNappula(new Ratsu(pelaaja2));
        assertTrue(kentta.ruutuUhattu(1, 2, 3));
    }
    @Test
    public void ruudunUhkausRatsulla6() {
        kentta.haeRuutu(4, 4).setNappula(new Ratsu(pelaaja2));
        assertTrue(kentta.ruutuUhattu(1, 2, 3));
    }
    
    @Test
    public void ruudunUhkausRatsulla7() {
        kentta.haeRuutu(4, 4).setNappula(new Ratsu(pelaaja2));
        assertTrue(kentta.ruutuUhattu(1, 2, 3));
    }
    
    @Test
    public void ruudunUhkausRatsulla8() {
        kentta.haeRuutu(4, 4).setNappula(new Ratsu(pelaaja2));
        assertTrue(kentta.ruutuUhattu(1, 2, 3));
    }
}