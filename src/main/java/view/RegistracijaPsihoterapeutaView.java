package view;

import controller.RegistracijaPsihoterapeutaController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.Psihoterapeut;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.HPos;

import java.time.LocalDate;

public class RegistracijaPsihoterapeutaView extends VBox {
    private TextField tfIme;
    private TextField tfPrezime;
    private TextField tfJmbg;
    private DatePicker dpDatumRodjenja;
    private TextField tfPrebivaliste;
    private TextField tfTelefon;
    private TextField tfEmail;
    private PasswordField pfLozinka;
    private PasswordField pfPotvrdaLozinke;
    private TextField tfStepenId; // TODO: Change to ComboBox fetching data from stepenstudija
    private TextField tfFakultetId; // TODO: Change to ComboBox fetching data from fakultet
    private TextField tfCentarId; // TODO: Change to ComboBox fetching data from centar_obuke
    private TextField tfStatusId; // TODO: Change to ComboBox fetching data from status_psihoterapeuta
    private CheckBox cbIsPsiholog;
    private CheckBox cbIsSupervizor;
    private Button btnRegistruj;
    private Button btnNazad;
    private RegistracijaPsihoterapeutaController controller;

    public RegistracijaPsihoterapeutaView() {
        controller = new RegistracijaPsihoterapeutaController();
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        // Naslov
        Text naslov = new Text("Registracija novog psihoterapeuta");
        naslov.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        // Forma Grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Polja za unos
        tfIme = new TextField();
        tfPrezime = new TextField();
        tfJmbg = new TextField();
        dpDatumRodjenja = new DatePicker();
        tfPrebivaliste = new TextField();
        tfTelefon = new TextField();
        tfEmail = new TextField();
        pfLozinka = new PasswordField();
        pfPotvrdaLozinke = new PasswordField();
        tfStepenId = new TextField(); // TODO: Change to ComboBox
        tfFakultetId = new TextField(); // TODO: Change to ComboBox
        tfCentarId = new TextField(); // TODO: Change to ComboBox
        tfStatusId = new TextField(); // TODO: Change to ComboBox
        cbIsPsiholog = new CheckBox();
        cbIsSupervizor = new CheckBox();

        // Setting date picker factory for Datum Rodjenja (optional: date restrictions)
        // Example restriction to prevent future dates:
         dpDatumRodjenja.setDayCellFactory(picker -> new DateCell() {
             @Override
             public void updateItem(LocalDate date, boolean empty) {
                 super.updateItem(date, empty);
                 setDisable(empty || date.compareTo(LocalDate.now()) > 0 );
             }
         });
        // You can add more restrictions here if needed, e.g., minimum age.

        // Dodavanje labela i polja u grid
        grid.add(new Label("Ime:"), 0, 0);
        grid.add(tfIme, 1, 0);
        grid.add(new Label("Prezime:"), 0, 1);
        grid.add(tfPrezime, 1, 1);
        grid.add(new Label("JMBG:"), 0, 2);
        grid.add(tfJmbg, 1, 2);
        grid.add(new Label("Datum ro\u0111enja:"), 0, 3);
        grid.add(dpDatumRodjenja, 1, 3);
        grid.add(new Label("Prebivali\u0161te:"), 0, 4);
        grid.add(tfPrebivaliste, 1, 4);
        grid.add(new Label("Telefon:"), 0, 5);
        grid.add(tfTelefon, 1, 5);
        grid.add(new Label("Email:"), 0, 6);
        grid.add(tfEmail, 1, 6);
        grid.add(new Label("Stepen ID:"), 0, 7); // TODO: Replace with ComboBox
        grid.add(tfStepenId, 1, 7);
        grid.add(new Label("Fakultet ID:"), 0, 8); // TODO: Replace with ComboBox
        grid.add(tfFakultetId, 1, 8);
        grid.add(new Label("Centar ID:"), 0, 9); // TODO: Replace with ComboBox
        grid.add(tfCentarId, 1, 9);
        grid.add(new Label("Status ID:"), 0, 10); // TODO: Replace with ComboBox
        grid.add(tfStatusId, 1, 10);
        grid.add(new Label("Psiholog:"), 0, 11);
        grid.add(cbIsPsiholog, 1, 11);
        grid.add(new Label("Supervizor:"), 0, 12);
        grid.add(cbIsSupervizor, 1, 12);
        grid.add(new Label("Lozinka:"), 0, 13);
        grid.add(pfLozinka, 1, 13);
        grid.add(new Label("Potvrda lozinke:"), 0, 14);
        grid.add(pfPotvrdaLozinke, 1, 14);

        // Dugmad
        HBox hbBtn = new HBox(10); // 10 pixels spacing
        btnRegistruj = new Button("Registruj");
        btnNazad = new Button("Nazad");
        hbBtn.getChildren().addAll(btnRegistruj, btnNazad);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(hbBtn, 1, 15);

        // Dodavanje komponenti u glavni layout
        getChildren().addAll(naslov, grid);
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(20));
    }

    private void setupLayout() {
        // Postavljanje event handlera
        btnRegistruj.setOnAction(e -> registrujPsihoterapeuta());
        btnNazad.setOnAction(e -> vratiSeNazad());
    }

    private void registrujPsihoterapeuta() {
        // Validacija
        if (!validirajUnos()) {
            return;
        }

        // Kreiranje novog psihoterapeuta
        Psihoterapeut psihoterapeut = new Psihoterapeut();
        psihoterapeut.setIme(tfIme.getText());
        psihoterapeut.setPrezime(tfPrezime.getText());
        psihoterapeut.setJmbg(tfJmbg.getText());
        psihoterapeut.setDatumRodjenja(dpDatumRodjenja.getValue());
        psihoterapeut.setPrebivaliste(tfPrebivaliste.getText());
        psihoterapeut.setTelefon(tfTelefon.getText());
        psihoterapeut.setEmail(tfEmail.getText());
        psihoterapeut.setLozinka(pfLozinka.getText()); // TODO: Implement password hashing

        // Get ID values from TextFields (requires validation to be valid integers)
        // TODO: Update this when using ComboBoxes
        try {
            psihoterapeut.setStepenId(Integer.parseInt(tfStepenId.getText()));
            psihoterapeut.setFakultetId(Integer.parseInt(tfFakultetId.getText()));
            psihoterapeut.setCentarId(Integer.parseInt(tfCentarId.getText()));
            psihoterapeut.setStatusId(Integer.parseInt(tfStatusId.getText()));
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greška pri unosu ID-a");
            alert.setHeaderText("Neispravan format ID-a");
            alert.setContentText("Molimo unesite cele brojeve za ID polja.");
            alert.showAndWait();
            return;
        }

        // Get boolean values from CheckBoxes
        psihoterapeut.setPsiholog(cbIsPsiholog.isSelected());
        psihoterapeut.setSupervizor(cbIsSupervizor.isSelected());

        // Čuvanje u bazi
        if (controller.registrujPsihoterapeuta(psihoterapeut)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Uspeh");
            alert.setHeaderText("Registracija uspešna");
            alert.setContentText("Psihoterapeut je uspešno registrovan.");
            alert.showAndWait();
            vratiSeNazad();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greška");
            alert.setHeaderText("Registracija nije uspela");
            alert.setContentText("Došlo je do greške prilikom registracije. Proverite konzolu za detalje."); // Updated message
            alert.showAndWait();
        }
    }

    private boolean validirajUnos() {
        StringBuilder greske = new StringBuilder();

        if (tfIme.getText().isEmpty()) greske.append("Ime je obavezno\n");
        if (tfPrezime.getText().isEmpty()) greske.append("Prezime je obavezno\n");
        if (tfJmbg.getText().isEmpty()) greske.append("JMBG je obavezan\n"); // Added validation
        if (dpDatumRodjenja.getValue() == null) greske.append("Datum ro\u0111enja je obavezan\n"); // Added validation
        if (tfPrebivaliste.getText().isEmpty()) greske.append("Prebivali\u0161te je obavezno\n"); // Added validation
        if (tfTelefon.getText().isEmpty()) greske.append("Telefon je obavezan\n");
        if (tfEmail.getText().isEmpty()) greske.append("Email je obavezan\n");
        // Basic validation for ID fields (requires valid integers)
        try {
            if (tfStepenId.getText().isEmpty()) greske.append("Stepen ID je obavezan\n");
            else Integer.parseInt(tfStepenId.getText());
            if (tfFakultetId.getText().isEmpty()) greske.append("Fakultet ID je obavezan\n");
            else Integer.parseInt(tfFakultetId.getText());
            if (tfCentarId.getText().isEmpty()) greske.append("Centar ID je obavezan\n");
            else Integer.parseInt(tfCentarId.getText());
            if (tfStatusId.getText().isEmpty()) greske.append("Status ID je obavezan\n");
            else Integer.parseInt(tfStatusId.getText());
        } catch (NumberFormatException e) {
             greske.append("ID polja moraju biti celi brojevi\n");
        }

        if (pfLozinka.getText().isEmpty()) greske.append("Lozinka je obavezna\n");
        if (!pfLozinka.getText().equals(pfPotvrdaLozinke.getText())) {
            greske.append("Lozinke se ne podudaraju\n");
        }

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

    private void vratiSeNazad() {
        Scene scene = getScene();
        Stage stage = (Stage) scene.getWindow();
        
        PrijavaPsihoterapeutaView prijavaView = new PrijavaPsihoterapeutaView();
        Scene novaScena = new Scene(prijavaView, 800, 600);
        stage.setScene(novaScena);
    }
} 