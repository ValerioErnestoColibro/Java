public class Classe_Automobile {
    private String marca;

    public Classe_Automobile(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String nuovaMarca) {
        this.marca = nuovaMarca;
    }

    public static void main(String[] args) {
        Classe_Automobile auto = new Classe_Automobile("Fiat");
        System.out.println("Marca dell'auto: " + auto.getMarca());
    }
}
