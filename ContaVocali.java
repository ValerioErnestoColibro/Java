import java.util.Scanner;

public class ContaVocali {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci una frase: ");
        String frase = input.nextLine().toLowerCase();

        int conteggio = 0;
        for (char c : frase.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                conteggio++;
            }
        }

        System.out.println("Numero di vocali: " + conteggio);
        input.close();
    }
}