public class MetodiStringhe {
    public static void main(String[] args) {
        // Creazione di una stringa
        String frase = "Programmare in Java è fantastico!";

        // Stampa della lunghezza della stringa
        System.out.println("Lunghezza: " + frase.length());

        // Convertire in maiuscolo
        System.out.println("Maiuscolo: " + frase.toUpperCase());

        // Convertire in minuscolo
        System.out.println("Minuscolo: " + frase.toLowerCase());

        // Sottostringa (dalla posizione 12 in poi)
        System.out.println("Parte della frase: " + frase.substring(12));

        // Controllare se contiene una parola
        System.out.println("Contiene 'Java'? " + frase.contains("Java"));

        // Sostituire una parola
        System.out.println("Sostituisci 'Java' con 'Python': " + frase.replace("Java", "Python"));
    }
}
