export class StudentGradeCalculator {
    constructor(yearToCalculate, teachers) {
        this.yearToCalculate = yearToCalculate;
        this.teachers        = teachers;
    }
    
    calculate(examGrades, hasReachedMinimumClasses) {
        if (examGrades.length !== 0) {
            
            let gradesSum       = 0;
            let gradesWeightSum = 0;
            
            for (let examGrade of examGrades) {
                gradesSum += (examGrade[0] * examGrade[1] / 100);
                gradesWeightSum += examGrade[0];
            }
            
            if (gradesWeightSum === 100) {
                if (hasReachedMinimumClasses) {
                    if (this.teachers.isThereAnyBenevolent(this.yearToCalculate)) {
                        return Math.min(10, gradesSum + 1);
                    } else {
                        return gradesSum;
                    }
                } else {
                    return 0;
                }
            } else if (gradesWeightSum > 100) {
                return -1;
            } else {
                return -2;
            }
        } else {
            return 0;
        }
    }
}
