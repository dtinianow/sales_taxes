package salestaxes;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class ReceiptTest {

    @Test
    public void itCanCreateANewReceipt() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("balloons", 2, 1.50));
        items.add(new Item("chocolate", 4, 0.75));
        Receipt receipt = new Receipt(items);

        assertThat(receipt, instanceOf(Receipt.class));
        assertEquals(items, receipt.getItems());
        assertEquals(0.0, receipt.getSalesTaxes(), 0.001);
        assertEquals(0.0, receipt.getTotalCost(), 0.001);
    }

    @Test
    public void itCanSetTotalTaxesByAddingToExistingAmount() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("balloons", 2, 1.50));
        items.add(new Item("chocolate", 4, 0.75));
        Receipt receipt = new Receipt(items);

        assertEquals(0.0, receipt.getSalesTaxes(), 0.001);

        receipt.setTotalTaxes(2.17);

        assertEquals(2.17, receipt.getSalesTaxes(), 0.001);

        receipt.setTotalTaxes(1.43);

        assertEquals(3.60, receipt.getSalesTaxes(), 0.001);
    }

    @Test
    public void itCanSetTotalCostByAddingToExistingAmount() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("balloons", 2, 1.50));
        items.add(new Item("chocolate", 4, 0.75));
        Receipt receipt = new Receipt(items);

        assertEquals(0.0, receipt.getTotalCost(), 0.001);

        receipt.setTotalCost(1.40);

        assertEquals(1.40, receipt.getTotalCost(), 0.001);

        receipt.setTotalCost(0.61);

        assertEquals(2.01, receipt.getTotalCost(), 0.001);
    }

    @Test
    public void itCanGetItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("balloons", 2, 1.50));
        Receipt receipt = new Receipt(items);
        Item item = items.get(0);

        assertThat(items, instanceOf(List.class));
        assertEquals(items, receipt.getItems());
        assertEquals("balloons", item.getDescription());
        assertEquals(2, item.getQuantity());
        assertEquals(1.50, item.getPrice(), 0.001);
    }

    @Test
    public void itCanGetSalesTaxes() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("balloons", 2, 1.50));
        Receipt receipt = new Receipt(items);
        receipt.setTotalTaxes(2.34);

        assertEquals(2.34, receipt.getSalesTaxes(), 0.001);
    }

    @Test
    public void itCanGetTotalCost() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("balloons", 2, 1.50));
        Receipt receipt = new Receipt(items);
        receipt.setTotalCost(5.22);

        assertEquals(5.22, receipt.getTotalCost(), 0.001);
    }
}