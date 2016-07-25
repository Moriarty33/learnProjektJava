import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        ParseCash("USD");
        ParseCashBank("316"); //там в методі в if є комент, це ід банку
    }


    public static void ParseCash(String s){
// argument  =  AUD AZN GBP BYR DKK USD EUR ISK KZT CAD MDL NOK PLN RUB SGD XDR TRY TMT HUF UZS CZK SEK CHF CNY JPY
        try {
        URL xmlURL = new URL("http://bank-ua.com/export/currrate.xml");
        InputStream xml = xmlURL.openStream();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(xml);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("item");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if(Objects.equals(eElement.getElementsByTagName("char3").item(0).getTextContent(), s))
                    //eElement.getElementsByTagName("date").item(0).getTextContent();  //Дата
                    //eElement.getElementsByTagName("code").item(0).getTextContent();  //Код валюти, нахуй надо
                    //eElement.getElementsByTagName("char3").item(0).getTextContent(); //3 значиний код, той шо в аргументі
                    //eElement.getElementsByTagName("size").item(0).getTextContent();  //кількість на яку ділити треба
                    //eElement.getElementsByTagName("name").item(0).getTextContent();  //імя валюти
                    //eElement.getElementsByTagName("rate").item(0).getTextContent();  //значення валюти
                    //eElement.getElementsByTagName("change").item(0).getTextContent();//як сі змінила
                        System.out.printf("");
                }
            }
            xml.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void ParseCashBank(String s){
// argument  =  AUD AZN GBP BYR DKK USD EUR ISK KZT CAD MDL NOK PLN RUB SGD XDR TRY TMT HUF UZS CZK SEK CHF CNY JPY
        try {
            URL xmlURL = new URL("http://resources.finance.ua/ua/public/currency-cash.xml");
            InputStream xml = xmlURL.openStream();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xml);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("organization");
            System.out.println("Root element " + doc.getDocumentElement().getNodeName());

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    //
                    //ВІДКОМЕНТУЙ ШОБ ПОБАЧИТИ ШО ТУТ ЗА ПОЄБОТА, ТО АЙДІ, ТО ШО ТРЕБА В ----------АГРУМЕНТІ------------- ПОДАВАТИ
                    //
                    //System.out.printf(eElement.getElementsByTagName("title").item(0).getAttributes().getNamedItem("value").getNodeValue() + ":  ");
                    //System.out.printf(eElement.getElementsByTagName("title").item(0).getParentNode().getAttributes().getNamedItem("oldid").getNodeValue() + "\n");

                    if (Objects.equals(s, eElement.getElementsByTagName("title").item(0).getParentNode().getAttributes().getNamedItem("oldid").getNodeValue())) {
                    System.out.printf(eElement.getElementsByTagName("title").item(0).getAttributes().getNamedItem("value").getNodeValue()+"\n");        // назва банку
                    System.out.printf(eElement.getElementsByTagName("branch").item(0).getAttributes().getNamedItem("value").getNodeValue()+"\n");       //паходу це відкритий чи закритий
                        //System.out.printf(eElement.getElementsByTagName("region ").item(0).getAttributes().getNamedItem("value").getNodeValue()+"\n");// хуйня якась
                        //System.out.printf(eElement.getElementsByTagName("city ").item(0).getAttributes().getNamedItem("value").getNodeValue()+"\n");  // хуйня якась
                    System.out.printf(eElement.getElementsByTagName("phone").item(0).getAttributes().getNamedItem("value").getNodeValue()+"\n");        //телефон
                    System.out.printf(eElement.getElementsByTagName("address").item(0).getAttributes().getNamedItem("value").getNodeValue()+"\n");      //адреса
                    System.out.printf(eElement.getElementsByTagName("link").item(0).getAttributes().getNamedItem("href").getNodeValue()+"\n");          //силка


                    //то зара буде діставати першу валюту
                        System.out.printf(eElement.getElementsByTagName("currencies").item(0).getFirstChild().getAttributes().getNamedItem("id").getNodeValue()
                            +": "+eElement.getElementsByTagName("currencies").item(0).getFirstChild().getAttributes().getNamedItem("br").getNodeValue()
                            +"  "+ eElement.getElementsByTagName("currencies").item(0).getFirstChild().getAttributes().getNamedItem("ar").getNodeValue() + "\n");
                    //то зара буде діставати другу валюту
                        System.out.printf(eElement.getElementsByTagName("currencies").item(0).getChildNodes().item(1).getAttributes().getNamedItem("id").getNodeValue()
                            +": "+eElement.getElementsByTagName("currencies").item(0).getChildNodes().item(1).getAttributes().getNamedItem("br").getNodeValue()
                            +"  "+ eElement.getElementsByTagName("currencies").item(0).getChildNodes().item(1).getAttributes().getNamedItem("ar").getNodeValue() + "\n");
                    //то зара буде діставати третю  валюту
                        System.out.printf(eElement.getElementsByTagName("currencies").item(0).getChildNodes().item(2).getAttributes().getNamedItem("id").getNodeValue()
                            +": "+eElement.getElementsByTagName("currencies").item(0).getChildNodes().item(2).getAttributes().getNamedItem("br").getNodeValue()
                            +"  "+ eElement.getElementsByTagName("currencies").item(0).getChildNodes().item(2).getAttributes().getNamedItem("ar").getNodeValue() + "\n");


                    }
                }
            }
            xml.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
