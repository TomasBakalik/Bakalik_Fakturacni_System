import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistraceOkno extends JFrame {

    private JTextField poleJmeno;
    private JTextField polePrijmeni;
    private JTextField poleAdresa;
    private JTextField poleEmail;
    private JPasswordField poleHeslo;
    private JTextField poleTelefon;
    private JTextField poleId;
    private JButton tlacitkoRegistrovat;

    public RegistraceOkno() {
        nastavOkno();
        setVisible(true);
    }

    public void nastavOkno(){
        setTitle("Registrace uživatele");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 30));

        panel.add(new JLabel("Jméno:"));
        poleJmeno = new JTextField();
        panel.add(poleJmeno);

        panel.add(new JLabel("Příjmení:"));
        polePrijmeni = new JTextField();
        panel.add(polePrijmeni);

        panel.add(new JLabel("Adresa:"));
        poleAdresa = new JTextField();
        panel.add(poleAdresa);

        panel.add(new JLabel("Email:"));
        poleEmail = new JTextField();
        panel.add(poleEmail);

        panel.add(new JLabel("Heslo:"));
        poleHeslo = new JPasswordField();
        panel.add(poleHeslo);

        panel.add(new JLabel("Telefon:"));
        poleTelefon = new JTextField();
        panel.add(poleTelefon);

        panel.add(new JLabel("ID uživatele (5 číslic):"));
        poleId = new JTextField();
        panel.add(poleId);

        tlacitkoRegistrovat = new JButton("Registrovat");
        tlacitkoRegistrovat.setBackground(new Color(58, 120, 233));
        tlacitkoRegistrovat.setForeground(Color.WHITE);
        tlacitkoRegistrovat.setFont(new Font("Arial", Font.BOLD, 16));
        tlacitkoRegistrovat.setFocusPainted(false);
        tlacitkoRegistrovat.setPreferredSize(new Dimension(500, 40));
        tlacitkoRegistrovat.addActionListener(e -> registrujUzivatele());

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(tlacitkoRegistrovat, BorderLayout.SOUTH);
    }

    public void registrujUzivatele() {
        try {
            String jmeno = poleJmeno.getText();
            String prijmeni = polePrijmeni.getText();
            String adresa = poleAdresa.getText();
            String email = poleEmail.getText();
            String heslo = new String(poleHeslo.getPassword());
            String telefon = poleTelefon.getText();
            String id = poleId.getText();

            Uzivatel uzivatel = new Uzivatel(jmeno, prijmeni, email, heslo, telefon, id, adresa);

            SpravceUzivatelu spravce = new SpravceUzivatelu();
            spravce.ulozUzivatele(uzivatel);

            JOptionPane.showMessageDialog(this, "Uživatel byl úspěšně registrován:\n" + uzivatel.toString());
            dispose();

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Chyba: " + e.getMessage());
        }
    }
}