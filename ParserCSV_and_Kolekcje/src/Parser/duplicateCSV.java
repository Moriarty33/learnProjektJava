package Parser;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by jamin on 21.11.2015.
 */
public class duplicateCSV {
    public static String[] array;

    public static void duplicate(String[] sA) throws IOException {
        String[] sB = new String[sA.length];
        HashMap<String, String> shMap = new HashMap<String, String>();
//Usuwanie duplikatów po paselu
        for (int i = 0; i < sA.length; i++) shMap.put(sA[i], "");
        int j = 0;
        for (int i = 0; i < sA.length; i++) {
            if (shMap.get(sA[i]).equals("")) {
                shMap.put(sA[i], sA[i]);
                sB[j++] = sA[i];
            }
        }
        array = sB;
        for (int i = 0; i < sB.length; i++) {
            if (sB[i] != null) {
                //  System.out.println(sB[i] + " ");
            }


        } ValidatorCSV.validator(sB);
    }
}