import com.google.gson.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
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

            sityurl.addProperty("sity_cutyurl", sity);

            // categoryname.addProperty("album_site", sity);

            Elements elementsDiv = doc.select("div.row.shop-discounts-wrapper > div.col-xs-6.shop-discounts-list");


            for (Element element : elementsDiv) {
                if(element.select("h3").select("a.shop-link").attr("href").equalsIgnoreCase(sity + "shops/roshen/")){
                }else {

                    String kategoryName = "";
                    String kategoryUrl = "";
                    Elements li = element.select("ul.discounts-list li");

                    for (int ii = 0; ii < li.size(); ii++) {

                        kategoryName = li.get(ii).select("a").text();
                        //  System.out.println(kategoryName);
                        kategoryUrl = li.get(ii).select("a").attr("href");//.replace("/'", "");

                        //  imgsets.add(kategoryName);
                        // imgsets.add(kategoryUrl);

                        //  test.addProperty("name", kategoryName);

                        JsonObject categorydata = new JsonObject();
                        HashMap<String, JsonObject> map = new HashMap<String, JsonObject>();
                        categorydata.addProperty("url",kategoryUrl);
                        categorydata.addProperty("name",kategoryName);
                        map.put("json" + ii, categorydata);
                        datasets.add(String.valueOf(map.get("json" + ii)));


                        // System.out.println(kategoryName);
                        // System.out.println(kategoryname);


                        /*int end = 20;
                        try {
                            for (int i = 1; i < end; i++) {

                                Document docimages = JsoupUtils.fetch("http://www.gotoshop.net.ua" + kategoryUrl +"?page=" + i + "&is_ajax=1", false);//parse();

                                elementsImgs = docimages.select("div.item").select("a.image-link");
                                if(!docimages.select("div.alert.alert-warning").select("p").isEmpty()){
                                  //  System.out.println(docimages.select("div.alert.alert-warning").select("p").text()+" NOT FOUND");
                                    end = i;
                                    break;
                                };
                                for (Element elementw : elementsImgs) {
                                  //  kategoryimg.put("imgurl",elementw.select("img").attr("src"));
                                  //  System.out.println(elementw.select("img").attr("src"));

                                 //   kategoryname.put("imgdata", kategoryimg);
                                   // counter++;
                                }


                            }

                        }catch(Exception e){
                            e.printStackTrace();
                        }*/

                    }


                }
                //   datasets.add(test);
                sityurl.add("dataset", datasets);

                Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
                System.out.println(gson.toJson(sityurl));

                System.out.println();
            }
            try {
                // Writing to a file
                File file=new File("E:\\gogi\\CountryJSONFile.json");
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
