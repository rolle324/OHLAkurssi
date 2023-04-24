package kps;


import java.time.Clock;
import java.util.ArrayList;
import java.util.List;

public class Peli {

    Pelaaja p1 = new Pelaaja();
    Pelaaja p2 = new Pelaaja();
    int tasapelit = 0, era = 0;
    boolean peliLoppui = false;
    String pelaaja1valinta, pelaaja2valinta;
    
    
    /**
     * Peli aloitetaan ja aletaan suorittamaan eri metodeita while loopissa, kunnes voittojen määrä toisilla pelaajista on kolme
 
     */
    public void aloitaPeli() {


        while (!peliLoppui) {
            //Erän määrää kasvatetaan aina uuden erän alkaessa
            era++;
        		
            System.out.println("Erä: " + era + " =====================\n");
            System.out.println("Tasapelien määrä: " + tasapelit + "\n");

            //Katsoo pelaajien valinnat
            pelaajienValinnat();


            //Tarkistaa pelaajien valinnat ja valintojen mukaisesti määrää erän voittajan
            tarkistaValinnat(pelaaja1valinta, pelaaja2valinta);


            //Tulostaa pelin tilanteen
            System.out.println("Tilanne: pelaajan 1 voitot: "+p1.getVoitot()+"\npelaajan 2 voitot: "+p2.getVoitot());

            //Tarkistaa että onko kummallakaan pelaajista kolmea voittoa
            pelinPaattymisenTarkistus();

            System.out.println();
        }	
    }
    
    /**
     * Arpoo 0-2 numeron ja valitsee kiven, paperin tai sakset
     * @param c
     * @param pelaaja1valinta
     * @param pelaaja2valinta
     */
    //Arpoo numeron 0, 1 tai 2 ja tekee valinnan sen mukaisesti
    public void pelaajienValinnat() {
    	int c = (int) (Math.random() * 3);
        pelaaja1valinta = p1.pelaajanValinta(c);
        System.out.println("Pelaaja 1: " + pelaaja1valinta);

        pelaaja2valinta = p2.pelaajanValinta(c);
        System.out.println("Pelaaja 2: " + pelaaja2valinta);
    }
    
    
    
    
    /**
     * Valitsee voittajan pelaajien valintojen mukaisesti
     * 
     * @param pelaaja1valinta
     * @param pelaaja2valinta
     * @param tasapelit
     */
    public void tarkistaValinnat(String pelaaja1valinta, String pelaaja2valinta) {
        if ((pelaaja1valinta.equals("kivi") && pelaaja2valinta.equals("paperi")) ||
                (pelaaja1valinta.equals("paperi") && pelaaja2valinta.equals("sakset")) ||
                (pelaaja1valinta.equals("sakset") && pelaaja2valinta.equals("kivi"))) {

            p2.kasvataVoitot();
            System.out.println("Pelaaja 2 voittaa erän");

        } else if ((pelaaja1valinta.equals("kivi") && pelaaja2valinta.equals("sakset")) ||
                (pelaaja1valinta.equals("paperi") && pelaaja2valinta.equals("kivi")) ||
                (pelaaja1valinta.equals("sakset") && pelaaja2valinta.equals("paperi"))) {

            p1.kasvataVoitot();
            System.out.println("Pelaaja 1 voittaa erän");

            //jos valinnat ovat samat kasvatetaan tasapelien määrää
        } else {
            tasapelit++;
            System.out.println("\n\t\t\t TASAPELI \n");
        }
    }
    
    /**
     * Tarkastaa päättyikö peli
     * 
     * @param peliLoppui
     */
    
    public void pelinPaattymisenTarkistus() {
        if (p1.getVoitot() >= 3 || p2.getVoitot() >= 3) {
            peliLoppui = true;
            System.out.println("KOLME VOITTOA PELI LOPPUI");
        }
    }
    
    
    
    
    /**
     * Testaamista varten hakee pelaajien voitot
     * @return pelaajien voitot
     */
    //saadaan kyseisen pelaaja olion voitot palautettua jUnit testeille
    public int getPelaajaVoitot(int player) {
    	if(player == 1) {
    		return p1.getVoitot(); 
    	}
    	else if (player == 2) {
    		return p2.getVoitot();
    	}
    	else {
    		return 0;	
    	}
    
    	
    }
    
    
    
    /**
     * Testaamista varten hakee tasapelit
     * @return pelaajien tasapelit
     */
    
    //Junit testausta varten palautetaan tasapelit
    public int getTasapelit() {
    	return tasapelit;
    }
    
    
    /**
     * Testaamista varten katsotaan loppuiko peli
     * @return peliloppumisen tila
     */
    
    //Pelin päättymisen testaamista varten tehty getteri
    public boolean getPeliPaattyi() {
    	return peliLoppui;
    }
    
    
    /**
     * Testaamista varten voidaan asettaan voittojen määrä
     */
    //Käytetään tasapelien testaamisessa
    public void setVoitot() {
    	p1.kasvataVoitot();
    }
    
    
    
}
