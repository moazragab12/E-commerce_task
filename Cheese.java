public class Cheese extends Products  implements Shippable{
    private double weight;


    Cheese() {
        setShippabale(true);
        setName("Cheese");
        setPrice(20);
        addItem();
        setRemainingDaysToexpire(15);
this.weight = 200;
    }
    @Override
    public double getWeight() {
        return weight;
    }





}
