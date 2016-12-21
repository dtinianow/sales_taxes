package salestaxes;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public final class Formatter {

    private static final DecimalFormat roundOff = new DecimalFormat("0.00");

    public static String prepareReceipt(Receipt receipt) {
        String receiptText = "";

        for (Item item : receipt.getItems()) {
            String description = item.getDescription();
            int quantity = item.getQuantity();
            double priceWithTaxes = item.getPrice() + item.getTaxes();

            String itemText = quantity + " " + description + ": " + roundOff.format(priceWithTaxes) + "\n";

            receiptText += itemText;
        }

        receiptText += ("Sales Taxes: " + roundOff.format(receipt.getSalesTaxes()) + "\n");
        receiptText += ("Total: " + roundOff.format(receipt.getTotalCost()));

        return receiptText;
    }
}