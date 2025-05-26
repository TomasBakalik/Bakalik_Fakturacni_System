import javax.swing.*;
import java.awt.*;

/**
 * Tato třída zobrazuje přihlašovací okno pro uživatele.
 * Uživatel zde zadá svůj e-mail a heslo, aby se mohl přihlásit do mého systému a podívat se na své již vystavené faktury nebo vystavit novou fakturu.
 */
public class PrihlaseniOkno extends JFrame {

    private JTextField poleEmail;
    private JPasswordField poleHeslo;
    private JButton tlacitkoPrihlasit;
    private SpravceFaktur spravceFaktur;

    public PrihlaseniOkno(SpravceFaktur spravceFaktur) {
        this.spravceFaktur = spravceFaktur;
        nastavOkno();
        setVisible(true);
    }

    /**
     * Nastaví vzhled přihlašovacího okna, přidá formulářová pole a tlačítko pro přihlášení.
     * Po kliknutí na tlačítko se zavolá metoda pro ověření údajů.
     */
    public void nastavOkno() {
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
        panelTlacitko.add(tlacitkoPrihlasit, BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(panelFormular, BorderLayout.CENTER);
        add(panelTlacitko, BorderLayout.SOUTH);
    }

    /**
     * Získá zadaný e-mail a heslo, ověří je podle uživatelů uložených v souboru registrovaných uživatelů.
     * Pokud jsou údaje správné, načtou se jeho faktury a otevře se uživatelské menu.
     * Pokud ne, zobrazí se chybová hláška.
     */
    public void prihlas() {
        String email = poleEmail.getText();
        String heslo = new String(poleHeslo.getPassword());

        SpravceUzivatelu spravce = new SpravceUzivatelu();
        Uzivatel uzivatel = spravce.prihlas(email, heslo);

        if (uzivatel != null) {
            spravceFaktur.nacistFakturyZeSouboru(uzivatel.getEmail());

            JOptionPane.showMessageDialog(this, "Vítej zpět, " + uzivatel.getJmeno() + "!");
            dispose();
            UzivatelMenuOkno menu = new UzivatelMenuOkno(uzivatel, spravceFaktur);
        } else {
            JOptionPane.showMessageDialog(this, "Neplatný email nebo heslo.");
        }
    }

}
