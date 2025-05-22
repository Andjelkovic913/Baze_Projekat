package view;

import controller.PsihoterapeutiController;
import model.Psihoterapeut;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PsihoterapeutiView extends JFrame {
    private JComboBox<Psihoterapeut> comboBox;
    private PsihoterapeutiController controller;

    public PsihoterapeutiView() {
        super("Novi početak");

        controller = new PsihoterapeutiController();
        comboBox = new JComboBox<>();

        setLayout(new BorderLayout());

        JLabel naslov = new JLabel("Novi početak", SwingConstants.CENTER);
        naslov.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Psihoterapeuti:"));
        panel.add(comboBox);

        add(naslov, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        popuniComboBox();

        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void popuniComboBox() {
        List<Psihoterapeut> terapeuti = controller.vratiSvePsihoterapeute();
        for (Psihoterapeut p : terapeuti) {
            comboBox.addItem(p);
        }
    }

    public static void main(String[] args) {
        new PsihoterapeutiView();
    }
}
