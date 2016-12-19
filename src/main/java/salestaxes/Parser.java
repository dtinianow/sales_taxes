package salestaxes;

public class Parser {

    public static LineItem parseLineItemData(String data) {
        String[] nameAndQuantityAndPrice = data.split(" at ");
        String[] nameAndQuantity = nameAndQuantityAndPrice[0].split(" ", 2);

        String description = nameAndQuantity[1];
        int quantity = Integer.parseInt(nameAndQuantity[0]);
        double price = Double.parseDouble(nameAndQuantityAndPrice[1]);

        LineItem lineItem = new LineItem(description, quantity, price);

        return lineItem;
    }
}