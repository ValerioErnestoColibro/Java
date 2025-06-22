
// Importazione delle librerie necessarie per tutte le classi
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// Classe Camera: rappresenta una camera dell'hotel
class Camera {
    // Attributi della classe Camera
    private int numero; // Numero identificativo della camera
    private String tipo; // Tipo di camera (singola, doppia, suite)
    private double prezzoPerNotte; // Prezzo per notte della camera
    private boolean occupata; // Stato di occupazione della camera
    private Cliente cliente; // Cliente che occupa la camera (null se libera)

    // Costruttore della classe Camera
    public Camera(int numero, String tipo, double prezzoPerNotte) {
        this.numero = numero; // Inizializza il numero della camera
        this.tipo = tipo; // Inizializza il tipo della camera
        this.prezzoPerNotte = prezzoPerNotte; // Inizializza il prezzo per notte
        this.occupata = false; // Inizialmente la camera è libera
        this.cliente = null; // Inizialmente non c'è nessun cliente
    }

    // Getter per il numero della camera
    public int getNumero() {
        return numero;
    }

    // Setter per il numero della camera
    public void setNumero(int numero) {
        this.numero = numero;
    }

    // Getter per il tipo della camera
    public String getTipo() {
        return tipo;
    }

    // Setter per il tipo della camera
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Getter per il prezzo per notte
    public double getPrezzoPerNotte() {
        return prezzoPerNotte;
    }

    // Setter per il prezzo per notte
    public void setPrezzoPerNotte(double prezzoPerNotte) {
        this.prezzoPerNotte = prezzoPerNotte;
    }

    // Getter per lo stato di occupazione
    public boolean isOccupata() {
        return occupata;
    }

    // Setter per lo stato di occupazione
    public void setOccupata(boolean occupata) {
        this.occupata = occupata;
    }

    // Getter per il cliente
    public Cliente getCliente() {
        return cliente;
    }

    // Setter per il cliente
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Metodo toString per visualizzare le informazioni della camera
    @Override
    public String toString() {
        return "Camera{" +
                "numero=" + numero + // Mostra il numero della camera
                ", tipo='" + tipo + '\'' + // Mostra il tipo della camera
                ", prezzoPerNotte=" + prezzoPerNotte + // Mostra il prezzo per notte
                ", occupata=" + occupata + // Mostra lo stato di occupazione
                ", cliente=" + (cliente != null ? cliente.toString() : "nessuno") + // Mostra il cliente se presente
                '}';
    }
}

// Classe Cliente: rappresenta un cliente che prenota
class Cliente {
    // Attributi della classe Cliente
    private String nome; // Nome del cliente
    private String cognome; // Cognome del cliente
    private String codiceFiscale; // Codice fiscale del cliente

    // Costruttore della classe Cliente
    public Cliente(String nome, String cognome, String codiceFiscale) {
        this.nome = nome; // Inizializza il nome del cliente
        this.cognome = cognome; // Inizializza il cognome del cliente
        this.codiceFiscale = codiceFiscale; // Inizializza il codice fiscale
    }

    // Getter per il nome
    public String getNome() {
        return nome;
    }

    // Setter per il nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter per il cognome
    public String getCognome() {
        return cognome;
    }

    // Setter per il cognome
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    // Getter per il codice fiscale
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    // Setter per il codice fiscale
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    // Metodo toString per visualizzare le informazioni del cliente
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' + // Mostra il nome del cliente
                ", cognome='" + cognome + '\'' + // Mostra il cognome del cliente
                ", codiceFiscale='" + codiceFiscale + '\'' + // Mostra il codice fiscale
                '}';
    }
}

// Classe Prenotazione: rappresenta una prenotazione effettuata
class Prenotazione {
    // Attributi della classe Prenotazione
    private Cliente cliente; // Cliente che effettua la prenotazione
    private Camera camera; // Camera prenotata
    private int numeroNotti; // Numero di notti prenotate

    // Costruttore della classe Prenotazione
    public Prenotazione(Cliente cliente, Camera camera, int numeroNotti) {
        this.cliente = cliente; // Inizializza il cliente
        this.camera = camera; // Inizializza la camera
        this.numeroNotti = numeroNotti; // Inizializza il numero di notti
    }

    // Getter per il cliente
    public Cliente getCliente() {
        return cliente;
    }

    // Setter per il cliente
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Getter per la camera
    public Camera getCamera() {
        return camera;
    }

    // Setter per la camera
    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    // Getter per il numero di notti
    public int getNumeroNotti() {
        return numeroNotti;
    }

    // Setter per il numero di notti
    public void setNumeroNotti(int numeroNotti) {
        this.numeroNotti = numeroNotti;
    }

    // Metodo per calcolare il totale della prenotazione
    public double calcolaTotale() {
        return camera.getPrezzoPerNotte() * numeroNotti; // Calcola prezzo totale moltiplicando prezzo per notte per
                                                         // numero notti
    }

