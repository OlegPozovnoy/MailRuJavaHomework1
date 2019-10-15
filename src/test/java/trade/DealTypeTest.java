package trade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealTypeTest {

    @Test
    void toStringTest() {

        DealType dealType = new Bond(100);
        assertTrue(dealType.toString().contains(dealType.getClass().toString())
                && dealType.toString().contains("Price:")
                && dealType.toString().contains("100"));

        dealType = new FxSpot(100);
        assertTrue(dealType.toString().contains(dealType.getClass().toString())
                && dealType.toString().contains("Price:")
                && dealType.toString().contains("100"));

    }
}
