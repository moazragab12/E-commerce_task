import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MobileTest {

    @Test
    public void testMobileProperties() {
        Mobile m = new Mobile();
        m.setPrice(6000);
        m.setQuantity(3);

        assertAll("Mobile Properties",
                () -> assertEquals("Mobile", m.getName()),
                () -> assertEquals(6000, m.getPrice()),
                () -> assertTrue(m.getShippabale()),
                () -> assertEquals(3, m.getQuantity())
        );
    }
}
