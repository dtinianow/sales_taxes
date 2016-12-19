package salestaxes;

public class LineItem {

    private String description;
    private int quantity;
    private double price;
    private String category;
    private boolean imported;

    public LineItem(String description, int quantity, double price) {
        this.description = description;
        this.quantity = quantity;
        this.price = price;
//        this.category = Parser.getCategory(data);
//        this.imported = Parser.isImported(data);
    }
}