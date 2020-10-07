import {CreateCourseRequest} from "./CreateCourseRequest";

export class CoursesController {
    constructor(courseCreator) {
        this.courseCreator = courseCreator;
    }

    create(request) {
        this.courseCreator.create(new CreateCourseRequest(request.body.id, request.body.name, request.body.duration));

        return {status: 201};
    }
}
