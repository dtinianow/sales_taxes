package salestaxes;

public final class Parser {

    public static Item parseItemData(String data) {
        String[] nameAndQuantityAndPrice = data.split(" at ");
        String[] nameAndQuantity = nameAndQuantityAndPrice[0].split(" ", 2);

        String description = nameAndQuantity[1];
        int quantity = Integer.parseInt(nameAndQuantity[0]);
        double price = Double.parseDouble(nameAndQuantityAndPrice[1]);

        Item item = new Item(description, quantity, price);

        return item;
    }
}