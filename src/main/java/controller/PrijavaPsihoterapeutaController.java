package controller;

import model.utility.JDBCUtils;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class PrijavaPsihoterapeutaController {
    
    public boolean prijaviPsihoterapeuta(String email, String lozinka) {
        String sql = "{ CALL sp_prijava_psihoterapeuta(?,?,?) }";
                
        Connection conn = null;
        CallableStatement cstmt = null;
        ResultSet rs = null; // Although procedure might not return a result set, keep for safety
        
        try {
            conn = JDBCUtils.getConnection();
            cstmt = conn.prepareCall(sql);
            
            // Set IN parameters
            cstmt.setString(1, email);
            cstmt.setString(2, lozinka);

            // Register OUT parameter (assuming ID is the 3rd parameter)
            cstmt.registerOutParameter(3, Types.INTEGER); // ID
            
            // Execute the stored procedure
            cstmt.execute();
            
            // Retrieve OUT parameter values
            int psihoterapeutId = cstmt.getInt(3);
            
            // Log retrieved values (optional, for debugging)
            System.out.println("Stored procedure sp_prijava_psihoterapeuta executed.");
            System.out.println("Returned ID: " + psihoterapeutId);

            // Check if login was successful based on returned ID
            return psihoterapeutId > 0; // Assuming ID > 0 indicates success
            
        } catch (SQLException e) {
            System.err.println("Error calling sp_prijava_psihoterapeuta: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null) rs.close(); // Close ResultSet if any
                if (cstmt != null) cstmt.close(); // Close CallableStatement
                // Do NOT close the connection here
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
} 