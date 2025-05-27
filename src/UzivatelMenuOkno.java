import javax.swing.*;
import java.awt.*;

/**
 * Tato třída zobrazuí menu poté, co se uživatel přihláší.
 * Uživatel si zde může vybrat, jestli chce vystavit novou fakturu nebo zobrazit ty, které už vytvořil.
 */
public class UzivatelMenuOkno extends JFrame {

    private Uzivatel prihlasenyUzivatel;
    private SpravceFaktur spravceFaktur;
    private JButton tlacitkoVystavit;
    private JButton tlacitkoZobrazit;

    public UzivatelMenuOkno(Uzivatel uzivatel, SpravceFaktur spravceFaktur) {
        this.prihlasenyUzivatel = uzivatel;
        this.spravceFaktur = spravceFaktur;
        nastavOkno();
        setVisible(true);
    }

    /**
     * Nastaví vzhled okna pro uživatele a přidá dvě tlačítka: jedno pro vystavení faktury a druhé pro zobrazení předchozích faktur.
     * Každé tlačítko otevírá nové okno podle vybrané akce.
     */
    public void nastavOkno() {
        setTitle("Uživatelské menu");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel nadpis = new JLabel("Vítej, " + prihlasenyUzivatel.getJmeno() + "!", SwingConstants.CENTER);
        nadpis.setFont(new Font("Arial", Font.BOLD, 24));
        add(nadpis, BorderLayout.NORTH);

        tlacitkoVystavit = new JButton("Vystavit novou fakturu");
        tlacitkoZobrazit = new JButton("Zobrazit moje faktury");

        tlacitkoVystavit.setFont(new Font("Arial", Font.BOLD, 18));
        tlacitkoVystavit.setBackground(new Color(59, 89, 152));
        tlacitkoVystavit.setForeground(Color.WHITE);

        tlacitkoZobrazit.setFont(new Font("Arial", Font.BOLD, 18));
        tlacitkoZobrazit.setBackground(new Color(231, 76, 60));
        tlacitkoZobrazit.setForeground(Color.WHITE);

        JPanel panelTlacitek = new JPanel(new GridLayout(2, 1, 10, 10));
        panelTlacitek.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        add(panelTlacitek, BorderLayout.CENTER);

        tlacitkoVystavit.addActionListener(e -> new FormularFaktura(prihlasenyUzivatel, spravceFaktur));
        tlacitkoZobrazit.addActionListener(e -> new ZobrazitFakturyOkno(prihlasenyUzivatel, spravceFaktur));
    }
}
