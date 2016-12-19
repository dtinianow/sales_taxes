package salestaxes;

public class Parser {

    public static LineItem parseLineItemData(String data) {
        String[] nameAndQuantityAndPrice = data.split(" at ");
        String[] nameAndQuantity = nameAndQuantityAndPrice[0].split(" ", 2);

        String name = nameAndQuantity[0];
        int quantity = Integer.parseInt(nameAndQuantity[1]);
        double price = Double.parseDouble(nameAndQuantityAndPrice[1]);
        
        LineItem lineItem = new LineItem(name, quantity, price);

        return lineItem;
    }
}