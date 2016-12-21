package salestaxes;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest {

    @Test
    public void itShouldCreateANewItemWithDefaultValues() {
        String description = "balloons";
        int quantity = 4;
        double price = 5.99;

        Item item = new Item(description, quantity, price);

        assertEquals("balloons", item.getDescription());
        assertEquals(4, item.getQuantity());
        assertEquals(5.99, item.getPrice(), 0.001);
        assertEquals(false, item.isExempt());
        assertEquals(false, item.isImported());
        assertEquals(0.0, item.getTaxes(), 0.001);
    }
}