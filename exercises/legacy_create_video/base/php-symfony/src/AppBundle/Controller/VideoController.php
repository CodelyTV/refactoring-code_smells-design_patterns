<?php

namespace AppBundle\Controller;

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
        $sql  = "INSERT INTO video (title, url, course_id) 
                VALUES (\"{$request->get('title')}\",
                        \"{$request->get('url')}\",
                        {$request->get('course_id')}
                )";

        // Prepare doctrine statement
        $connection = $this->getDoctrine()->getConnection();
        $stmt = $connection->prepare($sql);
        $stmt->execute();

        // IMPORTANT: Obtaining the video id. Take care, it's done without another query :)
        $videoId = $connection->lastInsertId();

        $title = $request->get('title');
        $sql = "UPDATE video SET ";
        if (strpos($request->get('title'), "hexagonal")) {
            $title = str_replace("hexagonal", "Hexagonal", $title);
        }
        if (strpos($request->get('title'), "solid")) {
            $title = str_replace("solid", "SOLID", $title);
        }
        if (strpos($request->get('title'), "tdd")) {
            $title = str_replace("tdd", "TDD", $title);
        }
        $sql .= "title = '" . $title . "' WHERE id = " . $videoId;
        $connection->query($sql);

        // And we return the video created
        return [
            'id'        => $videoId,
            'title'     => $title,
            'url'       => $request->get('url'),
            'course_id' => $request->get('course_id'),
        ];
    }
}
