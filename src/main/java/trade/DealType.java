package trade;

public abstract class DealType {
    private final double price;

    public DealType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.getClass() + " Price:" + price;
    }
}
