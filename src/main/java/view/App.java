package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.utility.JDBCUtils;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        JDBCUtils.connect();
        PsihoterapeutiView view = new PsihoterapeutiView();
        Scene scene = new Scene(view, 800, 600);
        
        primaryStage.setTitle("Novi Početak - Pregled Psihoterapeuta");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() {
        JDBCUtils.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
