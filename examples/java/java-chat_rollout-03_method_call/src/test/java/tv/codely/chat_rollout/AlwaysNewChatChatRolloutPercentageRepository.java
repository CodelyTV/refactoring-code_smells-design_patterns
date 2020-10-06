package tv.codely.chat_rollout;

public final class AlwaysNewChatChatRolloutPercentageRepository implements ChatRolloutPercentageRepository {
    @Override
    public int percentage() {
        return 100;
    }
}
