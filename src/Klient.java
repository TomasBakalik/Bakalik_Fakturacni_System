/**
 * Tato třída slouží k uchování údajů o klientovi, kterému je vystavena faktura.
 * Obsahuje jméno, příjmení, adresu, IČO, telefonní číslo a e-mail.
 * Zároveň provádí základní kontrolu zadaných údajů pomocí regexů.
 */

public class Klient {
    private String jmeno;
    private String prijmeni;
    private String adresa;
    private String ico;
    private String telefonniCislo;
    private String email;

    public Klient(String jmeno, String prijmeni, String adresa, String ico, String telefonniCislo, String email) {
        setJmeno(jmeno);
        setPrijmeni(prijmeni);
        setAdresa(adresa);
        setIco(ico);
        setTelefonniCislo(telefonniCislo);
        setEmail(email);
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        if (jmeno == null || !jmeno.matches("[A-Z][a-z]{1,20}")) {
            throw new IllegalArgumentException("Neplatné jméno.");
        } else {
            this.jmeno = jmeno;
        }
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        if (prijmeni == null || !prijmeni.matches("[A-Z][a-z]{1,20}")) {
            throw new IllegalArgumentException("Neplatné příjmení.");
        } else {
            this.prijmeni = prijmeni;
        }
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        if (adresa == null || adresa.isEmpty()) {
            throw new IllegalArgumentException("Neplatná adresa.");
        } else {
            this.adresa = adresa;
        }
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        if (ico == null || !ico.matches("\\d{8}")) {
            throw new IllegalArgumentException("Neplatne IČO.");
        } else {
            this.ico = ico;
        }
    }

    public String getTelefonniCislo() {
        return telefonniCislo;
    }

    public void setTelefonniCislo(String telefonniCislo) {
        if (telefonniCislo == null || !telefonniCislo.matches("\\d{9}")) {
            throw new IllegalArgumentException("Neplatné telefonní číslo.");
        } else {
            this.telefonniCislo = telefonniCislo;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new IllegalArgumentException("Neplatný email.");
        } else {
            this.email = email;
        }
    }

    @Override
    public String toString() {
        return "Jmeno: " + jmeno + " " + prijmeni + "\n" +
                "ICO: " + ico + "\n" +
                "Adresa: " + adresa + "\n" +
                "Telefon: " + telefonniCislo + "\n" +
                "Email: " + email;
    }
}
