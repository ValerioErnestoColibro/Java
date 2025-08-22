public class Operatori {
    public static void main(String[] args) {
        // 1. Dichiarazione di due variabili intere
        int a = 10;
        int b = 3;

        // Applicazione degli operatori aritmetici
        int somma = a + b;
        int differenza = a - b;
        int prodotto = a * b;
        int quoziente = a / b;
        int resto = a % b;

        // Stampa dei risultati
        System.out.println("Somma: " + somma);
        System.out.println("Differenza: " + differenza);
        System.out.println("Prodotto: " + prodotto);
        System.out.println("Quoziente: " + quoziente);
        System.out.println("Resto:" + resto);

        // 2. Operatori di incremento e decremento
        int x = 5;
        System.out.println("\nValore iniziale di x: " + x);
        System.out.println("Postincremento (x++): " + x++); // Usa x poi incrementa
        System.out.println("Dopo post-incremento, x: " + x);
        System.out.println("Pre-incremento (++x): " + (++x)); // Incrementa x poi la incrementi
        System.out.println("Post-decremento (x--): " + x--); // Usa x poi decrementa
        System.out.println("Dopo post-decremento, x: " + x);
        System.out.println("Pre-decremento (--x): " + (--x)); // Decrementa x poi la usa

        // 3. Operatori relazionali
        boolean uguale = (a == b); // Verifica se a è uguale a b
        boolean diverso = (a != b); // Verifica se a è diverso da b
        boolean maggiore = (a > b); // Verifica se a è maggiore di b
        boolean minore = (a < b); // Verifica se a è minore di b
        boolean maggioreUguale = (a >= b); // Verifica se a è maggiore o uguale a b
        boolean minoreUguale = (a <= b); // Verifica se a è minore o uguale a b

        // Stampa dei risultati
        System.out.println("\nOperatori relazionali:");
        System.out.println("a == b: " + uguale);
        System.out.println("a != b: " + diverso);
        System.out.println("a > b: " + maggiore);
        System.out.println("a < b: " + minore);
        System.out.println("a >= b: " + maggioreUguale);
        System.out.println("a <= b:" + minoreUguale);

        // 4. Operatori logici
        boolean condizione1 = (a > 5); // Vero perchè a è 10
        boolean condizione2 = (b < 5); // Vero perchè b è 3
        boolean andLogico = condizione1 && condizione2; // AND logico (true && true)
        boolean orLogico = condizione1 || condizione2; // OR logico (true || true)
        boolean notLogico = !condizione1; // NOT logico (!true = false)

        // Stampa dei risultati degli operatori logici
        System.out.println("\nOperatori logici:");
        System.out.println("condizione1 && condizione2: " + andLogico);
        System.out.println("condizione 1 || condizione2: " + orLogico);
        System.out.println("!condizione1: " + notLogico);

        // 5. Uso dello short-circuit per valutare l'efficienza degli operatori logici
        boolean shortCircuit = (a > 5) || metodoCheStamp("Questo non viene eseguito");
        System.out.println("\nShort-circuit OR: " + shortCircuit);

        boolean noShortCircuit = (a < 5) && metodoCheStamp("Questo viene eseguito");
        System.out.println("Short-circuit AND: " + noShortCircuit);
    }

    // Metodo che stampa un messaggio e restituisce "false"
    public static boolean metodoCheStamp(String messaggio) {
        System.out.println(messaggio);
        return false;
    }
}
