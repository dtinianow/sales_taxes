package salestaxes;

import java.io.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        validateArgs(args);

        for (String file : args) {
            List<Item> items = MyFileReader.readItemData(file);
            String receiptText = Formatter.formatReceipt(new Receipt(items));
            MyFileWriter.printReceipt(receiptText);
        }

    }

    private static void validateArgs(String[] args) {
        if (args.length < 1) { throw new IllegalArgumentException("Please enter one or more files to be read"); }
    }
}