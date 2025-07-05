import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BiscuitsTest {

    @Test
    public void testBiscuitsProperties() {
        Biscuits b = new Biscuits();
        b.setPrice(10);
        b.setQuantity(5);
        assertEquals("Biscuits", b.getName());
        assertTrue(b.getShippabale());
        assertEquals(30, b.getRemainingDaysToexpire());
        assertEquals(100, b.getWeight());
    }
}
