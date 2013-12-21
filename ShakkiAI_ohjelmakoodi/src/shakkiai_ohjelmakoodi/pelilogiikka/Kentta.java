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
     * @param xa alkuruudun rivinumero
     * @param ya alkuruudun sarakenumero
     * @param xl loppuruudun rivinumero
     * @param yl loppuruudun sarakenumero
     */
    public void teeSiirto(int xa, int ya, int xl, int yl) {
        kentta[xl][yl].setNappula(kentta[xa][ya].getNappula());
        kentta[xa][ya].poistaNappula();
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
        kentta[0][3].setNappula(new Kuningas(pelaaja1));
        
        kentta[7][3].setNappula(new Kuningas(pelaaja2));
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
        
        return false;
    }
    
    private boolean suoraLinjaUhattu(int pelaajaNumero, int x, int y) {
        if(uhattuYlhaalta(pelaajaNumero, x, y)) return true;
        if(uhattuAlhaalta(pelaajaNumero, x, y)) return true;
        if(uhattuVasemmalta(pelaajaNumero, x, y)) return true;
        if(uhattuOikealta(pelaajaNumero, x, y)) return true;
        
        return false;
    }
    
    private boolean uhattuAlhaalta(int pelaajaNumero, int x, int y) {
        int i = 1;
        while(x+1 < 8 && kentta[x+i][ y].onTyhja()) i++;
        
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
        while(x-i >= 0 && kentta[x+i][ y].onTyhja()) i++;
        
        if(x-i == 0) return false;
        
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
        while(y-i >= 0 && kentta[x][y+i].onTyhja()) i++;
        
        if(y-i == 0) return false;
        
        if(kentta[x][y-i].getNappula().omistajanPelinumero() != pelaajaNumero) {
            if(i == 1 && kentta[x][y+i].getNappula().getClass() == new Kuningas().getClass()) return true;
            if(kentta[x][y-i].getNappula().getClass() == new Kuningatar().getClass()) return true;
            if(kentta[x][y-i].getNappula().getClass() == new Torni().getClass()) return true;
        }
        
        return false;
    }
    
}
