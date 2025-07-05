public class TV extends Products implements Shippable {
    public static double weight;

    TV() {
        setShippabale(true);
        setName("TV");
        setPrice(8000);
        addItem();
        this.weight = 10000;
    }
    @Override
    public double getWeight() {
        return weight;
    }
    public void addItem() {
        setQuantity(getQuantity() + 1);
    }
    public void removeItem() {
        if (getQuantity() > 0) {
            setQuantity(getQuantity() - 1);
        }
    }


}
