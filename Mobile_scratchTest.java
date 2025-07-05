import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Mobile_scratchTest {

    @Test
    public void testMobileScratchProperties() {
        Mobile_scratch m = new Mobile_scratch();

        assertEquals("Mobile_scratch", m.getName());
        assertEquals(300, m.getPrice());
        assertFalse(m.getShippabale());
        assertEquals(1, m.getQuantity());
    }
}
