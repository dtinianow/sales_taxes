package salestaxes;

import java.util.List;

public class Receipt {

    private List<Items> items;
    private double salesTaxes;
    private double totalCost;

    public class Receipt(List<Items> items) {
        this.items = items;
    }

    public List<Items> getItems() { return items; }

    public void setSalesTaxes(double amount) { this.salesTaxes += amount; }

    public void setTotalCost(double amount) { this.totalCost += amount; }
}