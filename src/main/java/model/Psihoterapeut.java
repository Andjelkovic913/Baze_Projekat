package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Psihoterapeut {
    private int id;
    private String ime;
    private String prezime;
    private String oblast;
    private String sertifikat;
    private LocalDate datumSertifikacije;
    private String email;
    private String telefon;

    public Psihoterapeut() {
    }

    public Psihoterapeut(int id, String ime, String prezime, String email) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

    public Psihoterapeut(int id, String ime, String prezime, String oblast, String sertifikat, 
                        LocalDate datumSertifikacije, String email, String telefon) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.oblast = oblast;
        this.sertifikat = sertifikat;
        this.datumSertifikacije = datumSertifikacije;
        this.email = email;
        this.telefon = telefon;
    }

    public Psihoterapeut(ResultSet rs) throws SQLException {
        this.id = rs.getInt("psihoterapeut_id");
        this.ime = rs.getString("ime");
        this.prezime = rs.getString("prezime");
        this.oblast = rs.getString("oblast");
        this.sertifikat = rs.getString("sertifikat");
        this.datumSertifikacije = rs.getDate("datum_sertifikacije").toLocalDate();
        this.email = rs.getString("email");
        this.telefon = rs.getString("telefon");
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getOblast() {
        return oblast;
    }

    public void setOblast(String oblast) {
        this.oblast = oblast;
    }

    public String getSertifikat() {
        return sertifikat;
    }

    public void setSertifikat(String sertifikat) {
        this.sertifikat = sertifikat;
    }

    public LocalDate getDatumSertifikacije() {
        return datumSertifikacije;
    }

    public void setDatumSertifikacije(LocalDate datumSertifikacije) {
        this.datumSertifikacije = datumSertifikacije;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
}
