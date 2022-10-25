package tv.codely.checkout;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubscriptionsShould {
    @Test
    public void not_allow_negative_volume() {
        final int volume = 0;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Subscriptions.by(volume);
        });
        String expectedMessage = "You have to buy at least one subscription";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
