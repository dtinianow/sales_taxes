package salestaxes;

public final class Parser {

    public static Item parseItemData(String data) {
        String[] itemAndPrice = data.split(" at ");
        String[] quantityAndDescription = itemAndPrice[0].split(" ", 2);

        String description = quantityAndDescription[1];
        String quantity = quantityAndDescription[0];
        String price = itemAndPrice[1];

        return new Item(description, Integer.parseInt(quantity), Double.parseDouble(price));
    }
}