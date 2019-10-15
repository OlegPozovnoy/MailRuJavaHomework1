package trade;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class IRSwapTest {
    @Test
    void testInstantiation() {
        IRSwap irSwap = new IRSwap(100);
        assertNotNull(irSwap);
        assertTrue(irSwap instanceof DealType);
    }
}
