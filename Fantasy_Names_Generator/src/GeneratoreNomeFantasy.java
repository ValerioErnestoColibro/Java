import java.util.Random;

public class GeneratoreNomeFantasy {
    // Array di prefissi e suffissi per i nomi fantasy
    private static final String[] PREFISSI = { "Eld", "Thal", "Var", "Drak", "Zan", "Kel", "Mor", "Faer", "Aer",
            "Syl" };
    private static final String[] SUFFISSI = { "dor", "ion", "mir", "thas", "zar", "wyn", "dus", "vian", "gorn",
            "lith" };

    public static void main(String[] args) {
        // Genera e stampa 10 nomi casuali
        for (int i = 0; i < 10; i++) {
            System.out.println(generaNome());
        }
    }

    public static String generaNome() {
        Random random = new Random();
        String prefisso = PREFISSI[random.nextInt(PREFISSI.length)];
        String suffisso = SUFFISSI[random.nextInt(SUFFISSI.length)];
        return prefisso + suffisso;
    }
}