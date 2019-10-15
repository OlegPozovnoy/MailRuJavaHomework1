import org.json.JSONException;
import trade.*;
import org.json.JSONObject;

public class TradeBuilder {

    public static DealType create1(JSONObject json) {
        System.out.println(json);
        String dealType = json.getJSONObject("Trade").getString("type");
        double price = json.getJSONObject("Trade").getDouble("price");

        switch (dealType) {
            case "FX_SPOT":
                return new FxSpot(price);
            case "BOND":
                return new Bond(price);
            case "IR_SWAP":
                return new IRSwap(price);
            case "COMMODITY_SPOT":
                return new CommoditySpot(price);
            default:
                throw new IllegalArgumentException("Deal type is not recognized");
        }
    }

    public static DealType create2(JSONObject json) {
        try {
            String dealType = json.getJSONObject("Trade").getString("type");
            double price = json.getJSONObject("Trade").getDouble("price");
            return DealTypeEnum.valueOf(dealType).create(price);
        } catch (JSONException|IllegalArgumentException e){
            throw new IllegalArgumentException("Deal type is not recognized:" + e.getMessage());
        }
    }
}
