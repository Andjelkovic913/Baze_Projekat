package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import controller.PrijavaPsihoterapeutaController;

public class PrijavaPsihoterapeutaView extends VBox {
    private TextField tfEmail;
    private PasswordField pfLozinka;
    private Button btnPrijavi;
    private Button btnRegistracija;
    private PrijavaPsihoterapeutaController controller;

    public PrijavaPsihoterapeutaView() {
        controller = new PrijavaPsihoterapeutaController();
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        // Naslov
        Text naslov = new Text("Prijava psihoterapeuta");
        naslov.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        // Forma
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Polja za unos
        tfEmail = new TextField();
        pfLozinka = new PasswordField();

        // Dodavanje polja u grid
        grid.add(new Label("Email:"), 0, 0);
        grid.add(tfEmail, 1, 0);
        grid.add(new Label("Lozinka:"), 0, 1);
        grid.add(pfLozinka, 1, 1);

        // Dugmad
        HBox hbBtn = new HBox(10);
        btnPrijavi = new Button("Prijavi se");
        btnRegistracija = new Button("Registracija");
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(btnPrijavi, btnRegistracija);
        grid.add(hbBtn, 1, 2);

        // Dodavanje komponenti u glavni layout
        getChildren().addAll(naslov, grid);
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(20));
    }

    private void setupLayout() {
        // Postavljanje event handlera
        btnPrijavi.setOnAction(e -> prijaviPsihoterapeuta());
        btnRegistracija.setOnAction(e -> otvoriRegistraciju());
    }

    private void prijaviPsihoterapeuta() {
        // Validacija
        if (!validirajUnos()) {
            return;
        }

        // Pokušaj prijave
        if (controller.prijaviPsihoterapeuta(tfEmail.getText(), pfLozinka.getText())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Uspeh");
            alert.setHeaderText("Prijava uspešna");
            alert.setContentText("Uspešno ste se prijavili na sistem.");
            alert.showAndWait();
            otvoriDashboard();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greška");
            alert.setHeaderText("Prijava nije uspela");
            alert.setContentText("Pogrešan email ili lozinka. Molimo pokušajte ponovo.");
            alert.showAndWait();
        }
    }

    private boolean validirajUnos() {
        StringBuilder greske = new StringBuilder();

        if (tfEmail.getText().isEmpty()) greske.append("Email je obavezan\n");
        if (pfLozinka.getText().isEmpty()) greske.append("Lozinka je obavezna\n");

        if (greske.length() > 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greška");
            alert.setHeaderText("Molimo ispravite sledeće greške:");
            alert.setContentText(greske.toString());
            alert.showAndWait();
            return false;
        }

        return true;
    }

    private void otvoriRegistraciju() {
        Scene scene = getScene();
        Stage stage = (Stage) scene.getWindow();
        
        RegistracijaPsihoterapeutaView registracijaView = new RegistracijaPsihoterapeutaView();
        Scene novaScena = new Scene(registracijaView, 800, 600);
        stage.setScene(novaScena);
    }

    private void otvoriDashboard() {
        Scene scene = getScene();
        Stage stage = (Stage) scene.getWindow();
        
        PsihoterapeutDashboardView dashboardView = new PsihoterapeutDashboardView();
        Scene novaScena = new Scene(dashboardView, 800, 600);
        stage.setScene(novaScena);
    }
} 