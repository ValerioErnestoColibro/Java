import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DnD_Dices extends JFrame {
    private final JTextArea resultArea;
    private final Random random;

    public DnD_Dices() {
        // Imposta il titolo della finestra
        setTitle("Dadi di DnD");
        setSize(500, 200); // Dimensioni della finestra
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la finestra sullo schermo

        // Layout principale
        setLayout(new BorderLayout());

        // Area di testo per il risultato
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Verdana", Font.BOLD, 20));
        add(resultArea, BorderLayout.CENTER);

        // Pannello per i pulsanti
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 4, 5, 5)); // Griglia 2x4 con spaziatura

        // Array con i tipi di dado
        int[] diceTypes = { 4, 6, 8, 10, 12, 20, 100 };
        random = new Random();

        // Creazione dei pulsanti
        for (int sides : diceTypes) {
            JButton button = new JButton("d" + sides);
            button.setFont(new Font("Arial", Font.BOLD, 14));

            // Assegna un'azione a ogni pulsante
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int result = roll(sides);
                    resultArea.setText("Hai lanciato un d" + sides + " ed è uscito " + result);
                }
            });

            buttonPanel.add(button); // Aggiunge il pulsante al pannello
        }

        // Aggiunge il pannello dei pulsanti alla finestra
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Metodo per generare il risultato del lancio di un dado.
     * 
     * @param sides Numero di facce del dado.
     * @return Valore casuale tra 1 e sides, oppure multipli di 10 per d100.
     */
    private int roll(int sides) {
        if (sides == 100) {
            return (random.nextInt(10) + 1) * 10; // d100 con valori multipli di 10
        }
        return random.nextInt(sides) + 1; // Altri dadi
    }

    public static void main(String[] args) {
        // Esegue l'app in un thread Swing
        SwingUtilities.invokeLater(() -> new DnD_Dices().setVisible(true));
    }
}