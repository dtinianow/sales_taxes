package salestaxes;

import java.util.List;

public class Receipt {

    private List<Items> items;
    private double totalTaxes;
    private double totalPriceBeforeTaxes;
    private double totalCost;

    public class Receipt(List<Items> items) {
        this.items = items;
        calculateExpenses();
    }

    private void calculateExpenses() {
        for (item : items) {
            totalTaxes += item.getTaxes();
            totalPriceBeforeTaxes += item.getPrice();
        }
        totalCost = totalTaxes + totalPriceBeforeTaxes;
    }
}