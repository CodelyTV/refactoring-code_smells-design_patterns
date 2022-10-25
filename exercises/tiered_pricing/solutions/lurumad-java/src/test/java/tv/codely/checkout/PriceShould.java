package tv.codely.checkout;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PriceShould {
    @Test
    public void not_allow_negative_amount() {
        final float amount = -1.00f;
        final String currency = "€";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Price.of(amount, currency);
        });
        String expectedMessage = "Amount can not be less than 0";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
