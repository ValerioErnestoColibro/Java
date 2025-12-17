import java.util.Scanner; // Importa la classe Scanner per leggere l'input dell'utente
import java.util.Timer; // Importa la classe Timer per gestire il timer
import java.util.TimerTask; // Importa la classe TimerTask per definire il compito da eseguire

public class Countdown_Timer {
    public static void main(String[] args) {

        // PROGRAMMA DI CONTO ALLA ROVESCIA IN JAVA

        Scanner scanner = new Scanner(System.in); // Crea un oggetto Scanner per leggere l'input dell'utente

        System.out.print("Da quanti secondi inizia il countdown? "); // Chiede all'utente di inserire il numero di
                                                                     // secondi per il conto alla rovescia
        int response = scanner.nextInt(); // Legge il numero inserito dall'utente

        Timer timer = new Timer(); // Crea un'istanza di Timer per gestire il conto alla rovescia
        TimerTask task = new TimerTask() { // Definisce il compito da eseguire ad intervalli regolari

            int count = response; // Inizializza la variabile count con il valore inserito dall'utente

            @Override
            public void run() { // Metodo che viene eseguito periodicamente

                System.out.println(count); // Stampa il valore corrente del conto alla rovescia
                count--; // Decrementa il conteggio

                if (count < 0) { // Se il conteggio arriva sotto zero
                    System.out.println("BUON ANNO NUOVO!"); // Stampa il messaggio finale
                    timer.cancel(); // Ferma il timer
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000); // Avvia il timer con un ritardo iniziale di 0 ms e ripete
                                                  // l'operazione ogni 1000 ms (1 secondo)

        scanner.close(); // Chiude lo scanner per evitare sprechi di risorse
    }
}
