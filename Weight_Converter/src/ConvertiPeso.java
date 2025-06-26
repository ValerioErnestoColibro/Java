import java.util.Scanner; // Importa la classe Scanner per leggere l'input dell'utente

public class ConvertiPeso { // Definizione della classe principale
    public static void main(String[] args) { // Metodo principale dell'applicazione

        Scanner scanner = new Scanner(System.in); // Crea un oggetto Scanner per leggere l'input

        double weight; // Dichiarazione della variabile per il peso originale
        double newWeight; // Dichiarazione della variabile per il peso convertito
        int choice; // Dichiarazione della variabile per la scelta dell'utente

        System.out.println("Conversione del peso"); // Stampa il titolo del programma
        System.out.println("1. Converti lbs in kg"); // Stampa la prima opzione
        System.out.println("2. Converti i kg in lbs"); // Stampa la seconda opzione

        System.out.print("Scegli un'opzione: "); // Chiede all'utente di scegliere un'opzione
        choice = scanner.nextInt(); // Legge la scelta dell'utente

        if (choice == 1) { // Se l'utente sceglie l'opzione 1
            System.out.print("Dimmi il peso in lbs: "); // Chiede il peso in libbre
            weight = scanner.nextDouble(); // Legge il peso in libbre dall'utente
            newWeight = weight * 0.453592; // Converte il peso da libbre a chilogrammi
            System.out.printf("Il nuovo peso in kg è di %.2f", newWeight); // Stampa il risultato con due decimali
        } else if (choice == 2) { // Se l'utente sceglie l'opzione 2
            System.out.print("Dimmi il peso in kg: "); // Chiede il peso in chilogrammi
            weight = scanner.nextDouble(); // Legge il peso in chilogrammi dall'utente
            newWeight = weight * 2.20462; // Converte il peso da chilogrammi a libbre
            System.out.printf("Il nuovo peso in lbs è di %.2f", newWeight); // Stampa il risultato con due decimali
        } else { // Se l'utente inserisce un'opzione non valida
            System.out.printf("Scelta non valida!"); // Stampa un messaggio di errore
        }
        scanner.close(); // Chiude lo scanner per liberare le risorse
    }
}