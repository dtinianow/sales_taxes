package salestaxes;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class TaxCalculatorTest {

    @Test
    public void itShouldApplySalesTaxesToNonExemptAndNonImportedItem() {
        List<Item> items = new ArrayList<>();
        Item nonExemptAndNonImportedItem = new Item("balloons", 2, 1.00);
        items.add(nonExemptAndNonImportedItem);
        Receipt receipt = new Receipt(items);

        assertEquals(0.0, nonExemptAndNonImportedItem.getTaxes(), 0.001);
        assertEquals(0.0, receipt.getSalesTaxes(), 0.001);
        assertEquals(0.0, receipt.getTotalCost(), 0.001);

        TaxCalculator.applySalesTaxes(receipt);

        assertEquals(0.10, nonExemptAndNonImportedItem.getTaxes(), 0.001);
        assertEquals(0.10, receipt.getSalesTaxes(), 0.001);
        assertEquals(1.00, nonExemptAndNonImportedItem.getPrice(), 0.001);
        assertEquals(1.10, receipt.getTotalCost(), 0.001);
    }

    @Test
    public void itShouldApplySalesTaxesToExemptAndNonImportedItem() {
        List<Item> items = new ArrayList<>();
        Item exemptAndNonImportedItem = new Item("chocolate", 2, 1.00);
        items.add(exemptAndNonImportedItem);
        Receipt receipt = new Receipt(items);

        assertEquals(0.0, exemptAndNonImportedItem.getTaxes(), 0.001);
        assertEquals(0.0, receipt.getSalesTaxes(), 0.001);
        assertEquals(0.0, receipt.getTotalCost(), 0.001);

        TaxCalculator.applySalesTaxes(receipt);

        assertEquals(0.00, exemptAndNonImportedItem.getTaxes(), 0.001);
        assertEquals(0.00, receipt.getSalesTaxes(), 0.001);
        assertEquals(1.00, exemptAndNonImportedItem.getPrice(), 0.001);
        assertEquals(1.00, receipt.getTotalCost(), 0.001);
    }

    @Test
    public void itShouldApplySalesTaxesToExemptandImportedItem() {
        List<Item> items = new ArrayList<>();
        Item exemptAndImportedItem = new Item("imported chocolate", 2, 1.00);
        items.add(exemptAndImportedItem);
        Receipt receipt = new Receipt(items);

        assertEquals(0.0, exemptAndImportedItem.getTaxes(), 0.001);
        assertEquals(0.0, receipt.getSalesTaxes(), 0.001);
        assertEquals(0.0, receipt.getTotalCost(), 0.001);

        TaxCalculator.applySalesTaxes(receipt);

        assertEquals(0.05, exemptAndImportedItem.getTaxes(), 0.001);
        assertEquals(0.05, receipt.getSalesTaxes(), 0.001);
        assertEquals(1.00, exemptAndImportedItem.getPrice(), 0.001);
        assertEquals(1.05, receipt.getTotalCost(), 0.001);
    }

    @Test
    public void itShouldApplySalesTaxesToNonExemptandImportedItem() {
        List<Item> items = new ArrayList<>();
        Item nonExemptAndImportedItem = new Item("imported balloons", 2, 1.00);
        items.add(nonExemptAndImportedItem);
        Receipt receipt = new Receipt(items);

        assertEquals(0.0, nonExemptAndImportedItem.getTaxes(), 0.001);
        assertEquals(0.0, receipt.getSalesTaxes(), 0.001);
        assertEquals(0.0, receipt.getTotalCost(), 0.001);

        TaxCalculator.applySalesTaxes(receipt);

        assertEquals(0.15, nonExemptAndImportedItem.getTaxes(), 0.001);
        assertEquals(0.15, receipt.getSalesTaxes(), 0.001);
        assertEquals(1.00, nonExemptAndImportedItem.getPrice(), 0.001);
        assertEquals(1.15, receipt.getTotalCost(), 0.001);
    }

    @Test
    public void itShouldApplySalesTaxesToMultipleItems() {
        List<Item> items = new ArrayList<>();
        Item itemA = new Item("balloons", 2, 1.00);
        Item itemB = new Item("imported chocolate", 2, 1.00);
        items.add(itemA);
        items.add(itemB);
        Receipt receipt = new Receipt(items);

        assertEquals(0.0, itemA.getTaxes(), 0.001);
        assertEquals(0.0, itemB.getTaxes(), 0.001);
        assertEquals(0.0, receipt.getSalesTaxes(), 0.001);
        assertEquals(0.0, receipt.getTotalCost(), 0.001);

        TaxCalculator.applySalesTaxes(receipt);

        assertEquals(0.10, itemA.getTaxes(), 0.001);
        assertEquals(0.05, itemB.getTaxes(), 0.001);
        assertEquals(0.15, receipt.getSalesTaxes(), 0.001);
        assertEquals(2.15, receipt.getTotalCost(), 0.001);
    }
}