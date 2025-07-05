public class Mobile extends Products implements Shippable {
    private double weight;  // in grams

    public Mobile() {
        setName("Mobile");
        setPrice(5000);
        setQuantity(1);
   setShippabale(true);
        setRemainingDaysToexpire(0);
        this.weight = 200;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}