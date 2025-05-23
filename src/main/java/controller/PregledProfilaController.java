package controller;

import model.Psihoterapeut;
import model.utility.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PregledProfilaController {
    
    public Psihoterapeut vratiPodatkePsihoterapeuta() {
        String sql = """
                SELECT psihoterapeut_id, ime, prezime, oblast, sertifikat, 
                       datum_sertifikacije, email, telefon
                FROM psihoterapeut 
                WHERE email = ?
                """;
                
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // TODO: Implementirati čuvanje trenutno prijavljenog psihoterapeuta
            pstmt.setString(1, "test@example.com"); // Privremeno hardkodirano
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Psihoterapeut(rs);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
} 