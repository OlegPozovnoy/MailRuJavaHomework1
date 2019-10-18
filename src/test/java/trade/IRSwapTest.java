package trade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IRSwapTest {
    @Test
    void testInstantiation() {
        IRSwap irSwap = new IRSwap(100);
        assertNotNull(irSwap);
        assertTrue(irSwap instanceof DealType);
        assertEquals(100, irSwap.getPrice());
    }
}
