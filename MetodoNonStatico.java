public class MetodoNonStatico {
    String nome;

    // Metodo non statico
    public void saluta() {
        System.out.println("Ciao! Io mi chiamo " + nome);
    }

    public static void main(String[] args) {
        MetodoNonStatico m = new MetodoNonStatico(); // Creazione di un oggetto
        m.nome = "Valerio"; // Assegnazione del nome
        m.saluta(); // Chiamata al metodo non statico
    }
}
