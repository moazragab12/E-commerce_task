import java.util.*;

public class Main {
    public static void main(String[] args) {
        // our warehouse
        List<Products> warehouse = new ArrayList<>();


        Mobile mobile = new Mobile();
        mobile.setName("Mobile");
        mobile.setPrice(5000);
        mobile.setQuantity(10);
        mobile.setShippabale(false);
        mobile.setRemainingDaysToexpire(0);

        TV tv = new TV();
        tv.setName("Tv");
        tv.setPrice(8000);
        tv.setQuantity(5);
        tv.setShippabale(true);
        tv.setRemainingDaysToexpire(0);

        warehouse.add(mobile);
        warehouse.add(tv);


        Customers customer = new Customers("Ali", "ali@mail.com", "123 St", 20000);

        Mobile mobileForCart = new Mobile();
        mobileForCart.setName("Mobile");
        mobileForCart.setPrice(5000);
        mobileForCart.setQuantity(2);
        mobileForCart.setShippabale(false);
        mobileForCart.setRemainingDaysToexpire(0);

        TV tvForCart = new TV();
        tvForCart.setName("Tv");
        tvForCart.setPrice(8000);
        tvForCart.setQuantity(1);
        tvForCart.setShippabale(true);
        tvForCart.setRemainingDaysToexpire(0);
     customer.AddToCart(tvForCart);

        customer.AddToCart(mobileForCart);


        customer.checkout(warehouse);
    }

    public static Products findProductInInventory(String productName, List<Products> warehouse) {
        for (Products p : warehouse) {
            if (p.getName().equals(productName)) {
                return p;
            }
        }
        return null;
    }
}
