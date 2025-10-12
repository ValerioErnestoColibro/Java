import java.util.Scanner;

public class Giorni_settimana {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("In ordine numerico, che giorno è oggi? ");
        int giorno = input.nextInt();

        switch (giorno) {
            case 1:
                System.out.println("Oggi è Lunedì");
                break;
            case 2:
                System.out.println("Oggi è Martedì");
                break;
            case 3:
                System.out.println("Oggi è Mercoledì");
                break;
            case 4:
                System.out.println("Oggi è Giovedì");
                break;
            case 5:
                System.out.println("Oggi è Venerdì");
                break;
            case 6:
                System.out.println("Oggi è Sabato");
                break;
            case 7:
                System.out.println("Oggi è Domenica");
                break;
            default:
                System.out.println("Numero non valido!");
        }
        input.close();
    }
}
