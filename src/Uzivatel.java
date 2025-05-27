/**
 * Tato třída slouží pro uchování informací o jednom uživateli.
 * Obsahuje jeho jméno, příjmení, e-mail, heslo, telefon, ID a adresu.
 * Při vytváření i úpravách údajů se kontroluje, jestli jsou správně zadané (regex).
 */
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
        if (jmeno.matches("[A-Z][a-z]{1,20}")) {
            this.jmeno = jmeno;
        } else {
            throw new IllegalArgumentException("Neplatné jméno");
        }
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        if (prijmeni.matches("[A-Z][a-z]{1,20}")) {
            this.prijmeni = prijmeni;
        } else {
            throw new IllegalArgumentException("Neplatné příjmení");
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
        this.heslo = heslo;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        if (telefon.matches("[0-9]{9}")) {
            this.telefon = telefon;
        } else {
            throw new IllegalArgumentException("Neplatné telefonní číslo.");
        }
    }

    public String getIdUzivatele() {
        return idUzivatele;
    }

    public void setIdUzivatele(String idUzivatele) {
        if (idUzivatele.matches("[0-9]{5}")) {
            this.idUzivatele = idUzivatele;
        } else {
            throw new IllegalArgumentException("Neplatné ID uživatele.");
        }
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        if (adresa != null && !adresa.isEmpty()) {
            this.adresa = adresa;
        } else {
            throw new IllegalArgumentException("Neplatná adresa.");
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

    /**
     * Porovná zadané heslo s uloženým heslem uživatele.
     * @param heslo Heslo zadané při přihlášení.
     * @return Vrací true, pokud se hesla shodují, vrací false pokud ne.
     */
    public boolean jeSpravneHeslo(String heslo) {
        return this.heslo.equals(heslo);
    }
}