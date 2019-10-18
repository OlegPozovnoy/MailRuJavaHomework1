package trade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BondTest {
    @Test
    void testInstantiation() {
        Bond bond = new Bond(100);
        assertNotNull(bond);
        assertTrue(bond instanceof DealType);
        assertEquals(100, bond.getPrice());
    }
}
