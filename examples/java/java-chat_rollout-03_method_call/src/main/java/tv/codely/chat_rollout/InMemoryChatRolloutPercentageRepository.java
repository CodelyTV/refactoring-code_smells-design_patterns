package tv.codely.chat_rollout;

public final class InMemoryChatRolloutPercentageRepository implements ChatRolloutPercentageRepository {
    @Override
    public int percentage() {
        return 30;
    }
}
