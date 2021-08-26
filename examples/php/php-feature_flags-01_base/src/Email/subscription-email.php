<p>Message for all subscribers</p>

<?php if (\CodelyTv\FeatureFlags::instance()->get(\CodelyTv\Flags::NEW_SUBSCRIPTION_PAGE_NAME)): ?>
    <p>Additional message for subscribers with active flag</p>
<?php endif; ?>
