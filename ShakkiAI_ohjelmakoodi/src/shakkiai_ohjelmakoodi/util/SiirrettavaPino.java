/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.util;

import shakkiai_ohjelmakoodi.ai.Siirrettava;

/**
 * Siirrettava-luokan alkioista koostuva pino.
 * @author anterova
 */
public class SiirrettavaPino {
    private SiirrettavaSolmu head;

    public SiirrettavaPino() {
    }
    
   public void push(Siirrettava pushattava) {
       SiirrettavaSolmu uusi = new SiirrettavaSolmu(pushattava);
       
       if(head == null) head = uusi;
       else {
           uusi.asetaSeuraava(head);
           head = uusi;
       }
   }
   
   public Siirrettava pop() {
       if(head == null) return null;
       
       SiirrettavaSolmu temp = head;
       head = temp.seuraava();
       return temp.arvo();
   }
   
   public boolean onTyhja() {
       return head == null;
   }
    
}
