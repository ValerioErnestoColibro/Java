public class TipiDatiPrimitivi {
    public static void main(String[] args) {
        byte numeroByte = 10;
        short numeroShort = 1000;
        int numeroInt = 100000;
        long numeroLong = 1000000000L;
        float numeroFloat = 10.5f;
        double numeroDouble = 99.99;
        char carattere = 'A';
        boolean valoreBooleano = true;

        System.out.println("Valori iniziali:");
        System.out.println("byte: " + numeroByte);
        System.out.println("short: " + numeroShort);
        System.out.println("int: " + numeroInt);
        System.out.println("long: " + numeroLong);
        System.out.println("float: " + numeroFloat);
        System.out.println("double: " + numeroDouble);
        System.out.println("char: " + carattere);
        System.out.println("boolean: " + valoreBooleano);

        numeroByte = 20;
        numeroShort = 2000;
        numeroInt = 200000;
        numeroLong = 2000000000L;
        numeroFloat = 20.5f;
        numeroDouble = 199.99;
        carattere = 'B';
        valoreBooleano = false;

        System.out.println("\nValori modificati:");
        System.out.println("byte: " + numeroByte);
        System.out.println("short: " + numeroShort);
        System.out.println("int: " + numeroInt);
        System.out.println("long: " + numeroLong);
        System.out.println("float: " + numeroFloat);
        System.out.println("double: " + numeroDouble);
        System.out.println("char: " + carattere);
        System.out.println("boolean: " + valoreBooleano);

    }
}
