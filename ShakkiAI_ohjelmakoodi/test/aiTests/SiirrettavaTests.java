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
import shakkiai_ohjelmakoodi.ai.Siirrettava;
import shakkiai_ohjelmakoodi.main.Ihmispelaaja;
import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Kuningas;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Torni;
import shakkiai_ohjelmakoodi.pelilogiikka.Siirto;

/**
 *
 * @author anterova
 */
public class SiirrettavaTests {
    private Kentta kentta;
    private Siirrettava siirrettava;
    
    public SiirrettavaTests() {
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
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void sotilaallaAlussaKaksiSiirtoa() {
        siirrettava = new Siirrettava(kentta, 1, 0);
        int siirtoja = 0;
        Siirto siirto;
        while(siirrettava.siirtojaJaljella()) {
            siirto = siirrettava.seuraavaSiirto();
            siirtoja++;
        }
        assertEquals(2, siirtoja);
    }
    
    @Test
    public void ratsullaAlussaKaksiSiirtoa() {
        siirrettava = new Siirrettava(kentta, 0, 1);
        int siirtoja = 0;
        Siirto siirto;
        while(siirrettava.siirtojaJaljella()) {
            siirto = siirrettava.seuraavaSiirto();
            siirtoja++;
        }
        assertEquals(2, siirtoja);
    } 
    
    @Test
    public void tornillaEiAlussaSiirtoja() {
        siirrettava = new Siirrettava(kentta,0,0);
        assertFalse(siirrettava.siirtojaJaljella());
    }
    
    @Test
    public void lahetillaEiAlussaSiirtoja() {
        siirrettava = new Siirrettava(kentta,0,2);
        assertFalse(siirrettava.siirtojaJaljella());
    }
    
    @Test
    public void kunigattarellaEiAlussaSiirtoja() {
        siirrettava = new Siirrettava(kentta,0,4);
        assertFalse(siirrettava.siirtojaJaljella());
    }
    
    @Test
    public void kuninkaallaEiAlussaSiirtoja() {
        siirrettava = new Siirrettava(kentta,0,3);
        assertFalse(siirrettava.siirtojaJaljella());
    }
    
    @Test
    public void mattiTilanne1() {
        kentta = new Kentta();
        kentta.haeRuutu(0, 0).setNappula(new Kuningas(new Ihmispelaaja(1)));
        kentta.haeRuutu(0, 3).setNappula(new Torni(new Ihmispelaaja(2)));
        kentta.haeRuutu(1, 3).setNappula(new Torni(new Ihmispelaaja(2)));
        
        siirrettava = new Siirrettava(kentta, 0, 0);
        int siirtoja = 0;
        Siirto siirto;
        while(siirrettava.siirtojaJaljella()) {
            siirtoja++;
            siirto = siirrettava.seuraavaSiirto();
        }
        assertEquals(0, siirtoja);
    }
    
}