public class MatriceStampa {
    public static void main(String[] args) {
        // Creazione di un array bidimensionale (matrice)
        int[][] matrice = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        for (int i = 0; i < matrice.length; i++) { // Scorre le righe
            for (int j = 0; j < matrice[i].length; j++) { // Scorre le colonne
                System.out.print(matrice[i][j] + " "); // Stampa ogni elemento

            }
            System.out.println(); // Nuova riga per la stampa corretta
        }
    }
}
