import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import trade.Bond;
import trade.CommoditySpot;
import trade.FxSpot;
import trade.IRSwap;

import static org.junit.jupiter.api.Assertions.*;

class TradeBuilderTest {

    private String getJsonString(String dealType, String price){
        return "{Trade: { type:" + dealType + ", price: " + price + " }}";
    }

    @Test
    void createBond() {
        JSONObject json = new JSONObject(getJsonString("BOND", "100"));
        assertTrue(TradeBuilder.create1(json) instanceof Bond);
        assertTrue(TradeBuilder.create2(json) instanceof Bond);
    }

    @Test
    void createCommoditySpot() {
        JSONObject json = new JSONObject(getJsonString("COMMODITY_SPOT", "100"));
        assertTrue(TradeBuilder.create1(json) instanceof CommoditySpot);
        assertTrue(TradeBuilder.create2(json) instanceof CommoditySpot);
    }

    @Test
    void createFxSpot() {
        JSONObject json = new JSONObject(getJsonString("FX_SPOT", "100"));
        assertTrue(TradeBuilder.create1(json) instanceof FxSpot);
        assertTrue(TradeBuilder.create2(json) instanceof FxSpot);
    }


    @Test
    void createIRSwap() {
        JSONObject json = new JSONObject(getJsonString("IR_SWAP", "100"));
        assertTrue(TradeBuilder.create1(json) instanceof IRSwap);
        assertTrue(TradeBuilder.create2(json) instanceof IRSwap);
    }

    @Test
    void createUnrecognizedDeal() {
        JSONObject json = new JSONObject(getJsonString("Sausage", "100"));
        assertThrows(IllegalArgumentException.class, ()-> TradeBuilder.create1(json));
        assertThrows(IllegalArgumentException.class, ()-> TradeBuilder.create2(json));
    }


}