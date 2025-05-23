package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Psihoterapeut;
import model.utility.JDBCUtils;
import java.sql.*;

public class PsihoterapeutiController {
    public ObservableList<Psihoterapeut> vratiSvePsihoterapeute() {
        return FXCollections.observableArrayList(JDBCUtils.selectAllFromPsihoterapeut());
    }

    public ObservableList<Psihoterapeut> pretraziPsihoterapeute(String tekst, String kriterijum) {
        ObservableList<Psihoterapeut> psihoterapeuti = FXCollections.observableArrayList();
        String query = "SELECT * FROM psihoterapeut WHERE " + kriterijum + " LIKE ?";

        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, "%" + tekst + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                psihoterapeuti.add(new Psihoterapeut(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return psihoterapeuti;
    }
}
