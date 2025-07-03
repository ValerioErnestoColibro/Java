public class TipiPrimitivi
    {
    public static void main(String[] args)
    {
        for(int i = 0; i < 5; i++)
        {
            byte piccoloNumero = (byte) (i + 10);
            short numeroBreve = (short) (i * 20);
            int numeroIntero = i * 1000;
            long numeroLungo = i * 100000L;
            float numeroDecimale = i * 1.5f;
            double numeroPreciso = i * 9.99;
            char lettera = (char) ('A' + i);
            boolean valoreLogico = (i % 2 == 0);
              System.out.println("Iterazione " + i + ":" + piccoloNumero + ", " + numeroBreve + ", " + numeroIntero + ", " + numeroLungo + ", " + numeroDecimale + ", " + numeroPreciso + ", " + lettera + ", " + valoreLogico);            
        }
    }
}