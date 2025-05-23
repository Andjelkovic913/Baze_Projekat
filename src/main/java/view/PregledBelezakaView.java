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
import controller.PregledBelezakaController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PregledBelezakaView extends VBox {
    private TableView<Sesija> table;
    private TextArea taDetalji;
    private Button btnNazad;
    private PregledBelezakaController controller;

    public PregledBelezakaView() {
        controller = new PregledBelezakaController();
        initializeComponents();
        setupLayout();
        ucitajPodatke();
    }

    private void initializeComponents() {
        // Naslov
        Text naslov = new Text("Pregled beleški i testova");
        naslov.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        // Tabela seansi
        table = new TableView<>();
        
        // Kolone
        TableColumn<Sesija, String> kolonaDatum = new TableColumn<>("Datum");
        kolonaDatum.setCellValueFactory(new PropertyValueFactory<>("datum"));
        
        TableColumn<Sesija, String> kolonaVreme = new TableColumn<>("Vreme");
        kolonaVreme.setCellValueFactory(new PropertyValueFactory<>("vreme"));
        
        TableColumn<Sesija, String> kolonaKlijent = new TableColumn<>("Klijent");
        kolonaKlijent.setCellValueFactory(new PropertyValueFactory<>("klijent"));

        table.getColumns().addAll(kolonaDatum, kolonaVreme, kolonaKlijent);
        
        // Postavljanje širine kolona
        kolonaDatum.setPrefWidth(100);
        kolonaVreme.setPrefWidth(100);
        kolonaKlijent.setPrefWidth(200);

        // Oblast za detalje
        Label lblDetalji = new Label("Detalji seanse:");
        taDetalji = new TextArea();
        taDetalji.setEditable(false);
        taDetalji.setWrapText(true);
        taDetalji.setPrefRowCount(10);
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
        
        // Event handler za selektovanje seanse
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                prikaziDetaljeSeanse(newSelection);
            }
        });
    }

    private void ucitajPodatke() {
        ObservableList<Sesija> sesije = controller.vratiSveSeanse();
        table.setItems(sesije);
    }

    private void prikaziDetaljeSeanse(Sesija sesija) {
        StringBuilder detalji = new StringBuilder();
        detalji.append("Beleške:\n").append(sesija.getBelezke()).append("\n\n");
        
        // TODO: Dodati prikaz testova kada se implementira
        detalji.append("Testovi:\n");
        detalji.append("Funkcionalnost prikaza testova će biti dostupna uskoro.");
        
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