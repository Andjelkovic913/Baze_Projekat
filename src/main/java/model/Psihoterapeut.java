package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Psihoterapeut {
    private int id;
    private String ime;
    private String prezime;
    private String jmbg;
    private LocalDate datumRodjenja;
    private String prebivaliste;
    private String telefon;
    private String email;
    private String lozinka;
    private int stepenId;
    private int fakultetId;
    private int centarId;
    private int statusId;
    private boolean isPsiholog;
    private boolean isSupervizor;

    public Psihoterapeut() {
    }

    // Constructor for fetching data (adjusting for new fields)
    public Psihoterapeut(ResultSet rs) throws SQLException {
        this.id = rs.getInt("psihoterapeut_id");
        this.ime = rs.getString("ime");
        this.prezime = rs.getString("prezime");
        this.jmbg = rs.getString("jmbg");
        this.datumRodjenja = rs.getDate("datum_rodjenja").toLocalDate();
        this.prebivaliste = rs.getString("prebivaliste");
        this.telefon = rs.getString("telefon");
        this.email = rs.getString("email");
        this.lozinka = rs.getString("lozinka"); // Be cautious with fetching password
        this.stepenId = rs.getInt("stepen_id");
        this.fakultetId = rs.getInt("fakultet_id");
        this.centarId = rs.getInt("centar_id");
        this.statusId = rs.getInt("status_id");
        this.isPsiholog = rs.getBoolean("is_psiholog");
        this.isSupervizor = rs.getBoolean("is_supervizor");
    }

    // Getters and Setters for all fields
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getIme() { return ime; }
    public void setIme(String ime) { this.ime = ime; }

    public String getPrezime() { return prezime; }
    public void setPrezime(String prezime) { this.prezime = prezime; }

    public String getJmbg() { return jmbg; }
    public void setJmbg(String jmbg) { this.jmbg = jmbg; }

    public LocalDate getDatumRodjenja() { return datumRodjenja; }
    public void setDatumRodjenja(LocalDate datumRodjenja) { this.datumRodjenja = datumRodjenja; }

    public String getPrebivaliste() { return prebivaliste; }
    public void setPrebivaliste(String prebivaliste) { this.prebivaliste = prebivaliste; }

    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getLozinka() { return lozinka; }
    public void setLozinka(String lozinka) { this.lozinka = lozinka; }

    public int getStepenId() { return stepenId; }
    public void setStepenId(int stepenId) { this.stepenId = stepenId; }

    public int getFakultetId() { return fakultetId; }
    public void setFakultetId(int fakultetId) { this.fakultetId = fakultetId; }

    public int getCentarId() { return centarId; }
    public void setCentarId(int centarId) { this.centarId = centarId; }

    public int getStatusId() { return statusId; }
    public void setStatusId(int statusId) { this.statusId = statusId; }

    public boolean isPsiholog() { return isPsiholog; }
    public void setPsiholog(boolean psiholog) { isPsiholog = psiholog; }

    public boolean isSupervizor() { return isSupervizor; }
    public void setSupervizor(boolean supervizor) { isSupervizor = supervizor; }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
}
