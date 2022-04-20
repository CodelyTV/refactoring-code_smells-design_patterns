<?php

namespace AppBundle\Controller;

use Symfony\Component\HttpFoundation\Request;

final class CourseController extends BaseController
{
    public function getCourseAction(Request $request)
    {
        return $this->getDoctrine()
            ->getEntityManager()
            ->createQueryBuilder()
            ->select('c', 'v')
            ->from('AppBundle\Model\Course', 'c')
            ->where('c.level', '>', $request->get('from_level', 0))
            ->getQuery()
            ->execute();
    }

    public function getCourseVideosAction($courseId)
    {
        if ($this->hasCache('course-db-' . $courseId)) {
            return $this->getCache('course-db-' . $courseId);
        } else {
            $this->setCache(
                'course-db-' . $courseId,
                $this->getDoctrine()
                    ->getEntityManager()
                    ->createQueryBuilder()
                    ->select('c', 'v')
                    ->from('AppBundle\Model\Course', 'c')
                    ->leftJoin('a.Video', 'v')
                    ->where('c.id', '=', $courseId)
                    ->getQuery()
                    ->execute()
            );
        }

        return $this->getCache('course-db-' . $courseId);
    }
}
