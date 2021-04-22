using System;

namespace CodelyTv.CoursesStepsCsv
{
    public sealed class CourseStepsGetController
    {
        private readonly Platform platform;

        public CourseStepsGetController(Platform platform)
        {
            this.platform = platform;
        }

        public string Get(string courseId)
        {
            return platform.FindCourseSteps(courseId);
        }
    }
}
