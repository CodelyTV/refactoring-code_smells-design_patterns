export class CoursesController {
    constructor(courseCreator) {
        this.courseCreator = courseCreator;
    }

    create(request) {
        this.courseCreator.create(request.body.id, request.body.name, request.body.duration);

        return {status: 201};
    }
}
