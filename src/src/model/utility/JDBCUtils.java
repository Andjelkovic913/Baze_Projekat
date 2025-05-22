package model.utility;

import model.Psihoterapeut;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {
    private static Connection connection = null; // globalna promenljiva

    public static void connect() {
        if (connection != null) return;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/novi_pocetak?useSSL=false&serverTimezone=UTC",
                    "root",
                    ""
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Psihoterapeut> selectAllFromPsihoterapeut() {
        List<Psihoterapeut> terapeuti = new ArrayList<>();
        String query = "SELECT psihoterapeut_id, ime, prezime, email FROM psihoterapeut";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("psihoterapeut_id");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String email = rs.getString("email");
                Psihoterapeut p = new Psihoterapeut(id, ime, prezime, email);
                terapeuti.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return terapeuti;
    }
}
