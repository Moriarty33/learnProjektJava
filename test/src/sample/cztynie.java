package sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jamin on 20.12.2015.
 */
public class cztynie {
    List<String> warianty = new ArrayList<String>();
    List<String> pytanie = new ArrayList<String>();
    List<String> odpowiedzi = new ArrayList<String>();
    public void wczytaj_z_pliku(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("src/input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;

        try {
            int i = 0;
            while ((line = reader.readLine()) != null) {
                i++;
                if (i==1||i%6==1){
                    pytanie.add(line);
                }else if(i==2||(i%6)==2){
                    odpowiedzi.add(line);
                } else {
                    System.out.printf("");
                    warianty.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.printf(String.valueOf(pytanie)+"\n");
        //System.out.printf(String.valueOf(odpowiedzi)+"\n");
        //System.out.printf(String.valueOf(warianty));

    }
    public String GetPytanie(int number){
        return pytanie.get(number);
    }
    public String GetOdpowiedz(int number){
        return odpowiedzi.get(number);
    }
    public int GetMax(){
        return pytanie.size();
    }

    public String GetWarianty(int number){
        return warianty.get(number);
    }

}
