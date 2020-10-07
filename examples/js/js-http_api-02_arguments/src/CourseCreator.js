import {Course} from "./Course";

export class CourseCreator {
    constructor(repository) {
        this.repository = repository;
    }

    create(id, name, duration) {
        const course = new Course(id, name, duration);

        this.repository.save(course);
    }
}
