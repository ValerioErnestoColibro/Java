
// Importazione delle classi necessarie per la gestione delle eccezioni di file
import java.io.FileNotFoundException;
// Importazione della classe per scrivere file di testo
import java.io.FileWriter;
// Importazione della classe per gestire eccezioni di input/output
import java.io.IOException;

public class ScriviTesto {
    public static void main(String[] args) {

        // Definizione del percorso del file da creare
        String filePath = "test.text";

        // Definizione del contenuto di testo da scrivere nel file
        String textContent = """
                Le rose sono rosse
                Le viole sono blu
                BOOTY BOOTY BOOTY ROCKIN' EVERYWHERE!
                """;

        // Blocco "try-with-resources" per gestire automaticamente la chiusura del file
        // writer
        try (FileWriter writer = new FileWriter(filePath)) {
            // Scrittura del contenuto di testo nel file
            writer.write(textContent);
            // Stampa di un messaggio di conferma avvenuta scrittura
            System.out.println("Il file e' stato scritto");
        }
        // Gestione dell'eccezione se il file non viene trovato
        catch (FileNotFoundException e) {
            // Stampa di un messaggio di errore
            System.out.println("Impossibile trovare la posizione del file");
        }
        // Gestione di altre possibili eccezioni di input/output
        catch (IOException e) {
            // Stampa di un messaggio di errore generico
            System.out.println("Impossibile scrivere il file");
        }
    }
}
