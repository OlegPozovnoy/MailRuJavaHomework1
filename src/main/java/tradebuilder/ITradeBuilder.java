package tradebuilder;

import org.json.JSONObject;
import trade.DealType;

public interface ITradeBuilder {
    DealType create(JSONObject json);
}
