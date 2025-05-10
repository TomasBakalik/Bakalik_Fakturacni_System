import javax.swing.*;
import java.awt.*;

public class FormularFaktura extends JFrame{

    private JTextField poleJmeno;
    private JTextField polePrijmeni;
    private JTextField poleAdresa;
    private JTextField poleIco;
    private JTextField poleTelefon;
    private JTextField poleEmail;
    private JTextField poleNazevPolozky;
    private JTextField polePocetKusu;
    private JTextField poleCenaZaKus;
    private JTextField poleVystavitelJmeno;
    private JTextField poleVystavitelPrijmeni;
    private JTextField poleVystavitelIco;
    private JTextField poleVystavitelAdresa;
    private JTextField poleVystavitelTelefon;
    private JTextField poleVystavitelEmail;
    private JButton tlacitkoStahnout;

    public FormularFaktura(){
        nastavOkno();
    }

    public void nastavOkno(){
        setTitle("Vystavit fakturu");
        setSize(600, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(16, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Jméno vystavitele:"));
        poleVystavitelJmeno = new JTextField();
        panel.add(poleVystavitelJmeno);

        panel.add(new JLabel("Příjmení vystavitele:"));
        poleVystavitelPrijmeni = new JTextField();
        panel.add(poleVystavitelPrijmeni);

        panel.add(new JLabel("IČO vystavitele:"));
        poleVystavitelIco = new JTextField();
        panel.add(poleVystavitelIco);

        panel.add(new JLabel("Adresa vystavitele:"));
        poleVystavitelAdresa = new JTextField();
        panel.add(poleVystavitelAdresa);

        panel.add(new JLabel("Telefon vystavitele:"));
        poleVystavitelTelefon = new JTextField();
        panel.add(poleVystavitelTelefon);

        panel.add(new JLabel("Email vystavitele:"));
        poleVystavitelEmail = new JTextField();
        panel.add(poleVystavitelEmail);

        panel.add(new JLabel("Jméno klienta:"));
        poleJmeno = new JTextField();
        panel.add(poleJmeno);

        panel.add(new JLabel("Příjmení klienta:"));
        polePrijmeni = new JTextField();
        panel.add(polePrijmeni);

        panel.add(new JLabel("Adresa klienta:"));
        poleAdresa = new JTextField();
        panel.add(poleAdresa);

        panel.add(new JLabel("IČO klienta:"));
        poleIco = new JTextField();
        panel.add(poleIco);

        panel.add(new JLabel("Telefon klienta:"));
        poleTelefon = new JTextField();
        panel.add(poleTelefon);

        panel.add(new JLabel("Email klienta:"));
        poleEmail = new JTextField();
        panel.add(poleEmail);

        panel.add(new JLabel("Název položky:"));
        poleNazevPolozky = new JTextField();
        panel.add(poleNazevPolozky);

        panel.add(new JLabel("Počet kusů:"));
        polePocetKusu = new JTextField();
        panel.add(polePocetKusu);

        panel.add(new JLabel("Cena za kus:"));
        poleCenaZaKus = new JTextField();
        panel.add(poleCenaZaKus);

        tlacitkoStahnout = new JButton("Stáhnout fakturu");
        tlacitkoStahnout.setPreferredSize(new Dimension(100, 50));
        tlacitkoStahnout.setBackground(new Color(51, 102, 153));
        tlacitkoStahnout.setForeground(Color.WHITE);
        tlacitkoStahnout.setFont(new Font("Arial", Font.BOLD, 16));
        tlacitkoStahnout.setFocusPainted(false);
        tlacitkoStahnout.setPreferredSize(new Dimension(getWidth(), 50));


        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(tlacitkoStahnout, BorderLayout.SOUTH);

    }
}
