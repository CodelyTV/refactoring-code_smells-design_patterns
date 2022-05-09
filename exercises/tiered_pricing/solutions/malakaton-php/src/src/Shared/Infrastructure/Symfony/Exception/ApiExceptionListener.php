<?php

declare(strict_types=1);

namespace App\Shared\Infrastructure\Symfony\Exception;

use App\Shared\Infrastructure\Symfony\ApiResponseResource;
use Psr\Log\LoggerInterface;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpKernel\Event\ExceptionEvent;

final class ApiExceptionListener
{
    private LoggerInterface $logger;

    public function __construct(LoggerInterface $logger)
    {
        $this->logger = $logger;
    }

    /**
     * @param ExceptionEvent $event
     * @throws \JsonException
     */
    public function onKernelException(ExceptionEvent $event): void
    {
        // You get the exception object from the received event
        $exception = $event->getThrowable();

        try {
            $message = json_decode($exception->getMessage(), true, 512, JSON_THROW_ON_ERROR);
        } catch (\JsonException $e) {
            $message = [
                'message' => $exception->getMessage(),
                'errors' => $exception->getTrace()
            ];
        }

        $this->logger->critical("Exception occurred: {$message['message']}");

        $event->setResponse((new ApiResponseResource(
            $exception->getCode() > 0 ? $exception->getCode() : Response::HTTP_INTERNAL_SERVER_ERROR,
            [],
            $message['errors'],
            $message['message'],
            false

        ))->getResponse());
    }
}
