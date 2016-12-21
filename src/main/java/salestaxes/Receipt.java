package salestaxes;

import java.util.List;

public class Receipt {

    private List<Item> items;
    private double salesTaxes;
    private double totalCost;

    public Receipt(List<Item> items) {
        this.items = items;

        finalizeCosts();
    }

    public List<Item> getItems() { return items; }

    public double getSalesTaxes() { return salesTaxes; }

    public double getTotalCost() { return totalCost; }

    private void finalizeCosts() {
        for(Item item : items) {
            this.salesTaxes += item.getTaxes();
            this.totalCost += item.getPriceWithTaxes();
        }
    }
}