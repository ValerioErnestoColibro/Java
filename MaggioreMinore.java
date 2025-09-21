import java.util.Scanner;

public class MaggioreMinore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Inserisci il primo numero: ");
        int num1 = input.nextInt();

        System.out.print("Inserisci il secondo numero: ");
        int num2 = input.nextInt();

        if (num1 > num2) {
            System.out.println("Il primo numero è maggiore dell'altro!");

        } else if (num2 > num1) {
            System.out.println("Il secondo numero è maggiore dell'altro!");
        } else {
            System.out.println("I numeri sono uguali!");
        }
        input.close();
    }
}