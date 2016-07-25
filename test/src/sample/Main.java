package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.Random;

public class Main extends Application {
    int oldnumber=0;
    float dobre=0;
    float bledne=0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Test");
        final ToggleGroup group = new ToggleGroup();
        primaryStage.setScene(new Scene(root, 500, 475));
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        cztynie czyt = new cztynie();
        czyt.wczytaj_z_pliku();
        int number = 0;
        Scene scene = new Scene(grid, 500, 475);

        Text scenetitle = new Text("Witam w mojim testowniku");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label Pytanie = new Label("Pytanie: ");
        grid.add(Pytanie, 0, 1);

        final Text PytanieText = new Text();
        grid.add(PytanieText, 1, 1);

        Label pw = new Label("Odpowiedz:");
        grid.add(pw, 0, 2);

        final RadioButton RadioButton = new RadioButton();
        grid.add(RadioButton, 1, 2);
        RadioButton.setToggleGroup(group);
        final RadioButton RadioButton1 = new RadioButton();
        grid.add(RadioButton1, 1, 3);
        RadioButton1.setToggleGroup(group);
        final RadioButton RadioButton2 = new RadioButton();
        grid.add(RadioButton2, 1, 4);
        RadioButton2.setToggleGroup(group);
        final RadioButton RadioButton3 = new RadioButton();
        grid.add(RadioButton3, 1, 5);
        RadioButton3.setToggleGroup(group);

        Button btn = new Button("Zaczynamy?");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 7);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 8);


        Label dobra = new Label("Ilość Poprwanych odpowiedzi:");
        grid.add(dobra, 0, 9);
        final Text dobreodpowiedz = new Text(dobre+"");
        grid.add(dobreodpowiedz, 1, 9);

        Label zla = new Label("Ilość blędnych odpowiedzi:");
        grid.add(zla, 0, 10);
        final Text zleodpowiedz = new Text(bledne +"");
        grid.add(zleodpowiedz, 1, 10);

        Label procentlabel = new Label("Procent dobrych odpowiedzi");
        grid.add(procentlabel, 0, 11);
        final Text procent = new Text();
        grid.add(procent, 1, 11);
        renderpytania(RadioButton,RadioButton1,RadioButton2,RadioButton3,actiontarget,PytanieText,btn);
        Label labelavtor = new Label("Wykonal: ");
        grid.add(labelavtor, 0, 13);
        Label labelavtor1 = new Label("Bohdan Yaminskyy 207648");
        grid.add(labelavtor1, 0, 14);
        btn.setOnAction(e->handoption(RadioButton,RadioButton1,RadioButton2,RadioButton3,actiontarget,PytanieText,dobreodpowiedz,zleodpowiedz,btn,procent));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

private void handoption(RadioButton RadioButton, RadioButton RadioButton1, RadioButton RadioButton2, RadioButton RadioButton3, Text text, Text pytanie,Text dobreodpowiedz,Text zleodpowiedz,Button btn,Text procent){
    cztynie czyt = new cztynie();
    czyt.wczytaj_z_pliku();


    if(RadioButton.isSelected()){
        if (Objects.equals(RadioButton.getText(),czyt.GetOdpowiedz(oldnumber))){
            setDobre(dobreodpowiedz,procent);
        }else
        setbledne(zleodpowiedz,procent);
        renderpytania(RadioButton,RadioButton1,RadioButton2,RadioButton3,text,pytanie,btn);

    }
    if(RadioButton1.isSelected()){
        if (Objects.equals(RadioButton1.getText(), czyt.GetOdpowiedz(oldnumber))){
            setDobre(dobreodpowiedz,procent);
        }else
            setbledne(zleodpowiedz,procent);

        renderpytania(RadioButton,RadioButton1,RadioButton2,RadioButton3,text,pytanie,btn);
    }
    if(RadioButton2.isSelected()){
        if (Objects.equals(RadioButton2.getText(), czyt.GetOdpowiedz(oldnumber))){
            setDobre(dobreodpowiedz,procent);
        }else
            setbledne(zleodpowiedz,procent);
        renderpytania(RadioButton,RadioButton1,RadioButton2,RadioButton3,text,pytanie,btn);
    }
    if(RadioButton3.isSelected()){
        if (Objects.equals(RadioButton3.getText(), czyt.GetOdpowiedz(oldnumber))){
            setDobre(dobreodpowiedz,procent);
        }else
            setbledne(zleodpowiedz,procent);
        renderpytania(RadioButton,RadioButton1,RadioButton2,RadioButton3,text,pytanie,btn);


    }
}
    private void renderpytania(RadioButton RadioButton, RadioButton RadioButton1, RadioButton RadioButton2, RadioButton RadioButton3, Text text, Text pytanie,Button btn){
        cztynie czyt = new cztynie();
        czyt.wczytaj_z_pliku();
        Random generator = new Random();
        int number=generator.nextInt(czyt.GetMax());
        pytanie.setText(czyt.GetPytanie(number));
        RadioButton.setText(czyt.GetWarianty((number*4)+0));
        RadioButton1.setText(czyt.GetWarianty((number*4)+1));
        RadioButton2.setText(czyt.GetWarianty((number*4)+2));
        RadioButton3.setText(czyt.GetWarianty((number*4)+3));
        oldnumber=number;
        RadioButton.setSelected(false);
        RadioButton1.setSelected(false);
        RadioButton2.setSelected(false);
        RadioButton3.setSelected(false);
        btn.setText("Akceptuje");
    }
    private void setDobre(Text dobre1,Text procent){
        dobre++;
        dobre1.setText(dobre +"");
        dobre1.setFill(Color.GREEN);
        setprocent(procent);
    }
    private void setbledne(Text bledne1,Text procent){
        bledne++;
        bledne1.setText(bledne +"");
        bledne1.setFill(Color.RED);
        setprocent(procent);
    }
    private void setprocent(Text procent){
        if((dobre != 0) || (bledne != 0)) {
            procent.setText((dobre / (bledne + dobre)*100) + "%");
            procent.setFill(Color.BLUE);
        }else System.out.printf("zero");
    }
    public static void main(String[] args) {
        launch(args);
    }
}
