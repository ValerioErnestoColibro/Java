import java.util.Scanner; // Importa la classe Scanner per l'input da tastiera

public class GestioneVendite { // Dichiara la classe principale del programma
    public static void main(String[] args) { // Metodo principale di esecuzione del programma
        double[][] vendite = new double[5][4]; // Crea una matrice 5x4 per memorizzare le vendite dei prodotti
        Scanner scanner = new Scanner(System.in); // Crea un oggetto Scanner per leggere l'input dell'utente

        // Chiama il metodo per inserire i dati di vendita
        inserimentoDati(vendite, scanner);

        // Calcola i totali per ogni prodotto e settimana
        double[] totaliProdotti = calcolaTotaliProdotti(vendite);
        double[] totaliSettimane = calcolaTotaliSettimane(vendite);

        // Trova il prodotto e la settimana con le vendite più alte
        int prodottoTop = prodottoTopVendite(vendite);
        int settimanaTop = settimanaTopVendite(vendite);

        // Stampa la tabella ordinata dei prodotti per ricavi
        stampaTabellaOrdinata(vendite, totaliProdotti);

        // Stampa le statistiche aggiuntive sulla settimana e prodotto migliori
        System.out.println("\nSettimana migliore: " + (settimanaTop + 1) +
                " (totale: " + totaliSettimane[settimanaTop] + ")");
        System.out.println("Prodotto migliore: P" + (prodottoTop + 1) +
                " (totale: " + totaliProdotti[prodottoTop] + ")");
    }

    // Metodo per inserire manualmente i dati di vendita
    public static void inserimentoDati(double[][] m, Scanner scanner) {
        // Scorre ogni riga (prodotto)
        for (int i = 0; i < m.length; i++) {
            System.out.println("Inserisci vendite per Prodotto " + (i + 1) + ":");
            // Scorre ogni colonna (settimana)
            for (int j = 0; j < m[i].length; j++) {
                System.out.print("Settimana " + (j + 1) + ": ");
                // Legge il valore di vendita per ogni settimana
                m[i][j] = scanner.nextDouble();
            }
        }
    }

    // Calcola i totali delle vendite per ogni prodotto
    public static double[] calcolaTotaliProdotti(double[][] m) {
        // Crea un array per memorizzare i totali
        double[] totali = new double[m.length];
        // Calcola la somma per ogni riga (prodotto)
        for (int i = 0; i < m.length; i++) {
            totali[i] = sommaVenditeProdotto(m, i);
        }
        return totali;
    }

    // Calcola la somma delle vendite per un singolo prodotto
    public static double sommaVenditeProdotto(double[][] m, int riga) {
        double somma = 0;
        // Somma tutti i valori della riga (vendite del prodotto in ogni settimana)
        for (int j = 0; j < m[riga].length; j++) {
            somma += m[riga][j];
        }
        return somma;
    }

    // Calcola i totali delle vendite per ogni settimana
    public static double[] calcolaTotaliSettimane(double[][] m) {
        // Crea un array per memorizzare i totali
        double[] totali = new double[m[0].length];
        // Calcola la somma per ogni colonna (settimana)
        for (int j = 0; j < m[0].length; j++) {
            totali[j] = sommaVenditeSettimana(m, j);
        }
        return totali;
    }

    // Calcola la somma delle vendite per una singola settimana
    public static double sommaVenditeSettimana(double[][] m, int colonna) {
        double somma = 0;
        // Somma tutti i valori della colonna (vendite di tutti i prodotti in una
        // settimana)
        for (int i = 0; i < m.length; i++) {
            somma += m[i][colonna];
        }
        return somma;
    }

    // Trova il prodotto con le vendite più alte
    public static int prodottoTopVendite(double[][] m) {
        // Calcola i totali dei prodotti
        double[] totali = calcolaTotaliProdotti(m);
        // Inizializza l'indice del prodotto con vendite più alte
        int indiceMassimo = 0;
        // Confronta i totali per trovare il prodotto con vendite massime
        for (int i = 1; i < totali.length; i++) {
            if (totali[i] > totali[indiceMassimo]) {
                indiceMassimo = i;
            }
        }
        return indiceMassimo;
    }

    // Trova la settimana con le vendite più alte
    public static int settimanaTopVendite(double[][] m) {
        // Calcola i totali delle settimane
        double[] totali = calcolaTotaliSettimane(m);
        // Inizializza l'indice della settimana con vendite più alte
        int indiceMassimo = 0;
        // Confronta i totali per trovare la settimana con vendite massime
        for (int i = 1; i < totali.length; i++) {
            if (totali[i] > totali[indiceMassimo]) {
                indiceMassimo = i;
            }
        }
        return indiceMassimo;
    }

    // Stampa la tabella delle vendite ordinata per ricavi decrescenti
    public static void stampaTabellaOrdinata(double[][] m, double[] totaliProdotti) {
        // Crea un array di indici per gestire l'ordinamento
        int[] indiciOrdinati = new int[m.length];
        for (int i = 0; i < indiciOrdinati.length; i++) {
            indiciOrdinati[i] = i;
        }

        // Ordinamento a bolle per totali decrescenti
        for (int i = 0; i < indiciOrdinati.length - 1; i++) {
            for (int j = 0; j < indiciOrdinati.length - i - 1; j++) {
                // Scambia gli indici se il totale del prodotto successivo è maggiore
                if (totaliProdotti[indiciOrdinati[j]] < totaliProdotti[indiciOrdinati[j + 1]]) {
                    int temp = indiciOrdinati[j];
                    indiciOrdinati[j] = indiciOrdinati[j + 1];
                    indiciOrdinati[j + 1] = temp;
                }
            }
        }

        // Stampa intestazione della tabella
        System.out.println("\nVendite mensili:");
        System.out.println("------------------------------------");
        System.out.printf("Prodotto Set1  Set2  Set3  Set4  Totale%n");

        // Stampa dati ordinati per ricavi decrescenti
        for (int indice : indiciOrdinati) {
            System.out.printf("P%d     ", indice + 1);
            double totale = 0;
            // Stampa le vendite di ogni settimana
            for (int j = 0; j < m[indice].length; j++) {
                System.out.printf("%5.0f ", m[indice][j]);
                totale += m[indice][j];
            }
            // Stampa il totale del prodotto
            System.out.printf("%6.0f%n", totale);
        }
    }
}