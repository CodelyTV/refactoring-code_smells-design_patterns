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
        ),
        new AbstractMap.SimpleImmutableEntry<>(
            2018,
            List.of(
                new Pair<>("Javi", false),
                new Pair<>("Rafa", false),
                new Pair<>("Nico", false),
                new Pair<>("Núria", false)
            )
        ),
        new AbstractMap.SimpleImmutableEntry<>(
            2017,
            List.of(new Pair<>("Lerele", false))
        )
    );
    private final int                                       yearToCalculate;

    public StudentGradeCalculator(final int yearToCalculate) {
        this.yearToCalculate = yearToCalculate;
    }

    public float calculateGrades(final List<Pair<Integer, Float>> examsGrades, final boolean hasReachedMinimumClasses) {
        boolean hasDoneAnyExam = !examsGrades.isEmpty();
        if (!hasDoneAnyExam) {
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
        return examsGrades.stream().map(Pair::first).reduce(Integer::sum).orElse(0);
    }

    private boolean hasToIncreaseOneExtraPoint() {
        for (Map.Entry<Integer, List<Pair<String, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()) {
            if (yearToCalculate != yearlyTeachers.getKey()) {
                continue;
            }

            List<Pair<String, Boolean>> teachers = yearlyTeachers.getValue();

            for (Pair<String, Boolean> teacher : teachers) {
                Boolean isBenevolent = teacher.second();
                boolean isEvenYear   = yearToCalculate % 2 == 0;

                if ((isBenevolent && isEvenYear) || teacher.first().equals("Núria")) {
                    return true;
                }
            }
        }

        return false;
    }
}
