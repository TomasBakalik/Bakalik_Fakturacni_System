import javax.swing.*;
import java.awt.*;

public class UzivatelMenuOkno extends JFrame {

    private Uzivatel prihlasenyUzivatel;
    private SpravceFaktur spravceFaktur;
    private JButton tlacitkoVystavit;
    private JButton tlacitkoZobrazit;

    public UzivatelMenuOkno(Uzivatel uzivatel, SpravceFaktur spravceFaktur) {
        this.prihlasenyUzivatel = uzivatel;
        this.spravceFaktur = spravceFaktur;
    }

}
