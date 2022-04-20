<?php

namespace AppBundle\Util;

class Cache
{
    private static $cache = array();

    public static function set($key, $value)
    {
        self::$cache[$key] = $value;
    }

    public static function get($key)
    {
        return self::$cache[$key];
    }

    public static function has($key)
    {
        return array_key_exists($key, self::$cache);
    }
}
