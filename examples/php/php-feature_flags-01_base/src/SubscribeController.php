<?php

declare(strict_types=1);

namespace CodelyTv;

use CodelyTv\Application\Subscribe;
use Symfony\Component\HttpFoundation\Request;

final class SubscribeController
{
    public function __invoke(Request $request)
    {
        $flagHeader = $request->headers->get('X-FLAG');

        if ($flagHeader === Flags::NEW_SUBSCRIPTION_PAGE_TOKEN) {
            FeatureFlags::instance()->set('new_subscription_page', true);
        }

        $subscribeUseCase = new Subscribe();
        $subscribeUseCase->__invoke(
            $request->request->get('email'),
            $request->request->get('name'),
        );
    }
}
