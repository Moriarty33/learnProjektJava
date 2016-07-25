import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Properties {

    static String folderToWatch,accessToken;
    static int threadPool, secondBetweenStatisticWriting;

    void readProperties(){
        Interface inte = new Interface();
        try {
            File fileProperties = new File("properties.txt");
            Scanner dataScanner = new Scanner(fileProperties);
            threadPool = Integer.parseInt(dataScanner.nextLine().split("=")[1]);
            accessToken = dataScanner.nextLine().split("=")[1];
            secondBetweenStatisticWriting = Integer.parseInt(dataScanner.nextLine().split("=")[1]);
        } catch(FileNotFoundException e) {
            inte.setError("brak pliku properties.txt !");
        }
    }
}
