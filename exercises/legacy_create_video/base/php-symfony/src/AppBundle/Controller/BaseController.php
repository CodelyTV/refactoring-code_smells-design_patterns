<?php

namespace AppBundle\Controller;

use AppBundle\Util\Cache;
use FOS\RestBundle\Controller\FOSRestController;

/**
 * Very important, the base of all controllers
 */
abstract class BaseController extends FOSRestController
{
    public function setCache($key, $value)
    {
        Cache::set($key, $value);
    }

    public function getCache($key)
    {
        return Cache::get($key);
    }

    public function hasCache($key)
    {
        return Cache::has($key);
    }
}
