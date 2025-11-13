import java.util.Scanner; // Importa la classe Scanner per leggere l'input dell'utente

public class FCTemperatureConverter { // Definizione della classe principale per il convertitore di temperatura
    public static void main(String[] args) { // Metodo main, punto di ingresso del programma
        Scanner scanner = new Scanner(System.in); // Crea un nuovo oggetto Scanner per leggere l'input dall'utente

        double temp; // Dichiarazione della variabile per memorizzare la temperatura inserita
        double newTemp; // Dichiarazione della variabile per memorizzare la temperatura convertita
        String unit; // Dichiarazione della variabile per memorizzare l'unità di misura scelta

        System.out.print("Che temperatura vuoi inserire? "); // Chiede all'utente di inserire una temperatura
        temp = scanner.nextDouble(); // Legge il valore della temperatura inserito dall'utente

        System.out.print("Converti in Celsius o Fahrenheit? (C o F): "); // Chiede all'utente di scegliere l'unità di
                                                                         // misura
        unit = scanner.next().toUpperCase(); // Legge l'unità di misura scelta e la converte in maiuscolo

        // CORREZIONE: Le due righe seguenti sono state rimosse perché sono solo per
        // debug
        // System.out.println(temp);
        // System.out.println(unit);

        // Da Fahrenheit a Celsius: (temp - 32) * 5 / 9
        // Da Celsius a Fahrenheit: (temp * 9 / 5) + 32
        newTemp = (unit.equals("C")) ? (temp - 32) * 5 / 9 : (temp * 9 / 5) + 32; // Calcola la temperatura convertita
                                                                                  // in base all'unità scelta

        // CORREZIONE: Aggiungiamo il nome completo dell'unità di misura
        String unitName = (unit.equals("C")) ? "Celsius" : "Fahrenheit"; // Determina il nome completo dell'unità di
                                                                         // misura

        System.out.printf("%.1f gradi %s", newTemp, unitName); // Mostra il risultato della conversione con un decimale

        scanner.close(); // Chiude lo scanner per liberare le risorse
    }
}