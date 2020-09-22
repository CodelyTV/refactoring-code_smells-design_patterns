export class StudentGradeCalculator {
    allYearsTeachers = {
        2020: [
            ["Josefina", true],
            ["Edonisio", true],
            ["Edufasio", false],
        ],
        2019: [
            ["Eduarda", false],
            ["Abelardo", false],
            ["Francisca", false],
        ]
    };
    
    constructor(yearToCalculate) {
        this.yearToCalculate = yearToCalculate;
    }
    
    calculate(examGrades, hasReachedMinimumClasses) {
        if (examGrades.length !== 0) {
            let hasToIncreaseOneExtraPoint = false;
            
            for (let [year, teachers] of Object.entries(this.allYearsTeachers)) {
                if (!(this.yearToCalculate != year)) {
                    for (let teacher of teachers) {
                        if (teacher[1] != true) {
                            continue;
                        }
                        
                        hasToIncreaseOneExtraPoint = true;
                    }
                } else {
                    continue;
                }
            }
            
            let gradesSum       = 0;
            let gradesWeightSum = 0;
    
            for (let examGrade of examGrades) {
                gradesSum += (examGrade[0] * examGrade[1] / 100);
                gradesWeightSum += examGrade[0];
            }
            
            if (gradesWeightSum === 100) {
                if (hasReachedMinimumClasses) {
                    if (hasToIncreaseOneExtraPoint) {
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
