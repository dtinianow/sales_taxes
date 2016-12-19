package salestaxes;

public class LineItem {

    public String description;
    public int quantity;
    public double price;
    public String category;
    public boolean imported;

    public LineItem(String description, int quantity, double price) {
        this.description = description;
        this.quantity = quantity;
        this.price = price;
//        this.category = Parser.getCategory(data);
        this.imported = isImported(description);
    }

    private boolean isImported(String description) {
        return description.toLowerCase().contains("imported");
    }


}