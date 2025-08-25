public class Metodo_SommaRicorsiva {
    public static int somma(int n) {
        if (n == 1)
            return 1;
        return n + somma(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Somma dei numeri fino a 5 = " + somma(5));
    }
}
