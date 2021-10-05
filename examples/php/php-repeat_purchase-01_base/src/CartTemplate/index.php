<?php

use CodelyTv\CartTemplate\CartId;
use CodelyTv\CartTemplate\CreateCartFromTemplate;
use CodelyTv\CartTemplate\DummyCartRepository;

require_once __DIR__ . '/../../vendor/autoload.php';

$repository = new DummyCartRepository();
$createCartFromTemplate = new CreateCartFromTemplate($repository);
$createCartFromTemplate(new CartId('dummyCart'));
