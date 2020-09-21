package tv.codely.student_grades;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentGradeCalculatorShould {
    @Test
    void fail_given_there_are_no_exams() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

        final List<Pair<Integer, Float>> examsGrades              = Collections.emptyList();
        final boolean                    hasReachedMinimumClasses = true;

        assertEquals(0, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    @Test
    void calculate_same_grade_given_one_single_exam_and_attending_the_minimum_classes() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

        final List<Pair<Integer, Float>> examsGrades              = List.of(new Pair<>(100, 5f));
        final boolean                    hasReachedMinimumClasses = true;

        assertEquals(5, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    @Test
    void calculate_average_grade_given_different_exam_grades_and_attending_the_minimum_classes() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

        final List<Pair<Integer, Float>> examsGrades = List.of(
            new Pair<>(10, 4f),
            new Pair<>(10, 6f),
            new Pair<>(10, 2f),
            new Pair<>(10, 8f),
            new Pair<>(10, 0f),
            new Pair<>(10, 10f),
            new Pair<>(10, 0f),
            new Pair<>(10, 10f),
            new Pair<>(10, 0f),
            new Pair<>(10, 10f)
        );
        final boolean hasReachedMinimumClasses = true;

        assertEquals(5, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    @Test
    void round_up_to_2_decimals_given_odd_exam_grades_and_attending_the_minimum_classes() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

        final List<Pair<Integer, Float>> examsGrades = List.of(
            new Pair<>(50, 4f),
            new Pair<>(50, 5f)
        );
        final boolean hasReachedMinimumClasses = true;

        assertEquals(4.5f, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    // hasReachedMinimumClasses

    @Test
    void fail_when_there_are_no_exams_and_has_not_attended_the_minimum_classes() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

        final List<Pair<Integer, Float>> examsGrades              = Collections.emptyList();
        final boolean                    hasReachedMinimumClasses = false;

        assertEquals(0, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    @Test
    void fail_given_one_single_exam_but_not_attending_the_minimum_classes() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

        final List<Pair<Integer, Float>> examsGrades              = List.of(new Pair<>(100, 5f));
        final boolean                    hasReachedMinimumClasses = false;

        assertEquals(0, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    @Test
    void fail_given_different_exam_grades_but_not_attending_the_minimum_classes() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

        final List<Pair<Integer, Float>> examsGrades = List.of(
            new Pair<>(10, 4f),
            new Pair<>(10, 6f),
            new Pair<>(10, 2f),
            new Pair<>(10, 8f),
            new Pair<>(10, 0f),
            new Pair<>(10, 10f),
            new Pair<>(10, 0f),
            new Pair<>(10, 10f),
            new Pair<>(10, 0f),
            new Pair<>(10, 10f)
        );
        final boolean hasReachedMinimumClasses = false;

        assertEquals(0, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    @Test
    void fail_given_odd_exam_grades_but_not_attending_the_minimum_classes() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

        final List<Pair<Integer, Float>> examsGrades = List.of(
            new Pair<>(50, 5f),
            new Pair<>(50, 4f)
        );
        final boolean hasReachedMinimumClasses = false;

        assertEquals(0, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    // Weight

    @Test
    void validate_all_exam_grades_weight_below_100() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

        final List<Pair<Integer, Float>> examsGrades = List.of(
            new Pair<>(10, 4f),
            new Pair<>(10, 6f)
        );
        final boolean hasReachedMinimumClasses = true;

        assertEquals(-2, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    @Test
    void validate_all_exam_grades_weight_over_100() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

        final List<Pair<Integer, Float>> examsGrades = List.of(
            new Pair<>(90, 4f),
            new Pair<>(20, 6f)
        );
        final boolean hasReachedMinimumClasses = true;

        assertEquals(-1, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }
}
