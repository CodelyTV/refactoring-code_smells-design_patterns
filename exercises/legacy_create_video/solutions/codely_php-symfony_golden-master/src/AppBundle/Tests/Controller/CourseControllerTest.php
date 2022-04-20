<?php

namespace AppBundle\Tests\Controller;

use AppBundle\Controller\CourseController;
use Doctrine\Bundle\DoctrineBundle\Registry;
use Doctrine\ORM\AbstractQuery;
use Doctrine\ORM\EntityManager;
use Doctrine\ORM\QueryBuilder;
use PHPUnit_Framework_TestCase;
use Symfony\Component\DependencyInjection\ContainerInterface;
use Symfony\Component\HttpFoundation\Request;

final class CourseControllerTest extends PHPUnit_Framework_TestCase
{
    public function testGetCoursesFilteredByLevel()
    {
        $fromLevel = 0;
        $request   = new Request(['from_level' => $fromLevel]);

        $container     = \Mockery::mock(ContainerInterface::class);
        $doctrine      = \Mockery::mock(Registry::class);
        $entityManager = \Mockery::mock(EntityManager::class);
        $queryBuilder  = \Mockery::mock(QueryBuilder::class);
        $query         = \Mockery::mock(AbstractQuery::class);

        $container->shouldReceive('has')
            ->once()
            ->with('doctrine')
            ->andReturn(true);
        $container->shouldReceive('get')
            ->once()
            ->with('doctrine')
            ->andReturn($doctrine);
        $doctrine->shouldReceive('getEntityManager')
            ->once()
            ->withNoArgs()
            ->andReturn($entityManager);
        $entityManager->shouldReceive('createQueryBuilder')
            ->once()
            ->withNoArgs()
            ->andReturn($queryBuilder);
        $queryBuilder->shouldReceive('select')
            ->once()
            ->with('c', 'v')
            ->andReturn($queryBuilder);
        $queryBuilder->shouldReceive('from')
            ->once()
            ->with('AppBundle\Model\Course', 'c')
            ->andReturn($queryBuilder);
        $queryBuilder->shouldReceive('where')
            ->once()
            ->with('c.level', '>', $fromLevel)
            ->andReturn($queryBuilder);
        $queryBuilder->shouldReceive('getQuery')
            ->once()
            ->withNoArgs()
            ->andReturn($query);
        $query->shouldReceive('execute')
            ->once()
            ->withNoArgs()
            ->andReturn(
                [
                    [
                        'title' => 'Codely mola',
                        'level' => 2,
                    ],
                    [
                        'title' => 'Aprende a decir basicamente como Javi',
                        'level' => 5,
                    ],
                ]
            );

        $controller = new CourseController();
        $controller->setContainer($container);
        $controllerResult = $controller->getCourseAction($request);
        $this->assertEquals(
            [
                [
                    'title' => 'Codely mola',
                    'level' => 2,
                ],
                [
                    'title' => 'Aprende a decir basicamente como Javi',
                    'level' => 5,
                ],
            ],
            $controllerResult
        );
    }
}
