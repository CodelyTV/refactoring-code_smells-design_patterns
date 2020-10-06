package tv.codely.chat_rollout;

import java.util.Random;

public final class ChatController {
    private final int newChatRolloutPercentage;

    public ChatController(int newChatRolloutPercentage) {
        this.newChatRolloutPercentage = newChatRolloutPercentage;
    }

    public String pullMessages() {
        if (new Random().nextInt(100) <= newChatRolloutPercentage) {
            return "Messages from the NEW chat system";
        } else {
            return "Messages from the OLD chat system";
        }
    }
}
