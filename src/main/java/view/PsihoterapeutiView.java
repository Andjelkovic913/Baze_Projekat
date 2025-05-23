package view;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import model.Psihoterapeut;
import controller.PsihoterapeutiController;

public class PsihoterapeutiView extends BorderPane {

    private TableView<Psihoterapeut> table;
    private Button refreshButton;
    private PsihoterapeutiController controller;

    public PsihoterapeutiView() {
        controller = new PsihoterapeutiController();
        initializeComponents();
        setupLayout();
        ucitajPodatke();
    }

    private void initializeComponents() {
        // Inicijalizacija tabele
        table = new TableView<>();
        
        // Kolone tabele
        TableColumn<Psihoterapeut, String> imeColumn = new TableColumn<>("Ime");
        imeColumn.setCellValueFactory(new PropertyValueFactory<>("ime"));
        
        TableColumn<Psihoterapeut, String> prezimeColumn = new TableColumn<>("Prezime");
        prezimeColumn.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        
        TableColumn<Psihoterapeut, String> oblastColumn = new TableColumn<>("Oblast");
        oblastColumn.setCellValueFactory(new PropertyValueFactory<>("oblast"));
        
        TableColumn<Psihoterapeut, String> sertifikatColumn = new TableColumn<>("Sertifikat");
        sertifikatColumn.setCellValueFactory(new PropertyValueFactory<>("sertifikat"));

        table.getColumns().addAll(imeColumn, prezimeColumn, oblastColumn, sertifikatColumn);
        
        refreshButton = new Button("Osveži");
        refreshButton.setOnAction(e -> ucitajPodatke());
    }

    private void setupLayout() {
        // Gornji deo sa naslovom
        Label naslov = new Label("Pregled psihoterapeuta");
        naslov.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        BorderPane.setAlignment(naslov, Pos.CENTER);

        // Gornji deo sa dugmetom za osvežavanje
        HBox topBox = new HBox(10);
        topBox.setAlignment(Pos.CENTER_RIGHT);
        topBox.setPadding(new Insets(10));
        topBox.getChildren().add(refreshButton);

        // Glavni layout
        VBox mainBox = new VBox(10);
        mainBox.setPadding(new Insets(10));
        mainBox.getChildren().addAll(naslov, table);

        // Postavljanje u BorderPane
        setTop(topBox);
        setCenter(mainBox);
    }

    private void ucitajPodatke() {
        table.setItems(controller.vratiSvePsihoterapeute());
    }
}
