/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.ai;

/**
 *
 * @author anterova
 */
public class Siirtohallinta {
    private int[][][] siirtohallinta;
    private int osoitin;
    
    public Siirtohallinta(int pelaajaNro) {
        siirtohallinta = new int[16][32][2];
        osoitin = 0;
        if(pelaajaNro == 1) keraaValkoisenSiirrot();
        else keraaMustanSiirrot();
    }

    private void keraaValkoisenSiirrot() {
        for (int i = 0; i < 8; i++) {
            int[][] ises = siirtohallinta[i];
            
        }
    }

    private void keraaMustanSiirrot() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
