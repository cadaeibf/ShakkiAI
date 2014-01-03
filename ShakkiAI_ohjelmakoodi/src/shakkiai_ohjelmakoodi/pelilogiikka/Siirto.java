/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka;

/**
 *
 * @author anterova
 */
public class Siirto {
    private int xAlku;
    private int yAlku;
    private int xLoppu;
    private int yLoppu;

    public Siirto(int xAlku, int yAlku, int xLoppu, int yLoppu) {
        this.xAlku = xAlku;
        this.yAlku = yAlku;
        this.xLoppu = xLoppu;
        this.yLoppu = yLoppu;
    }
    
    public int xAlku() {
        return xAlku;
    }
    
    public int yAlku() {
        return yAlku;
    }
    
    public int xLoppu() {
        return xLoppu;
    }
    
    public int yLoppu() {
        return yLoppu;
    }
}
