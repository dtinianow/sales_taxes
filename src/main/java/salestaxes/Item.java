package salestaxes;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Item {

    private static final Map<String, List<String>> taxExemptItemsByCategory = new HashMap<>();
    static {
        taxExemptItemsByCategory.put("book", new ArrayList<String>());
        taxExemptItemsByCategory.put("food", new ArrayList<String>());
        taxExemptItemsByCategory.put("medical", new ArrayList<String>());
        taxExemptItemsByCategory.get("book").add("book");
        taxExemptItemsByCategory.get("food").add("chocolate");
        taxExemptItemsByCategory.get("medical").add("pill");
    }

    private String description;
    private int quantity;
    private double price;
    private boolean importationStatus;
    private boolean exemptionStatus;
    private double taxes;

    public Item(String description, int quantity, double price) {
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.importationStatus = determineIfImported();
        this.exemptionStatus = determineIfExempt();
        this.taxes = TaxCalculator.calculateSalesTaxes(this);
    }

    public String getDescription() { return description; }

    public int getQuantity() { return quantity; }

    public double getPrice() { return price; }

    public double getTaxes() { return taxes; }

    public double getPriceWithTaxes() { return price + taxes; }

    public boolean isExempt() { return exemptionStatus; }

    public boolean isImported() { return importationStatus; }

    private boolean determineIfImported() { return description.toLowerCase().contains("imported"); }

    private boolean determineIfExempt() {
        for (List<String> items : taxExemptItemsByCategory.values()) {
            for (String item : items) {
                if (description.toLowerCase().contains(item)) {
                    exemptionStatus = true;
                    break;
                }
            }
        }
        return exemptionStatus;
    }
}