    // Metodo toString per visualizzare le informazioni della prenotazione
    @Override
    public String toString() {
        return "Prenotazione{" +
                "cliente=" + cliente + // Mostra il cliente
                ", camera=" + camera + // Mostra la camera
                ", numeroNotti=" + numeroNotti + // Mostra il numero di notti
                ", totale=" + calcolaTotale() + // Mostra il totale calcolato
                '}';
    }
}

// Classe Hotel: rappresenta l'hotel e gestisce tutte le operazioni
class Hotel {
    // Attributi della classe Hotel
    private ArrayList<Camera> camere; // Lista delle camere dell'hotel
    private ArrayList<Prenotazione> prenotazioni; // Lista delle prenotazioni

    // Costruttore della classe Hotel
    public Hotel() {
        this.camere = new ArrayList<>(); // Inizializza la lista delle camere
        this.prenotazioni = new ArrayList<>(); // Inizializza la lista delle prenotazioni
    }

    // Metodo per aggiungere una camera
    public void aggiungiCamera(Camera c) {
        camere.add(c); // Aggiunge la camera alla lista delle camere
    }

    // Metodo per ottenere le camere disponibili
    public List<Camera> getCamereDisponibili() {
        return camere.stream()
                .filter(c -> !c.isOccupata()) // Filtra le camere non occupate
                .collect(Collectors.toList()); // Converte il risultato in una lista
    }

    // Metodo per creare una nuova prenotazione
    public void nuovaPrenotazione(Prenotazione p) {
        prenotazioni.add(p); // Aggiunge la prenotazione alla lista
        p.getCamera().setOccupata(true); // Imposta la camera come occupata
        p.getCamera().setCliente(p.getCliente()); // Associa il cliente alla camera
    }

    // Metodo per mostrare tutte le prenotazioni
    public void mostraPrenotazioni() {
        for (Prenotazione p : prenotazioni) {
            System.out.println(p); // Stampa ogni prenotazione
        }
    }

    // Metodo per calcolare l'incasso totale di tutte le prenotazioni
    public double incassoTotale() {
        return prenotazioni.stream()
                .mapToDouble(Prenotazione::calcolaTotale) // Mappa ogni prenotazione al suo totale
                .sum(); // Somma tutti i totali
    }

    // Metodo per cercare prenotazioni per un cliente specifico
    public List<Prenotazione> cercaPrenotazioniPerCliente(String codiceFiscale) {
        return prenotazioni.stream()
                .filter(p -> p.getCliente().getCodiceFiscale().equals(codiceFiscale)) // Filtra per codice fiscale
                .collect(Collectors.toList()); // Converte il risultato in una lista
    }

    // Metodo per verificare se esiste già una camera con lo stesso numero
    public boolean esisteCamera(int numero) {
        return camere.stream()
                .anyMatch(c -> c.getNumero() == numero); // Verifica se esiste una camera con il numero specificato
    }
}

// Classe Main: contiene il menu e gestisce l'interazione con l'utente
public class hotel_management {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crea uno scanner per leggere input
        Hotel hotel = new Hotel(); // Crea un'istanza dell'hotel

        boolean continua = true; // Flag per continuare l'esecuzione del programma

