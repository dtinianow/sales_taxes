package salestaxes;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFileWriter {

    public static void printReceipt(String output) {
        try {
            String timestamp = new SimpleDateFormat("yyyy.MM.dd-HH:mm:ss:SS").format(new Date());
            String outputFile = "src/resources/output-files/receipt-" + timestamp + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(output);
            System.out.println(output);
            System.out.println("Your receipt has been printed to " + outputFile);
            writer.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}