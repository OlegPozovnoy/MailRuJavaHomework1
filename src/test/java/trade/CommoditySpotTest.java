package trade;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommoditySpotTest {
    @Test
    void testInstantiation() {
        CommoditySpot commoditySpot = new CommoditySpot(100);
        assertNotNull(commoditySpot);
        assertTrue(commoditySpot instanceof DealType);
    }
}
