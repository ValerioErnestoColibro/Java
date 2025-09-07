public class MetodoRicorsivo {
    public static int calcolaFattoriale(int n) {
        if (n == 0)
            return 1; // Caso base
        return n * calcolaFattoriale(n - 1); // Chiamata ricorsiva
    }

    public static void main(String[] args) {
        System.out.println("Fattoriale di 5 = " + calcolaFattoriale(5));
    }
}
