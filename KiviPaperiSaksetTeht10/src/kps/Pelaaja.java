
package kps;

public class Pelaaja {
    int voitot;      // Voittojen lukumäärä


    
    /**
     * Arvotaan numero ja tehdään valinta
     * @param c
     * @return valinta arvotulla numerolla saatu valinta
     */
    public String pelaajanValinta(int c) {
        String valinta = "";
        switch (c) {
            case 0:
                valinta = "kivi";
                break;

            case 1:
                valinta = "paperi";
                break;

            case 2:
                valinta = "sakset";
                break;
        }
        return valinta;
    }

    
    /**
     * Kasvatetaan voittoja
     * @return voitot palautetaan voitot ja kasvatetaan arvoa yhdellä
     */
    public int kasvataVoitot() {

        return voitot++;
    }
    
    /**
     * Haetaan pelaajan voitot
     * @return voitot 
     */
    public int getVoitot() {
        return voitot;
    }
}
