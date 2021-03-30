package ui;

import domain.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class DriehoekApp
{
    private Label invoerXPunt1Label, invoerYPunt1Label,invoerXPunt2Label, invoerYPunt2Label,invoerXPunt3Label, invoerYPunt3Label;
    private TextField invoerXPunt1, invoerYPunt1, invoerXPunt2, invoerYPunt2, invoerXPunt3, invoerYPunt3;
    private Punt punt1,punt2,punt3;
    private Vorm vorm;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    public DriehoekApp(GridPane root) {
        init(root, 0);
        invoerYPunt3.setOnAction(eventXPunt3Ingave ->
        {
            try
            {
                punt3 = new Punt(Integer.parseInt(invoerXPunt3.getText()),Integer.parseInt(invoerYPunt3.getText()));
                vorm = new Driehoek(punt1,punt2,punt3);
                root.getChildren().clear();
                Text uitvoer = new Text();
                uitvoer.setText(vorm.toString());
                root.add(uitvoer, 0, 1);
            }
            catch (NumberFormatException ne){
                invoerYPunt3.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y-coördinaat moet een geheel getal zijn.");
                foutenboodschap.showAndWait();
            }
            catch (DomainException e)
            {
                invoerYPunt3.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });
    }

    public DriehoekApp(GridPane root, Tekening tekening) {
        init(root, 1);
        invoerYPunt3.setOnAction(eventXPunt3Ingave ->
        {
            try
            {
                punt3 = new Punt(Integer.parseInt(invoerXPunt3.getText()),Integer.parseInt(invoerYPunt3.getText()));
                vorm = new Driehoek(punt1,punt2,punt3);
                tekening.voegToe(vorm);
                cleanUp(root);
            }
            catch (NumberFormatException ne){
                invoerYPunt3.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y-coördinaat moet een geheel getal zijn.");
                foutenboodschap.showAndWait();
            }
            catch (DomainException e)
            {
                invoerYPunt3.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });
    }

    public void init(GridPane root, int teller)
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

        root.add(invoerXPunt1Label,0,teller);
        root.add(invoerXPunt1,1,teller);
        root.add(invoerYPunt1Label,0,teller+1);
        root.add(invoerYPunt1,1,teller+1);

        invoerXPunt1.setOnAction(eventXPunt1Ingave ->
        {
            punt1 = new Punt(Integer.parseInt(invoerXPunt1.getText()),Integer.parseInt(invoerYPunt1.getText()));
            root.getChildren().clear();
            root.add(invoerXPunt2Label,0,teller);
            root.add(invoerXPunt2,1,teller);
            root.add(invoerYPunt2Label,0,teller+1);
            root.add(invoerYPunt2,1,teller+1);
        });

        invoerYPunt1.setOnAction(eventXPunt1Ingave ->
        {
            punt1 = new Punt(Integer.parseInt(invoerXPunt1.getText()),Integer.parseInt(invoerYPunt1.getText()));
            root.getChildren().clear();
            root.add(invoerXPunt2Label,0,teller);
            root.add(invoerXPunt2,1,teller);
            root.add(invoerYPunt2Label,0,teller+1);
            root.add(invoerYPunt2,1,teller+1);
        });

        invoerYPunt2.setOnAction(eventXPunt2Ingave ->
        {
            punt2 = new Punt(Integer.parseInt(invoerXPunt2.getText()),Integer.parseInt(invoerYPunt2.getText()));
            root.getChildren().clear();
            root.add(invoerXPunt3Label,0,teller);
            root.add(invoerXPunt3,1,teller);
            root.add(invoerYPunt3Label,0,teller+1);
            root.add(invoerYPunt3,1,teller+1);
        });


    }
    private void  cleanUp(GridPane root){
        root.getChildren().remove(invoerXPunt1);
        root.getChildren().remove(invoerXPunt1Label);
        root.getChildren().remove(invoerXPunt2);
        root.getChildren().remove(invoerXPunt2Label);
        root.getChildren().remove(invoerXPunt3);
        root.getChildren().remove(invoerXPunt3Label);
        root.getChildren().remove(invoerYPunt1);
        root.getChildren().remove(invoerYPunt1Label);
        root.getChildren().remove(invoerYPunt2);
        root.getChildren().remove(invoerYPunt2Label);
        root.getChildren().remove(invoerYPunt3);
        root.getChildren().remove(invoerYPunt3Label);


    }

}