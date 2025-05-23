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
import model.Sesija;
import controller.PregledSeansiController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PregledSeansiView extends VBox {
    private TableView<Sesija> table;
    private Button btnNazad;
    private PregledSeansiController controller;

    public PregledSeansiView() {
        controller = new PregledSeansiController();
        initializeComponents();
        setupLayout();
        ucitajPodatke();
    }

    private void initializeComponents() {
        // Naslov
        Text naslov = new Text("Pregled održanih seansi");
        naslov.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        // Tabela
        table = new TableView<>();
        
        // Kolone
        TableColumn<Sesija, String> kolonaDatum = new TableColumn<>("Datum");
        kolonaDatum.setCellValueFactory(new PropertyValueFactory<>("datum"));
        
        TableColumn<Sesija, String> kolonaVreme = new TableColumn<>("Vreme");
        kolonaVreme.setCellValueFactory(new PropertyValueFactory<>("vreme"));
        
        TableColumn<Sesija, String> kolonaTrajanje = new TableColumn<>("Trajanje (min)");
        kolonaTrajanje.setCellValueFactory(new PropertyValueFactory<>("trajanje"));
        
        TableColumn<Sesija, String> kolonaKlijent = new TableColumn<>("Klijent");
        kolonaKlijent.setCellValueFactory(new PropertyValueFactory<>("klijent"));
        
        TableColumn<Sesija, String> kolonaBelezke = new TableColumn<>("Beleške");
        kolonaBelezke.setCellValueFactory(new PropertyValueFactory<>("belezke"));

        table.getColumns().addAll(kolonaDatum, kolonaVreme, kolonaTrajanje, kolonaKlijent, kolonaBelezke);
        
        // Postavljanje širine kolona
        kolonaDatum.setPrefWidth(100);
        kolonaVreme.setPrefWidth(100);
        kolonaTrajanje.setPrefWidth(100);
        kolonaKlijent.setPrefWidth(150);
        kolonaBelezke.setPrefWidth(300);

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
        ObservableList<Sesija> sesije = controller.vratiSveSeanse();
        table.setItems(sesije);
    }

    private void vratiSeNazad() {
        Scene scene = getScene();
        Stage stage = (Stage) scene.getWindow();
        
        PsihoterapeutDashboardView dashboardView = new PsihoterapeutDashboardView();
        Scene novaScena = new Scene(dashboardView, 800, 600);
        stage.setScene(novaScena);
    }
} 