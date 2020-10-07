import {Course} from "./Course";

export class CourseCreator {
    constructor(repository) {
        this.repository = repository;
    }

    create(request) {
        const course = new Course(request.id, request.name, request.duration);

        this.repository.save(course);
    }
}
