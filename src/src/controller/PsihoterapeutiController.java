package controller;

import model.Psihoterapeut;
import model.utility.JDBCUtils;

import java.sql.*;
import java.util.*;

public class PsihoterapeutiController {


    public List<Psihoterapeut> vratiSvePsihoterapeute() {
        JDBCUtils.connect(); // ⬅️ mora pre svakog pristupa bazi ako nije već pozvan
        return JDBCUtils.selectAllFromPsihoterapeut();
    }
}
