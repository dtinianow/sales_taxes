package salestaxes;

public final class TaxCalculator {

    private static final double SALES_TAX_RATE = 0.10;
    private static final double IMPORT_TAX_RATE = 0.05;

    public static double applySalesTaxes(Receipt receipt) {
          List<Items> items = receipt.getItems();

          for (item : items) {
              totalTaxes += item.getTaxes();
              totalPriceBeforeTaxes += item.getPrice();
          }
          totalCost = totalTaxes + totalPriceBeforeTaxes();


//        double initialPrice = item.getPrice();
//        double salesTax = 0.0;
//        double importTax = 0.0;
//
//        if (!item.isExempt()) { salesTax += roundUpTax(initialPrice * SALES_TAX_RATE); }
//        if (item.isImported()) { importTax += roundUpTax(initialPrice * IMPORT_TAX_RATE); }
//
//        double totalTaxes = salesTax + importTax;
//
//        return Math.round(totalTaxes * 100.0) / 100.0;
    }

    private static double roundUpTax(double tax) {
        return Math.ceil(tax * 20) / 20.0;
    }
}