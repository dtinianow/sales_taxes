package salestaxes;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFileWriter {

    public static void printReceipt(String receiptText) {
        try {
            String receiptFile = createReceiptFile("src/resources/output-files/");
            BufferedWriter writer = new BufferedWriter(new FileWriter(receiptFile));
            writer.write(receiptText);
            System.out.println(receiptText + "\nYour receipt has been printed to " + receiptFile);
            writer.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    private static String generateTimestamp() {
        return new SimpleDateFormat("yyyy.MM.dd-HH:mm:ss:SS").format(new Date());
    }

    private static String createReceiptFile(String directory) {
        return directory + "receipt-" + generateTimestamp() + ".txt";
    }
}