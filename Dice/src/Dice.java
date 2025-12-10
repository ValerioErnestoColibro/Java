import java.util.Random; // Importa la classe Random

public class Dice { // Dichiarazione della classe
    public static void main(String[] args) { // Dichiarazione del metodo main
        Random random = new Random(); // Crea un oggetto Random
        int risultato = random.nextInt(6) + 1; // Genera un numero da 1 a 6
        System.out.println("Hai lanciato un dado! Risultato: " + risultato); // Stampa il risultato con spazio dopo i
                                                                             // due punti
    }
}
