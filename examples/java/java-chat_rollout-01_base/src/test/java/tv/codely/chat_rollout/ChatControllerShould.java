package tv.codely.chat_rollout;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class ChatControllerShould {
    @Test
    @Disabled("This fails randomly because we can't control the CHAT_ROLLOUT_PERCENTAGE")
    void should_use_the_old_chat_system_pulling_messages() {
        var controller = new ChatController();

        assertEquals("Messages from the OLD chat system", controller.pullMessages());
    }

    @Test
    @Disabled("This fails randomly because we can't control the CHAT_ROLLOUT_PERCENTAGE")
    void should_use_the_new_chat_system_pulling_messages() {
        var controller = new ChatController();

        assertEquals("Messages from the NEW chat system", controller.pullMessages());
    }
}
