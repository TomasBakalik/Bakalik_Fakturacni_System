public class PolozkaFaktury {

    private String nazev;
    private int pocetKusu;
    private double cenaZaKus;
    private double cenaCelkova;

    public PolozkaFaktury(String nazev, int pocetKusu, double cenaZaKus) {
        setNazev(nazev);
        setPocetKusu(pocetKusu);
        setCenaZaKus(cenaZaKus);
        vypocitejCelkovaCena();
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        if(nazev == null || nazev.isEmpty()){
            throw new IllegalArgumentException("Název nesmí být prázdný.");
        }else{
            this.nazev = nazev;
        }
    }

    public int getPocetKusu() {
        return pocetKusu;
    }

    public void setPocetKusu(int pocetKusu) {
        if(pocetKusu <= 0){
            throw new IllegalArgumentException("Počet kusů musí být větší než 0.");
        }else{
            this.pocetKusu = pocetKusu;
        }
    }

    public double getCenaZaKus() {
        return cenaZaKus;
    }

    public void setCenaZaKus(double cenaZaKus) {
        if(cenaZaKus < 0){
            throw new IllegalArgumentException("Cena za kus nesmí být záporná.");
        }else{
            this.cenaZaKus = cenaZaKus;
        }
    }

    public double getCenaCelkova() {
        return cenaCelkova;
    }

    public void vypocitejCelkovaCena() {
        this.cenaCelkova = this.pocetKusu * this.cenaZaKus;
    }

    @Override
    public String toString() {
        return "PolozkaFaktury{" +
                "nazev='" + nazev + '\'' +
                ", pocetKusu=" + pocetKusu +
                ", cenaZaKus=" + cenaZaKus +
                ", cenaCelkova=" + cenaCelkova +
                '}';
    }
}
