using System;
using Xunit;
using Moq;

namespace CodelyTv.CoursesStepsCsv.Tests
{
    public class CourseStepsGetControllerShould
    {
        private readonly Mock<Platform> platform;
        private readonly CourseStepsGetController courseStepsGetController;
        public CourseStepsGetControllerShould()
        {
            platform = new Mock<Platform>();
            courseStepsGetController = new CourseStepsGetController(platform.Object);
        }

        [Fact]
        public void ReturnEmptyStepList()
        {
            var courseId = "8fe17ce6-1d33-4b6b-a27c-4e0d1f870a19";
            var emptyCsv = "";

            GivenPlatformReturnsCourseStepCsv(courseId, emptyCsv);

            var actualCourseSteps = courseStepsGetController.Get(courseId);

            Assert.Equal("", actualCourseSteps);
        }

        private void GivenPlatformReturnsCourseStepCsv(string courseId, string csv)
        {
            platform.Setup(x => x.FindCourseSteps(courseId)).Returns(csv);
        }
    }
}
