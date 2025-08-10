public class Scope {
    // Variabile di istanza: ogni oggetto avrà una propria copia indipendente
    private int variabileIstanza;

    // Variabile statica: condivisa tra tutti gli oggetti della classe
    private static int variabileStatica;

    // Metodo che modifica la variabile di istanza
    public void modificaIstanza(int nuovoValore) {
        variabileIstanza = nuovoValore; // Assegna il nuovo valore solo per l'oggetto corrente
    }

    // Metodo che modifica la variabile statica
    public static void modificaStatica(int nuovoValore) {
        variabileStatica = nuovoValore; // Modifica il valore condiviso tra tutti gli oggetti
    }

    // Metodo per stampare i valori delle variabili
    public void stampaValori(String nomeOggetto) {
        System.out.println(nomeOggetto + " - Variabile di istanza: " + variabileIstanza +
                ", Variabile statica: " + variabileStatica);
    }

    public static void main(String[] args) {
        // Creazione di due oggetti della classe
        Scope obj1 = new Scope();
        Scope obj2 = new Scope();

        // Modifica della variabile di istanza per ciascun oggetto
        obj1.modificaIstanza(10); // Solo obj1 cambia la sua variabile di istanza
        obj2.modificaIstanza(20); // Solo obj2 cambia la sua variabile di istanza

        // Modifica della variabile statica
        Scope.modificaStatica(100); // Chiamata corretta per un metodo statico

        // Stampare i valori dopo la modifica
        obj1.stampaValori("obj1");
        obj2.stampaValori("obj2");

        // Modifica della variabile statica da obj2
        Scope.modificaStatica(200); // Cambia il valore della variabile statica per tutti gli oggetti

        // Stampare nuovamente i valori per vedere l'effetto della modifica della
        // variabile statica
        obj1.stampaValori("obj1");
        obj2.stampaValori("obj2");
    }
}
