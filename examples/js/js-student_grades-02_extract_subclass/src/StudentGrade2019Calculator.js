import {StudentGradeCalculator} from "./StudentGradeCalculator";

export class StudentGrade2019Calculator extends StudentGradeCalculator {
    thisYearTeachers() {
        return [
            ["Eduarda", false],
            ["Abelardo", false],
            ["Francisca", false],
        ];
    }
}
