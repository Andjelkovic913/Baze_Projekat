package model.utility;

import model.Psihoterapeut;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtils {
    private static final String URL =
            "jdbc:mysql://localhost:3306/novi_pocetak?useSSL=false&serverTimezone=UTC";
    private static final String USER = "appuser";
    private static final String PASS = "StrongPass123!";

    private static Connection connection;

    /** Pozovi jednom (npr. u MainApp.init()) */
    public static void connect() {
        if (connection != null) return;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            throw new RuntimeException("DB connect failed → " + e.getMessage(), e);
        }
    }

    /** Uvek zatvaraj resurse!  */
    public static List<Psihoterapeut> selectAllFromPsihoterapeut() {
        final String sql = """
                SELECT psihoterapeut_id, ime, prezime, email
                FROM psihoterapeut ORDER BY prezime
                """;
        List<Psihoterapeut> list = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next())
                list.add(new Psihoterapeut(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
        } catch (SQLException e) {
            e.printStackTrace(); // zameni Logger-om
        }
        return list;
    }

    public static void close() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            connect();
        }
        return connection;
    }
}
