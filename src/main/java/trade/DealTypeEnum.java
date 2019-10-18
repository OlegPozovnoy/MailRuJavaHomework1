package trade;

public enum DealTypeEnum {
    BOND {
        public DealType create(double price) {
            return new Bond(price);
        }
    },
    COMMODITY_SPOT {
        public DealType create(double price) {
            return new CommoditySpot(price);
        }
    },
    FX_SPOT {
        public DealType create(double price) {
            return new FxSpot(price);
        }
    },
    IR_SWAP {
        public DealType create(double price) {
            return new IRSwap(price);
        }
    };

    public abstract DealType create(double price);
}
