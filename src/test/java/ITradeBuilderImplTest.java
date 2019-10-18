import org.json.JSONObject;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import trade.*;
import tradebuilder.ITradeBuilder;
import tradebuilder.TradeBuilderEnumImpl;
import tradebuilder.TradeBuilderSwitchImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ITradeBuilderImplTest {
    private String getJsonString(String dealType, String price) {
        return "{Trade: { type:" + dealType + ", price: " + price + " }}";
    }

    private static Stream<Arguments> provideTradeBuilder() {
        return Stream.of(
                Arguments.of(new TradeBuilderSwitchImpl()),
                Arguments.of(new TradeBuilderEnumImpl())
        );
    }

    @ParameterizedTest
    @MethodSource("provideTradeBuilder")
    void createBond(ITradeBuilder tradeBuilder) {
        JSONObject json = new JSONObject(getJsonString("BOND", "100"));
        DealType deal = tradeBuilder.create(json);
        assertTrue(deal instanceof Bond);
        assertEquals(100, deal.getPrice());
    }

    @ParameterizedTest
    @MethodSource("provideTradeBuilder")
    void createCommoditySpot(ITradeBuilder tradeBuilder) {
        JSONObject json = new JSONObject(getJsonString("COMMODITY_SPOT", "100"));
        DealType deal = tradeBuilder.create(json);
        assertTrue(deal instanceof CommoditySpot);
        assertEquals(100, deal.getPrice());
    }

    @ParameterizedTest
    @MethodSource("provideTradeBuilder")
    void createFxSpot(ITradeBuilder tradeBuilder) {
        JSONObject json = new JSONObject(getJsonString("FX_SPOT", "100"));
        DealType deal = tradeBuilder.create(json);
        assertTrue(deal instanceof FxSpot);
        assertEquals(100, deal.getPrice());
    }

    @ParameterizedTest
    @MethodSource("provideTradeBuilder")
    void createIRSwap(ITradeBuilder tradeBuilder) {
        JSONObject json = new JSONObject(getJsonString("IR_SWAP", "100"));
        DealType deal = tradeBuilder.create(json);
        assertTrue(deal instanceof IRSwap);
        assertEquals(100, deal.getPrice());
    }

    @ParameterizedTest
    @MethodSource("provideTradeBuilder")
    void createUnrecognizedDeal(ITradeBuilder tradeBuilder) {
        JSONObject json = new JSONObject(getJsonString("Sausage", "100"));
        assertThrows(IllegalArgumentException.class, () -> tradeBuilder.create(json));
    }
}
