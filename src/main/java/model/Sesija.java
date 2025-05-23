package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Sesija {
    private int id;
    private LocalDate datum;
    private LocalTime vreme;
    private int trajanje;
    private String klijent;
    private String belezke;

    public Sesija() {}

    public Sesija(ResultSet rs) throws SQLException {
        this.id = rs.getInt("sesija_id");
        this.datum = rs.getDate("datum").toLocalDate();
        this.vreme = rs.getTime("vreme").toLocalTime();
        this.trajanje = rs.getInt("trajanje");
        this.klijent = rs.getString("klijent_ime") + " " + rs.getString("klijent_prezime");
        this.belezke = rs.getString("belezke");
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getDatum() { return datum; }
    public void setDatum(LocalDate datum) { this.datum = datum; }

    public LocalTime getVreme() { return vreme; }
    public void setVreme(LocalTime vreme) { this.vreme = vreme; }

    public int getTrajanje() { return trajanje; }
    public void setTrajanje(int trajanje) { this.trajanje = trajanje; }

    public String getKlijent() { return klijent; }
    public void setKlijent(String klijent) { this.klijent = klijent; }

    public String getBelezke() { return belezke; }
    public void setBelezke(String belezke) { this.belezke = belezke; }
} 