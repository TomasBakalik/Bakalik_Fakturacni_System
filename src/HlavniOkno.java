import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HlavniOkno extends JFrame {

    private JButton tlacitkoVystavit;
    private JButton tlacitkoRegistrovat;
    private JButton tlacitkoPrihlasit;
    private SpravceFaktur spravceFaktur;

    public HlavniOkno(){
        nastavOkno();
        setVisible(true);
    }

    public void nastavOkno(){
        setTitle("Fakturační Systém");
        setSize(1200,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        ImageIcon pozadiObrazek = new ImageIcon(getClass().getResource("/pozadi.jpg"));

        JLabel pozadi = new JLabel(pozadiObrazek);

        JPanel panel = new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                if(pozadiObrazek != null){
                    g.drawImage(pozadiObrazek.getImage(), 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        panel.setLayout(new BorderLayout());
        setContentPane(panel);

        tlacitkoVystavit = vytvorTlacitko("Vystavit fakturu", new Color(59, 89, 152));
        tlacitkoRegistrovat = vytvorTlacitko("Registrovat", new Color(72, 133, 237));
        tlacitkoPrihlasit = vytvorTlacitko("Příhlásit se", new Color(0, 153, 51));

        JPanel panelTlacitek = new JPanel();
        panelTlacitek.setOpaque(false);
        panelTlacitek.setLayout(new GridLayout(3,1, 0, 20));
        panelTlacitek.add(tlacitkoVystavit);
        panelTlacitek.add(tlacitkoRegistrovat);
        panelTlacitek.add(tlacitkoPrihlasit);

        JPanel panelStred = new JPanel(new GridBagLayout());
        panelStred.setOpaque(false);
        panelStred.setBorder(BorderFactory.createEmptyBorder(20,100,20,100));
        panelStred.add(panelTlacitek);

        panel.add(panelStred, BorderLayout.CENTER);

        tlacitkoVystavit.addActionListener(e -> otevrtiFormular());
        tlacitkoRegistrovat.addActionListener(e -> new RegistraceOkno().setVisible(true));
        tlacitkoPrihlasit.addActionListener(e -> new PrihlaseniOkno(spravceFaktur).setVisible(true));

    }

    public JButton vytvorTlacitko(String text, Color barvaPozadi){
        JButton tlacitko = new JButton(text);
        tlacitko.setPreferredSize(new Dimension(250, 50));
        tlacitko.setFont(new Font("Arial", Font.BOLD, 20));
        tlacitko.setForeground(Color.WHITE);
        tlacitko.setBackground(barvaPozadi);
        tlacitko.setFocusPainted(false);
        return tlacitko;
    }

    public void otevrtiFormular(){
        FormularFaktura formular = new FormularFaktura();
        formular.setVisible(true);
    }
}
