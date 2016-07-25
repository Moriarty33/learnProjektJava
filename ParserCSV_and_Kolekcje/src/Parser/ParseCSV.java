package Parser;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jamin on 21.11.2015.
 */
public class ParseCSV {
    static String NameKolun;
    static String csv_name;
    public static void ParseCsv(String csvFilename) throws IOException {
        String[] row = null;
        CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
        List content = csvReader.readAll();
        ArrayList<String> sA = new ArrayList<String>();
        int i = 0;
        for (Object object : content) {
            row = (String[]) object;
           // System.out.println(row[0] + "  "+ row[1]);
            try{
                sA.add(row[1]);
                NameKolun=row[0];
            }
            catch (NullPointerException e){
                e.printStackTrace();
            }
            i++;
        }
        csvReader.close();
        String[] stockArr = new String[sA.size()];
        stockArr = sA.toArray(stockArr);
        duplicateCSV.duplicate(stockArr);

    }
}
