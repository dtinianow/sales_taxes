package salestaxes;

import java.io.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        if (args.length != 1) { throw new IllegalArgumentException("Please enter a valid file to read"); }

        List<Item> items = MyFileReader.readItemData(args[0]);;
        String receiptText = Formatter.formatReceipt(new Receipt(items));
        MyFileWriter.printReceipt(receiptText);
    }
}