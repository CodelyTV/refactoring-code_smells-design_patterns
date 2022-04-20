<?php

namespace AppBundle\Tests\Model;

use AppBundle\Model\Course;
use PHPUnit_Framework_TestCase;

final class CourseTest extends PHPUnit_Framework_TestCase
{
    public function testGetters()
    {
        $course = new Course();

        $this->assertEquals(Course::DEFAULT_TITLE, $course->getTitle());
        $this->assertEquals(Course::DEFAULT_LEVEL, $course->getLevel());
        $this->assertEquals(Course::DEFAULT_TYPE, $course->getType());
    }
}
