package Parser;

import com.opencsv.CSVWriter;
import properties.CrunchifyGetPropertyValues;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by jamin on 21.11.2015.
 */
public class ZapisWCSV {
    public static void zapis(String[] sA, String status) throws IOException {
        List<String[]> data = new ArrayList<String[]>();
        CrunchifyGetPropertyValues properties = new CrunchifyGetPropertyValues();
        String name_plik = properties.getPropValues("name_plik");
        String error_name_plik =  properties.getPropValues("error_name_plik");
        int number_plik = sA.length;
        int num = 0;
        int lux =0;
        int define_rozmiar = Integer.parseInt(properties.getPropValues("rowsPerFile"));
        if (status == "ok") {
            try {
                number_plik /= define_rozmiar;
                number_plik++;
            }catch (NullPointerException e){}
            //System.out.printf(String.valueOf(number_plik));

            while (num!=number_plik){
                if (lux%define_rozmiar == 0) {
                        if (num==number_plik-1)
                                {
                                   lux=sA.length;
                                }
                        else {
                            lux += define_rozmiar;
                        }
                    for (int i = num * define_rozmiar; i < lux; i++) {
                        data.add(new String[]{ParseCSV.NameKolun, sA[i]});
                    }
                    num++;

                }
                String csv = name_plik + "_" + num + ".csv";
                CSVWriter writer = new CSVWriter(new FileWriter(csv));
                writer.writeAll(data);

                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                data.clear();
            }

        }else if( status == "error"){
            try {
                number_plik /= define_rozmiar;
                number_plik++;
            }catch (NullPointerException e){}
            //System.out.printf(String.valueOf(number_plik));

            while (num!=number_plik){
                if (lux%define_rozmiar == 0) {
                    if (num==number_plik-1)
                    {
                        lux=sA.length;
                    }
                    else {
                        lux += define_rozmiar;
                    }
                    for (int i = num * define_rozmiar; i < lux; i++) {
                        data.add(new String[]{ParseCSV.NameKolun, sA[i]});
                    }
                    num++;

                }
                String csv = error_name_plik + "_" + num + ".csv";
                CSVWriter writer = new CSVWriter(new FileWriter(csv));
                writer.writeAll(data);

                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                data.clear();
            }
        }else System.out.printf("bad status");
    }
}

