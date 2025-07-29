import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleForm {
    public static void main(String[] args) {
        // Creazione della finestra
        JFrame frame = new JFrame("Form Utente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3, 2));

        // Creazione dei componenti
        JLabel nameLabel = new JLabel("Nome:");
        JTextField nameField = new JTextField();
        JLabel surnameLabel = new JLabel("Cognome:");
        JTextField surnameField = new JTextField();
        JButton submitButton = new JButton("Invia");

        // Aggiunta degli eventi
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String surname = surnameField.getText();
                JOptionPane.showMessageDialog(frame, "Nome: " + name + "\nCognome: " + surname);
            }
        });

        // Aggiunta dei componenti al frame
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(surnameLabel);
        frame.add(surnameField);
        frame.add(submitButton);

        // Visualizzazione della finestra
        frame.setVisible(true);
    }
}
