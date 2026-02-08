// Con Incapsulamento

public class Classe_Rettangolo {
    private int base;
    private int altezza;

    public Classe_Rettangolo(int base, int altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    public int calcolaArea() {
        return base * altezza;
    }

    public void mostraInfo() {
        System.out.println("Base: " + base + "\nAltezza: " + altezza + "\nArea del rettangolo = " + calcolaArea());
    }

    public static void main(String[] args) {
        Classe_Rettangolo rettangolo = new Classe_Rettangolo(20, 30);
        rettangolo.mostraInfo();
    }
}
