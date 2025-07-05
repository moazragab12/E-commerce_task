import java.util.*;

public class Main {
    public static void main(String[] args) {


        TV tv = new TV();
        tv.setQuantity(2);
        tv.setPrice(8000);

        Mobile mobile = new Mobile();
        mobile.setQuantity(5);
        mobile.setPrice(5000);

        Biscuits biscuits = new Biscuits();
        biscuits.setQuantity(10);
        biscuits.setPrice(10);

        List<Products> warehouse = new ArrayList<>();
        warehouse.add(tv);
        warehouse.add(mobile);
        warehouse.add(biscuits);



        Customers customer = new Customers("Sara", "sara@example.com", "Cairo", 50000.0);




        TV tvOrder = new TV();
        tvOrder.setQuantity(1);
        tvOrder.setPrice(8000);
        customer.AddToCart(tvOrder);


        Mobile mobileOrder = new Mobile();
        mobileOrder.setQuantity(2);
        mobileOrder.setPrice(5000);
        customer.AddToCart(mobileOrder);


        Biscuits biscuitsOrder = new Biscuits();
        biscuitsOrder.setQuantity(3);
        biscuitsOrder.setPrice(10);
        customer.AddToCart(biscuitsOrder);



        customer.checkout(warehouse);


        System.out.println("\n---- Warehouse After Purchase ----");
        for (Products p : warehouse) {
            System.out.println("Product: " + p.getName() +
                    ", Quantity left: " + p.getQuantity());
        }


    }
}
