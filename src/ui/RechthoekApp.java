package ui;

import domain.*;
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
    private Vorm vorm;

    public RechthoekApp(GridPane root) {
        init(root, 0);
        invoerHoogte.setOnAction(eventIngaveHoogte -> {
            try{
                hoogte = Integer.parseInt(invoerHoogte.getText());
                vorm = new Rechthoek(punt,breedte,hoogte);
                root.getChildren().clear();
                Text uitvoer = new Text();
                uitvoer.setText(vorm.toString());
                root.add(uitvoer, 0,0);
            }
            catch (NumberFormatException e){
                invoerHoogte.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("hoogte moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
            catch (DomainException e){
                invoerHoogte.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setHeaderText(null);
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }

        });

    }

    public RechthoekApp(GridPane root, Tekening tekening) {
        init(root, 1);
        invoerHoogte.setOnAction(eventIngaveHoogte -> {
            try{
                hoogte = Integer.parseInt(invoerHoogte.getText());
                vorm = new Rechthoek(punt,breedte,hoogte);
                tekening.voegToe(vorm);
                cleanUp(root);
            }
            catch (NumberFormatException e){
                invoerHoogte.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("hoogte moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
            catch (DomainException e){
                invoerHoogte.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setHeaderText(null);
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }

        });
    }

    public void init(GridPane root, int teller) {

        invoerXLinksLabel = new Label("Geef de x-coordinaat van de linkerbovenhoek van de rechthoek ");
        invoerXLinks = new TextField();
        invoerYLinksLabel = new Label("Geef de y-coordinaat van de linkerbovenhoek van de rechthoek ");
        invoerYLinks = new TextField();
        invoerBreedteLabel = new Label("Geef de breedte van de rechthoek");
        invoerBreedte = new TextField();
        invoerHoogteLabel = new Label("Geef de hoogte van de rechthoek");
        invoerHoogte = new TextField();

        root.add(invoerXLinksLabel, 0, teller);
        root.add(invoerXLinks, 1, teller);


        invoerXLinks.setOnAction(eventIngaveX -> {
            try {

                x = Integer.parseInt(invoerXLinks.getText());
                invoerXLinks.setDisable(true);
                root.add(invoerYLinksLabel, 0, teller+1);
                root.add(invoerYLinks, 1, teller+1);
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
                root.add(invoerBreedteLabel, 0, teller + 2);
                root.add(invoerBreedte, 1, teller +2);
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
                root.add(invoerHoogteLabel,0,teller+3);
                root.add(invoerHoogte,1,teller+3);
            } catch (NumberFormatException e){
                invoerBreedte.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("breedte moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

    }
    private void  cleanUp(GridPane root){
        root.getChildren().remove(invoerBreedteLabel);
        root.getChildren().remove(invoerBreedte);
        root.getChildren().remove(invoerHoogte);
        root.getChildren().remove(invoerHoogteLabel);
        root.getChildren().remove(invoerYLinks);
        root.getChildren().remove(invoerYLinksLabel);
        root.getChildren().remove(invoerXLinks);
        root.getChildren().remove(invoerXLinksLabel);

    }
}