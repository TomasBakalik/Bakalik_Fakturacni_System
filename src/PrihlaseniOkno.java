import javax.swing.*;
import java.awt.*;

public class PrihlaseniOkno extends JFrame {

    private JTextField poleEmail;
    private JPasswordField poleHeslo;
    private JButton tlacitkoPrihlasit;
    private SpravceFaktur spravceFaktur;

    public PrihlaseniOkno(SpravceFaktur spravceFaktur) {
        this.spravceFaktur = spravceFaktur;
        nastavOkno();
    }

    private void nastavOkno() {
        setTitle("Přihlášení uživatele");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel panelFormular = new JPanel(new GridLayout(2, 2, 10, 10));
        panelFormular.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20));

        panelFormular.add(new JLabel("Email:"));
        poleEmail = new JTextField();
        panelFormular.add(poleEmail);

        panelFormular.add(new JLabel("Heslo:"));
        poleHeslo = new JPasswordField();
        panelFormular.add(poleHeslo);

        tlacitkoPrihlasit = new JButton("Přihlásit se");
        tlacitkoPrihlasit.setBackground(new Color(0, 153, 0));
        tlacitkoPrihlasit.setForeground(Color.WHITE);
        tlacitkoPrihlasit.setFont(new Font("Arial", Font.BOLD, 14));
        tlacitkoPrihlasit.setFocusPainted(false);
        tlacitkoPrihlasit.setPreferredSize(new Dimension(400, 45));

        tlacitkoPrihlasit.addActionListener(e -> prihlas());

        JPanel panelTlacitko = new JPanel(new BorderLayout());
        panelTlacitko.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        panelTlacitko.add(tlacitkoPrihlasit, BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(panelFormular, BorderLayout.CENTER);
        add(panelTlacitko, BorderLayout.SOUTH);
    }

    private void prihlas() {
        String email = poleEmail.getText();
        String heslo = new String(poleHeslo.getPassword());

        SpravceUzivatelu spravce = new SpravceUzivatelu();
        Uzivatel uzivatel = spravce.prihlas(email, heslo);

        if (uzivatel != null) {
            spravceFaktur.nacistFakturyZeSouboru(uzivatel.getEmail());

            JOptionPane.showMessageDialog(this, "Vítej zpět, " + uzivatel.getJmeno() + "!");
            dispose();
            UzivatelMenuOkno menu = new UzivatelMenuOkno(uzivatel, spravceFaktur);
            menu.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Neplatný email nebo heslo.");
        }
    }

}
