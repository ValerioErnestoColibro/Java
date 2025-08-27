import java.util.Scanner;

public class Metodo_PariDispari {
    public static void controllaNumero(int numero) {
        if (numero % 2 == 0) {
            System.out.println("Il numero " + numero + " è pari!");
        } else {
            System.out.println("Il numero " + numero + " è dispari!");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci un numero: ");
        int numero = input.nextInt();
        controllaNumero(numero);
        input.close();
    }
}
