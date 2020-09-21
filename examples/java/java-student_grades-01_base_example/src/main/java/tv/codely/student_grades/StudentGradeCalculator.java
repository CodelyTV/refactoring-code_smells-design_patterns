package tv.codely.student_grades;

import java.util.List;

public class StudentGradeCalculator {
    public Float calculateGrades(final List<Float> examsGrades, final Boolean hasReachedMinimumClasses) {
        if (!examsGrades.isEmpty()) {
            Float gradesSum = 0.f;
            Integer gradesCounter = 0;

            for (Float examGrade : examsGrades) {
                gradesSum += examGrade;
                gradesCounter++;
            }

            if (hasReachedMinimumClasses) {
                return gradesSum / gradesCounter;
            } else {
                return 0.f;
            }
        } else {
            return 0.f;
        }
    }
}
