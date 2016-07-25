package Parser;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by jamin on 21.11.2015.
 */
public class ValidatorCSV {
    public static void validator(String[] sA) throws IOException {
        ArrayList<String> good = new ArrayList<String>();
        ArrayList<String> error = new ArrayList<String>();
        ArrayList<Integer> s = new ArrayList<Integer>();
        for (int i = 0; i < sA.length; i++){
            if (sA[i] == null){
                s.add(i);
            }
        }
        for (int i = 0; i < (sA.length - s.size()); i++){
            if(sA[i].length() == 9){
                 try {
                     good.add(sA[i]);
                 }catch (NullPointerException e){}
            }else
                 try {
                     error.add(sA[i]);
                 }catch (NullPointerException e){}
        }
        String[] stockArr = new String[good.size()];
        stockArr = good.toArray(stockArr);
        ZapisWCSV.zapis(stockArr,"ok");

        String[] stockArr1 = new String[error.size()];
        stockArr1 = error.toArray(stockArr1);
        ZapisWCSV.zapis(stockArr1,"error");


    }
}
