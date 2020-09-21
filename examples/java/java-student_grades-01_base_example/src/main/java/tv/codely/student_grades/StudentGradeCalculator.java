package tv.codely.student_grades;

import java.util.List;
import java.util.Map;

public class StudentGradeCalculator {
    public Float calculateGrades(final List<Pair<Integer, Float>> examsGrades, final boolean hasReachedMinimumClasses) {
        if (!examsGrades.isEmpty()) {
            Float gradesSum = 0f;
            Integer gradesWeightSum = 0;

            for (Pair<Integer, Float> examGrade : examsGrades) {
                gradesSum += (examGrade.first() * examGrade.second() / 100);
                gradesWeightSum += examGrade.first();
            }

            if (gradesWeightSum == 100) {
                if (hasReachedMinimumClasses) {
                    return gradesSum;
                } else {
                    return 0f;
                }
            } else if (gradesWeightSum > 100) {
                return -1f;
            } else {
                return -2f;
            }
        } else {
            return 0f;
        }
    }
}
