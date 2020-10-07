export class MockCourseRepository {
    constructor(expectedCourseToBeSaved) {
        this.expectedCourseToBeSaved = expectedCourseToBeSaved;
    }

    save(course) {
        if (course.id !== this.expectedCourseToBeSaved.id ||
            course.name !== this.expectedCourseToBeSaved.name ||
            course.duration !== this.expectedCourseToBeSaved.duration
        ) {
            throw "The expected course and the actual are not the same";
        }
    }
}
