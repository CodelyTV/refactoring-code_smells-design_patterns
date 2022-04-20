<?php

namespace AppBundle\Controller;

use AppBundle\Application\VideoCreator;
use AppBundle\Repository\MySqlVideoRepository;
use Symfony\Component\HttpFoundation\Request;

/**
 * THE VIDEO CONTROLLER
 * © CodelyTV 2017
 */
class VideoController extends BaseController
{
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
        $videoCreator = new VideoCreator(new MySqlVideoRepository($connection));

        list($title, $videoId) = $videoCreator->createVideo($title, $url, $courseId);

        // And we return the video created
        return [
            'id'        => $videoId,
            'title'     => $title,
            'url'       => $url,
            'course_id' => $courseId,
        ];
    }

}
