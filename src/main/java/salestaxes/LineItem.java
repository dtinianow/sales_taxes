package salestaxes;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class LineItem {

    private static final Map<String, List<String>> exemptItemsByCategory = new HashMap<>();
    static {
        exemptItemsByCategory.put("book", new ArrayList<String>());
        exemptItemsByCategory.put("food", new ArrayList<String>());
        exemptItemsByCategory.put("medical", new ArrayList<String>());
        exemptItemsByCategory.get("book").add("book");
        exemptItemsByCategory.get("food").add("chocolate");
        exemptItemsByCategory.get("medical").add("pill");
    }

    public String description;
    public int quantity;
    public double price;
    public String category;
    public boolean exemptionStatus;
    public boolean importationStatus;

    public LineItem(String description, int quantity, double price) {
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.exemptionStatus = isExempt();
        this.importationStatus = isImported();
    }

    private boolean isExempt() {
        for (List<String> items : exemptItemsByCategory.values()) {
            for (String item : items) {
                if (description.toLowerCase().contains(item)) {
                    exemptionStatus = true;
                    break;
                }
            }
        }
        return exemptionStatus;
    }

    private boolean isImported() {
        return description.toLowerCase().contains("imported");
    }
}