import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("DropBox");
        primaryStage.setScene(new Scene(root, 600, 475));
        Interface inte = new Interface();
                inte.init(primaryStage);

        primaryStage.show();
        Thread myThready = new Thread(new Runnable()
        {
            public void run()
            {
                Properties propertiesObject = new Properties();
                propertiesObject.readProperties();
                DropboxAuth dropboxObject = new DropboxAuth();
                dropboxObject.autorizeDropbox();

            }
        });
        myThready.start();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
