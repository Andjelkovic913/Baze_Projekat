package controller;

import model.Psihoterapeut;
import model.utility.JDBCUtils;

import java.sql.*;
import java.util.*;

public class PsihoterapeutiController {


    public List<Psihoterapeut> vratiSvePsihoterapeute() {
        JDBCUtils.connect();
        return JDBCUtils.selectAllFromPsihoterapeut();
    }
}
