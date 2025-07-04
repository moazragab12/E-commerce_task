public class TV extends Products {
    public static double weight;

    TV() {
        setShippabale(true);
        setName("TV");
        setPrice(8000);
        addItem();
        setWeight(10000);
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
