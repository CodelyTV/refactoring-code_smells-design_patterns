<?php

namespace AppBundle\Model;

final class Course
{
    const DEFAULT_TITLE = 'El mejor curso de la historia';
    const DEFAULT_LEVEL = 'easy';
    const DEFAULT_TYPE = 'subscription';

    public $title;
    public $level;
    public $type;

    public function getTitle()
    {
        return $this->title ?: self::DEFAULT_TITLE;
    }

    public function getLevel()
    {
        return $this->level ?: self::DEFAULT_LEVEL;
    }

    public function getType()
    {
        return $this->type ?: self::DEFAULT_TYPE;
    }
}
