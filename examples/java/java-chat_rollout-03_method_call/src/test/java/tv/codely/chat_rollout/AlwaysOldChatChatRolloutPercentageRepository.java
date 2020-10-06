package tv.codely.chat_rollout;

public final class AlwaysOldChatChatRolloutPercentageRepository implements ChatRolloutPercentageRepository {
    @Override
    public int percentage() {
        return 0;
    }
}

