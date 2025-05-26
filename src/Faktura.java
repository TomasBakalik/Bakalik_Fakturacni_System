import java.util.ArrayList;
import java.util.Date;

/**
 * Tato třída reprezentuje jednu fakturu. Obsahuje údaje o klientovi, datumu, položkách, stavu a celkové částce.
 */
public class Faktura {

    private String cisloFaktury;
    private Klient klient;
    private ArrayList<PolozkaFaktury> seznamPolozek;
    private Date datumVystaveni;
    private Date datumSplatnosti;
    private StavFaktury stavFaktury;
    private String emailVystavitele;
    private double castkaCelkova;

    public Faktura(String cisloFaktury, Klient klient, Date datumVystaveni, Date datumSplatnosti, String emailVystavitele) {
        setCisloFaktury(cisloFaktury);
        setKlient(klient);
        seznamPolozek = new ArrayList<>();
        setDatumVystaveni(datumVystaveni);
        setDatumSplatnosti(datumSplatnosti);
        setEmailVystavitele(emailVystavitele);
        stavFaktury = StavFaktury.NEZAPLACENA;
    }

    public String getCisloFaktury() {
        return cisloFaktury;
    }

    public void setCisloFaktury(String cisloFaktury) {
        if(cisloFaktury == null || cisloFaktury.isEmpty()){
            throw new IllegalArgumentException("Číslo faktury nesmí být prázdné.");
        }else{
            this.cisloFaktury = cisloFaktury;
        }
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        if (klient == null) {
            throw new IllegalArgumentException("Klient nesmí být null");
        } else {
            this.klient = klient;
        }
    }
    public ArrayList<PolozkaFaktury> getSeznamPolozek() {
        return seznamPolozek;
    }

    /**
     * Tato metoda přidá položku do seznamu položek ve faktuře. Když bude položka null vyhodí se chyba.
     */
    public void pridatPolozku(PolozkaFaktury polozka){
        if(polozka == null){
            throw new IllegalArgumentException("Položka nesmí být null");
        }else{
            seznamPolozek.add(polozka);
        }
    }

    public Date getDatumVystaveni() {
        return datumVystaveni;
    }

    public void setDatumVystaveni(Date datumVystaveni) {
        if(datumVystaveni == null){
            throw new IllegalArgumentException("Datum vystavení nesmí být null");
        }else{
            this.datumVystaveni = datumVystaveni;
        }
    }

    public Date getDatumSplatnosti() {
        return datumSplatnosti;
    }

    public void setDatumSplatnosti(Date datumSplatnosti) {
        if(datumSplatnosti == null){
            throw new IllegalArgumentException("Datum splatnosti nesmí být null");
        }else{
            this.datumSplatnosti = datumSplatnosti;
        }
    }

    public StavFaktury getStavFaktury() {
        return stavFaktury;
    }

    public void setStavFaktury(StavFaktury stavFaktury) {
        if(stavFaktury == null){
            throw new IllegalArgumentException("Stav faktury nesmí být null");
        }else{
            this.stavFaktury = stavFaktury;
        }
    }

    public String getEmailVystavitele() {
        return emailVystavitele;
    }

    public void setEmailVystavitele(String emailVystavitele) {
        if(emailVystavitele == null || emailVystavitele.isEmpty()){
            throw new IllegalArgumentException("Email vystavitele nesmí být prázdný");
        }else{
            this.emailVystavitele = emailVystavitele;
        }
    }

    public double getCastkaCelkova() {
        return castkaCelkova;
    }

    public void setCastkaCelkova(double castkaCelkova) {
        this.castkaCelkova = castkaCelkova;
    }

    /**
     * Spočítá celkovou cenu faktury podle toho, kolik faktura obsahuje položek.
     * @return Sečte ceny všech položek a následně to vrátí (celková cena).
     */
    public double spocitejCelkovaCena(){
        double celkem = 0;
        for(PolozkaFaktury polozka : seznamPolozek){
            celkem += polozka.getCenaCelkova();
        }
        return celkem;
    }

    @Override
    public String toString() {
        return "Faktura{" +
                "cisloFaktury='" + cisloFaktury + '\'' +
                ", klient=" + klient +
                ", seznamPolozek=" + seznamPolozek +
                ", datumVystaveni=" + datumVystaveni +
                ", datumSplatnosti=" + datumSplatnosti +
                ", stavFaktury=" + stavFaktury +
                ", emailVystavitele='" + emailVystavitele + '\'' +
                ", castkaCelkova=" + castkaCelkova +
                '}';
    }
}