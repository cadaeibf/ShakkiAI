/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkiai_ohjelmakoodi.pelilogiikka;

import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Kuningas;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Kuningatar;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Nappula;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Lahetti;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Ratsu;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Sotilas;
import shakkiai_ohjelmakoodi.pelilogiikka.Nappulat.Torni;

/**
 * Luokka, joka hallinnoi pelitilannetta kaksiulotteisen Ruutu-alkioisen taulukon
 * avulla
 * @author anterova
 */
public class Kentta {
    private Ruutu[][] kentta;
    
    public Kentta(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.kentta = new Ruutu[8][8];
        
        alustaRuudut();
        
        asetaSotilaat(pelaaja1, pelaaja2);
        asetaTornit(pelaaja1, pelaaja2);
        asetaRatsut(pelaaja1, pelaaja2);
        asetaLahetit(pelaaja1, pelaaja2);
        asetaKuningattaret(pelaaja1, pelaaja2);
        asetaKuninkaat(pelaaja1, pelaaja2);
    }
    
    private void alustaRuudut() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                kentta[i][j] = new Ruutu();
            }
        }
        
    }
    
    /**
     * Suorittaa annetun siirron.
     * @param siirto suoritettava siirto
     */
    public void teeSiirto(Siirto siirto) {
        kentta[siirto.xLoppu()][siirto.yLoppu()].setNappula(kentta[siirto.xAlku()][siirto.yAlku()].getNappula());
        kentta[siirto.xAlku()][siirto.yAlku()].poistaNappula();
    }
    
    /**
     * Metodi palauttaa Ruudun annetussa paikassa
     * @param x halutun Ruudun rivinumero
     * @param y halutun Ruudun sarakenumero
     * @return haluttu Ruutu
     */
    public Ruutu haeRuutu(int x, int y) {
        return kentta[x][y];
    }
    
    /**
     * Metodi palauttaa Nappulan halutusta paikasta, tai null, jos kyseisessä
     * paikassa oleva ruutu on tyhjä.
     * @param x halutun Ruudun rivinumero
     * @param y halutun Ruudun sarakenumero
     * @return Nappula halutusta paikasta, tai null, jos Ruutu on tyhjä
     */
    public Nappula nappulaKoordinaatissa(int x, int y) {
        return kentta[x][y].getNappula();
    }
    
    @Override
    public String toString() {
        String tuloste = "0  ";
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tuloste += kentta[i][j].toString();
            }
            if(i < 7)tuloste += "\n" + (i+1) + "  ";
        }
        
        tuloste = "    0  1  2  3  4  5  6  7 <- y\n" + tuloste;
        tuloste += "\nx";
        
        return tuloste;
    }

    private void asetaTornit(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        kentta[0][0].setNappula(new Torni(pelaaja1));
        kentta[0][7].setNappula(new Torni(pelaaja1));
        
        kentta[7][0].setNappula(new Torni(pelaaja2));
        kentta[7][7].setNappula(new Torni(pelaaja2));
    }

    private void asetaSotilaat(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        for (int i = 0; i < 8; i++) {
            kentta[1][i].setNappula(new Sotilas(pelaaja1));
            kentta[6][i].setNappula(new Sotilas(pelaaja2));
        }
    }

    private void asetaRatsut(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        kentta[0][1].setNappula(new Ratsu(pelaaja1));
        kentta[0][6].setNappula(new Ratsu(pelaaja1));
        
        kentta[7][1].setNappula(new Ratsu(pelaaja2));
        kentta[7][6].setNappula(new Ratsu(pelaaja2));
    }

    private void asetaLahetit(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        kentta[0][2].setNappula(new Lahetti(pelaaja1));
        kentta[0][5].setNappula(new Lahetti(pelaaja1));
        
        kentta[7][2].setNappula(new Lahetti(pelaaja2));
        kentta[7][5].setNappula(new Lahetti(pelaaja2));
    }

    private void asetaKuningattaret(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        kentta[0][4].setNappula(new Kuningatar(pelaaja1));
        
        kentta[7][4].setNappula(new Kuningatar(pelaaja2));
    }

    private void asetaKuninkaat(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        Kuningas kuningas;
        
        kuningas = new Kuningas(pelaaja1);
        kentta[0][3].setNappula(kuningas);
        pelaaja1.setKuningas(kuningas);
        
        kuningas = new Kuningas(pelaaja2);
        kentta[7][3].setNappula(kuningas);
        pelaaja2.setKuningas(kuningas);
    }
    
    /**
     * Metodi tarkistaa, onko ruutu uhattu annetun pelaajanumeron suhteen.
     * @param pelaajaNumero pelaajaNumero pelaajalle, jonka suhteen uhkaus tarkistetaan.
     * @param x tutkittavan ruudun rivinumero
     * @param y tutkittavan ruudun sarakenumero
     * @return totuusarvo siitä, onko tutkittu ruutu uhattu
     */
    public boolean ruutuUhattu(int pelaajaNumero, int x, int y) {
        if(suoraLinjaUhattu(pelaajaNumero, x, y)) return true;
        if(diagonaaliUhattu(pelaajaNumero,x,y)) return true;
        if(ratsujaUhkaa(pelaajaNumero, x, y)) return true;
        
        return false;
    }
    
    private boolean suoraLinjaUhattu(int pelaajaNumero, int x, int y) {
        if(uhattuYlhaalta(pelaajaNumero, x, y)) return true;
        if(uhattuAlhaalta(pelaajaNumero, x, y)) return true;
        if(uhattuVasemmalta(pelaajaNumero, x, y)) return true;
        if(uhattuOikealta(pelaajaNumero, x, y)) return true;
        
        return false;
    }
    
    private boolean diagonaaliUhattu(int pelaajaNumero, int x, int y) {
        if(vasenYlaUhattu(pelaajaNumero, x, y)) return true;
        if(oikeaYlaUhattu(pelaajaNumero, x, y)) return true;
        if(oikeaAlaUhattu(pelaajaNumero, x, y)) return true;
        if(vasenAlaUhattu(pelaajaNumero, x, y)) return true;
        
        return false;
    }
    
    private boolean uhattuAlhaalta(int pelaajaNumero, int x, int y) {
        int i = 1;
        while(x+1 < 8 && kentta[x+i][y].onTyhja()) i++;
        
        if(x+i == 8) return false;
        
        if(kentta[x+i][y].getNappula().omistajanPelinumero() != pelaajaNumero) {
            if(i == 1 && kentta[x+i][y].getNappula().getClass() == new Kuningas().getClass()) return true;
            if(kentta[x+i][y].getNappula().getClass() == new Kuningatar().getClass()) return true;
            if(kentta[x+i][y].getNappula().getClass() == new Torni().getClass()) return true;
        }
        
        return false;
    }
    
    private boolean uhattuYlhaalta(int pelaajaNumero, int x, int y) {
        int i = 1;
        while(x-i >= 0 && kentta[x-i][y].onTyhja()) i++;
        
        if(x-i < 0) return false;
        
        if(kentta[x-i][y].getNappula().omistajanPelinumero() != pelaajaNumero) {
            if(i == 1 && kentta[x-i][y].getNappula().getClass() == new Kuningas().getClass()) return true;
            if(kentta[x-i][y].getNappula().getClass() == new Kuningatar().getClass()) return true;
            if(kentta[x-i][y].getNappula().getClass() == new Torni().getClass()) return true;
        }
        
        return false;
    }
    
    private boolean uhattuOikealta(int pelaajaNumero, int x, int y) {
        int i = 1;
        while(y+i < 8 && kentta[x][y+i].onTyhja()) i++;
        
        if(y+i == 8) return false;
        
        if(kentta[x][y+i].getNappula().omistajanPelinumero() != pelaajaNumero) {
            if(i == 1 && kentta[x][y+i].getNappula().getClass() == new Kuningas().getClass()) return true;
            if(kentta[x][y+i].getNappula().getClass() == new Kuningatar().getClass()) return true;
            if(kentta[x][y+i].getNappula().getClass() == new Torni().getClass()) return true;
        }
        
        return false;
    }
    
    private boolean uhattuVasemmalta(int pelaajaNumero, int x, int y) {
        int i = 1;
        while(y-i >= 0 && kentta[x][y-i].onTyhja()) i++;
        
        if(y-i == -1) return false;
        
        if(kentta[x][y-i].getNappula().omistajanPelinumero() != pelaajaNumero) {
            if(i == 1 && kentta[x][y-i].getNappula().getClass() == new Kuningas().getClass()) return true;
            if(kentta[x][y-i].getNappula().getClass() == new Kuningatar().getClass()) return true;
            if(kentta[x][y-i].getNappula().getClass() == new Torni().getClass()) return true;
        }
        
        return false;
    }

    private boolean vasenYlaUhattu(int pelaajaNumero, int x, int y) {
        int i = 1;
        while(x-i >= 0 && y-i >= 0 && kentta[x-i][y-i].onTyhja()) i++;
        
        if(x-i == -1 || y-i == -1) return false;
        
        if(kentta[x-i][y-i].getNappula().omistajanPelinumero() != pelaajaNumero) {
            
            if(kentta[x-i][y-i].getNappula().getClass() == new Kuningatar().getClass()) return true;    // Kunigatartarkistus
            if(kentta[x-i][y-i].getNappula().getClass() == new Lahetti().getClass()) return true;       // Lähettitarkistus
            if(i == i && kentta[x-i][y-i].getNappula().getClass() == new Kuningas().getClass()) return true;    // Kuningastarkistus
            
            if(i == 1 && kentta[x-i][y-i].getNappula().getClass() == new Sotilas().getClass()) {        // Sotilastarkistus
                if(kentta[x-i][y-i].getNappula().omistajanPelinumero() == 1
                        && pelaajaNumero == 2) return true;
            }
        }
        
        return false;
    }

    private boolean oikeaAlaUhattu(int pelaajaNumero, int x, int y) {
        int i = 1;
        while(x+i < 8 && y+i < 8 && kentta[x+i][y+i].onTyhja()) i++;
        
        if(x+i == 8 || y+i == 8) return false;
        
        if(kentta[x+i][y+i].getNappula().omistajanPelinumero() != pelaajaNumero) {
            
            if(kentta[x+i][y+i].getNappula().getClass() == new Kuningatar().getClass()) return true;    // Kunigatartarkistus
            if(kentta[x+i][y+i].getNappula().getClass() == new Lahetti().getClass()) return true;       // Lähettitarkistus
            if(i == i && kentta[x+i][y+i].getNappula().getClass() == new Kuningas().getClass()) return true;    // Kuningastarkistus
            
            if(i == 1 && kentta[x+i][y+i].getNappula().getClass() == new Sotilas().getClass()) {        // Sotilastarkistus
                if(kentta[x+i][y+i].getNappula().omistajanPelinumero() == 2
                        && pelaajaNumero == 1) return true;
            }
        }
        
        return false;
    }

    private boolean oikeaYlaUhattu(int pelaajaNumero, int x, int y) {
        int i = 1;
        while(x-i >= 0 && y+i < 8 && kentta[x-i][y+i].onTyhja()) i++;
        
        if(x-i == -1 || y+i == 8) return false;
        
        if(kentta[x-i][y+i].getNappula().omistajanPelinumero() != pelaajaNumero) {
            
            if(kentta[x-i][y+i].getNappula().getClass() == new Kuningatar().getClass()) return true;    // Kunigatartarkistus
            if(kentta[x-i][y+i].getNappula().getClass() == new Lahetti().getClass()) return true;       // Lähettitarkistus
            if(i == i && kentta[x-i][y+i].getNappula().getClass() == new Kuningas().getClass()) return true;    // Kuningastarkistus
            
            if(i == 1 && kentta[x-i][y+i].getNappula().getClass() == new Sotilas().getClass()) {        // Sotilastarkistus
                if(kentta[x-i][y+i].getNappula().omistajanPelinumero() == 1
                        && pelaajaNumero == 2) return true;
            }
        }
        
        return false;
    }

    private boolean vasenAlaUhattu(int pelaajaNumero, int x, int y) {
        int i = 1;
        while(x+i < 8 && y-i >= 0 && kentta[x+i][y-i].onTyhja()) i++;
        
        if(x+i == 8 || y-i == -1) return false;
        
        if(kentta[x+i][y-i].getNappula().omistajanPelinumero() != pelaajaNumero) {
            
            if(kentta[x+i][y-i].getNappula().getClass() == new Kuningatar().getClass()) return true;    // Kunigatartarkistus
            if(kentta[x+i][y-i].getNappula().getClass() == new Lahetti().getClass()) return true;       // Lähettitarkistus
            if(i == i && kentta[x+i][y-i].getNappula().getClass() == new Kuningas().getClass()) return true;    // Kuningastarkistus
            
            if(i == 1 && kentta[x+i][y-i].getNappula().getClass() == new Sotilas().getClass()) {        // Sotilastarkistus
                if(kentta[x+i][y-i].getNappula().omistajanPelinumero() == 2
                        && pelaajaNumero == 1) return true;
            }
        }
        
        return false;
    }

    private boolean ratsujaUhkaa(int pelaajaNumero, int x, int y) {
        Ratsu ratsu = new Ratsu();
        Nappula cond;
        
        if(x+2 < 8 && y+1 < 8 && !kentta[x+2][y+1].onTyhja()) {
            cond = kentta[x+2][y+1].getNappula();
            if(cond.omistajanPelinumero() != pelaajaNumero && cond.getClass() == ratsu.getClass()) return true;
        } if(x+2 < 8 && y-1 >= 0 && !kentta[x+2][y-1].onTyhja()) {
            cond = kentta[x+2][y-1].getNappula();
            if(cond.omistajanPelinumero() != pelaajaNumero && cond.getClass() == ratsu.getClass()) return true;
        } if(x-2 >= 0 && y+1 < 8 && !kentta[x-2][y+1].onTyhja()) {
            cond = kentta[x-2][y+1].getNappula();
            if(cond.omistajanPelinumero() != pelaajaNumero && cond.getClass() == ratsu.getClass()) return true;
        } if(x-2 >= 0 && y-1 >= 0 && !kentta[x-2][y-1].onTyhja()) {
            cond = kentta[x-2][y-1].getNappula();
            if(cond.omistajanPelinumero() != pelaajaNumero && cond.getClass() == ratsu.getClass()) return true;
        } if(x+1 < 8 && y+2 < 8 && !kentta[x+1][y+2].onTyhja()) {
            cond = kentta[x+1][y+2].getNappula();
            if(cond.omistajanPelinumero() != pelaajaNumero && cond.getClass() == ratsu.getClass()) return true;
        } if(x+1 < 8 && y-2 >= 0 && !kentta[x+1][y-2].onTyhja()) {
            cond = kentta[x+1][y-2].getNappula();
            if(cond.omistajanPelinumero() != pelaajaNumero && cond.getClass() == ratsu.getClass()) return true;
        } if(x-1 >= 0 && y+2 < 8 && !kentta[x-1][y+2].onTyhja()) {
            cond = kentta[x-1][y+2].getNappula();
            if(cond.omistajanPelinumero() != pelaajaNumero && cond.getClass() == ratsu.getClass()) return true;
        } if(x-1 >= 0 && y-2 >= 0 && !kentta[x-1][y-2].onTyhja()) {
            cond = kentta[x-1][y-2].getNappula();
            if(cond.omistajanPelinumero() != pelaajaNumero && cond.getClass() == ratsu.getClass()) return true;
        }
        
        return false;
    }
    
}
