package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import model.Termin;
import controller.PregledTerminaController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PregledTerminaView extends VBox {
    private TableView<Termin> table;
    private Button btnNazad;
    private PregledTerminaController controller;

    public PregledTerminaView() {
        controller = new PregledTerminaController();
        initializeComponents();
        setupLayout();
        ucitajPodatke();
    }

    private void initializeComponents() {
        // Naslov
        Text naslov = new Text("Pregled termina");
        naslov.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        // Tabela termina
        table = new TableView<>();
        
        // Kolone
        TableColumn<Termin, String> kolonaDatum = new TableColumn<>("Datum");
        kolonaDatum.setCellValueFactory(new PropertyValueFactory<>("datum"));
        
        TableColumn<Termin, String> kolonaVreme = new TableColumn<>("Vreme");
        kolonaVreme.setCellValueFactory(new PropertyValueFactory<>("vreme"));
        
        TableColumn<Termin, String> kolonaKlijent = new TableColumn<>("Klijent");
        kolonaKlijent.setCellValueFactory(new PropertyValueFactory<>("klijent"));
        
        TableColumn<Termin, String> kolonaTrajanje = new TableColumn<>("Trajanje (min)");
        kolonaTrajanje.setCellValueFactory(new PropertyValueFactory<>("trajanje"));

        table.getColumns().addAll(kolonaDatum, kolonaVreme, kolonaKlijent, kolonaTrajanje);
        
        // Postavljanje širine kolona
        kolonaDatum.setPrefWidth(100);
        kolonaVreme.setPrefWidth(100);
        kolonaKlijent.setPrefWidth(200);
        kolonaTrajanje.setPrefWidth(100);

        // Dugme za povratak
        btnNazad = new Button("Nazad");

        // Dodavanje komponenti u layout
        getChildren().addAll(naslov, table, btnNazad);
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(20));
    }

    private void setupLayout() {
        btnNazad.setOnAction(e -> vratiSeNazad());
    }

    private void ucitajPodatke() {
        ObservableList<Termin> termini = controller.vratiSveTermine();
        table.setItems(termini);
    }

    private void vratiSeNazad() {
        Scene scene = getScene();
        Stage stage = (Stage) scene.getWindow();
        
        PsihoterapeutDashboardView dashboardView = new PsihoterapeutDashboardView();
        Scene novaScena = new Scene(dashboardView, 800, 600);
        stage.setScene(novaScena);
    }
} 