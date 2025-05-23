package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Prijava {
    private int id;
    private LocalDate datumPrijave;
    private String klijent;
    private String email;
    private String telefon;
    private LocalDate datumRodjenja;
    private String pol;
    private boolean ranijeIskustvo;
    private String opisProblema;

    public Prijava() {}

    public Prijava(ResultSet rs) throws SQLException {
        this.id = rs.getInt("prijava_id");
        this.datumPrijave = rs.getDate("datum_prijave").toLocalDate();
        this.klijent = rs.getString("klijent_ime") + " " + rs.getString("klijent_prezime");
        this.email = rs.getString("email");
        this.telefon = rs.getString("telefon");
        this.datumRodjenja = rs.getDate("datum_rodjenja").toLocalDate();
        this.pol = rs.getString("pol");
        this.ranijeIskustvo = rs.getBoolean("ranije_iskustvo");
        this.opisProblema = rs.getString("opis_problema");
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getDatumPrijave() { return datumPrijave; }
    public void setDatumPrijave(LocalDate datumPrijave) { this.datumPrijave = datumPrijave; }

    public String getKlijent() { return klijent; }
    public void setKlijent(String klijent) { this.klijent = klijent; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }

    public LocalDate getDatumRodjenja() { return datumRodjenja; }
    public void setDatumRodjenja(LocalDate datumRodjenja) { this.datumRodjenja = datumRodjenja; }

    public String getPol() { return pol; }
    public void setPol(String pol) { this.pol = pol; }

    public boolean isRanijeIskustvo() { return ranijeIskustvo; }
    public void setRanijeIskustvo(boolean ranijeIskustvo) { this.ranijeIskustvo = ranijeIskustvo; }

    public String getOpisProblema() { return opisProblema; }
    public void setOpisProblema(String opisProblema) { this.opisProblema = opisProblema; }
} 