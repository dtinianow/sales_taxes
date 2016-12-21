package salestaxes;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.Test;

public class ParserTest {

    @Test
    public void itShouldParseItemDataAndReturnAnItem() {
        String itemData = "1 chocolate bar at 0.85";

        Item item = Parser.parseItemData(itemData);

        assertThat(item, instanceOf(Item.class));

        assertEquals("chocolate bar", item.getDescription());
        assertThat(item.getDescription(), instanceOf(String.class));

        assertEquals(1, item.getQuantity());
        assertThat(item.getQuantity(), instanceOf(Integer.class));

        assertEquals(0.85, item.getPrice(), 0.001);
        assertThat(item.getPrice(), instanceOf(Double.class));
    }
}