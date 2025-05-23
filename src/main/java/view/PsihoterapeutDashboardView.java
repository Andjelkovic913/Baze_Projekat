package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class PsihoterapeutDashboardView extends VBox {
    private Button btnPregledSeansi;
    private Button btnPregledProfila;
    private Button btnPregledBelezaka;
    private Button btnPregledTermina;
    private Button btnPregledPrijava;
    private Button btnOdjava;
    private Text naslov;

    public PsihoterapeutDashboardView() {
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        // Naslov
        naslov = new Text("Glavni meni psihoterapeuta");
        naslov.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        // Dugmad za navigaciju
        btnPregledSeansi = new Button("Pregled održanih seansi");
        btnPregledProfila = new Button("Pregled profila");
        btnPregledBelezaka = new Button("Pregled beleški i testova");
        btnPregledTermina = new Button("Pregled termina");
        btnPregledPrijava = new Button("Pregled prijava klijenata");
        btnOdjava = new Button("Odjava");

        // Postavljanje veličine dugmadi
        btnPregledSeansi.setPrefWidth(250);
        btnPregledProfila.setPrefWidth(250);
        btnPregledBelezaka.setPrefWidth(250);
        btnPregledTermina.setPrefWidth(250);
        btnPregledPrijava.setPrefWidth(250);
        btnOdjava.setPrefWidth(250);
    }

    private void setupLayout() {
        // Grid za dugmad
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Dodavanje dugmadi u grid
        grid.add(btnPregledSeansi, 0, 0);
        grid.add(btnPregledProfila, 0, 1);
        grid.add(btnPregledBelezaka, 0, 2);
        grid.add(btnPregledTermina, 0, 3);
        grid.add(btnPregledPrijava, 0, 4);
        grid.add(btnOdjava, 0, 5);

        // Event handleri
        btnPregledSeansi.setOnAction(e -> otvoriPregledSeansi());
        btnPregledProfila.setOnAction(e -> otvoriPregledProfila());
        btnPregledBelezaka.setOnAction(e -> otvoriPregledBelezaka());
        btnPregledTermina.setOnAction(e -> otvoriPregledTermina());
        btnPregledPrijava.setOnAction(e -> otvoriPregledPrijava());
        btnOdjava.setOnAction(e -> odjaviSe());

        // Dodavanje komponenti u glavni layout
        getChildren().addAll(naslov, grid);
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(20));
    }

    private void otvoriPregledSeansi() {
        Scene scene = getScene();
        Stage stage = (Stage) scene.getWindow();
        
        PregledSeansiView pregledSeansiView = new PregledSeansiView();
        Scene novaScena = new Scene(pregledSeansiView, 800, 600);
        stage.setScene(novaScena);
    }

    private void otvoriPregledProfila() {
        Scene scene = getScene();
        Stage stage = (Stage) scene.getWindow();
        
        PregledProfilaView pregledProfilaView = new PregledProfilaView();
        Scene novaScena = new Scene(pregledProfilaView, 800, 600);
        stage.setScene(novaScena);
    }

    private void otvoriPregledBelezaka() {
        Scene scene = getScene();
        Stage stage = (Stage) scene.getWindow();
        
        PregledBelezakaView pregledBelezakaView = new PregledBelezakaView();
        Scene novaScena = new Scene(pregledBelezakaView, 800, 600);
        stage.setScene(novaScena);
    }

    private void otvoriPregledTermina() {
        Scene scene = getScene();
        Stage stage = (Stage) scene.getWindow();
        
        PregledTerminaView pregledTerminaView = new PregledTerminaView();
        Scene novaScena = new Scene(pregledTerminaView, 800, 600);
        stage.setScene(novaScena);
    }

    private void otvoriPregledPrijava() {
        Scene scene = getScene();
        Stage stage = (Stage) scene.getWindow();
        
        PregledPrijavaView pregledPrijavaView = new PregledPrijavaView();
        Scene novaScena = new Scene(pregledPrijavaView, 800, 600);
        stage.setScene(novaScena);
    }

    private void odjaviSe() {
        Scene scene = getScene();
        Stage stage = (Stage) scene.getWindow();
        
        PrijavaPsihoterapeutaView prijavaView = new PrijavaPsihoterapeutaView();
        Scene novaScena = new Scene(prijavaView, 800, 600);
        stage.setScene(novaScena);
    }
} 