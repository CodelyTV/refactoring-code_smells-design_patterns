<?php

use CodelyTv\RepeatPurchase\CartId;
use CodelyTv\RepeatPurchase\DummyCartRepository;
use CodelyTv\RepeatPurchase\RepeatPurchase;

require_once __DIR__ . '/../../vendor/autoload.php';

$repository = new DummyCartRepository();
$repeatPurchase = new RepeatPurchase($repository);
$repeatPurchase(new CartId('dummyCart'));
