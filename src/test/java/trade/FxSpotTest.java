package trade;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class FxSpotTest {
    @Test
    void testInstantiation() {
        FxSpot fxSpot = new FxSpot(100);
        assertNotNull(fxSpot);
        assertTrue(fxSpot instanceof DealType);
    }
}
