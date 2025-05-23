package controller;

import model.Prijava;
import model.utility.JDBCUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PregledPrijavaController {
    
    public ObservableList<Prijava> vratiSvePrijave() {
        String sql = """
                SELECT p.prijava_id, p.datum_prijave, 
                       k.ime as klijent_ime, k.prezime as klijent_prezime,
                       k.email, k.telefon, k.datum_rodjenja, k.pol,
                       p.ranije_iskustvo, p.opis_problema
                FROM prijava p
                JOIN klijent k ON p.klijent_id = k.klijent_id
                WHERE p.psihoterapeut_id = ?
                ORDER BY p.datum_prijave DESC
                """;
                
        ObservableList<Prijava> prijave = FXCollections.observableArrayList();
        
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // TODO: Implementirati čuvanje trenutno prijavljenog psihoterapeuta
            pstmt.setInt(1, 1); // Privremeno hardkodirano
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                prijave.add(new Prijava(rs));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return prijave;
    }
} 