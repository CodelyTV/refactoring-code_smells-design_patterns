package tv.codely.student_grades;

import java.util.List;

public class StudentGradeCalculator {
    public Integer calculateGrades(List<Integer> examsGrades) {
        if (!examsGrades.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
