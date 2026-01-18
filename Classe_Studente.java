public class Classe_Studente {
    String nome;
    String cognome;
    int matricola;

    public Classe_Studente(String nome, String cognome, int matricola) {
        this.nome = nome; // Assegna il valore del parametro alla variabile di istanza
        this.cognome = cognome; // Assegna il valore del parametro alla variabile di istanza
        this.matricola = matricola; // Assegna il valore del parametro alla variabile di istanza
    }

    public void mostraInfo() {
        System.out.println("Studente: " + nome + " " + cognome + ", Matricola: " + matricola);
    }

    public static void main(String[] args) {
        Classe_Studente studente = new Classe_Studente("Mario", "Rossi", 12345);
        studente.mostraInfo();
    }
}
