package salestaxes;

public final class Parser {

    public static Item parseItemData(String data) {
        String[] itemAndPrice = data.split(" at ");
        String[] quantityAndDescription = itemAndPrice[0].split(" ", 2);

        String description = quantityAndDescription[1];
        int quantity = Integer.parseInt(quantityAndDescription[0]);
        double price = Double.parseDouble(itemAndPrice[1]);

        return new Item(description, quantity, price);
    }
}