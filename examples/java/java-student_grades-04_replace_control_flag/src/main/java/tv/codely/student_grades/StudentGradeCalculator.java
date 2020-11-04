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
        boolean hasNotDoneAnyExam = examsGrades.isEmpty();
        if (hasNotDoneAnyExam) {
            return 0f;
        }

        if (!hasReachedMinimumClasses) {
            return 0f;
        }

        ensureGradesWeightsIsValid(examsGrades);

        if (hasToIncreaseOneExtraPoint()) {
            float increasedGrade = gradesSum(examsGrades) + 1;

            return Float.min(10f, increasedGrade);
        }

        return gradesSum(examsGrades);
    }

    private void ensureGradesWeightsIsValid(List<Pair<Integer, Float>> examsGrades) {
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
        for (Map.Entry<Integer, List<Pair<String, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()) {
            if (yearToCalculate != yearlyTeachers.getKey()) {
                continue;
            }

            List<Pair<String, Boolean>> teachers = yearlyTeachers.getValue();

            for (Pair<String, Boolean> teacher : teachers) {
                Boolean isBenevolent = teacher.second();
                if (isBenevolent) {
                    return true;
                }
            }
        }

        return false;
    }
}
