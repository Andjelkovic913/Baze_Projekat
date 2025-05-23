package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Termin {
    private int id;
    private LocalDate datum;
    private LocalTime vreme;
    private String klijent;
    private int trajanje;

    public Termin() {}

    public Termin(ResultSet rs) throws SQLException {
        this.id = rs.getInt("termin_id");
        this.datum = rs.getDate("datum").toLocalDate();
        this.vreme = rs.getTime("vreme").toLocalTime();
        this.klijent = rs.getString("klijent_ime") + " " + rs.getString("klijent_prezime");
        this.trajanje = rs.getInt("trajanje");
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getDatum() { return datum; }
    public void setDatum(LocalDate datum) { this.datum = datum; }

    public LocalTime getVreme() { return vreme; }
    public void setVreme(LocalTime vreme) { this.vreme = vreme; }

    public String getKlijent() { return klijent; }
    public void setKlijent(String klijent) { this.klijent = klijent; }

    public int getTrajanje() { return trajanje; }
    public void setTrajanje(int trajanje) { this.trajanje = trajanje; }
} 