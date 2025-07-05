public class Biscuits  extends Products implements Shippable  {
    private double weight;

    Biscuits() {
      setShippabale(true);
      setName("Biscuits");
        setPrice(10);
        addItem();
        setRemainingDaysToexpire(30);
      this.weight = 100;

    }
    @Override
    public double getWeight() {
        return weight;
    }


}
