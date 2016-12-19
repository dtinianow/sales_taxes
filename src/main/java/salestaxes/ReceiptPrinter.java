package salestaxes;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceiptPrinter {
    public static void main(String[] args) {

        // Check for correct number of arguments
        if (args.length != 1) {
            throw new IllegalArgumentException("Please enter a valid file to read");
        }

        // Read a file
        try {
            File inputFile = new File(args[0]);
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;
            List<LineItem> lineItems = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                LineItem lineItem = Parser.parseLineItemData(line);
            }
            reader.close();

        } catch(Exception ex) {
            ex.printStackTrace();
        }

        // Write to a file
        try {
            String timestamp = new SimpleDateFormat("yyyy.MM.dd-HH:mm:ss:SS").format(new Date());
            String outputFile = "src/resources/output-files/receipt-" + timestamp + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
//            writer.write("Sample output");
            writer.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}