public class SommaElementiArray {
    public static void main(String[] args) {
        int[] numeri = {7, 14, 21, 28};
        int somma = 0;
        for (int num : numeri) { // Ciclo for-each
            somma += num;
        }
        System.out.println("Somma totale: " + somma);
    }
}
