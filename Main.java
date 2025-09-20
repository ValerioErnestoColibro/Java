public class Auto {
    String marca;
    String modello;
    int anno;

    // Costruttore per inizializzare gli attributi
    public Auto(String marca, String modello, int anno) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
    }

    public void mostraDettagli() {
        System.out.println("Auto: " + marca + " " + modello + ", Anno: " + anno);
    }
}

public class Main {
    public static void main(String[] args) {
        // Creazione oggetto con costruttore
        Auto miaAuto = new Auto("Fiat", "Panda", 2020);
        miaAuto.mostraDettagli();
    }
}
