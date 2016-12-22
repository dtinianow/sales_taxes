package salestaxes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaxCalculatorTest {

    @Test
    public void itShouldCalculateSalesTaxesForNonExemptNonImportedItem() {
        Item nonExemptNonImported = new Item("balloons", 2, 1.00);
        double tax = TaxCalculator.calculateSalesTaxes(nonExemptNonImported);

        assertEquals(0.10, nonExemptNonImported.getTaxes(), 0.001);
        assertEquals(tax, 0.10, 0.001);
    }

    @Test
    public void itShouldCalculateSalesTaxesForExemptNonImportedItem() {
        Item exemptNonImported = new Item("chocolate", 2, 1.00);
        double tax = TaxCalculator.calculateSalesTaxes(exemptNonImported);

        assertEquals(0.0, exemptNonImported.getTaxes(), 0.001);
        assertEquals(tax, 0.0, 0.001);
    }

    @Test
    public void itShouldCalculateSalesTaxesForExemptImportedItem() {
        Item exemptImported = new Item("imported chocolate", 2, 1.00);
        double tax = TaxCalculator.calculateSalesTaxes(exemptImported);

        assertEquals(0.05, exemptImported.getTaxes(), 0.001);
        assertEquals(tax, 0.05, 0.001);
    }

    @Test
    public void itShouldCalculateSalesTaxesForNonExemptImportedItem() {
        Item nonExemptImported = new Item("imported balloons", 2, 1.00);
        double tax = TaxCalculator.calculateSalesTaxes(nonExemptImported);

        assertEquals(0.15, nonExemptImported.getTaxes(), 0.001);
        assertEquals(tax, 0.15, 0.001);
    }
}