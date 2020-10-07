export class CoursesController {
    constructor(courseCreator) {
        this.courseCreator = courseCreator;
    }

    create(request) {
        this.courseCreator.create(request);

        return {status: 201};
    }
}
