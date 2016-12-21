package salestaxes;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Application {
    public static void main(String[] args) {

        // Check for correct number of arguments
        if (args.length != 1) {
            throw new IllegalArgumentException("Please enter a valid file to read");
        }

        List<Item> items = new ArrayList<>();

        // Read a file
        try {
            File inputFile = new File(args[0]);
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                Item item = Parser.parseItemData(line);
                items.add(item);
            }
            reader.close();

        } catch(Exception ex) {
            ex.printStackTrace();
        }

        Receipt receipt = new Receipt(items);
        TaxCalculator.applySalesTaxes(receipt);

        String output = Formatter.prepareReceipt(receipt);

        System.out.println(output);

        // Write to a file
        try {
            String timestamp = new SimpleDateFormat("yyyy.MM.dd-HH:mm:ss:SS").format(new Date());
            String outputFile = "src/resources/output-files/receipt-" + timestamp + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(output);
            writer.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}