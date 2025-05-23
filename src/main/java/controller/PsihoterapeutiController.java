package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Psihoterapeut;
import model.utility.JDBCUtils;
import java.sql.*;
import java.time.LocalDate;

public class PsihoterapeutiController {
    public ObservableList<Psihoterapeut> vratiSvePsihoterapeute() {
        String sql = "SELECT * FROM psihoterapeut ORDER BY prezime";
        ObservableList<Psihoterapeut> psihoterapeuti = FXCollections.observableArrayList();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                psihoterapeuti.add(new Psihoterapeut(rs));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
             try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
             } catch (SQLException e) {
                e.printStackTrace();
             }
        }
        
        return psihoterapeuti;
    }

    public ObservableList<Psihoterapeut> pretraziPsihoterapeute(String tekst, String kriterijum) {
        ObservableList<Psihoterapeut> psihoterapeuti = FXCollections.observableArrayList();
        String query = "SELECT * FROM psihoterapeut WHERE " + kriterijum + " LIKE ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(query);

            pstmt.setString(1, "%" + tekst + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                psihoterapeuti.add(new Psihoterapeut(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
             try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
             } catch (SQLException e) {
                e.printStackTrace();
             }
        }

        return psihoterapeuti;
    }

    public boolean dodajPsihoterapeuta(Psihoterapeut psihoterapeut) {
        String sql = "{CALL sp_kreiraj_psihoterapeuta(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        
        Connection conn = null;
        CallableStatement cstmt = null;
        
        try {
            conn = JDBCUtils.getConnection();
            cstmt = conn.prepareCall(sql);
            
            // Set parameters for the stored procedure (14 IN + 1 OUT)
            cstmt.setString(1, psihoterapeut.getIme());
            cstmt.setString(2, psihoterapeut.getPrezime());
            cstmt.setString(3, psihoterapeut.getEmail());
            cstmt.setString(4, psihoterapeut.getTelefon());
            cstmt.setString(5, psihoterapeut.getJmbg());
            cstmt.setString(6, psihoterapeut.getLozinka());
            cstmt.setDate(7, Date.valueOf(psihoterapeut.getDatumRodjenja()));
            cstmt.setString(8, psihoterapeut.getPrebivaliste());
            cstmt.setInt(9, psihoterapeut.getStepenId());
            cstmt.setInt(10, psihoterapeut.getFakultetId());
            cstmt.setInt(11, psihoterapeut.getCentarId());
            cstmt.setInt(12, psihoterapeut.getStatusId());
            cstmt.setBoolean(13, psihoterapeut.isPsiholog());
            cstmt.setBoolean(14, psihoterapeut.isSupervizor());
            cstmt.registerOutParameter(15, Types.INTEGER); // Register OUT parameter
            
            // Log the parameters being passed
            System.out.println("Calling sp_kreiraj_psihoterapeuta with parameters:");
            System.out.println("1. Ime: " + psihoterapeut.getIme());
            System.out.println("2. Prezime: " + psihoterapeut.getPrezime());
            System.out.println("3. Email: " + psihoterapeut.getEmail());
            System.out.println("4. Telefon: " + psihoterapeut.getTelefon());
            System.out.println("5. JMBG: " + psihoterapeut.getJmbg());
            System.out.println("6. Lozinka: [HIDDEN]");
            System.out.println("7. Datum ro\u0111enja: " + psihoterapeut.getDatumRodjenja());
            System.out.println("8. Prebivaliste: " + psihoterapeut.getPrebivaliste());
            System.out.println("9. Stepen ID: " + psihoterapeut.getStepenId());
            System.out.println("10. Fakultet ID: " + psihoterapeut.getFakultetId());
            System.out.println("11. Centar ID: " + psihoterapeut.getCentarId());
            System.out.println("12. Status ID: " + psihoterapeut.getStatusId());
            System.out.println("13. Is Psiholog: " + psihoterapeut.isPsiholog());
            System.out.println("14. Is Supervizor: " + psihoterapeut.isSupervizor());
            
            // Execute the stored procedure
            cstmt.execute();

            // You can optionally retrieve the OUT parameter value here
            // int noviId = cstmt.getInt(15);
            // System.out.println("New Psihoterapeut ID: " + noviId);
            
            return true;
            
        } catch (SQLException e) {
            System.err.println("Error calling sp_kreiraj_psihoterapeuta: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
             try {
                if (cstmt != null) cstmt.close();
             } catch (SQLException e) {
                e.printStackTrace();
             }
        }
    }
}
