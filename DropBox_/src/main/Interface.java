import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Created by jamin on 16.01.2016.
 */
public class Interface {
    static Stage primaryStage;
    static Text scenetitle = new Text();
    static ComboBox combobox = new ComboBox();
    static Text title_options = new Text("Wybierz folder dla obserwacji: ");
    static Text kalalog = new Text("Obserwówany katalog: ");
    static Text kalalog_value = new Text();
    static Text Error = new Text();
    static Text Error_value = new Text();

    private static TableView<String> table;
    private ObservableList<String> data;

    public static void init(Stage primaryStage1) throws Exception{
       primaryStage=primaryStage1;
       Button btn = new Button("Zaczynamy?");

       GridPane grid = new GridPane();
       grid.setAlignment(Pos.CENTER);
       grid.setHgap(10);
       grid.setVgap(10);
       grid.setPadding(new Insets(25, 25, 25, 25));
       grid.add(scenetitle, 0, 0, 2, 1);
       grid.add(title_options, 0, 1);
       grid.add(combobox, 1, 1);
       grid.add(btn,2,1);
       grid.add(kalalog, 0, 2);
       grid.add(kalalog_value, 1, 2);

        grid.add(Error, 0, 4);
        grid.add(Error_value, 1, 4);

       listInterface list = new listInterface();
        list.list(primaryStage,grid);

       btn.setOnAction(new EventHandler<ActionEvent>() {
           @Override public void handle(ActionEvent e) {
               Thread myThready = new Thread(new Runnable()
               {
                   public void run() {
                       MyDropboxClient clientObject = new MyDropboxClient();
                       clientObject.getDirectoryToWatch();
                   }
               });
               myThready.start();
           }});
       combobox.getItems().addAll("test","test1","folder3");
       Scene scene = new Scene(grid, 500, 475);
       primaryStage.setScene(scene);
    }
    public String getComboBox(){
        return combobox.getValue().toString();
    }
    public void setScenetitle(String title){
        scenetitle.setText(title);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
    }
    public void setError(String title){
        Error_value.setText(title);
        Error_value.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        Error_value.setFill(Color.RED);
    }
    public void setkalalog_value(String title){
        kalalog_value.setText(title);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 13));
    }

}
