package salestaxes;

import java.io.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Item> items = MyFileReader.readItemData(args[0]);
        Receipt receipt = new Receipt(items);
        String receiptText = Formatter.formatReceipt(receipt);
        MyFileWriter.printReceipt(receiptText);
    }
}