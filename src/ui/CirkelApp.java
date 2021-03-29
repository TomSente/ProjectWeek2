package ui;

import domain.Cirkel;
import domain.Punt;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class CirkelApp {
    private Label invoerXLabel, invoerYLabel, invoerRadiusLabel;
    private TextField invoerX, invoerY, invoerRadius;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private Punt punt;

    public CirkelApp(GridPane root) {

        invoerXLabel =  new Label("Geef de x-coordinaat van het middelpunt van de cirkel ");
        invoerX= new TextField();
        invoerYLabel = new Label("Geef de y-coordinaat van het middelpunt van de cirkel ");
        invoerY = new TextField();
        invoerRadiusLabel = new Label("Geef de straal van de cirkel.");
        invoerRadius = new TextField();


        root.add(invoerXLabel,0,0);
        root.add(invoerX,1,0);

        invoerX.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerX.getText());
                root.add(invoerYLabel, 0, 1);
                root.add(invoerY, 1, 1);
            }
            catch(NumberFormatException e){
                invoerX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerY.setOnAction(eventIngaveY -> {
            try {
                punt = new Punt(Integer.parseInt(invoerX.getText()), Integer.parseInt(invoerY.getText()));
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(punt.toString());
                root.add(uitvoer, 0, 0);
            } catch(NumberFormatException e){

                invoerY.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
    }
}
