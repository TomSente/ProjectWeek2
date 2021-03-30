package ui;

import domain.Cirkel;
import domain.LijnStuk;
import domain.Punt;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class LijnStukApp {
    private Label invoerXStartPuntLabel, invoerYStartPuntLabel, invoerXEindPuntLabel, invoerYEindPuntLabel;
    private TextField invoerXStartPunt, invoerYStartPunt, invoerXEindPunt, invoerYEindPunt;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private int x1, x2, y1, y;
    private Punt startpunt, eindpunt;
    private LijnStuk lijnstuk;

    public LijnStukApp(GridPane root) {
        invoerXStartPuntLabel = new Label("Geef de x-coördinaat van het startpunt.");
        invoerXStartPunt = new TextField();
        invoerYStartPuntLabel = new Label("Geef de y-coördinaat van het startpunt.");
        invoerYStartPunt = new TextField();
        invoerXEindPuntLabel = new Label("Geef de x-coördinaat van het eindpunt.");
        invoerXEindPunt = new TextField();
        invoerYEindPuntLabel = new Label("Geef de y-coördinaat van het eindpunt.");
        invoerYEindPunt = new TextField();

        root.add(invoerXStartPuntLabel, 0, 0);
        root.add(invoerXStartPunt, 1, 0);

        invoerXStartPunt.setOnAction(eventIngaveXStart -> {
            try {

                x1 = Integer.parseInt(invoerXStartPunt.getText());
                invoerXStartPunt.setDisable(true);
                root.add(invoerYStartPuntLabel, 0, 1);
                root.add(invoerYStartPunt, 1, 1);
            } catch (NumberFormatException e) {
                invoerXStartPunt.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerYStartPunt.setOnAction(eventIngaveYStart -> {
            try {
                startpunt = new Punt(Integer.parseInt(invoerXStartPunt.getText()), Integer.parseInt(invoerYStartPunt.getText()));
                invoerYStartPunt.setDisable(true);
                root.add(invoerXEindPuntLabel, 0, 2);
                root.add(invoerXEindPunt, 1, 2);
            } catch (NumberFormatException e) {

                invoerYStartPunt.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerXEindPunt.setOnAction(eventIngaveXEind -> {
            try {

                x1 = Integer.parseInt(invoerXEindPunt.getText());
                invoerXEindPunt.setDisable(true);
                root.add(invoerYEindPuntLabel, 0, 3);
                root.add(invoerYEindPunt, 1, 3);
            } catch (NumberFormatException e) {
                invoerXEindPunt.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
        invoerYEindPunt.setOnAction(eventIngaveYEind -> {
            try {
                eindpunt = new Punt(Integer.parseInt(invoerXEindPunt.getText()), Integer.parseInt(invoerYEindPunt.getText()));
                lijnstuk = new LijnStuk(startpunt, eindpunt);
                Text uitvoer = new Text();
                uitvoer.setText(lijnstuk.toString());
                root.getChildren().clear();
                root.add(uitvoer, 0, 0);

            } catch (NumberFormatException e) {

                invoerYEindPunt.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

    }
}
