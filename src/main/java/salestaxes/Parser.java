package salestaxes;

public final class Parser {

    public static Item parseItemData(String data) {
        String[] itemAndPrice = data.split(" at ");
        String[] quantityAndDescription = itemAndPrice[0].split(" ", 2);

        String description = findDescription(quantityAndDescription);
        int quantity = findQuantity(quantityAndDescription);
        double price = findPrice(itemAndPrice);

        return new Item(description, quantity, price);
    }

    private static String findDescription(String[] data) {
        return data[1];
    }

    private static int findQuantity(String[] data) {
        return Integer.parseInt(data[0]);
    }

    private static double findPrice(String[] data) {
        return Double.parseDouble(data[1]);
    }
}