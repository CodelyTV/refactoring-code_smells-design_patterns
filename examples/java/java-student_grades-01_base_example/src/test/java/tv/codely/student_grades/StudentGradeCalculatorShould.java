package tv.codely.student_grades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class StudentGradeCalculatorShould {

	@Test
	void calculate_0_with_no_exam_grades() {
		StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

        final List<Float> examsGrades = Collections.emptyList();

        assertEquals(0, studentGradeCalculator.calculateGrades(examsGrades));
	}

	@Test
	void calculate_same_grade_with_one_single_exam() {
		StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

        final List<Float> examsGrades = List.of(5.f);

        assertEquals(5, studentGradeCalculator.calculateGrades(examsGrades));
	}

	@Test
	void calculate_average_grade_based_on_different_exam_grades() {
		StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

        final List<Float> examsGrades = List.of(5.f, 4.f, 6.f, 2.f, 8.f, 0.f, 10.f);

        assertEquals(5, studentGradeCalculator.calculateGrades(examsGrades));
	}

	@Test
	void round_up_to_2_decimals() {
		StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

        final List<Float> examsGrades = List.of(5.f, 4.f);

        assertEquals(4.5f, studentGradeCalculator.calculateGrades(examsGrades));
	}
}
