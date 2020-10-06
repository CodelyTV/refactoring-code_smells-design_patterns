package tv.codely.chat_rollout;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class ChatControllerShould {
    @Test
    void should_use_the_old_chat_system_pulling_messages() {
        var controller = new ChatController(new AlwaysOldChatChatRolloutPercentageRepository());

        assertEquals("Messages from the OLD chat system", controller.pullMessages());
    }

    @Test
    void should_use_the_new_chat_system_pulling_messages() {
        var controller = new ChatController(new AlwaysNewChatChatRolloutPercentageRepository());

        assertEquals("Messages from the NEW chat system", controller.pullMessages());
    }
}
