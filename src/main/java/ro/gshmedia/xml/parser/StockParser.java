package ro.gshmedia.xml.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ro.gshmedia.xml.model.Stock;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StockParser {

    private static final String FILENAME = "stock_new/stock1.xml";


    //TODO incearca sa iti dai seama ce facem gresit la citirea din fisier
    // tip: urmareste exmplul de unde am luat codul si vezi cum mai trebuie adaptat
    public List<Stock> readStocks(InputStream file) {


        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            //TODO creaza cate o constanta de tipul String cu numele fiecarui element din fisierul XML pentru stocuri
            // de exemplu: private static final String STOCKS = "stocks";
            NodeList list = doc.getElementsByTagName("stocks");


            List<Stock> stockList = new ArrayList<>();


            for (int temp = 0; temp < list.getLength(); temp++) {

                Node node = list.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    int productId = Integer.parseInt(element.getElementsByTagName("product_id").item(0).getTextContent());
                    int quantity = Integer.parseInt(element.getElementsByTagName("quantity").item(0).getTextContent());

                    Stock stock = new Stock(productId, quantity);
                    stockList.add(stock);


                }
                return stockList;
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }


}
