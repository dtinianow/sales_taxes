package salestaxes;

public final class TaxCalculator {

    private static final double SALES_TAX_RATE = 0.10;
    private static final double IMPORT_TAX_RATE = 0.05;

    public static void applySalesTaxes(Receipt receipt) {
        for (Item item : receipt.getItems()) {
            double taxes = calculateTaxes(item);

            item.setTaxes(taxes);
            receipt.setTotalTaxes(taxes);
            receipt.setTotalCost(item.getPriceWithTaxes());
        }
    }

    private static double roundUpTax(double tax) {
        return Math.ceil(tax * 20) / 20.0;
    }

    private static double calculateTaxes(Item item) {
        return generalSalesTax(item) + importSalesTax(item);
    }

    private static double generalSalesTax(Item item) {
        double salesTax = 0.0;

        if (!item.isExempt()) { salesTax += taxRate(item, SALES_TAX_RATE); }

        return salesTax;
    }

    private static double importSalesTax(Item item) {
        double importTax = 0.0;

        if (item.isImported()) { importTax += taxRate(item, IMPORT_TAX_RATE); }

        return importTax;
    }

    private static double taxRate(Item item, double taxType) {
        return roundUpTax(item.getPrice() * taxType);
    }
}