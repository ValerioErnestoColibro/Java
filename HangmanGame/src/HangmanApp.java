import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HangmanApp extends JFrame {
    private String parolaSegreta; // Parola segreta caricata dal file
    private char[] parolaArray;
    private char[] parolaNascosta;
    private int tentativiMassimi = 6;
    private int errori = 0;
    private ArrayList<Character> lettereUsate = new ArrayList<>();

    // Componenti GUI
    private JLabel labelParola;
    private JLabel labelTentativi;
    private JLabel labelLettereUsate;
    private JTextArea asciiImpiccato; // Area per disegno ASCII
    private JTextField inputLettera;
    private JButton buttonInvia;

    public HangmanApp() {
        // Carica la parola segreta dal file
        parolaSegreta = caricaParolaDaFile("C:\\Users\\DOCENTE\\eclipse-workspace\\HangmanGame\\src\\words.txt");
        if (parolaSegreta == null) {
            JOptionPane.showMessageDialog(this, "Errore: impossibile caricare la parola segreta!", "Errore", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        parolaArray = parolaSegreta.toCharArray();
        parolaNascosta = new char[parolaSegreta.length()];
        for (int i = 0; i < parolaNascosta.length; i++) {
            parolaNascosta[i] = '_';
        }

        // Configura la finestra principale
        setTitle("Gioco dell'impiccato con ASCII e File");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Pannello superiore per stato del gioco
        JPanel panelTop = new JPanel(new GridLayout(3, 1));
        labelParola = new JLabel("Parola: " + new String(parolaNascosta));
        labelTentativi = new JLabel("Tentativi rimanenti: " + (tentativiMassimi - errori));
        labelLettereUsate = new JLabel("Lettere già usate: " + lettereUsate);
        panelTop.add(labelParola);
        panelTop.add(labelTentativi);
        panelTop.add(labelLettereUsate);

        // Pannello centrale per il disegno ASCII
        asciiImpiccato = new JTextArea(10, 30);
        asciiImpiccato.setEditable(false); // L'utente non può modificare
        asciiImpiccato.setFont(new Font("Monospaced", Font.PLAIN, 20));
        asciiImpiccato.setText(getAsciiImpiccato(0)); // Disegno iniziale
        JScrollPane scrollPane = new JScrollPane(asciiImpiccato);

        // Pannello inferiore per input
        JPanel panelBottom = new JPanel();
        inputLettera = new JTextField(5);
        buttonInvia = new JButton("Prova lettera");
        panelBottom.add(new JLabel("Inserisci una lettera:"));
        panelBottom.add(inputLettera);
        panelBottom.add(buttonInvia);

        // Aggiungi pannelli alla finestra principale
        add(panelTop, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);

        // Azione pulsante per tentare una lettera
        buttonInvia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputLettera.getText().toUpperCase();
                if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                    JOptionPane.showMessageDialog(HangmanApp.this, "Inserisci una singola lettera valida!", "Errore", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                char lettera = input.charAt(0);

                // Controlla se la lettera è già stata usata
                if (lettereUsate.contains(lettera)) {
                    JOptionPane.showMessageDialog(HangmanApp.this, "Hai già provato questa lettera!", "Attenzione", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                lettereUsate.add(lettera);

                // Controlla se la lettera è nella parola
                if (parolaSegreta.contains(String.valueOf(lettera))) {
                    for (int i = 0; i < parolaArray.length; i++) {
                        if (parolaArray[i] == lettera) {
                            parolaNascosta[i] = lettera;
                        }
                    }
                } else {
                    errori++;
                }

                // Aggiorna GUI
                labelParola.setText("Parola: " + new String(parolaNascosta));
                labelTentativi.setText("Tentativi rimanenti: " + (tentativiMassimi - errori));
                labelLettereUsate.setText("Lettere già usate: " + lettereUsate);
                asciiImpiccato.setText(getAsciiImpiccato(errori)); // Aggiorna il disegno ASCII

                // Controlla condizioni di vittoria o sconfitta
                if (new String(parolaNascosta).equals(parolaSegreta)) {
                    JOptionPane.showMessageDialog(HangmanApp.this, "Hai vinto! La parola era: " + parolaSegreta, "Vittoria", JOptionPane.INFORMATION_MESSAGE);
                    buttonInvia.setEnabled(false);
                } else if (errori >= tentativiMassimi) {
                    JOptionPane.showMessageDialog(HangmanApp.this, "Hai perso! La parola era: " + parolaSegreta, "Sconfitta", JOptionPane.INFORMATION_MESSAGE);
                    buttonInvia.setEnabled(false);
                }

                inputLettera.setText(""); // Pulisce il campo di input
            }
        });
    }

    // Metodo per ottenere il disegno ASCII in base al numero di errori
    private String getAsciiImpiccato(int errori) {
        String[] disegni = {
            "  +---+\n      |\n      |\n      |\n     ===",
            "  +---+\n  O   |\n      |\n      |\n     ===",
            "  +---+\n  O   |\n  |   |\n      |\n     ===",
            "  +---+\n  O   |\n /|   |\n      |\n     ===",
            "  +---+\n  O   |\n /|\\  |\n      |\n     ===",
            "  +---+\n  O   |\n /|\\  |\n /    |\n     ===",
            "  +---+\n  O   |\n /|\\  |\n / \\  |\n     ==="
        };
        return disegni[Math.min(errori, disegni.length - 1)];
    }

    // Metodo per caricare la parola segreta da file
    public static String caricaParolaDaFile(String nomeFile) {
        try {
            File file = new File(nomeFile);
            Scanner scanner = new Scanner(file);

            if (scanner.hasNextLine()) {
                String parolaSegreta = scanner.nextLine().toUpperCase();
                scanner.close();
                return parolaSegreta;
            } else {
                scanner.close();
                return null;
            }
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HangmanApp gioco = new HangmanApp();
            gioco.setVisible(true);
        });
    }
}

