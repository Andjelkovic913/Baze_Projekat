package controller;

import model.Psihoterapeut;
import model.utility.JDBCUtils;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class RegistracijaPsihoterapeutaController {
    
    public boolean registrujPsihoterapeuta(Psihoterapeut psihoterapeut) {
        return new PsihoterapeutiController().dodajPsihoterapeuta(psihoterapeut);
    }
} 