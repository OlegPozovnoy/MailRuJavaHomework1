package trade;

public abstract class DealType {

    public DealType(double price) {
        this.price = price;
    }

    private final double price;

    @Override
    public String toString() {
        return this.getClass() + " Price:" + price;
    }
}
