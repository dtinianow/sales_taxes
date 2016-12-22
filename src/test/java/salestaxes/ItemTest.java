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
        assertEquals(description, item.getDescription());
        assertEquals(quantity, item.getQuantity());
        assertEquals(price, item.getPrice(), 0.001);
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

    @Test
    public void itCanGetQuantity() {
        String description = "balloons";
        int quantity = 4;
        double price = 1.00;

        Item item = new Item(description, quantity, price);

        int expected = item.getQuantity();

        assertEquals(expected, quantity);
    }

    @Test
    public void itCanGetDescription() {
        String description = "balloons";
        int quantity = 4;
        double price = 1.00;

        Item item = new Item(description, quantity, price);

        String expected = item.getDescription();

        assertEquals(expected, description);
    }

    @Test
    public void itCanGetPrice() {
        String description = "balloons";
        int quantity = 4;
        double price = 1.00;

        Item item = new Item(description, quantity, price);

        double expected = item.getPrice();

        assertEquals(expected, price, 0.001);
    }

    @Test
    public void itCanGetTaxes() {
        String description = "balloons";
        int quantity = 4;
        double price = 1.00;

        Item item = new Item(description, quantity, price);

        double expected = item.getTaxes();

        assertEquals(expected, 0.10, 0.001);
    }

    @Test
    public void itCanGetPriceWithTaxes() {
        String description = "balloons";
        int quantity = 4;
        double price = 1.00;

        Item item = new Item(description, quantity, price);

        double expected = item.getPriceWithTaxes();
        double priceWithTaxes = price + item.getTaxes();

        assertEquals(expected, priceWithTaxes, 0.001);
    }

    @Test
    public void itCanGetExemptionStatus() {
        String description = "chocolate";
        int quantity = 4;
        double price = 1.00;

        Item item = new Item(description, quantity, price);

        boolean expected = item.isExempt();

        assertEquals(expected, true);
    }

    @Test
    public void itCanGetImportationStatus() {
        String description = "imported chocolate";
        int quantity = 4;
        double price = 1.00;

        Item item = new Item(description, quantity, price);

        boolean expected = item.isImported();

        assertEquals(expected, true);
    }
}