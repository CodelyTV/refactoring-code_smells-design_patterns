package tv.codely.student_grades;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class StudentGradeCalculator {
    final private Map<Integer, List<Pair<String, Boolean>>> allYearsTeachers = Map.ofEntries(
        new AbstractMap.SimpleImmutableEntry<>(
            2020,
            List.of(
                new Pair<>("Josefina", true),
                new Pair<>("Edonisio", true),
                new Pair<>("Edufasio", false)
            )
        ),
        new AbstractMap.SimpleImmutableEntry<>(
            2019,
            List.of(
                new Pair<>("Eduarda", false),
                new Pair<>("Abelardo", false),
                new Pair<>("Francisca", false)
            )
        )
    );
    private final int                                       yearToCalculate;

    public StudentGradeCalculator(final int yearToCalculate) {
        this.yearToCalculate = yearToCalculate;
    }

    public float calculateGrades(final List<Pair<Integer, Float>> examsGrades, final boolean hasReachedMinimumClasses) {
        if (examsGrades.isEmpty()) {
            return 0f;
        }

        if (!hasReachedMinimumClasses) {
            return 0f;
        }

        ensureGradesWeightSumIs100percent(examsGrades);

        float gradesSum = gradesSum(examsGrades);

        if (hasToIncreaseOneExtraPoint()) {
            return Float.min(10f, gradesSum + 1);
        }

        return gradesSum;
    }

    private void ensureGradesWeightSumIs100percent(List<Pair<Integer, Float>> examsGrades) {
        int gradesWeightSum = gradesWeightSum(examsGrades);

        if (gradesWeightSum > 100) {
            throw new GradesWeightOverMaxException();
        } else if (gradesWeightSum < 100) {
            throw new GradesWeightBelowMinException();
        }
    }

    private float gradesSum(List<Pair<Integer, Float>> examsGrades) {
        float gradesSum = 0f;
        for (Pair<Integer, Float> examGrade : examsGrades) {
            gradesSum += (examGrade.first() * examGrade.second() / 100);
        }
        return gradesSum;
    }

    private int gradesWeightSum(List<Pair<Integer, Float>> examsGrades) {
        return examsGrades.stream().map(Pair::first).reduce(Integer::sum).get();
    }

    private boolean hasToIncreaseOneExtraPoint() {
        boolean hasToIncreaseOneExtraPoint = false;

        for (Map.Entry<Integer, List<Pair<String, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()) {
            if (!(yearToCalculate != yearlyTeachers.getKey())) {
                List<Pair<String, Boolean>> teachers = yearlyTeachers.getValue();

                for (Pair<String, Boolean> teacher : teachers) {
                    if (teacher.second() != true) {
                        continue;
                    }
                    hasToIncreaseOneExtraPoint = true;
                }
            } else {
                continue;
            }
        }
        return hasToIncreaseOneExtraPoint;
    }
}
