import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CheeseTest {

    @Test
    public void testCheeseProperties() {
        Cheese c = new Cheese();
        c.setPrice(50);
        c.setQuantity(3);

        assertAll("Cheese Properties",
                () -> assertEquals("Cheese", c.getName()),
                () -> assertTrue(c.getShippabale()),
                () -> assertEquals(15, c.getRemainingDaysToexpire()),
                () -> assertEquals(200, c.getWeight()),
                () -> assertEquals(50, c.getPrice()),
                () -> assertEquals(3, c.getQuantity())
        );
    }
}
