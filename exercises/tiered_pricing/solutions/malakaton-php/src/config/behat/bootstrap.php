<?php

(new Symfony\Component\Dotenv\Dotenv())->bootEnv(dirname(__DIR__, 2).'/.env.test');
