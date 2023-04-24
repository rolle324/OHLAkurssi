package kps;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class kiviPaperiSaksetTest {

	private Peli testPeli = new Peli();
	private Pelaaja testPelaaja = new Pelaaja();

	 @ParameterizedTest(name="Testataan pelaajien eri valinnat")
	 @CsvSource({ "0, kivi","1, paperi", "2, sakset"})
	 public void pelaajienValinnatTest(int valinta, String merkkijono) {

	 assertEquals(merkkijono, testPelaaja.pelaajanValinta(valinta));
	 }
	 
	 @ParameterizedTest(name="Pelaajan voittamisen testaaminen")
	 @CsvSource({ "kivi, sakset"})
	 public void valintojenToimivuusTest(String pelaaja1valinta, String pelaaja2valinta) {
		 testPeli.tarkistaValinnat(pelaaja1valinta, pelaaja2valinta);
		 
	 assertEquals(1, testPeli.getPelaajaVoitot(1));
	 }
	 
	 @ParameterizedTest(name="Tasapelien testaaminen")
	 @CsvSource({ "sakset, sakset"})
	 public void tasapeliTest(String pelaaja1valinta, String pelaaja2valinta) {
		 testPeli.tarkistaValinnat(pelaaja1valinta, pelaaja2valinta);
		 
	 assertEquals(1, testPeli.getTasapelit());
	 }
	 
	 
	 @ParameterizedTest(name="Pelin päättymisen testaaminen")
	 @CsvSource({ "sakset, paperi"})
	 public void pelinLoppuminenTest(String pelaaja1valinta, String pelaaja2valinta) {
		 for(int i = 0; i <= 2; i++) {
			 testPeli.setVoitot();
		 }
		 
		 testPeli.tarkistaValinnat(pelaaja1valinta, pelaaja2valinta);
		 testPeli.pelinPaattymisenTarkistus();
		 
	 assertEquals(true, testPeli.getPeliPaattyi());
	 }
	 
	 
	 
	 
	 
	 


}
