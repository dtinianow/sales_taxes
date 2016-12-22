package salestaxes;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.Test;
import java.util.HashMap;

public class ItemTest {

    @Test
    public void itShouldCreateANewItemWithDefaultValues() {
        String description = "balloons";
        int quantity = 4;
        double price = 1.00;

        Item item = new Item(description, quantity, price);

        assertThat(item, instanceOf(Item.class));
        assertEquals("balloons", item.getDescription());
        assertEquals(4, item.getQuantity());
        assertEquals(1.00, item.getPrice(), 0.001);
        assertEquals(false, item.isExempt());
        assertEquals(false, item.isImported());
        assertEquals(0.10, item.getTaxes(), 0.001);
    }

    @Test
    public void itShouldDetermineIfItemIsImported() {
        Item importedItemA = new Item("imported chocolate", 2, 1.50);
        Item importedItemB = new Item("imported balloons", 4, 5.99);
        Item nonImportedItemA = new Item("chocolate", 2, 1.50);
        Item nonImportedItemB = new Item("balloons", 4, 5.99);

        assertEquals(true, importedItemA.isImported());
        assertEquals(true, importedItemB.isImported());
        assertEquals(false, nonImportedItemA.isImported());
        assertEquals(false, nonImportedItemB.isImported());
    }

    @Test
    public void itShouldDetermineIfItemIsExempt() {
        Item exemptItemA = new Item("chocolate", 2, 1.50);
        Item exemptItemB = new Item("imported chocolate", 4, 5.99);
        Item nonExemptItemA = new Item("balloons", 2, 1.50);
        Item nonExemptItemB = new Item("imported balloons", 4, 5.99);

        assertEquals(false, nonExemptItemA.isExempt());
        assertEquals(false, nonExemptItemB.isExempt());
        assertEquals(true, exemptItemA.isExempt());
        assertEquals(true, exemptItemB.isExempt());
    }
}