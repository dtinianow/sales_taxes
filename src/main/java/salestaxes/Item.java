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

    public String description;
    public int quantity;
    private double price;
    public String category;
    private boolean exemptionStatus;
    private boolean importationStatus;

    public Item(String description, int quantity, double price) {
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.exemptionStatus = determineIfExempt();
        this.importationStatus = determineIfImported();
    }

    public double getPrice() {
        return price;
    }

    public boolean isExempt() {
        return exemptionStatus;
    }

    public boolean isImported() {
        return importationStatus;
    }

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

    private boolean determineIfImported() {
        return description.toLowerCase().contains("imported");
    }
}