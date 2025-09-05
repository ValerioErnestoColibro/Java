public class MetodoVariParametri {
    // Metodo che esegue un'operazione base su due numeri
    public static double operazione(double num1, double num2, String operatore) {

        switch (operatore) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0)
                    return num1 / num2;
                else
                    System.out.println("NON PUOI DIVIDERE PER ZERO!");
            default:
                System.out.println("Operatore non valido!");
                return 0;
        }
    }

    public static void main(String[] args) {
        double risultato = operazione(10, 5, "*");
        System.out.println("Risultato: " + risultato);
    }
}
