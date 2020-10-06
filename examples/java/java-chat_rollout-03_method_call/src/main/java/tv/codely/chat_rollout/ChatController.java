package tv.codely.chat_rollout;

import java.util.Random;

public final class ChatController {
    private final ChatRolloutPercentageRepository rolloutRepository;

    public ChatController(ChatRolloutPercentageRepository rolloutRepository) {
        this.rolloutRepository = rolloutRepository;
    }

    public String pullMessages() {
        if (new Random().nextInt(100) <= rolloutRepository.percentage()) {
            return "Messages from the NEW chat system";
        } else {
            return "Messages from the OLD chat system";
        }
    }
}
