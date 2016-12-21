package salestaxes;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class MyFileReader {

    public static List<Item> readItemData(String file) {

        List<Item> items = new ArrayList<>();

        try {
            File inputFile = new File(file);
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                Item item = Parser.parseItemData(line);
                items.add(item);
            }
            System.out.println("-----------");
            reader.close();

        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return items;
    }
}