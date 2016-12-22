package salestaxes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class FormatterTest {

    @Test
    public void itShouldFormatReceipt() {
        List<Item> items = new ArrayList<>();
        Item itemA = new Item("balloons", 2, 1.00);
        Item itemB = new Item("imported chocolate", 1, 2.50);
        items.add(itemA);
        items.add(itemB);
        Receipt receipt = new Receipt(items);

        String receiptText = Formatter.formatReceipt(receipt);
        String expected = "2 balloons: 1.10\n1 imported chocolate: 2.65\nSales Taxes: 0.25\nTotal: 3.75";

        assertEquals(expected, receiptText);
    }
}