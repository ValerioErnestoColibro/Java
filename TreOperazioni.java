import java.util.Scanner;
public class TreOperazioni {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il primo numero: ");
        int num1 = scanner.nextInt();
        System.out.print("Inserisci il secondo numero: ");
        int num2 = scanner.nextInt();
        int somma = num1 + num2;
        int differenza = num1 - num2;
        int prodotto = num1 * num2;
        System.out.println("Somma = " + somma);
        System.out.println("Differenza = " + differenza);
        System.out.println("Prodotto = " + prodotto);
        scanner.close();
    }
}