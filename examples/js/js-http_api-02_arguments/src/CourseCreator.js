import {Course} from "./Course";

export class CourseCreator {
    constructor(repository) {
        this.repository = repository;
    }

    create(request) {
        const course = new Course(request.body.id, request.body.name, request.body.duration);

        this.repository.save(course);
    }
}
