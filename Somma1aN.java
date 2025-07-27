import java.util.Scanner;

public class Somma1aN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci un numero: ");
        int n = input.nextInt();
        int somma = 0;

        for (int i = 1; i <= n; i++) {
            somma += i;
        }
        System.out.println("La somma dei numeri da 1 a " + n + " è " + somma);
        input.close();
    }
}
