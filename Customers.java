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
        if (cart == null || cart.getIncartProducts().isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }

        double subtotal = 0.0;
        boolean needsShipping = false;

        for (Products productInCart : cart.getIncartProducts()) {
            Products productInInventory = findProductInInventory(productInCart.getName(), warehouse);
            if (productInInventory == null) {
                System.out.println("Error: Product " + productInCart.getName() + " not found in inventory.");
                return;
            }

            if (productInCart.getRemainingDaysToexpire() != 0 &&
                    productInCart.getRemainingDaysToexpire() <= 0) {
                System.out.println("Error: Product " + productInCart.getName() + " is expired.");
                return;
            }

            if (productInInventory.getQuantity() < productInCart.getQuantity()) {
                System.out.println("Error: Not enough stock for " + productInCart.getName());
                return;
            }

            subtotal += productInCart.getPrice() * productInCart.getQuantity();

            if (productInCart.getShippabale()) {
                needsShipping = true;
            }
        }

        double shipping = needsShipping ? 20.0 : 0.0;
        double total = subtotal + shipping;

        if (balance < total) {
            System.out.println("Error: Insufficient balance. You have $" + balance + " but need $" + total);
            return;
        }

        balance -= total;

        for (Products productInCart : cart.getIncartProducts()) {
            Products productInInventory = findProductInInventory(productInCart.getName(), warehouse);
            productInInventory.decreaseQuantity(productInCart.getQuantity());
        }

        System.out.println("----- CHECKOUT SUCCESSFUL -----");
        System.out.println("Customer: " + name);
        System.out.println("Order Details:");

        for (Products p : cart.getIncartProducts()) {
            System.out.printf( "name "+
                    p.getName() +" quantity "+
                    p.getQuantity()+" price "+
                    p.getPrice() * p.getQuantity()+" ");
            if (p.getShippabale()) {
                System.out.println(" weight "+ p.getWeight());
            }
        }

        System.out.printf("Subtotal: $%.2f\n", subtotal);
        System.out.printf("Shipping fees: $%.2f\n", shipping);
        System.out.printf("Total paid amount: $%.2f\n", total);
        System.out.printf("Remaining balance: $%.2f\n", balance);
        cart.clearCart();
    }
    public Products findProductInInventory(String name, List<Products> warehouse) {
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