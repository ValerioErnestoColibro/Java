public class ScopeTest {
    private int variabileIstanza = 0;
    private static int variabileStatica = 0;

    public static void main(String[] args) {
        ScopeTest scopeTest = new ScopeTest();
        scopeTest.incrementaVariabili();
        scopeTest.incrementaVariabili();
    }

    public void incrementaVariabili() {
        int variabileLocale = 0;
        for (int i = 0; i < 3; i++) {
            variabileLocale++;
            variabileIstanza++;
            variabileStatica++;
            System.out.println("Iterazione " + i + " - Locale: " + variabileLocale + ", Istanza: " + variabileIstanza + ", Statica:" + variabileStatica);
        }
    }
}
