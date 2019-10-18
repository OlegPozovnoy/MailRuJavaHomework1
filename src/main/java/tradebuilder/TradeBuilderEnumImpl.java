package tradebuilder;

import org.json.JSONException;
import trade.*;
import org.json.JSONObject;

public class TradeBuilderEnumImpl implements ITradeBuilder {
    public DealType create(JSONObject json) {
        try {
            String dealType = json.getJSONObject("Trade").getString("type");
            double price = json.getJSONObject("Trade").getDouble("price");
            return DealTypeEnum.valueOf(dealType).create(price);
        } catch (JSONException | IllegalArgumentException e) {
            throw new IllegalArgumentException("Deal type is not recognized:" + e.getMessage());
        }
    }
}
