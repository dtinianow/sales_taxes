package salestaxes;

public final class Formatter {
    public static String formatReceipt(Receipt receipt) {
        List<Items> items = receipt.getItems();

        for (item : items) {
            String description = item.getDescription();
            int quantity = item.getQuantity();
            double priceWithTaxes = item.getPrice() + item.getTaxes();
        }

        quantity + " " + description + ": " + priceWithTaxes
    }
}