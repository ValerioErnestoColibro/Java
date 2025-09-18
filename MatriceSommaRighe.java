public class MatriceSommaRighe {
    public static void main(String[] args) {
        // Definizione della matrice 3x3
        int[][] matrice = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Calcola e stampa della somma di ogni riga
        for (int i = 0; i < matrice.length; i++) {
            int somma = 0;
            for (int j = 0; j < matrice[i].length; j++) {
                somma += matrice[i][j];
            }
            System.out.println("Somma riga " + (i + 1) + ": " + somma);
        }
    }
}
