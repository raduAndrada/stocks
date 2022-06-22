package ro.gshmedia.xml.StockParserTest;

import org.junit.jupiter.api.Test;
import ro.gshmedia.xml.model.Stock;
import ro.gshmedia.xml.parser.StockParser;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class StockParserTest {

    private StockParser stockParser = new StockParser();


    @Test
    public void testReadFromFile() {

        List<Stock> stockList = stockParser.readStocks();
        assertThat(stockList, hasSize(3));

    }
}
