import java.util.*;

// Classe per gestire i personaggi di D&D
class Personaggio {
    String nome; // Nome del personaggio
    int puntiVita; // Punti ferita del personaggio
    int classeArmatura; // Classe armatura del personaggio
    List<String> status; // Lista degli status attivi

    // Costruttore della classe
    public Personaggio(String nome, int puntiVita, int classeArmatura) {
        this.nome = nome;
        this.puntiVita = puntiVita;
        this.classeArmatura = classeArmatura;
        this.status = new ArrayList<>(); // Inizializza la lista degli status
    }

    // Metodo per modificare i punti vita
    public void setPuntiVita(int nuoviPuntiVita) {
        this.puntiVita = Math.max(0, nuoviPuntiVita); // Evita valori negativi
    }

    // Metodo per modificare la CA
    public void setClasseArmatura(int nuovaClasseArmatura) {
        this.classeArmatura = Math.max(0, nuovaClasseArmatura);
    }

    // Metodo per aggiungere uno status
    public void aggiungiStatus(String nuovoStatus) {
        if (!status.contains(nuovoStatus)) {
            status.add(nuovoStatus);
        }
    }

    // Metodo per rimuovere uno status
    public void rimuoviStatus(String statusRimosso) {
        status.remove(statusRimosso);
    }

    // Metodo per visualizzare le informazioni del personaggio
    public void mostraInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Punti Ferita: " + puntiVita);
        System.out.println("CA: " + classeArmatura);
        System.out.println("Status: " + (status.isEmpty() ? "Nessuno" : String.join(",", status)));
        System.out.println("-----------------------");
    }
}

public class dnd_characters_management {
    static Scanner scanner = new Scanner(System.in); // Scanner per input utente
    static Map<String, Personaggio> personaggi = new HashMap<>(); // Mappa per memorizzare i personaggi

    public static void main(String[] args) {
        while (true) {
            // Mostra il menù di opzioni
            System.out.println("\n--- GESTORE PERSONAGGI D&D ---");
            System.out.println("1. Aggiungi personaggio");
            System.out.println("2. Modifica personaggio");
            System.out.println("3. Elimina personaggio");
            System.out.println("4. Mostra tutti i personaggi");
            System.out.println("5. Esci");
            System.out.println("Seleziona un'opzione: ");

            String scelta = scanner.nextLine();
            switch (scelta) {
                case "1":
                    aggiungiPersonaggio();
                    break;
                case "2":
                    modificaPersonaggio();
                    break;
                case "3":
                    eliminaPersonaggio();
                    break;
                case "4":
                    mostraPersonaggi();
                    break;
                case "5":
                    System.out.println("Programma chiuso. A presto!");
                    return;
                default:
                    System.out.println("Opzione non valida. Riprova");

            }
        }
    }

    // Metodo per aggiungere un personaggio
    public static void aggiungiPersonaggio() {
        System.out.print("Inserisci il nome del personaggio: ");
        String nome = scanner.nextLine();
        if (personaggi.containsKey(nome)) {
            System.out.println("Questo personaggio esiste già!");
            return;
        }

        System.out.print("Inserisci i punti ferita: ");
        int puntiVita = Integer.parseInt(scanner.nextLine());
        System.out.print("Inserisci la CA: ");
        int classeArmatura = Integer.parseInt(scanner.nextLine());

        personaggi.put(nome, new Personaggio(nome, puntiVita, classeArmatura));
        System.out.println("Personaggio aggiunto con successo!");
    }

    // Metodo per modificare un personaggio
    public static void modificaPersonaggio() {
        System.out.print("Inserisci il nome del personaggio da modificare: ");
        String nome = scanner.nextLine();
        if (!personaggi.containsKey(nome)) {
            System.out.println("Questo personaggio non esiste!");
            return;
        }

        Personaggio p = personaggi.get(nome);
        System.out.println("1. Modifica punti ferita");
        System.out.println("2. Modifica la CA");
        System.out.println("3. Aggiung status");
        System.out.println("4. Rimuovi status");
        System.out.print("Seleziona un'opzione: ");

        String scelta = scanner.nextLine();
        switch (scelta) {
            case "1":
                System.out.print("Inserisci i nuovi punti ferita: ");
                p.setPuntiVita(Integer.parseInt(scanner.nextLine()));
                break;
            case "2":
                System.out.print("Inserisci la nuova CA: ");
                p.setClasseArmatura(Integer.parseInt(scanner.nextLine()));
                break;
            case "3":
                System.out.print("Inserisci lo status da aggiungere: ");
                p.aggiungiStatus(scanner.nextLine());
                break;
            case "4":
                System.out.print("Inserisci lo status da rimuovere: ");
                p.rimuoviStatus(scanner.nextLine());
                break;
            default:
                System.out.println("Opzione non valida");
        }
    }

    // Metodo per eliminare un personaggio
    public static void eliminaPersonaggio() {
        System.out.print("Inserisci il nome del personaggio da eliminare: ");
        String nome = scanner.nextLine();
        if (personaggi.remove(nome) != null) {
            System.out.println("Personaggio eliminato con successo!");
        } else {
            System.out.println("Questo personaggio non esiste!");
        }
    }

    // Metodo per mostrare tutti i personaggi
    public static void mostraPersonaggi() {
        if (personaggi.isEmpty()) {
            System.out.println("Nessun personaggio presente");
            return;
        }
        for (Personaggio p : personaggi.values()) {
            p.mostraInfo();
        }
    }
}