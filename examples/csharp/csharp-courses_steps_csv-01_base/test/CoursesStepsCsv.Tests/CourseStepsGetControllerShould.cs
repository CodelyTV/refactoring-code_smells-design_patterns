using System;
using Xunit;

namespace CodelyTv.CoursesStepsCsv.Tests
{
    public class CourseStepsGetControllerShould
    {
        [Fact]
        public void ReturnAString()
        {
            var courseStepsGetController = new CourseStepsGetController();

            Assert.Equal("lerele", courseStepsGetController.Lerele());
        }
    }
}
