package tv.codely.chat_rollout;

import java.util.Random;

public final class ChatController {
    public static final int NEW_CHAT_ROLLOUT_PERCENTAGE = 30;

    public String pullMessages() {
        if (new Random().nextInt(100) <= NEW_CHAT_ROLLOUT_PERCENTAGE) {
            return "Messages from the NEW chat system";
        } else {
            return "Messages from the OLD chat system";
        }
    }
}
