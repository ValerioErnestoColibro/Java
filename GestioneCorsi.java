import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GestioneCorsi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creazione di un array monodimensionale per i corsi
        String[] corsi = { "Matematica", "Informatica", "Fisica" };

        // Creazione di un array bidimensionale per i voti
        int[][] voti = {
                { 85, 90, 78 }, // Studenti di Matematica
                { 88, 76, 95 }, // Studenti di Informatica
                { 92, 89 } // Studenti di Fisica (solo 2 studenti)
        };

        // Creazione di un array irregolare (Jagged Array) per gli studenti
        String[][] studenti = {
                { "Alice", "Bob", "Charlie" }, // Matematica
                { "David", "Eve", "Frank" }, // Informatica
                { "Grace", "Henry" } // Fisica
        };

        // Uso di ArrayList per gestire corsi dinamici
        ArrayList<String> listaCorsi = new ArrayList<>(Arrays.asList(corsi));
        ArrayList<ArrayList<String>> listaStudenti = new ArrayList<>();

        for (String[] s : studenti) {
            listaStudenti.add(new ArrayList<>(Arrays.asList(s)));
        }

        boolean continua = true;

        while (continua) {
            // Menu di gestione corsi
            System.out.println("\n**Sistema di Gestione Corsi**");
            System.out.println("1. Visualizza corsi e studenti");
            System.out.println("2. Aggiungi un nuovo corso");
            System.out.println("3. Aggiungi uno studente a un corso");
            System.out.println("4. Modifica il voto di uno studente");
            System.out.println("5. Svuota un corso (rimuovi tutti gli studenti)");
            System.out.println("6. Elimina un corso");
            System.out.println("7. Esci");
            System.out.print("Seleziona un'opzione: ");

            int scelta = scanner.nextInt();
            scanner.nextLine(); // Pulisce il buffer

            switch (scelta) {
                case 1:
                    // Visualizza i corsi e gli studenti
                    System.out.println("\n📋 Lista Corsi e Studenti:");
                    for (int i = 0; i < listaCorsi.size(); i++) {
                        System.out.println("- " + listaCorsi.get(i) + ": " + listaStudenti.get(i));
                    }
                    break;

                case 2:
                    // Aggiungi un nuovo corso
                    System.out.print("Inserisci il nome del nuovo corso: ");
                    String nuovoCorso = scanner.nextLine();
                    listaCorsi.add(nuovoCorso);
                    listaStudenti.add(new ArrayList<>()); // Inizializza lista vuota
                    System.out.println("Corso aggiunto con successo!");
                    break;

                case 3:
                    // Aggiungi uno studente a un corso
                    System.out.print("Inserisci il nome del corso: ");
                    String corsoDaAggiornare = scanner.nextLine();
                    int indexCorso = listaCorsi.indexOf(corsoDaAggiornare);

                    if (indexCorso != -1) {
                        System.out.print("Inserisci il nome dello studente: ");
                        String nuovoStudente = scanner.nextLine();
                        listaStudenti.get(indexCorso).add(nuovoStudente);
                        System.out.println("Studente aggiunto con successo!");
                    } else {
                        System.out.println("Corso non trovato.");
                    }
                    break;

                case 4:
                    // Modifica il voto di uno studente
                    System.out.print("Inserisci il nome del corso: ");
                    String corsoModifica = scanner.nextLine();
                    int corsoIndex = listaCorsi.indexOf(corsoModifica);

                    if (corsoIndex != -1) {
                        System.out.print("Inserisci il nome dello studente: ");
                        String studenteModifica = scanner.nextLine();
                        int studenteIndex = listaStudenti.get(corsoIndex).indexOf(studenteModifica);

                        if (studenteIndex != -1) {
                            System.out.print("Inserisci il nuovo voto: ");
                            int nuovoVoto = scanner.nextInt();
                            voti[corsoIndex][studenteIndex] = nuovoVoto;
                            System.out.println("Voto aggiornato con successo!");
                        } else {
                            System.out.println("Studente non trovato.");
                        }
                    } else {
                        System.out.println("Corso non trovato.");
                    }
                    break;

                case 5:
                    // Svuota un corso (rimuove tutti gli studenti)
                    System.out.print("Inserisci il nome del corso da svuotare: ");
                    String corsoDaSvuotare = scanner.nextLine();
                    int corsoSvuotaIndex = listaCorsi.indexOf(corsoDaSvuotare);

                    if (corsoSvuotaIndex != -1) {
                        listaStudenti.get(corsoSvuotaIndex).clear();
                        System.out.println("Tutti gli studenti sono stati rimossi dal corso.");
                    } else {
                        System.out.println("Corso non trovato.");
                    }
                    break;

                case 6:
                    // Elimina un corso
                    System.out.print("Inserisci il nome del corso da eliminare: ");
                    String corsoDaEliminare = scanner.nextLine();
                    int corsoEliminaIndex = listaCorsi.indexOf(corsoDaEliminare);

                    if (corsoEliminaIndex != -1) {
                        listaCorsi.remove(corsoEliminaIndex);
                        listaStudenti.remove(corsoEliminaIndex);
                        System.out.println("Corso eliminato con successo!");
                    } else {
                        System.out.println("Corso non trovato.");
                    }
                    break;

                case 7:
                    // Esci dal programma
                    continua = false;
                    System.out.println("Arrivederci!");
                    break;

                default:
                    System.out.println("Opzione non valida, riprova.");
            }
        }

        scanner.close(); // Chiude lo scanner per evitare memory leak
    }
}
