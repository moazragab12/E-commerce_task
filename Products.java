public    class Products  {
    private String name;
    private double price;
    private int quantity;
    private boolean isShippabale;
    private int remainingDaysToexpire;


    public Products() {
        this.name = "";
        this.price = 0;
        this.quantity = 0;
        this.isShippabale = false;

        this.remainingDaysToexpire = -1 ; //-1 indicates no expiry
    }
    public Products(String name, int price, int quantity, Boolean isShippabale, double weight, int remainingDaysToexpire) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isShippabale = isShippabale;

        this.remainingDaysToexpire = remainingDaysToexpire;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addItem() {
        setQuantity(getQuantity() + 1);
    }
    public void removeItem() {
        if (getQuantity() > 0) {
            setQuantity(getQuantity() - 1);
        }
    }
    public void decreaseQuantity(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
        } else {
            throw new IllegalArgumentException("Cannot decrease quantity below zero");
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Boolean getShippabale() {
        return isShippabale;
    }

    public int getRemainingDaysToexpire() {
        return remainingDaysToexpire;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setShippabale(Boolean shippabale) {
        isShippabale = shippabale;
    }

    public void setRemainingDaysToexpire(int remainingDaysToexpire) {
        this.remainingDaysToexpire = remainingDaysToexpire;
    }
}
