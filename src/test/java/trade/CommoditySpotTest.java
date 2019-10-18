package trade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommoditySpotTest {
    @Test
    void testInstantiation() {
        CommoditySpot commoditySpot = new CommoditySpot(100);
        assertNotNull(commoditySpot);
        assertTrue(commoditySpot instanceof DealType);
        assertEquals(100, commoditySpot.getPrice());
    }
}
