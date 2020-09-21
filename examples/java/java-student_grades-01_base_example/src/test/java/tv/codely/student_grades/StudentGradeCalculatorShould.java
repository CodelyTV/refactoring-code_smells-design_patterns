package tv.codely.student_grades;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentGradeCalculatorShould {
    @Test
    void fail_given_there_are_no_exams() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator(2019);

        final List<Pair<Integer, Float>> examsGrades              = Collections.emptyList();
        final boolean                    hasReachedMinimumClasses = true;

        assertEquals(0, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    @Test
    void calculate_same_grade_given_one_single_exam_and_attending_the_minimum_classes() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator(2019);

        final List<Pair<Integer, Float>> examsGrades              = List.of(new Pair<>(100, 5f));
        final boolean                    hasReachedMinimumClasses = true;

        assertEquals(5, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    @Test
    void calculate_average_grade_given_different_exam_grades_and_attending_the_minimum_classes() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator(2019);

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
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator(2019);

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
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator(2019);

        final List<Pair<Integer, Float>> examsGrades              = Collections.emptyList();
        final boolean                    hasReachedMinimumClasses = false;

        assertEquals(0, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    @Test
    void fail_given_one_single_exam_but_not_attending_the_minimum_classes() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator(2019);

        final List<Pair<Integer, Float>> examsGrades              = List.of(new Pair<>(100, 5f));
        final boolean                    hasReachedMinimumClasses = false;

        assertEquals(0, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    @Test
    void fail_given_different_exam_grades_but_not_attending_the_minimum_classes() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator(2019);

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
    void fail_given_odd_exam_grades_but_attending_the_minimum_classes() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator(2019);

        final List<Pair<Integer, Float>> examsGrades              = List.of(new Pair<>(100, 5f));
        final boolean                    hasReachedMinimumClasses = false;

        assertEquals(0, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    // Weight

    @Test
    void validate_all_exam_grades_weight_below_100() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator(2019);

        final List<Pair<Integer, Float>> examsGrades = List.of(
            new Pair<>(10, 4f),
            new Pair<>(10, 6f)
        );
        final boolean hasReachedMinimumClasses = true;

        assertEquals(-2, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    @Test
    void validate_all_exam_grades_weight_over_100() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator(2019);

        final List<Pair<Integer, Float>> examsGrades = List.of(
            new Pair<>(90, 4f),
            new Pair<>(20, 6f)
        );
        final boolean hasReachedMinimumClasses = true;

        assertEquals(-1, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    // hasToRaiseOnePoint

    @Test
    void not_increase_one_extra_point_if_there_is_not_any_benevolent_teacher_in_the_year_to_calculate_grades() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator(2019);

        final List<Pair<Integer, Float>> examsGrades              = List.of(new Pair<>(100, 9.8f));
        final boolean                    hasReachedMinimumClasses = true;

        assertEquals(9.8f, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    @Test
    void increase_one_extra_point_if_there_is_any_benevolent_teacher_in_the_year_to_calculate_grades() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator(2020);

        final List<Pair<Integer, Float>> examsGrades              = List.of(new Pair<>(100, 5f));
        final boolean                    hasReachedMinimumClasses = true;

        assertEquals(6, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    @Test
    void maintain_10_as_the_maximum_grade_even_if_increasing_one_extra_point() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator(2020);

        final List<Pair<Integer, Float>> examsGrades              = List.of(new Pair<>(100, 9.8f));
        final boolean                    hasReachedMinimumClasses = true;

        assertEquals(10, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }
}
