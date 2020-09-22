import {StudentGradeCalculator} from "./StudentGradeCalculator";

export class StudentGrade2020Calculator extends StudentGradeCalculator {
    thisYearTeachers() {
        return [
            ["Josefina", true],
            ["Edonisio", true],
            ["Edufasio", false],
        ];
    }
}
