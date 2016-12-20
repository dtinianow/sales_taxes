package salestaxes;

public final class Formatter {
    public static void formatReceipt(Receipt receipt) {
        for (Item item : receipt.getItems()) {
            String description = item.getDescription();
            int quantity = item.getQuantity();
            double priceWithTaxes = item.getPrice() + item.getTaxes();
        }

//        return quantity + " " + description + ": " + priceWithTaxes + "\n";
    }
}