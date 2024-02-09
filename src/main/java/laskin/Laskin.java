package laskin;

public class Laskin {

    private double tulos;  	// Muuttuja tulokselle

    public void nollaa() {  // Nollaa tulosmuuttuja
        tulos = 0;
    }

    public double annaTulos() {
        return tulos;
    }

    public void lisaa(int n) {
        tulos = tulos + n;
    }

    public void vahenna(int n) {
        tulos = tulos - n;
    }

    public void kerro(int n) {
        // Ei vielä toteutettu
        tulos *= n;
    }

    public void jaa(double n) {
    	if (n==0) throw new ArithmeticException("Nollalla ei voi jakaa");
        tulos /= n;
    }

    public void nelio(double n) {
        tulos = Math.pow(n, 2);
    }

    public void neliojuuri(double n) {
        if (n<0) throw new ArithmeticException("Negatiivisille numeroille ei ole neliöjuurta");
        tulos = Math.sqrt(n);
    }

    public void virtaON() {
        // Tähän voisi laittaa alkutoimet
        tulos = 0;
    }

    public void virtaOFF() {
        // Tähän voisi laittaa lopputoimet
    }

}
