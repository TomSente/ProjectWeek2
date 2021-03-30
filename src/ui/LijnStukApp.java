package ui;

import domain.*;
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
    private Vorm vorm;

    public LijnStukApp(GridPane root) {
        init(root, 0);
        invoerYEindPunt.setOnAction(eventIngaveYEind -> {
            try {
                eindpunt = new Punt(Integer.parseInt(invoerXEindPunt.getText()), Integer.parseInt(invoerYEindPunt.getText()));
                vorm = new LijnStuk(startpunt, eindpunt);
                Text uitvoer = new Text();
                uitvoer.setText(vorm.toString());
                root.getChildren().clear();
                root.add(uitvoer, 0, 0);

            } catch (NumberFormatException e) {

                invoerYEindPunt.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
            catch (DomainException e){
                invoerYEindPunt.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setHeaderText(null);
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });
    }

    public LijnStukApp(GridPane root, Tekening tekening) {
        init(root, 1);
        invoerYEindPunt.setOnAction(eventIngaveYEind -> {
            try {
                eindpunt = new Punt(Integer.parseInt(invoerXEindPunt.getText()), Integer.parseInt(invoerYEindPunt.getText()));
                vorm = new LijnStuk(startpunt, eindpunt);
                tekening.voegToe(vorm);
                cleanUp(root);

            } catch (NumberFormatException e) {

                invoerYEindPunt.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
            catch (DomainException e){
                invoerYEindPunt.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setHeaderText(null);
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });
    }

    public void init(GridPane root, int teller) {
        invoerXStartPuntLabel = new Label("Geef de x-coördinaat van het startpunt.");
        invoerXStartPunt = new TextField();
        invoerYStartPuntLabel = new Label("Geef de y-coördinaat van het startpunt.");
        invoerYStartPunt = new TextField();
        invoerXEindPuntLabel = new Label("Geef de x-coördinaat van het eindpunt.");
        invoerXEindPunt = new TextField();
        invoerYEindPuntLabel = new Label("Geef de y-coördinaat van het eindpunt.");
        invoerYEindPunt = new TextField();

        root.add(invoerXStartPuntLabel, 0, teller);
        root.add(invoerXStartPunt, 1, teller);

        invoerXStartPunt.setOnAction(eventIngaveXStart -> {
            try {

                x1 = Integer.parseInt(invoerXStartPunt.getText());
                invoerXStartPunt.setDisable(true);
                root.add(invoerYStartPuntLabel, 0, teller+1);
                root.add(invoerYStartPunt, 1, teller+1);
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
                root.add(invoerXEindPuntLabel, 0, teller+2);
                root.add(invoerXEindPunt, 1, teller+2);
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
                root.add(invoerYEindPuntLabel, 0, teller+3);
                root.add(invoerYEindPunt, 1, teller+3);
            } catch (NumberFormatException e) {
                invoerXEindPunt.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });


    }
    private void  cleanUp(GridPane root){
        root.getChildren().remove(invoerXEindPunt);
        root.getChildren().remove(invoerXEindPuntLabel);
        root.getChildren().remove(invoerXStartPunt);
        root.getChildren().remove(invoerXStartPuntLabel);
        root.getChildren().remove(invoerYEindPunt);
        root.getChildren().remove(invoerYEindPuntLabel);
        root.getChildren().remove(invoerYStartPunt);
        root.getChildren().remove(invoerYStartPuntLabel);


    }
}
