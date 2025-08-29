public class Metodo_Parametri {
    // Metodo con parametri che restituisce un valore
    public static int somma(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int risultato = somma(5, 7); // Chiamata con argomenti 5 e 7
        System.out.println("La somma di 5 e 7 è uguale a " + risultato);
    }
}
