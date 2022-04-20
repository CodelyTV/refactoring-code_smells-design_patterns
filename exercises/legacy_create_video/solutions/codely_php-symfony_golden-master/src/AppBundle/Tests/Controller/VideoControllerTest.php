<?php

namespace AppBundle\Tests\Controller;

use Bazinga\Bundle\RestExtraBundle\Test\WebTestCase;
use PDO;

class VideoControllerTest extends WebTestCase
{
    private $connection;

    protected function setUp()
    {
        $this->connection = $this->getClient()->getContainer()->get('database_connection');
        $this->connection->query("TRUNCATE video");
    }

    public function testPostVideo()
    {
        $client = $this->getClient(true);

        $client->request('POST', '/videos.json', [
            'title' => 'Arquitectura hexagonal, solid y tdd',
            'url' => 'https://pro.codely.tv/library/testing-frontend',
            'course_id' => 5
        ]);
        $response = $client->getResponse();

        $this->assertJsonResponse($response);
        $expectedId = "1";
        $expectedTitle = "Arquitectura Hexagonal, SOLID y TDD";
        $expectedUrl = "https://pro.codely.tv/library/testing-frontend";
        $expectedCourseId = 5;
        $expectedResponse = [
            "id" => $expectedId,
            "title" => $expectedTitle,
            "url" => $expectedUrl,
            "course_id" => $expectedCourseId
        ];

        $this->assertEquals(json_encode($expectedResponse), $response->getContent());

        $stmt = $this->connection->prepare("SELECT * FROM video WHERE id = 1");
        $stmt->execute();
        $result = $stmt->fetch(PDO::FETCH_ASSOC);

        $this->assertEquals($expectedTitle, $result['title']);
        $this->assertEquals($expectedUrl, $result['url']);
        $this->assertEquals($expectedCourseId, $result['course_id']);
    }

    private function getClient($authenticated = false)
    {
        $params = array();
        if ($authenticated) {
            $params = array_merge($params, array(
                    'PHP_AUTH_USER' => 'restapi',
                    'PHP_AUTH_PW'   => 'secretpw',
                ));
        }

        return static::createClient(array(), $params);
    }
}
