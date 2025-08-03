import java.util.Scanner; // Importa la classe Scanner per leggere l'input dell'utente

public class ShoppingCart { // Definizione della classe principale
    public static void main(String[] args) { // Metodo principale da cui inizia l'esecuzione
        Scanner scanner = new Scanner(System.in); // Crea un nuovo oggetto Scanner
        String item; // Dichiarazione della variabile per il nome dell'articolo
        double price; // Dichiarazione della variabile per il prezzo
        int quantity; // Dichiarazione della variabile per la quantità
        char currency = '€'; // Dichiarazione ed inizializzazione della variabile per il simbolo della valuta
        double total; // Dichiarazione della variabile per il totale

        System.out.print("Cosa vorresti comprare? "); // Chiede all'utente cosa vuole comprare
        item = scanner.nextLine(); // Legge il nome dell'articolo inserito dall'utente

        System.out.print("Qual è il prezzo del singolo elemento? "); // Chiede all'utente il prezzo del singolo elemento
        price = scanner.nextDouble(); // Legge il prezzo inserito dall'utente

        System.out.print("La quantità di questo prodotto? "); // Chiede all'utente la quantità da comprare
        quantity = scanner.nextInt(); // Legge la quantità inserita dall'utente

        total = price * quantity; // Calcola il prezzo totale moltiplicando il prezzo totale

        System.out.println("\nHai comprato " + quantity + " " + item); // Mostra la quantità totale
        System.out.println("Il prezzo totale è di " + currency + total); // Mostra il totale del prezzo da pagare

        scanner.close(); // Chiude lo Scanner per liberare le risorse
    }
}