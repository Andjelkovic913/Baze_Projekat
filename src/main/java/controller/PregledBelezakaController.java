package controller;

import model.Sesija;
import model.utility.JDBCUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PregledBelezakaController {
    
    public ObservableList<Sesija> vratiSveSeanse() {
        String sql = """
                SELECT s.sesija_id, s.datum, s.vreme, s.trajanje, 
                       k.ime as klijent_ime, k.prezime as klijent_prezime, s.belezke
                FROM sesija s
                JOIN klijent k ON s.klijent_id = k.klijent_id
                WHERE s.psihoterapeut_id = ?
                ORDER BY s.datum DESC, s.vreme DESC
                """;
                
        ObservableList<Sesija> sesije = FXCollections.observableArrayList();
        
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // TODO: Implementirati čuvanje trenutno prijavljenog psihoterapeuta
            pstmt.setInt(1, 1); // Privremeno hardkodirano
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                sesije.add(new Sesija(rs));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return sesije;
    }
} 