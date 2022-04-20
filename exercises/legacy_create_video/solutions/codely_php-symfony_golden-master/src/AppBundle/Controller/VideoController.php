<?php

namespace AppBundle\Controller;

use AppBundle\Application\VideoCreator;
use Symfony\Component\HttpFoundation\Request;

/**
 * THE VIDEO CONTROLLER
 * © CodelyTV 2017
 */
class VideoController extends BaseController
{
    /** @var VideoCreator */
    private $videoCreator;

    public function __construct()
    {
        $this->videoCreator = new VideoCreator();
    }

    /**
     * Method used to create a new video
     * @todo Validate the request
     */
    public function postVideoAction(Request $request)
    {
        // Preparing the sql to create the video
        $title = $request->get('title');
        $url = $request->get('url');
        $courseId = $request->get('course_id');
        $connection = $this->getDoctrine()->getConnection();

        list($title, $videoId) = $this->videoCreator->createVideo($title, $url, $courseId, $connection);

        // And we return the video created
        return [
            'id'        => $videoId,
            'title'     => $title,
            'url'       => $url,
            'course_id' => $courseId,
        ];
    }

}
