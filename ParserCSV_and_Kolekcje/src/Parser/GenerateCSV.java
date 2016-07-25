package Parser;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jamin on 21.11.2015.
 */
public class GenerateCSV {

    public static void generateCsvFile(String csv,int record) throws IOException {
        Random generator = new Random();
        CSVWriter writer = new CSVWriter(new FileWriter(csv));
        String no_random = String.valueOf(181756642);
        List<String[]> data = new ArrayList<String[]>();
        int i = 0;
        while (true) {
            if (!(i < record)) break;
                if(i%13 == 0){
                    data.add(new String[]{"Pesel", no_random});
                }
                else
                {
                    data.add(new String[]{"Pesel", String.valueOf(generator.nextInt(999999999))});
                }
            i++;
        }
        writer.writeAll(data);

        writer.close();

    }
}
