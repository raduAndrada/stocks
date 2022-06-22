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
import java.util.ArrayList;
import java.util.List;

public class StockParser {

    private static final String FILENAME = "stock_new/stock1.xml";

    public List<Stock> readStocks() {


        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(FILENAME));
            doc.getDocumentElement().normalize();


            // get <staff>
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
