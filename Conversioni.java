public class Conversioni {
    public static void main(String[] args) {
        // 1. Dichiarare una variabile double e assegnarle un valore
        double numeroDouble = 9.75; // Numero con parte decimale

        // 2. Convertirla in int (casting esplicito)
        int numeroInt = (int) numeroDouble; // Il casting tronca la parte decimale

        // Stampare entrambi i valori per osservare la differenza
        System.out.println("Valore double: " + numeroDouble); // Stampa 9.75
        System.out.println("Valore int dopo conversione: " + numeroInt); // Stampa 9 (perché la parte decimale viene eliminata)

        // 3. Dichiarare una variabile int e assegnarle un valore elevato
        int numeroGrande = 130; // Valore int superiore alla capacità massima di un byte

        // 4. Convertirla in byte (casting esplicito)
        byte numeroByte = (byte) numeroGrande; // Il valore viene ridotto alla capacità di un byte (-128 a 127)

        // Stampare entrambi i valori per osservare il comportamento
        System.out.println("Valore int: " + numeroGrande); // Stampa 130
        System.out.println("Valore byte dopo conversione: " + numeroByte); // Stampa -126 (perché 130 supera il range di un byte e viene "avvolto")

        // 🔍 Spiegazione del comportamento del byte overflow:
        // Un byte può contenere valori da -128 a 127.
        // Quando si prova a memorizzare 130 in un byte, avviene un overflow:
        // - Il valore 130 viene ridotto modulo 256 (il range di un byte: 2^8 = 256)
        // - 130 - 256 = -126, quindi il valore risultante in byte è -126
    }
}
