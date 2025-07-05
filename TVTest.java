import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TVTest {

    @Test
    public void testTVProperties() {
        TV tv = new TV();
        tv.setPrice(10000);
        tv.setQuantity(2);
        assertEquals("TV", tv.getName());
        assertEquals(10000, tv.getPrice());
        assertTrue(tv.getShippabale());
        assertEquals(2, tv.getQuantity());
        assertEquals(10000.0, tv.getWeight());
    }
}
