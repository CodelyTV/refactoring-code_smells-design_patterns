import {MockCourseRepository} from "./MockCourseRepository";
import {CoursesController}    from "../src/CoursesController";
import {CourseCreator}        from "../src/CourseCreator";
import {Course}               from "../src/Course";

describe('CoursesController should', () => {
    it('create a valid course', () => {
        const request = {
            body: {
                id:       "659045a4-300c-4a49-aee6-a4d880cf3079",
                name:     "Refactoring: Bloaters",
                duration: 777
            }
        };

        const expectedCourse = new Course("659045a4-300c-4a49-aee6-a4d880cf3079", "Refactoring: Bloaters", 777);

        const repository = new MockCourseRepository(expectedCourse);
        const creator    = new CourseCreator(repository);
        const controller = new CoursesController(creator);

        expect(controller.create(request)).toStrictEqual({status: 201});
    });
});
