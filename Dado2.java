// 1 - Dichiara le variabili
// 2 - Chiedi all'utente quanti dadi vuole lanciare
// 3 - Lancia i dadi
// 4 - Somma i loro risultati
// 5 - Stampa i risultati con il codice ASCII
// 6 - Prima di avviare il programma su terminale, usa il codice "chcp 65001" per leggere i codici ASCII

import java.util.Random;
import java.util.Scanner;

public class Dado2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numOfDice;
        int total = 0;

        System.out.print("Dimmi quanti dadi vuoi giocare: ");

        // Controllo input per evitare crash con valori errati
        while (!scanner.hasNextInt()) {
            System.out.println("ERRORE! Riprova con un numero valido");
            scanner.next(); // scarta l'input errato
        }
        numOfDice = scanner.nextInt();

        if (numOfDice > 0) {
            for (int i = 0; i < numOfDice; i++) {
                int roll = random.nextInt(6) + 1; // Genera un numero tra 1 e 6
                printDie(roll);
                System.out.println("Il dado ha fatto " + roll);
                total += roll;
            }
            System.out.println("Somma dei dadi: " + total);
        } else {
            System.out.println("# of dice must be greater than 0");
        }

        scanner.close();
    }

    static void printDie(int roll) {
        String[] diceFaces = {
                """
                         -------
                        |       |
                        |   *   |
                        |       |
                         -------
                        """,
                """
                         -------
                        | *     |
                        |       |
                        |     * |
                         -------
                        """,
                """
                         -------
                        | *     |
                        |   *   |
                        |     * |
                         -------
                        """,
                """
                         -------
                        | *   * |
                        |       |
                        | *   * |
                         -------
                        """,
                """
                         -------
                        | *   * |
                        |   *   |
                        | *   * |
                         -------
                        """,
                """
                         -------
                        | *   * |
                        | *   * |
                        | *   * |
                         -------
                        """
        };

        if (roll >= 1 && roll <= 6) {
            System.out.println(diceFaces[roll - 1]); // Usare println per la visualizzazione corretta
        } else {
            System.out.println("ERRORE! Riprova con un numero da 1 in poi");
        }
    }
}
