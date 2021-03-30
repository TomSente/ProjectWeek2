package ui;

import domain.Cirkel;
import domain.Punt;
import domain.Rechthoek;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class RechthoekApp {
    private Label invoerXLinksLabel, invoerYLinksLabel, invoerBreedteLabel, invoerHoogteLabel;
    private TextField invoerXLinks, invoerYLinks, invoerBreedte, invoerHoogte;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private Punt punt;
    private int breedte, hoogte, x, y;
    private Rechthoek rechthoek;

    public RechthoekApp(GridPane root) {

        invoerXLinksLabel = new Label("Geef de x-coordinaat van de linkerbovenhoek van de rechthoek ");
        invoerXLinks = new TextField();
        invoerYLinksLabel = new Label("Geef de y-coordinaat van de linkerbovenhoek van de rechthoek ");
        invoerYLinks = new TextField();
        invoerBreedteLabel = new Label("Geef de breedte van de rechthoek");
        invoerBreedte = new TextField();
        invoerHoogteLabel = new Label("Geef de hoogte van de rechthoek");
        invoerHoogte = new TextField();

        root.add(invoerXLinksLabel, 0, 0);
        root.add(invoerXLinks, 1, 0);


        invoerXLinks.setOnAction(eventIngaveX -> {
            try {

                x = Integer.parseInt(invoerXLinks.getText());
                invoerXLinks.setDisable(true);
                root.add(invoerYLinksLabel, 0, 1);
                root.add(invoerYLinks, 1, 1);
            } catch (NumberFormatException e) {
                invoerXLinks.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerYLinks.setOnAction(eventIngaveY -> {
            try {
                punt = new Punt(Integer.parseInt(invoerXLinks.getText()), Integer.parseInt(invoerYLinks.getText()));
                root.add(invoerBreedteLabel, 0, 2);
                root.add(invoerBreedte, 1, 2);
            } catch (NumberFormatException e) {

                invoerYLinks.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
        invoerBreedte.setOnAction(eventIngaveBreedte -> {

            try{
                breedte = Integer.parseInt(invoerBreedte.getText());
                invoerBreedte.setDisable(true);
                root.add(invoerHoogteLabel,0,3);
                root.add(invoerHoogte,1,3);
            } catch (NumberFormatException e){
                invoerBreedte.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("breedte moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
        invoerHoogte.setOnAction(eventIngaveHoogte -> {
            try{
                hoogte = Integer.parseInt(invoerHoogte.getText());
                invoerBreedte.setDisable(true);
                rechthoek = new Rechthoek(punt,breedte,hoogte);
                Text uitvoer = new Text();
                uitvoer.setText(rechthoek.toString());
                root.getChildren().clear();
                root.add(uitvoer, 0,0);
            }
            catch (NumberFormatException e){
                invoerHoogte.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("hoogte moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }

        });

    }
}