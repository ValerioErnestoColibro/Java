public class Literals {
    public static void main(String[] args) {
        // Dichiarazione di variabili con valori literal per ogni variabile primitiva
        byte byteLiteral = 127;
        short shortLiteral = 32000;
        int intLiteral = 100000;
        long longLiteral = 1000000000L;
        float floatLiteral = 3.14f;
        double doubleLiteral = 2.71828;
        char charLiteral = 'A';
        boolean booleanLiteral = true;

        System.out.println("Valori literal:");
        System.out.println("byte: " + byteLiteral);
        System.out.println("short: " + shortLiteral);
        System.out.println("int: " + intLiteral);
        System.out.println("long: " + longLiteral);
        System.out.println("float: " + floatLiteral);
        System.out.println("double: " + doubleLiteral);
        System.out.println("char: " + charLiteral);
        System.out.println("boolean: " + booleanLiteral);
    
        // Sommiamo due valori di tipo diverso e vediamo cosa succede
        int sommaIntDouble = intLiteral + doubleLiteral; // Cast esplicito a "int"
        double sommaDoubleInt = intLiteral + doubleLiteral; // Conversione implicita a "double"

        System.out.println("Somma int + double (con cast): " + sommaIntDouble);
        System.out.println("Somma int + double (senza cast): " + sommaDoubleInt);
    }
}
