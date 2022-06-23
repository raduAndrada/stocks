package ro.gshmedia.xml.StockParserTest;

import org.junit.jupiter.api.Test;
import ro.gshmedia.xml.model.Stock;
import ro.gshmedia.xml.parser.StockParser;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class StockParserTest {

    // am adaugat folderul de test/resource cu documentul .xml stocks_test_1.xml
    private static final String TEST_FILE_1 = "stock_new/stocks_test_1.xml";
    private StockParser stockParser = new StockParser();


    //TODO verifica cum trebuie sa parsam fisierul nostru de test ca sa treaca testul asta
    @Test
    public void testReadFromFile() {
        List<Stock> stockList = stockParser.readStocks(
                // asta este clasa care trebuie folosita ca sa putem citi din fisierul /resources
                getClass().getClassLoader().getResourceAsStream(TEST_FILE_1)
        );
        assertThat(stockList, hasSize(3));
    }

    //TODO creaza urmatoarele fisiere in test/resources:
    // 1. un fisier xml care nu respecta formatul din fisierul exemplu (numele tagurilor sunt gresite, formatul e gresit etc.)
    // 2. un fisier xml care sa contina un tag de <stocks></stocks> fara alte elemente
    // 3. un fisier xml care sa contina stocuri dar, stocurile din interior sa nu aiba fie id_produs, fie quantity

    //TODO creaza cate un test care sa citeasca din fiecare fisier creat anterior
    // creaza cate o constanta pentru fiecare fisier creat
    // hint: foloseste metoda de citire din testul de mai sus
}
