<?php

declare(strict_types=1);

namespace App\Checkout\Infrastructure\Http\Controller;

use App\Checkout\Application\Query\CalculateTotalPriceQuery;
use App\Shared\Infrastructure\Http\Controller\QueryController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

final class GetTieredPricingController extends QueryController
{
    /**
     * @Route("/checkout/total", methods={"GET"})
     *
     * @param Request $request
     * @return Response
     */
    public function __invoke(Request $request): Response
    {
        $query = new CalculateTotalPriceQuery((int) $request->query->get('subscriptions'));

        $total = $this->ask($query);

        return $this->json($total);
    }
}
