package salestaxes;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public final class Formatter {

    private static final DecimalFormat roundOff = new DecimalFormat("0.00");

    public static String formatReceipt(Receipt receipt) {
        String receiptText = "";

        for (Item item : receipt.getItems()) { receiptText += formatItem(item); }
        receiptText += formatTaxesAndTotal(receipt);

        return receiptText;
    }

    private static String formatItem(Item item) {
        String description = item.getDescription();
        int quantity = item.getQuantity();
        double priceWithTaxes = item.getPriceWithTaxes();

        return quantity + " " + description + ": " + roundOff.format(priceWithTaxes) + "\n";
    }

    private static String formatTaxesAndTotal(Receipt receipt) {
        return formatTaxes(receipt) + formatTotal(receipt);
    }

    private static String formatTaxes(Receipt receipt) {
        return "Sales Taxes: " + roundOff.format(receipt.getSalesTaxes()) + "\n";
    }

    private static String formatTotal(Receipt receipt) {
        return "Total: " + roundOff.format(receipt.getTotalCost());
    }
}