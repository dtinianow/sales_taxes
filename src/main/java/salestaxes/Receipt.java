package salestaxes;

import java.util.List;

public class Receipt {

    private List<Item> items;
    private double salesTaxes;
    private double totalCost;

    public Receipt(List<Item> items) { this.items = items; }

    public List<Item> getItems() { return items; }

    public double getSalesTaxes() { return salesTaxes; }

    public double getTotalCost() { return totalCost; }

    public void setTotalTaxes(double amount) { this.salesTaxes += amount; }

    public void setTotalCost(double amount) { this.totalCost += amount; }
}