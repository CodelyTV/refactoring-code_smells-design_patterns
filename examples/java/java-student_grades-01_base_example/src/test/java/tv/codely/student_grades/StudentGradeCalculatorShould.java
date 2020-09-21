package tv.codely.student_grades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Collections;

public class StudentGradeCalculatorShould {

	@Test
	void return_0_with_no_exam_grades() {
		StudentGradeCalculator studentGradeCalculator = new StudentGradeCalculator();

		assertEquals(0, studentGradeCalculator.calculateGrades(Collections.emptyList()));
	}
}
