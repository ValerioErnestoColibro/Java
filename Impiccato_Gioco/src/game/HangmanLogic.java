package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe che gestisce la logica del gioco dell'impiccato.
 */
public class HangmanLogic {
    // Attributi per memorizzare lo stato del gioco
    private String parolaSegreta;
    private char[] parolaNascosta;
    private List<Character> lettereTentate;
    private int errori;
    private int tentativiMassimi;
    private boolean giocoFinito;
    private boolean vittoria;
    private List<String> wordsList;

    /**
     * Costruttore della classe HangmanLogic.
     */
    public HangmanLogic() {
        // Inizializza il numero massimo di tentativi
        this.tentativiMassimi = 6;
        this.lettereTentate = new ArrayList<>();
        this.errori = 0;
        this.giocoFinito = false;
        this.vittoria = false;

        // Carica le parole dal file
        this.wordsList = new ArrayList<>();
        caricaParoleDaFile();
    }

    /**
     * Carica le parole da un file di testo.
     */
    private void caricaParoleDaFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/words.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    wordsList.add(line.trim().toLowerCase());
                }
            }
        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file: " + e.getMessage());
            // Aggiunge alcune parole predefinite in caso di errore
            wordsList.add("programmazione");
            wordsList.add("computer");
            wordsList.add("algoritmo");
            wordsList.add("sviluppo");
            wordsList.add("software");
        }
    }

    /**
     * Inizializza una nuova partita scegliendo una parola casuale.
     */
    public void iniziaNuovaPartita() {
        // Seleziona una parola casuale
        Random random = new Random();
        parolaSegreta = wordsList.get(random.nextInt(wordsList.size()));

        // Inizializza le variabili di gioco
        parolaNascosta = new char[parolaSegreta.length()];
        for (int i = 0; i < parolaSegreta.length(); i++) {
            parolaNascosta[i] = '_';
        }

        lettereTentate.clear();
        errori = 0;
        giocoFinito = false;
        vittoria = false;
    }

    /**
     * Inizializza una nuova partita con una parola specifica.
     * 
     * @param parola La parola da indovinare
     */
    public void iniziaNuovaPartita(String parola) {
        this.parolaSegreta = parola.toLowerCase();

        // Inizializza le variabili di gioco
        parolaNascosta = new char[parolaSegreta.length()];
        for (int i = 0; i < parolaSegreta.length(); i++) {
            parolaNascosta[i] = '_';
        }

        lettereTentate.clear();
        errori = 0;
        giocoFinito = false;
        vittoria = false;
    }

    /**
     * Processa un tentativo con una lettera.
     * 
     * @param lettera La lettera tentata
     * @return true se la lettera è presente nella parola, false altrimenti
     */
    public boolean tentaLettera(char lettera) {
        // Converte la lettera in minuscolo
        lettera = Character.toLowerCase(lettera);

        // Controlla se il gioco è già finito
        if (giocoFinito) {
            return false;
        }

        // Controlla se la lettera è già stata tentata
        if (lettereTentate.contains(lettera)) {
            return false;
        }

        // Aggiunge la lettera alle lettere tentate
        lettereTentate.add(lettera);

        // Controlla se la lettera è nella parola
        boolean letteraTrovata = false;
        for (int i = 0; i < parolaSegreta.length(); i++) {
            if (parolaSegreta.charAt(i) == lettera) {
                parolaNascosta[i] = lettera;
                letteraTrovata = true;
            }
        }

        // Se la lettera non è presente, incrementa il contatore degli errori
        if (!letteraTrovata) {
            errori++;
        }

        // Controlla la condizione di vittoria
        controllaVittoria();

        // Controlla se il gioco è finito
        if (vittoria || errori >= tentativiMassimi) {
            giocoFinito = true;
        }

        return letteraTrovata;
    }

    /**
     * Controlla se tutte le lettere sono state indovinate.
     */
    private void controllaVittoria() {
        for (char c : parolaNascosta) {
            if (c == '_') {
                vittoria = false;
                return;
            }
        }
        vittoria = true;
    }

    // Metodi getter per accedere agli attributi dalla classe GUI

    public String getParolaSegreta() {
        return parolaSegreta;
    }

    public char[] getParolaNascosta() {
        return parolaNascosta;
    }

    public List<Character> getLettereTentate() {
        return lettereTentate;
    }

    public int getErrori() {
        return errori;
    }

    public int getTentativiMassimi() {
        return tentativiMassimi;
    }

    public boolean isGiocoFinito() {
        return giocoFinito;
    }

    public boolean isVittoria() {
        return vittoria;
    }
}