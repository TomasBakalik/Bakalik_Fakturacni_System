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

        setLayout(new BorderLayout());
        add(panelFormular, BorderLayout.CENTER);
    }

}
