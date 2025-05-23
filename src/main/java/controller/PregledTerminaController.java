package controller;

import model.Termin;
import model.utility.JDBCUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class PregledTerminaController {
    
    public ObservableList<Termin> vratiSveTermine() {
        String sql = """
                SELECT t.termin_id, t.datum, t.vreme, t.trajanje,
                       k.ime as klijent_ime, k.prezime as klijent_prezime
                FROM termin t
                JOIN klijent k ON t.klijent_id = k.klijent_id
                WHERE t.psihoterapeut_id = ? AND t.datum >= ?
                ORDER BY t.datum ASC, t.vreme ASC
                """;
                
        ObservableList<Termin> termini = FXCollections.observableArrayList();
        
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // TODO: Implementirati čuvanje trenutno prijavljenog psihoterapeuta
            pstmt.setInt(1, 1); // Privremeno hardkodirano
            pstmt.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                termini.add(new Termin(rs));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return termini;
    }
} 