/**
 * Created by jamin on 30.04.2016.
 */
import com.google.gson.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
public class main {
    public static void main(String[] args) {
        json();
    }

    public static void json(){
        try {

            JsonObject album = new JsonObject();
            JsonObject sityurl = new JsonObject();

            JsonArray datasets = new JsonArray();
            JsonArray imgsets = new JsonArray();

            JsonObject categoryname = new JsonObject();

            int counter = 1;
            Elements elementsImgs;

            String sity = "/uk/belaya-tserkov/";

            String nameimage = "";
            Document doc = JsoupUtils.fetch("http://www.gotoshop.net.ua" + sity + "discounts/",false);//parse();

            sityurl.addProperty("sity_cutyurl", "/uk/belaya-tserkov/");

            // categoryname.addProperty("album_site", sity);

            Elements elementsDiv = doc.select("div.row.shop-discounts-wrapper > div.col-xs-6.shop-discounts-list");


            for (Element element : elementsDiv) {

                if(element.select("h3").select("a.shop-link").attr("href").equalsIgnoreCase(sity + "shops/roshen/")){
                }else {

                    String kategoryName = "";
                    String kategoryUrl = "";
                    Elements li = element.select("ul.discounts-list li");

                        kategoryName = li.select("a").text();
                        //  System.out.println(kategoryName);
                        kategoryUrl = li.select("a").attr("href");//.replace("/'", "");

                        //  imgsets.add(kategoryName);
                        // imgsets.add(kategoryUrl);

                        //  test.addProperty("name", kategoryName);

                        JsonObject categorydata = new JsonObject();
                        HashMap<String, JsonObject> map = new HashMap<String, JsonObject>();
                        categorydata.addProperty("url",kategoryUrl);
                        categorydata.addProperty("name",kategoryName);
                        map.put("json" +li, categorydata);
                        datasets.add(String.valueOf(map.get("json" + li)));

                }
                //   datasets.add(test);

            }
            try {
                sityurl.add("dataset", datasets);

                Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls()
                        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
                System.out.println(gson.toJson(sityurl));

                System.out.println();
                // Writing to a file
                File file=new File("CountryJSONFile.json");
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(file);
                //  System.out.println("Writing JSON object to file");
                System.out.println("-----------------------");
                fileWriter.write(sityurl.toString());
                fileWriter.flush();
                fileWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
