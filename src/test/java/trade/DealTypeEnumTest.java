package trade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealTypeEnumTest {
    @Test
    void create() {
        for (DealTypeEnum val : DealTypeEnum.values()) {
            assertNotNull(val.create(100));
        }
    }
}
