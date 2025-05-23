package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import model.Psihoterapeut;
import controller.PregledProfilaController;

public class PregledProfilaView extends VBox {
    private TextField tfIme;
    private TextField tfPrezime;
    private TextField tfJmbg;
    private TextField tfDatumRodjenja;
    private TextField tfPrebivaliste;
    private TextField tfTelefon;
    private TextField tfEmail;
    private TextField tfStepenId;
    private TextField tfFakultetId;
    private TextField tfCentarId;
    private TextField tfStatusId;
    private CheckBox cbIsPsiholog;
    private CheckBox cbIsSupervizor;
    private Button btnNazad;
    private PregledProfilaController controller;

    public PregledProfilaView() {
        controller = new PregledProfilaController();
        initializeComponents();
        setupLayout();
        ucitajPodatke();
    }

    private void initializeComponents() {
        // Naslov
        Text naslov = new Text("Profil psihoterapeuta");
        naslov.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        // Grid za podatke
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Polja za unos (read-only)
        tfIme = new TextField();
        tfIme.setEditable(false);
        tfIme.setPrefWidth(300);
        
        tfPrezime = new TextField();
        tfPrezime.setEditable(false);
        tfPrezime.setPrefWidth(300);

        tfJmbg = new TextField();
        tfJmbg.setEditable(false);
        tfJmbg.setPrefWidth(300);

        tfDatumRodjenja = new TextField();
        tfDatumRodjenja.setEditable(false);
        tfDatumRodjenja.setPrefWidth(300);

        tfPrebivaliste = new TextField();
        tfPrebivaliste.setEditable(false);
        tfPrebivaliste.setPrefWidth(300);
        
        tfTelefon = new TextField();
        tfTelefon.setEditable(false);
        tfTelefon.setPrefWidth(300);
        
        tfEmail = new TextField();
        tfEmail.setEditable(false);
        tfEmail.setPrefWidth(300);

        tfStepenId = new TextField();
        tfStepenId.setEditable(false);
        tfStepenId.setPrefWidth(300);

        tfFakultetId = new TextField();
        tfFakultetId.setEditable(false);
        tfFakultetId.setPrefWidth(300);

        tfCentarId = new TextField();
        tfCentarId.setEditable(false);
        tfCentarId.setPrefWidth(300);

        tfStatusId = new TextField();
        tfStatusId.setEditable(false);
        tfStatusId.setPrefWidth(300);

        cbIsPsiholog = new CheckBox();
        cbIsPsiholog.setDisable(true); // Make it read-only
        cbIsSupervizor = new CheckBox();
        cbIsSupervizor.setDisable(true); // Make it read-only

        // Dodavanje labela i polja u grid
        grid.add(new Label("Ime:"), 0, 0);
        grid.add(tfIme, 1, 0);
        
        grid.add(new Label("Prezime:"), 0, 1);
        grid.add(tfPrezime, 1, 1);

        grid.add(new Label("JMBG:"), 0, 2);
        grid.add(tfJmbg, 1, 2);

        grid.add(new Label("Datum ro\u0111enja:"), 0, 3);
        grid.add(tfDatumRodjenja, 1, 3);

        grid.add(new Label("Prebivali\u0161te:"), 0, 4);
        grid.add(tfPrebivaliste, 1, 4);

        grid.add(new Label("Telefon:"), 0, 5);
        grid.add(tfTelefon, 1, 5);
        
        grid.add(new Label("Email:"), 0, 6);
        grid.add(tfEmail, 1, 6);

        grid.add(new Label("Stepen ID:"), 0, 7);
        grid.add(tfStepenId, 1, 7);

        grid.add(new Label("Fakultet ID:"), 0, 8);
        grid.add(tfFakultetId, 1, 8);

        grid.add(new Label("Centar ID:"), 0, 9);
        grid.add(tfCentarId, 1, 9);

        grid.add(new Label("Status ID:"), 0, 10);
        grid.add(tfStatusId, 1, 10);

        grid.add(new Label("Psiholog:"), 0, 11);
        grid.add(cbIsPsiholog, 1, 11);

        grid.add(new Label("Supervizor:"), 0, 12);
        grid.add(cbIsSupervizor, 1, 12);

        // Dugme za povratak
        btnNazad = new Button("Nazad");

        // Dodavanje komponenti u layout
        getChildren().addAll(naslov, grid, btnNazad);
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(20));
    }

    private void setupLayout() {
        btnNazad.setOnAction(e -> vratiSeNazad());
    }

    private void ucitajPodatke() {
        Psihoterapeut psihoterapeut = controller.vratiPodatkePsihoterapeuta();
        if (psihoterapeut != null) {
            tfIme.setText(psihoterapeut.getIme());
            tfPrezime.setText(psihoterapeut.getPrezime());
            tfJmbg.setText(psihoterapeut.getJmbg());
            tfDatumRodjenja.setText(psihoterapeut.getDatumRodjenja().toString());
            tfPrebivaliste.setText(psihoterapeut.getPrebivaliste());
            tfTelefon.setText(psihoterapeut.getTelefon());
            tfEmail.setText(psihoterapeut.getEmail());
            tfStepenId.setText(String.valueOf(psihoterapeut.getStepenId()));
            tfFakultetId.setText(String.valueOf(psihoterapeut.getFakultetId()));
            tfCentarId.setText(String.valueOf(psihoterapeut.getCentarId()));
            tfStatusId.setText(String.valueOf(psihoterapeut.getStatusId()));
            cbIsPsiholog.setSelected(psihoterapeut.isPsiholog());
            cbIsSupervizor.setSelected(psihoterapeut.isSupervizor());
        }
    }

    private void vratiSeNazad() {
        Scene scene = getScene();
        Stage stage = (Stage) scene.getWindow();
        
        PsihoterapeutDashboardView dashboardView = new PsihoterapeutDashboardView();
        Scene novaScena = new Scene(dashboardView, 800, 600);
        stage.setScene(novaScena);
    }
} 