        // Loop principale del programma
        while (continua) {
            // Mostra il menu all'utente
            System.out.println("\n==== SISTEMA GESTIONE HOTEL ====");
            System.out.println("1. Aggiungi camera");
            System.out.println("2. Visualizza camere disponibili");
            System.out.println("3. Effettua prenotazione");
            System.out.println("4. Visualizza prenotazioni");
            System.out.println("5. Calcola incasso totale");
            System.out.println("6. Cerca prenotazioni per cliente");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");

            try {
                int scelta = scanner.nextInt(); // Legge la scelta dell'utente
                scanner.nextLine(); // Consuma il carattere di nuova linea

                // Switch per gestire le diverse opzioni del menu
                switch (scelta) {
                    case 0:
                        continua = false; // Imposta il flag per uscire dal programma
                        System.out.println("Arrivederci!"); // Messaggio di uscita
                        break;

                    case 1:
                        // Aggiunta di una nuova camera
                        System.out.print("Inserisci il numero della camera: ");
                        int numero = scanner.nextInt();
                        scanner.nextLine(); // Consuma il carattere di nuova linea

                        // Verifica se la camera esiste già
                        if (hotel.esisteCamera(numero)) {
                            System.out.println("Errore: Esiste già una camera con il numero " + numero);
                            break;
                        }

                        System.out.print("Inserisci il tipo (singola, doppia, suite): ");
                        String tipo = scanner.nextLine();

                        // Validazione del tipo di camera
                        while (!tipo.equals("singola") && !tipo.equals("doppia") && !tipo.equals("suite")) {
                            System.out.println("Tipo non valido. Inserisci 'singola', 'doppia' o 'suite':");
                            tipo = scanner.nextLine();
                        }

                        System.out.print("Inserisci il prezzo per notte: ");
                        double prezzo = scanner.nextDouble();
                        scanner.nextLine(); // Consuma il carattere di nuova linea

                        // Validazione del prezzo
                        while (prezzo <= 0) {
                            System.out.println("Il prezzo deve essere positivo. Inserisci un nuovo prezzo:");
                            prezzo = scanner.nextDouble();
                            scanner.nextLine(); // Consuma il carattere di nuova linea
                        }

                        // Crea e aggiunge la camera
                        Camera camera = new Camera(numero, tipo, prezzo);
                        hotel.aggiungiCamera(camera);
                        System.out.println("Camera aggiunta con successo!");
                        break;

                    case 2:
                        // Visualizzazione delle camere disponibili
                        List<Camera> disponibili = hotel.getCamereDisponibili();
                        if (disponibili.isEmpty()) {
                            System.out.println("Non ci sono camere disponibili.");
                        } else {
                            System.out.println("Camere disponibili:");
                            for (Camera c : disponibili) {
                                System.out.println(c);
                            }
                        }
                        break;

                    case 3:
                        // Effettuazione di una prenotazione
                        List<Camera> camereDisponibili = hotel.getCamereDisponibili();
                        if (camereDisponibili.isEmpty()) {
                            System.out.println("Non ci sono camere disponibili per la prenotazione.");
                            break;
                        }

                        // Raccolta dati cliente
                        System.out.print("Inserisci il nome del cliente: ");
                        String nome = scanner.nextLine();

                        System.out.print("Inserisci il cognome del cliente: ");
                        String cognome = scanner.nextLine();

                        System.out.print("Inserisci il codice fiscale del cliente: ");
                        String codiceFiscale = scanner.nextLine();

                        // Crea il cliente
                        Cliente cliente = new Cliente(nome, cognome, codiceFiscale);

                        // Visualizza camere disponibili
                        System.out.println("Camere disponibili:");
                        for (int i = 0; i < camereDisponibili.size(); i++) {
                            System.out.println(i + ": " + camereDisponibili.get(i));
                        }

                        // Scelta della camera
                        System.out.print("Seleziona il numero dell'opzione della camera: ");
                        int indiceCamere = scanner.nextInt();
                        scanner.nextLine(); // Consuma il carattere di nuova linea

                        // Validazione dell'indice della camera
                        while (indiceCamere < 0 || indiceCamere >= camereDisponibili.size()) {
                            System.out.println("Opzione non valida. Inserisci un numero tra 0 e "
                                    + (camereDisponibili.size() - 1) + ":");
                            indiceCamere = scanner.nextInt();
                            scanner.nextLine(); // Consuma il carattere di nuova linea
                        }

                        Camera cameraScelta = camereDisponibili.get(indiceCamere);

                        // Numero di notti
                        System.out.print("Inserisci il numero di notti: ");
                        int notti = scanner.nextInt();
                        scanner.nextLine(); // Consuma il carattere di nuova linea

                        // Validazione del numero di notti
                        while (notti <= 0) {
                            System.out.println("Il numero di notti deve essere positivo. Inserisci un nuovo valore:");
                            notti = scanner.nextInt();
                            scanner.nextLine(); // Consuma il carattere di nuova linea
                        }

                        // Crea la prenotazione
                        Prenotazione prenotazione = new Prenotazione(cliente, cameraScelta, notti);
                        hotel.nuovaPrenotazione(prenotazione);

                        System.out.println("Prenotazione effettuata con successo!");
                        System.out.println("Totale da pagare: €" + prenotazione.calcolaTotale());
                        break;

                    case 4:
                        // Visualizzazione di tutte le prenotazioni
                        System.out.println("Elenco prenotazioni:");
                        hotel.mostraPrenotazioni();
                        break;

                    case 5:
                        // Calcolo dell'incasso totale
                        double incasso = hotel.incassoTotale();
                        System.out.println("Incasso totale: €" + incasso);
                        break;

                    case 6:
                        // Ricerca prenotazioni per cliente
                        System.out.print("Inserisci il codice fiscale del cliente: ");
                        String cf = scanner.nextLine();

                        List<Prenotazione> prenotazioniCliente = hotel.cercaPrenotazioniPerCliente(cf);

                        if (prenotazioniCliente.isEmpty()) {
                            System.out.println("Nessuna prenotazione trovata per il codice fiscale: " + cf);
                        } else {
                            System.out.println("Prenotazioni trovate per il cliente con codice fiscale " + cf + ":");
                            for (Prenotazione p : prenotazioniCliente) {
                                System.out.println(p);
                            }
                        }
                        break;

                    default:
                        System.out.println("Opzione non valida. Riprova."); // Messaggio per opzione non valida
                }
            } catch (InputMismatchException e) {
                // Gestione eccezione per input non valido
                System.out.println("Errore: Inserisci un valore valido!");
                scanner.nextLine(); // Pulisce l'input errato
            } catch (Exception e) {
                // Gestione generica delle eccezioni
                System.out.println("Si è verificato un errore: " + e.getMessage());
                e.printStackTrace();
            }
        }

        scanner.close(); // Chiude lo scanner
    }
}