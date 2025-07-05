import java.util.ArrayList;
import java.util.List;

public class Customers {
    private String name;
    private String email;
    private String address;
    private double balance;
    private Cart cart;

    private static final double SHIPPING_FEE = 20.0;


    public Customers() {
        this.name = "";
        this.email = "";
        this.address = "";
        this.balance = 0.0;
        this.cart = new Cart();
    }

    public Customers(String name, String email, String address, double balance) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.balance = balance;
        this.cart = new Cart();
    }

    public Customers(String name, String email, String address, double balance, Cart cart) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.balance = balance;
        this.cart = cart;
    }


    public void AddToCart(Products product) {
        if (cart == null) {
            cart = new Cart();
        }
        cart.addProduct(product);
    }


    public void RemoveFromCart(Products product) {
        if (cart != null) {
            cart.removeProduct(product);
        }
    }


    public void checkout(List<Products> warehouse) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        double subtotal = cart.calculateTotalPrice();
        double shippingFee = 100;
        double total = subtotal + shippingFee;

        if (balance < total) {
            System.out.println("Insufficient balance!");
            return;
        }

        List<Shippable> toShip = new ArrayList<>();

        for (Products p : cart.getIncartProducts()) {

            Products warehouseProduct = findProductInInventory(warehouse, p.getName());
            if (warehouseProduct != null) {
                warehouseProduct.decreaseQuantity(p.getQuantity());
            }

            System.out.println(
                    "name " + p.getName() +
                            " quantity " + p.getQuantity() +
                            " price " + (p.getPrice() * p.getQuantity())
            );

            if (p instanceof Shippable) {
                toShip.add((Shippable) p);
            }
        }

        balance -= total;
        cart.clearCart();

        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping fee: " + shippingFee);
        System.out.println("Total paid: " + total);
        System.out.println("Remaining balance: " + balance);

        if (!toShip.isEmpty()) {
            ShippingService.sendToShipping(toShip);
        }
    }


    public Products findProductInInventory(List<Products> warehouse, String name) {
        for (Products p : warehouse) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }



    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", balance=" + balance +
                ", cart=" + cart +
                '}';
    }
}