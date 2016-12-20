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

        List<Item> Items = new ArrayList<>();

        // Read a file
        try {
            File inputFile = new File(args[0]);
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                Item item = Parser.parseItemData(line);
                Items.add(item);
//                Items.add(TaxCalculator.taxesDue(item));
            }
            reader.close();

        } catch(Exception ex) {
            ex.printStackTrace();
        }


        // Loop through each item
        // Apply sales tax calculation
//        Receipt receipt = new Receipt(Items);

        for (Item item : Items) {
            System.out.println(item.description);
            System.out.println(item.quantity);
            System.out.println(item.getPrice());
            System.out.println(item.isExempt());
            System.out.println(item.isImported());
            System.out.println(item.taxes);
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