import java.util.Random;
import java.util.Scanner;

public class IndovinaNumero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int numeroSegreto = random.nextInt(10) + 1;
        int tentativo;

        do {
            System.out.print("Indovina il numero tra 1 e 10: ");
            tentativo = input.nextInt();

            if (tentativo < numeroSegreto) {
                System.out.println("Troppo basso! Riprova!");
            } else if (tentativo > numeroSegreto) {
                System.out.println("Troppo alto! Riprova!");
            }
        } while (tentativo != numeroSegreto);

        System.out.println("Esatto! Hai indovinato!");
        input.close();
    }
}
