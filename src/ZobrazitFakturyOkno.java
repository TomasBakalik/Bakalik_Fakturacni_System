import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * Tato třída zobrazí okno s tabulkou, ve které jsou vypsané všechny faktury uživatele, který je přihlášený.
 */
public class ZobrazitFakturyOkno extends JFrame {

    private Uzivatel prihlasenyUzivatel;
    private SpravceFaktur spravceFaktur;
    private JTable tabulka;

    public ZobrazitFakturyOkno(Uzivatel uzivatel, SpravceFaktur spravceFaktur) {
        this.prihlasenyUzivatel = uzivatel;
        this.spravceFaktur = spravceFaktur;
        nastavOkno();
        nacistFakturyUzivatele();
        setVisible(true);
    }

    /**
     * Nastaví vzhled okna, vytvoří tabulku s názvy sloupců a vloží vše do okna.
     */
    public void nastavOkno() {
        setTitle("Moje faktury");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        String[] sloupce = {"Cislo", "Datum vystaveni", "Splatnost", "Stav", "Cena celkem"};
        DefaultTableModel model = new DefaultTableModel(sloupce, 0);
        tabulka = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabulka);
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Načte faktury přihlášeného uživatele a zobrazí je do tabulky.
     * Pokud se žádná faktura nenajde, zobrazí se zpráva o tom, že nic nebylo nalezeno.
     */
    public void nacistFakturyUzivatele() {
        ArrayList<Faktura> faktury = spravceFaktur.ziskejVsechnyFaktury();
        DefaultTableModel model = (DefaultTableModel) tabulka.getModel();
        model.setRowCount(0);

        for (Faktura f : faktury) {
            Object[] radek = {
                    f.getCisloFaktury(),
                    f.getDatumVystaveni(),
                    f.getDatumSplatnosti(),
                    f.getStavFaktury(),
                    f.spocitejCelkovaCena() + " Kč"
            };
            model.addRow(radek);
        }

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Žádné faktury nebyly nalezeny.");
        }
    }
}
