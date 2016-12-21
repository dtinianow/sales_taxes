package salestaxes;

public final class TaxCalculator {

    private static final double SALES_TAX_RATE = 0.10;
    private static final double IMPORT_TAX_RATE = 0.05;

    public static void applySalesTaxes(Receipt receipt) {
        for (Item item : receipt.getItems()) {
            double initialPrice = item.getPrice();
            double salesTax = 0.0;
            double importTax = 0.0;

            if (!item.isExempt()) {
                salesTax += roundUpTax(initialPrice * SALES_TAX_RATE);
            }
            if (item.isImported()) {
                importTax += roundUpTax(initialPrice * IMPORT_TAX_RATE);
            }

            double taxes = salesTax + importTax;

            item.setTaxes(taxes);
            receipt.setSalesTaxes(taxes);
            receipt.setTotalCost(item.getPrice() + taxes);
        }
    }

    private static double roundUpTax(double tax) {
        return Math.ceil(tax * 20) / 20.0;
    }
}