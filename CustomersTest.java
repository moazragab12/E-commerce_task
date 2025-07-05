import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CustomersTest {

    @Test
    public void testCheckoutSuccess() {
        List<Products> warehouse = new ArrayList<>();
        TV tv = new TV(); tv.setName("TV"); tv.setQuantity(2); tv.setPrice(8000);
        Mobile mobile = new Mobile(); mobile.setName("Mobile"); mobile.setQuantity(5); mobile.setPrice(5000);
        warehouse.add(tv); warehouse.add(mobile);

        Customers customer = new Customers("Sara", "sara@email.com", "Cairo", 50000);

        TV orderTV = new TV(); orderTV.setName("TV"); orderTV.setPrice(8000); orderTV.setQuantity(1);
        Mobile orderMobile = new Mobile(); orderMobile.setName("Mobile"); orderMobile.setPrice(5000); orderMobile.setQuantity(2);
        customer.AddToCart(orderTV); customer.AddToCart(orderMobile);

        customer.checkout(warehouse);
        assertEquals(31900.0, customer.getBalance(), 0.1);
        assertEquals(1, warehouse.get(0).getQuantity());
        assertEquals(3, warehouse.get(1).getQuantity());
    }
}
