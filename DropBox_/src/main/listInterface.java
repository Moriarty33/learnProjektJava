
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
 * Created by jamin on 16.01.2016.
 */

public class listInterface {
    static ObservableList<String> list = FXCollections.observableArrayList();
    static ListView<String> leftListView = new ListView<String>(list);
    GridPane gridpane;
    Stage primaryStage;
    public void list(Stage primaryStage1, GridPane gridpane1){
        gridpane=gridpane1;
        primaryStage=primaryStage1;
        Label candidatesLbl = new Label("Przeslane pliki: ");
        GridPane.setHalignment(candidatesLbl, HPos.CENTER);
        gridpane.add(candidatesLbl,0,3);

        leftListView.setPrefWidth(350);
        leftListView.setPrefHeight(150);
        gridpane.add(leftListView, 2, 3);

    }

  public void addfile(String title){
        try {
            list.add(title);
            leftListView = new ListView<String>(list);
        }catch (Exception e){

        }
    }

}
