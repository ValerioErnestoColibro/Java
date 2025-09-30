// File: src/game/HangmanGUI.java
package game;

import java.util.Scanner;

/**
 * Classe che gestisce l'interfaccia utente del gioco dell'impiccato.
 */
public class HangmanGUI {
    private HangmanLogic gameLogic;
    private Scanner scanner;

    /**
     * Costruttore della classe HangmanGUI.
     * 
     * @param gameLogic La logica di gioco
     */
    public HangmanGUI(HangmanLogic gameLogic) {
        this.gameLogic = gameLogic;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Avvia il gioco e gestisce l'interazione con l'utente.
     */
    public void startGame() {
        System.out.println("Benvenuto al Gioco dell'Impiccato!");

        // Chiedi all'utente se vuole inserire una parola o usare una parola casuale
        System.out.print("Vuoi inserire tu la parola da indovinare? (s/n): ");
        String risposta = scanner.nextLine().trim().toLowerCase();

        if (risposta.equals("s")) {
            System.out.print("Inserisci la parola da indovinare (non sarà visibile): ");
            String parola = scanner.nextLine().trim();

            // Pulisci la console (metodo approssimativo)
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }

            gameLogic.iniziaNuovaPartita(parola);
        } else {
            gameLogic.iniziaNuovaPartita();
        }

        // Mostra la lunghezza della parola
        System.out.println("Devi indovinare una parola di " + gameLogic.getParolaSegreta().length() + " lettere.");
        System.out.println("Hai " + gameLogic.getTentativiMassimi() + " tentativi.");

        // Ciclo principale del gioco
        while (!gameLogic.isGiocoFinito()) {
            // Mostra lo stato attuale del gioco
            mostraStatoGioco();

            // Chiedi all'utente di inserire una lettera
            System.out.print("Inserisci una lettera: ");
            char lettera = scanner.nextLine().trim().toLowerCase().charAt(0);

            // Processa il tentativo
            boolean risultato = gameLogic.tentaLettera(lettera);

            // Mostra il risultato del tentativo
            if (gameLogic.getLettereTentate().contains(lettera)) {
                if (risultato) {
                    System.out.println("Lettera trovata!");
                } else {
                    System.out.println("Lettera non presente nella parola!");
                }
            } else {
                System.out.println("Hai già provato questa lettera!");
            }
        }

        // Mostra il risultato finale
        mostraRisultatoFinale();

        // Chiudi lo scanner
        scanner.close();
    }

    /**
     * Mostra lo stato attuale del gioco.
     */
    private void mostraStatoGioco() {
        // Mostra la parola nascosta
        System.out.println("\nParola: " + String.valueOf(gameLogic.getParolaNascosta()));

        // Mostra il numero di errori
        System.out.println("Errori: " + gameLogic.getErrori() + "/" + gameLogic.getTentativiMassimi());

        // Mostra le lettere già tentate
        System.out.print("Lettere già tentate: ");
        for (char c : gameLogic.getLettereTentate()) {
            System.out.print(c + " ");
        }
        System.out.println();

        // Mostra il disegno dell'impiccato
        disegnaImpiccato(gameLogic.getErrori());
    }

    /**
     * Mostra il risultato finale del gioco.
     */
    private void mostraRisultatoFinale() {
        // Mostra la parola nascosta
        System.out.println("\nParola: " + String.valueOf(gameLogic.getParolaNascosta()));

        // Mostra il disegno dell'impiccato
        disegnaImpiccato(gameLogic.getErrori());

        // Mostra il messaggio di vittoria o sconfitta
        if (gameLogic.isVittoria()) {
            System.out.println("Congratulazioni! Hai indovinato la parola: " + gameLogic.getParolaSegreta());
        } else {
            System.out.println("Hai perso! La parola era: " + gameLogic.getParolaSegreta());
        }
    }

    /**
     * Disegna l'impiccato in base al numero di errori.
     * 
     * @param errori Il numero di errori commessi
     */
    private void disegnaImpiccato(int errori) {
        System.out.println("  +---+");
        System.out.println("  |   |");
        System.out.println("  " + (errori >= 1 ? "O" : " ") + "   |");
        System.out.println(
                " " + (errori >= 3 ? "/" : " ") + (errori >= 2 ? "|" : " ") + (errori >= 4 ? "\\" : " ") + "  |");
        System.out.println(" " + (errori >= 5 ? "/" : " ") + " " + (errori >= 6 ? "\\" : " ") + "  |");
        System.out.println("      |");
        System.out.println("=========");
    }
}