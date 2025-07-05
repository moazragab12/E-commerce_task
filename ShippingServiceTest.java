import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShippingServiceTest {

    @Test
    public void testSendToShipping() {
        List<Shippable> items = new ArrayList<>();

        TV tv = new TV();
        tv.setName("TV");
        tv.setPrice(8000);
        tv.setQuantity(1);

        Biscuits biscuits = new Biscuits();
        biscuits.setName("Biscuits");
        biscuits.setPrice(10);
        biscuits.setQuantity(1);

        items.add(tv);
        items.add(biscuits);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ShippingService.sendToShipping(items);

        System.setOut(System.out);

        String output = outContent.toString();

        assertTrue(output.contains("Sending 2 items to shipping:"));
        assertTrue(output.contains("TV"));
        assertTrue(output.contains(String.valueOf(tv.getWeight())));
        assertTrue(output.contains("Biscuits"));
        assertTrue(output.contains(String.valueOf(biscuits.getWeight())));
    }
}
