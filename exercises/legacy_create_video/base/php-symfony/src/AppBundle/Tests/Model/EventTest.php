<?php

namespace AppBundle\Tests\Model;

use AppBundle\Model\Event;
use PHPUnit_Framework_TestCase;

final class EventTest extends PHPUnit_Framework_TestCase
{
    public function testItShouldSetAName()
    {
        $event = new Event('Some name ', new \DateTime());
        $event->setName('New name');
        $this->assertEquals('New name', $event->getName());
    }

    public function testItShouldSetADate()
    {
        $event = new Event('Some name ', new \DateTime());
        $newDate = new \DateTime();
        $event->setDate($newDate);
        $this->assertEquals($newDate, $event->getDate());
    }
}
