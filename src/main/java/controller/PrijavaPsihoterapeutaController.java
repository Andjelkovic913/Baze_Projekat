package controller;

import model.utility.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrijavaPsihoterapeutaController {
    
    public boolean prijaviPsihoterapeuta(String email, String lozinka) {
        String sql = """
                SELECT COUNT(*) FROM psihoterapeut 
                WHERE email = ? AND lozinka = ?
                """;
                
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, email);
            pstmt.setString(2, lozinka); // TODO: Implementirati hashovanje lozinke
            
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                // Do NOT close the connection here
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return false;
    }
} 