package salestaxes;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class MyFileReader {

    public static List<Item> readItemData(String file) {
        List<Item> items = new ArrayList<>();

        try {
            BufferedReader reader = prepareFileReader(file);
            readAndParseItemData(reader, items);
            System.out.println("----- Successfully read input. Preparing your receipt... -----");
            reader.close();

        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return items;
    }

    private static BufferedReader prepareFileReader(String file) throws FileNotFoundException {
        File inputFile = new File(file);
        FileReader fileReader = new FileReader(inputFile);
        BufferedReader reader = new BufferedReader(fileReader);

        return reader;
    }

    private static void readAndParseItemData(BufferedReader reader, List<Item> items) throws IOException {
        String line = null;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            Item item = Parser.parseItemData(line);
            items.add(item);
        }
    }
}