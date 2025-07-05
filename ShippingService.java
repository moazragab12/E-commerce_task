import java.util.List;

public class ShippingService {
    public static void sendToShipping(List<Shippable> items) {
        System.out.println("Sending " + items.size() + " items to shipping:");
        for (Shippable s : items) {
            System.out.println(" - " + s.getName() + ": " + s.getWeight() + " g");
        }
    }
}