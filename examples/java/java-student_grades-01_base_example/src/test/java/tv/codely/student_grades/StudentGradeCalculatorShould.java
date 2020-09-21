package tv.codely.student_grades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class StudentGradeCalculatorShould {

    @Test
    void fail_given_there_are_no_exams() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

        final List<Float> examsGrades              = Collections.emptyList();
        final Boolean     hasReachedMinimumClasses = true;

        assertEquals(0, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    @Test
    void calculate_same_grade_given_one_single_exam_and_attending_the_minimum_classes() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

        final List<Float> examsGrades              = List.of(5.f);
        final Boolean     hasReachedMinimumClasses = true;

        assertEquals(5, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    @Test
    void calculate_average_grade_given_different_exam_grades_and_attending_the_minimum_classes() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

        final List<Float> examsGrades              = List.of(5.f, 4.f, 6.f, 2.f, 8.f, 0.f, 10.f);
        final Boolean     hasReachedMinimumClasses = true;

        assertEquals(5, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    @Test
    void round_up_to_2_decimals_given_odd_exam_grades_and_attending_the_minimum_classes() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

        final List<Float> examsGrades              = List.of(5.f, 4.f);
        final Boolean     hasReachedMinimumClasses = true;

        assertEquals(4.5f, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    // hasReachedMinimumClasses

    @Test
    void fail_when_there_are_no_exams_and_has_not_attended_the_minimum_classes() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

        final List<Float> examsGrades              = Collections.emptyList();
        final Boolean     hasReachedMinimumClasses = false;

        assertEquals(0, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    @Test
    void fail_given_one_single_exam_but_not_attending_the_minimum_classes() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

        final List<Float> examsGrades              = List.of(5.f);
        final Boolean     hasReachedMinimumClasses = false;

        assertEquals(0, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    @Test
    void fail_given_different_exam_grades_but_not_attending_the_minimum_classes() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

        final List<Float> examsGrades              = List.of(5.f, 4.f, 6.f, 2.f, 8.f, 0.f, 10.f);
        final Boolean     hasReachedMinimumClasses = false;

        assertEquals(0, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }

    @Test
    void fail_given_odd_exam_grades_but_not_attending_the_minimum_classes() {
        StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

        final List<Float> examsGrades              = List.of(5.f, 4.f);
        final Boolean     hasReachedMinimumClasses = false;

        assertEquals(0, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses));
    }
}
