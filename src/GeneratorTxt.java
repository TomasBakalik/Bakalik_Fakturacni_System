import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Tato třída slouží k vytvoření a uložení faktury do textového souboru.
 * Vytvoří jednoduchý textový soubor s údaji o faktuře, který si uživatel může uložit do počítače.
 */
public class GeneratorTxt {

    /**
     * Tato metoda uloží fakturu do počítače do souboru, který si uživatel sám vybere.
     * Faktura se ukládá jako textový soubor podle jednoduché šablony.
     * Pokud se faktura uloží úspěšně, zobrazí se zpráva o úspěchu.
     * Když nastane chyba při ukládání, zobrazí se chybová hláška.
     */
    public void ulozFakturu(Faktura faktura, String jmeno, String prijmeni, String ico, String adresa, String telefon, String email){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File("faktura_" + faktura.getCisloFaktury() + ".txt"));

        int vysledek = fileChooser.showOpenDialog(null);

        if(vysledek == JFileChooser.APPROVE_OPTION){
            File soubor = fileChooser.getSelectedFile();

            try{
                FileWriter fw = new FileWriter(soubor);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write("FAKTURA – DANOVY DOKLAD");
                bw.newLine();
                bw.newLine();

                bw.write("Vystavitel:");
                bw.newLine();
                bw.write("Jméno: " + jmeno + " " + prijmeni);
                bw.newLine();
                bw.write("IČO: " + ico);
                bw.newLine();
                bw.write("Adresa: " + adresa);
                bw.newLine();
                bw.write("Telefon: " + telefon);
                bw.newLine();
                bw.write("Email: " + email);
                bw.newLine();
                bw.newLine();

                bw.write("Odběratel:");
                bw.newLine();
                bw.write(faktura.getKlient().toString());
                bw.newLine();
                bw.newLine();

                bw.write("Faktura c.: " + faktura.getCisloFaktury());
                bw.newLine();
                bw.write("Datum vystavení: " + faktura.getDatumVystaveni());
                bw.newLine();
                bw.write("Datum splatnosti: " + faktura.getDatumSplatnosti());
                bw.newLine();
                bw.newLine();

                if (!faktura.getSeznamPolozek().isEmpty()) {
                    PolozkaFaktury p = faktura.getSeznamPolozek().get(0);
                    bw.write("Popis: " + p.getNazev());
                    bw.newLine();
                    bw.write("Cena celkem: " + faktura.spocitejCelkovaCena() + " Kc");
                    bw.newLine();
                } else {
                    bw.write("Popis: -");
                    bw.newLine();
                    bw.write("Cena celkem: -");
                    bw.newLine();
                }

                bw.newLine();
                bw.write("Nejsme plátci DPH.");
                bw.newLine();

                bw.close();
                fw.close();

                JOptionPane.showMessageDialog(null, "Faktura byla uložena jako TXT.");

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Chyba při ukládání faktury: " + e.getMessage());
            }
        }
    }
}
