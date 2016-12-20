package salestaxes;

public class TaxCalculator {

    private static final double SALES_TAX_RATE = 0.10;
    private static final double IMPORT_TAX_RATE = 0.05;

    public static double applyTaxes(Item item) {
        double initialPrice = item.getPrice();
        double salesTax = 0.0;
        double importTax = 0.0;

        if (!item.isExempt()) { salesTax += initialPrice * SALES_TAX_RATE; }
        if (item.isImported()) { importTax += initialPrice * IMPORT_TAX_RATE; }

        return salesTax + importTax;
    }
}