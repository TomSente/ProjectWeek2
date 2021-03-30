package ui;

import domain.DomainException;
import domain.Driehoek;
import domain.Speler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import domain.Punt;

public class DriehoekApp
{
    private Label invoerXPunt1Label, invoerYPunt1Label,invoerXPunt2Label, invoerYPunt2Label,invoerXPunt3Label, invoerYPunt3Label;
    private TextField invoerXPunt1, invoerYPunt1, invoerXPunt2, invoerYPunt2, invoerXPunt3, invoerYPunt3;
    private Punt punt1,punt2,punt3;
    private Driehoek driehoek;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    public DriehoekApp(GridPane root)
    {
        invoerXPunt1Label =  new Label("Geef de x-coordinaat van het 1ste punt ");
        invoerXPunt1= new TextField();
        invoerYPunt1Label = new Label("Geef de y-coordinaat van het 1ste punt ");
        invoerYPunt1 = new TextField();
        invoerXPunt2Label =  new Label("Geef de x-coordinaat van het 2de punt ");
        invoerXPunt2= new TextField();
        invoerYPunt2Label = new Label("Geef de y-coordinaat van het 2de punt ");
        invoerYPunt2 = new TextField();
        invoerXPunt3Label =  new Label("Geef de x-coordinaat van het 3de punt ");
        invoerXPunt3= new TextField();
        invoerYPunt3Label = new Label("Geef de y-coordinaat van het 3de punt ");
        invoerYPunt3 = new TextField();

        root.add(invoerXPunt1Label,0,0);
        root.add(invoerXPunt1,1,0);
        root.add(invoerYPunt1Label,0,1);
        root.add(invoerYPunt1,1,1);
        invoerYPunt1.setOnAction(eventXPunt1Ingave ->
        {
            punt1 = new Punt(Integer.parseInt(invoerXPunt1.getText()),Integer.parseInt(invoerYPunt1.getText()));
            root.getChildren().clear();
            root.add(invoerXPunt2Label,0,0);
            root.add(invoerXPunt2,1,0);
            root.add(invoerYPunt2Label,0,1);
            root.add(invoerYPunt2,1,1);
        });

        invoerYPunt2.setOnAction(eventXPunt2Ingave ->
        {
            punt2 = new Punt(Integer.parseInt(invoerXPunt2.getText()),Integer.parseInt(invoerYPunt2.getText()));
            root.getChildren().clear();
            root.add(invoerXPunt3Label,0,0);
            root.add(invoerXPunt3,1,0);
            root.add(invoerYPunt3Label,0,1);
            root.add(invoerYPunt3,1,1);
        });

        invoerYPunt3.setOnAction(eventXPunt3Ingave ->
        {
            try
            {
                punt3 = new Punt(Integer.parseInt(invoerXPunt3.getText()),Integer.parseInt(invoerYPunt3.getText()));
                root.getChildren().clear();

                driehoek = new Driehoek(punt1,punt2,punt3);
                Text uitvoer = new Text();
                uitvoer.setText(driehoek.toString());
                root.add(uitvoer, 0, 1);
            }
            catch (DomainException e)
            {
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });
    }

}