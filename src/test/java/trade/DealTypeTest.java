package trade;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DealTypeTest {
    private static Stream<Arguments> provideDealType() {
        return Stream.of(
                Arguments.of(new Bond(100), 100),
                Arguments.of(new CommoditySpot(100), 100),
                Arguments.of(new FxSpot(100), 100),
                Arguments.of(new IRSwap(100), 100)
        );
    }

    private boolean isValid(DealType dealType, double price) {
        return (dealType.toString().contains(dealType.getClass().toString())
                && dealType.toString().contains("Price:")
                && dealType.toString().contains(Double.toString(price)));
    }

    @ParameterizedTest
    @MethodSource("provideDealType")
    void toStringTest(DealType dealType, double price) {
        assertTrue(isValid(dealType, price));
    }

    @ParameterizedTest
    @MethodSource("provideDealType")
    void toGetterTest(DealType dealType, double price) {
        assertEquals(price, dealType.getPrice());
    }
}
