import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List <Products>incartProducts;

    public Cart() {
        this.incartProducts = new ArrayList<>();
    }
    public Cart(List<Products> incartProducts) {
        this.incartProducts = incartProducts;
    }
    public List<Products> getIncartProducts() {
        return incartProducts;
    }
    public void setIncartProducts(List<Products> incartProducts) {
        this.incartProducts = incartProducts;
    }
    public void addProduct(Products product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        for (Products p : incartProducts) {
            if (p.getName().equals(product.getName())) {
                p.setQuantity(p.getQuantity() + product.getQuantity());
                return;
            }
        }
        incartProducts.add(product);

    }

    public void clearCart() {
        incartProducts.clear();
    }

    public void removeProduct(Products product) {

        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        for (int i = 0; i < incartProducts.size(); i++) {
            Products p = incartProducts.get(i);
            if (p.getName().equals(product.getName())) {
                if (p.getQuantity() > product.getQuantity()) {
                    p.setQuantity(p.getQuantity() - product.getQuantity());
                } else {
                    incartProducts.remove(i);
                }
                return;
            }
        }
    }
    public double calculateTotalPrice() {
        double total = 0.0;
        for (Products product : incartProducts) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }
    public boolean isEmpty() {
        return incartProducts.isEmpty();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cart contains:\n");
        for (Products product : incartProducts) {
            sb.append(product.toString()).append("\n");
        }
        sb.append("Total Price: ").append(calculateTotalPrice());
        return sb.toString();
    }
}
