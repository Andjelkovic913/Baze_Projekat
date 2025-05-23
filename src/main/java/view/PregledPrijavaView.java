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
import model.Prijava;
import controller.PregledPrijavaController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PregledPrijavaView extends VBox {
    private TableView<Prijava> table;
    private TextArea taDetalji;
    private Button btnNazad;
    private PregledPrijavaController controller;

    public PregledPrijavaView() {
        controller = new PregledPrijavaController();
        initializeComponents();
        setupLayout();
        ucitajPodatke();
    }

    private void initializeComponents() {
        // Naslov
        Text naslov = new Text("Pregled prijava klijenata");
        naslov.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        // Tabela prijava
        table = new TableView<>();
        
        // Kolone
        TableColumn<Prijava, String> kolonaDatum = new TableColumn<>("Datum prijave");
        kolonaDatum.setCellValueFactory(new PropertyValueFactory<>("datumPrijave"));
        
        TableColumn<Prijava, String> kolonaKlijent = new TableColumn<>("Klijent");
        kolonaKlijent.setCellValueFactory(new PropertyValueFactory<>("klijent"));
        
        TableColumn<Prijava, String> kolonaEmail = new TableColumn<>("Email");
        kolonaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        TableColumn<Prijava, String> kolonaTelefon = new TableColumn<>("Telefon");
        kolonaTelefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));

        table.getColumns().addAll(kolonaDatum, kolonaKlijent, kolonaEmail, kolonaTelefon);
        
        // Postavljanje širine kolona
        kolonaDatum.setPrefWidth(120);
        kolonaKlijent.setPrefWidth(200);
        kolonaEmail.setPrefWidth(200);
        kolonaTelefon.setPrefWidth(120);

        // Oblast za detalje
        Label lblDetalji = new Label("Detalji prijave:");
        taDetalji = new TextArea();
        taDetalji.setEditable(false);
        taDetalji.setWrapText(true);
        taDetalji.setPrefRowCount(5);
        taDetalji.setPrefColumnCount(50);

        // Dugme za povratak
        btnNazad = new Button("Nazad");

        // Dodavanje komponenti u layout
        getChildren().addAll(naslov, table, lblDetalji, taDetalji, btnNazad);
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(20));
    }

    private void setupLayout() {
        btnNazad.setOnAction(e -> vratiSeNazad());
        
        // Event handler za selektovanje prijave
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                prikaziDetaljePrijave(newSelection);
            }
        });
    }

    private void ucitajPodatke() {
        ObservableList<Prijava> prijave = controller.vratiSvePrijave();
        table.setItems(prijave);
    }

    private void prikaziDetaljePrijave(Prijava prijava) {
        StringBuilder detalji = new StringBuilder();
        detalji.append("Datum rođenja: ").append(prijava.getDatumRodjenja()).append("\n");
        detalji.append("Pol: ").append(prijava.getPol()).append("\n");
        detalji.append("Ranije iskustvo: ").append(prijava.isRanijeIskustvo() ? "Da" : "Ne").append("\n\n");
        detalji.append("Opis problema:\n").append(prijava.getOpisProblema());
        
        taDetalji.setText(detalji.toString());
    }

    private void vratiSeNazad() {
        Scene scene = getScene();
        Stage stage = (Stage) scene.getWindow();
        
        PsihoterapeutDashboardView dashboardView = new PsihoterapeutDashboardView();
        Scene novaScena = new Scene(dashboardView, 800, 600);
        stage.setScene(novaScena);
    }
} 