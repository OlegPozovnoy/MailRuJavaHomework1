package trade;

import com.sun.corba.se.spi.transport.TransportDefault;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class BondTest {
    @Test
    void testInstantiation() {
        Bond bond = new Bond(100);
        assertNotNull(bond);
        assertTrue(bond instanceof DealType);
    }
}
