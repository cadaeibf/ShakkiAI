/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pelilogiikkaTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import shakkiai_ohjelmakoodi.main.Ihmispelaaja;
import shakkiai_ohjelmakoodi.pelilogiikka.Kentta;
import shakkiai_ohjelmakoodi.pelilogiikka.Matintarkastaja;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Kuningas;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Torni;

/**
 *
 * @author anterova
 */
public class MatintarkastajaTests {
    Matintarkastaja matintarkastaja;
    Kentta kentta;
    
    public MatintarkastajaTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        matintarkastaja = new Matintarkastaja();
        kentta = new Kentta();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void mattiKahdellaTornilla() {
        kentta.haeRuutu(0, 0).setNappula(new Kuningas(new Ihmispelaaja(1)));
        kentta.haeRuutu(0, 3).setNappula(new Torni(new Ihmispelaaja(2)));
        kentta.haeRuutu(1, 3).setNappula(new Torni(new Ihmispelaaja(2)));
        
        assertTrue(matintarkastaja.matti(kentta, 1));
    }
    
}