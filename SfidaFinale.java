import java.util.Scanner; // Importazione della classe Scanner per l'input dell'utente

public class SfidaFinale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creazione di un oggetto Scanner

        // 1. Richiedere all'utente di inserire due numeri interi
        System.out.print("Inserisci il primo numero intero: ");
        int numero1 = scanner.nextInt(); // Lettura del primo numero

        System.out.print("Inserisci il secondo numero intero: ");
        int numero2 = scanner.nextInt(); // Lettura del secondo numero

        // 2. Applicare tutte le operazioni aritmetiche
        int somma = numero1 + numero2;
        int differenza = numero1 - numero2;
        int prodotto = numero1 * numero2;
        int quoziente = numero1 / numero2; // Divisione intera
        int resto = numero1 % numero2; // Modulo

        // 3. Applicare tutte le operazioni relazionali
        boolean uguale = numero1 == numero2;
        boolean diverso = numero1 != numero2;
        boolean maggiore = numero1 > numero2;
        boolean minore = numero1 < numero2;
        boolean maggioreUguale = numero1 >= numero2;
        boolean minoreUguale = numero1 <= numero2;

        // 4. Applicare operatori logici
        boolean andLogico = (numero1 > 0) && (numero2 > 0); // Entrambi positivi
        boolean orLogico = (numero1 > 0) || (numero2 > 0); // Almeno uno positivo
        boolean notLogico = !(numero1 > 0); // Negazione della condizione

        // 5. Stampare i risultati in un formato leggibile
        System.out.println("\n--- RISULTATI OPERAZIONI ---");
        System.out.println("Somma: " + somma);
        System.out.println("Differenza: " + differenza);
        System.out.println("Prodotto: " + prodotto);
        System.out.println("Quoziente: " + quoziente);
        System.out.println("Resto: " + resto);

        System.out.println("\n--- OPERAZIONI RELAZIONALI ---");
        System.out.println("Uguale: " + uguale);
        System.out.println("Diverso: " + diverso);
        System.out.println("Maggiore: " + maggiore);
        System.out.println("Minore: " + minore);
        System.out.println("Maggiore o Uguale: " + maggioreUguale);
        System.out.println("Minore o Uguale: " + minoreUguale);

        System.out.println("\n--- OPERAZIONI LOGICHE ---");
        System.out.println("AND Logico (entrambi > 0): " + andLogico);
        System.out.println("OR Logico (almeno uno > 0): " + orLogico);
        System.out.println("NOT Logico (primo <= 0): " + notLogico);

        // 6. Conversioni di tipo
        double numero1Double = (double) numero1; // Conversione del primo numero in double
        byte numero2Byte = (byte) numero2; // Conversione del secondo numero in byte

        // 7. Stampare i valori dopo la conversione
        System.out.println("\n--- CONVERSIONI ---");
        System.out.println("Primo numero come double: " + numero1Double);
        System.out.println("Secondo numero come byte: " + numero2Byte);

        scanner.close(); // Chiudere lo scanner per evitare problemi di risorse
    }
}
