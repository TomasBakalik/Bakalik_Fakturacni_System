public class Uzivatel {

    private String jmeno;
    private String prijmeni;
    private String email;
    private String heslo;
    private String telefon;
    private String idUzivatele;
    private String adresa;

    public Uzivatel(String jmeno, String prijmeni, String email, String heslo, String telefon, String idUzivatele, String adresa) {
        setJmeno(jmeno);
        setPrijmeni(prijmeni);
        setEmail(email);
        setHeslo(heslo);
        setTelefon(telefon);
        setIdUzivatele(idUzivatele);
        setAdresa(adresa);
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        if(jmeno == null || !jmeno.matches("[A-Z][a-z]+")){
            throw new IllegalArgumentException("Neplatné jméno.");
        }else{
            this.jmeno = jmeno;
        }
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        if(prijmeni == null || !prijmeni.matches("[A-Z][a-z]+")){
            throw new IllegalArgumentException("Neplatné příjmení.");
        }else{
            this.prijmeni = prijmeni;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Neplatný email");
        }
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        if (heslo == null || !heslo.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) {
            throw new IllegalArgumentException("Heslo musí obsahovat alespoň jedno velké písmeno, malé písmeno, číslici a mít minimálně 8 znaků.");
        } else {
            this.heslo = heslo;
        }
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        if(telefon == null || !telefon.matches("[0-9]{9}")){
            throw new IllegalArgumentException("Neplatné telefonní číslo.");
        }else{
            this.telefon = telefon;
        }
    }

    public String getIdUzivatele() {
        return idUzivatele;
    }

    public void setIdUzivatele(String idUzivatele) {
        if(telefon == null || !telefon.matches("[0-9]{5}")){
            throw new IllegalArgumentException("Neplatné telefonní číslo.");
        }else{
            this.idUzivatele = idUzivatele;
        }
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        if(adresa == null || adresa.isEmpty()){
            throw new IllegalArgumentException("Neplatná adresa.");
        }else{
            this.adresa = adresa;
        }
    }

    @Override
    public String toString() {
        return "Uzivatel{" +
                "jmeno='" + jmeno + '\'' +
                ", prijmeni='" + prijmeni + '\'' +
                ", email='" + email + '\'' +
                ", heslo='" + heslo + '\'' +
                ", telefon='" + telefon + '\'' +
                ", idUzivatele='" + idUzivatele + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}