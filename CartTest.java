import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

    @Test
    public void testAddProduct() {
        Cart cart = new Cart();


        TV tv = new TV();
        tv.setName("TV");
        tv.setPrice(8000);
        tv.setQuantity(1);

        cart.addProduct(tv);

        assertEquals(1, cart.getIncartProducts().size());
        assertEquals("TV", cart.getIncartProducts().get(0).getName());
    }

    @Test
    public void testRemoveProduct() {
        Cart cart = new Cart();

        TV tv = new TV();
        tv.setName("TV");
        tv.setPrice(8000);
        tv.setQuantity(2);

        cart.addProduct(tv);


        TV tvToRemove = new TV();
        tvToRemove.setName("TV");
        tvToRemove.setQuantity(1);

        cart.removeProduct(tvToRemove);

        assertEquals(1, cart.getIncartProducts().get(0).getQuantity());
    }

    @Test
    public void testClearCart() {
        Cart cart = new Cart();

        TV tv = new TV();
        tv.setName("TV");
        tv.setPrice(8000);
        tv.setQuantity(1);

        cart.addProduct(tv);

        cart.clearCart();

        assertTrue(cart.getIncartProducts().isEmpty());
    }

    @Test
    public void testCalculateTotalPrice() {
        Cart cart = new Cart();

        TV tv = new TV();
        tv.setName("TV");
        tv.setPrice(8000);
        tv.setQuantity(1);

        Mobile mobile = new Mobile();
        mobile.setName("Mobile");
        mobile.setPrice(5000);
        mobile.setQuantity(2);

        cart.addProduct(tv);
        cart.addProduct(mobile);

        double expectedTotal = (1 * 8000) + (2 * 5000);

        assertEquals(expectedTotal, cart.calculateTotalPrice());
    }
}