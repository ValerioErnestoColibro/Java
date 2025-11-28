import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// Classe per rappresentare un personaggio con nome, iniziativa e classe armatura
class Personaggio {
    String nome; // Nome del personaggio
    int iniziativa; // Valore dell'iniziativa
    int classeArmatura; // Classe armatura del personaggio

    // Costruttore della classe Personaggio
    public Personaggio(String nome, int iniziativa, int classeArmatura) {
        this.nome = nome; // Inizializza il nome
        this.iniziativa = iniziativa; // Inizializza l'iniziativa
        this.classeArmatura = classeArmatura; // Inizializza la classe armatura
    }
}

public class TrackerIniziativaDnd {
    static Scanner scanner = new Scanner(System.in); // Scanner per leggere l'input utente
    static ArrayList<Personaggio> iniziativaList = new ArrayList<>(); // Lista per memorizzare i personaggi

    public static void main(String[] args) {
        while (true) { // Loop per il menu principale
            System.out.println("\n--- TRACKER INIZIATIVA D&D ---");
            System.out.println("1. Aggiungi personaggio");
            System.out.println("2. Mostra ordine di iniziativa");
            System.out.println("3. Elimina personaggio");
            System.out.println("4. Esci");
            System.out.print("Seleziona un'opzione: ");
            String scelta = scanner.nextLine(); // Legge l'input dell'utente

            switch (scelta) {
                case "1":
                    aggiungiPersonaggio(); // Chiama il metodo per aggiungere un personaggio
                    break;
                case "2":
                    mostraIniziativa(); // Chiama il metodo per mostrare l'iniziativa
                    break;
                case "3":
                    eliminaPersonaggio(); // Chiama il metodo per eliminare un personaggio
                    break;
                case "4":
                    System.out.println("Chiusura del tracker. Buon gioco!");
                    return; // Termina il programma
                default:
                    System.out.println("Opzione non valida. Riprova."); // Gestisce input errati
            }
        }
    }

    // Metodo per aggiungere un personaggio alla lista
    public static void aggiungiPersonaggio() {
        System.out.print("Inserisci il nome del personaggio: ");
        String nome = scanner.nextLine(); // Legge il nome del personaggio

        int iniziativa = leggiIntero("Inserisci il valore di iniziativa: "); // Chiede il valore di iniziativa
        int classeArmatura = leggiIntero("Inserisci la classe armatura: "); // Chiede la classe armatura

        // Crea un nuovo personaggio e lo aggiunge alla lista
        iniziativaList.add(new Personaggio(nome, iniziativa, classeArmatura));
        System.out.println("Personaggio aggiunto con successo!");
    }

    // Metodo per mostrare l'ordine di iniziativa
    public static void mostraIniziativa() {
        if (iniziativaList.isEmpty()) { // Controlla se la lista è vuota
            System.out.println("Nessun personaggio nell'iniziativa.");
            return;
        }

        // Ordina la lista in ordine decrescente di iniziativa
        Collections.sort(iniziativaList, Comparator.comparingInt((Personaggio p) -> p.iniziativa).reversed());

        System.out.println("\n--- Ordine di Iniziativa ---");
        for (int i = 0; i < iniziativaList.size(); i++) {
            Personaggio p = iniziativaList.get(i); // Ottiene il personaggio corrente
            System.out.println((i + 1) + ". " + p.nome + " - Iniziativa: " + p.iniziativa + " - Classe Armatura: "
                    + p.classeArmatura);
        }
        System.out.println("----------------------------");
    }

    // Metodo per eliminare un personaggio dalla lista
    public static void eliminaPersonaggio() {
        if (iniziativaList.isEmpty()) { // Controlla se ci sono personaggi nella lista
            System.out.println("Nessun personaggio da eliminare.");
            return;
        }

        System.out.print("Inserisci il nome del personaggio da eliminare: ");
        String nome = scanner.nextLine(); // Legge il nome del personaggio da eliminare

        // Rimuove il personaggio se esiste nella lista
        boolean rimosso = iniziativaList.removeIf(p -> p.nome.equalsIgnoreCase(nome));

        if (rimosso) {
            System.out.println("Personaggio " + nome + " eliminato con successo.");
        } else {
            System.out.println("Personaggio non trovato.");
        }
    }

    // Metodo per leggere un numero intero con controllo degli errori
    public static int leggiIntero(String messaggio) {
        while (true) {
            try {
                System.out.print(messaggio);
                return Integer.parseInt(scanner.nextLine()); // Legge e converte l'input in intero
            } catch (NumberFormatException e) {
                System.out.println("Errore: inserisci un numero intero valido."); // Gestisce input non validi
            }
        }
    }
}
