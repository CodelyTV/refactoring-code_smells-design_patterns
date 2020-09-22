import {StudentGradeCalculator} from '../src/StudentGradeCalculator';

describe('StudentGradeCalculator should', () => {
    it('fail given there are no exams', () => {
        const calculator = new StudentGradeCalculator(2019);
        
        const examsGrades              = [];
        const hasReachedMinimumClasses = true;
        
        expect(calculator.calculate(examsGrades, hasReachedMinimumClasses)).toBe(0);
    });
    
    it('calculate same grade given one single exam and attending the minimum classes', () => {
        const calculator = new StudentGradeCalculator(2019);
        
        const examsGrades              = [[100, 5]];
        const hasReachedMinimumClasses = true;
        
        expect(calculator.calculate(examsGrades, hasReachedMinimumClasses)).toBe(5);
    });
    
    it('calculate average grade given different exam grades and attending the minimum classes', () => {
        const calculator = new StudentGradeCalculator(2019);
        
        const examsGrades              = [
            [10, 4],
            [10, 6],
            [10, 2],
            [10, 8],
            [10, 0],
            [10, 10],
            [10, 0],
            [10, 10],
            [10, 0],
            [10, 10],
        ];
        const hasReachedMinimumClasses = true;
        
        expect(calculator.calculate(examsGrades, hasReachedMinimumClasses)).toBe(5);
    });
    
    it('round up to 2 decimals given odd exam grades and attending the minimum classes', () => {
        const calculator = new StudentGradeCalculator(2019);
        
        const examsGrades              = [
            [50, 4],
            [50, 5]
        ];
        const hasReachedMinimumClasses = true;
        
        expect(calculator.calculate(examsGrades, hasReachedMinimumClasses)).toBe(4.5);
    });
    
    // hasReachedMinimumClasses
    
    it('fail when there are no exams and has not attended the minimum classes', () => {
        const calculator = new StudentGradeCalculator(2019);
        
        const examsGrades              = [];
        const hasReachedMinimumClasses = false;
        
        expect(calculator.calculate(examsGrades, hasReachedMinimumClasses)).toBe(0);
    });
    
    it('fail given one single exam but not attending the minimum classes', () => {
        const calculator = new StudentGradeCalculator(2019);
        
        const examsGrades              = [[100, 5]];
        const hasReachedMinimumClasses = false;
        
        expect(calculator.calculate(examsGrades, hasReachedMinimumClasses)).toBe(0);
    });
    
    it('fail given different exam grades but not attending the minimum classes', () => {
        const calculator = new StudentGradeCalculator(2019);
        
        const examsGrades              = [
            [10, 4],
            [10, 6],
            [10, 2],
            [10, 8],
            [10, 0],
            [10, 10],
            [10, 0],
            [10, 10],
            [10, 0],
            [10, 10],
        ];
        const hasReachedMinimumClasses = false;
        
        expect(calculator.calculate(examsGrades, hasReachedMinimumClasses)).toBe(0);
    });
    
    it('fail given odd exam grades but not attending the minimum classes', () => {
        const calculator = new StudentGradeCalculator(2019);
        
        const examsGrades              = [[50, 5], [50, 4]];
        const hasReachedMinimumClasses = false;
        
        expect(calculator.calculate(examsGrades, hasReachedMinimumClasses)).toBe(0);
    });
    
    // Weight
    
    it('validate all exam grades weight below 100', () => {
        const calculator = new StudentGradeCalculator(2019);
        
        const examsGrades              = [
            [10, 4],
            [10, 6]
        ];
        const hasReachedMinimumClasses = false;
        
        expect(calculator.calculate(examsGrades, hasReachedMinimumClasses)).toBe(-2);
    });
    
    it('validate all exam grades weight over 100', () => {
        const calculator = new StudentGradeCalculator(2019);
        
        const examsGrades              = [
            [90, 4],
            [20, 6]
        ];
        const hasReachedMinimumClasses = false;
        
        expect(calculator.calculate(examsGrades, hasReachedMinimumClasses)).toBe(-1);
    });
    
    // hasToRaiseOnePoint
    
    it('not increase one extra point if there is not any benevolent teacher in the year to calculate grades', () => {
        const calculator = new StudentGradeCalculator(2019);
        
        const examsGrades              = [[100, 9.8]];
        const hasReachedMinimumClasses = true;
        
        expect(calculator.calculate(examsGrades, hasReachedMinimumClasses)).toBe(9.8);
    });
   
    it('increase one extra point if there is any benevolent teacher in the year to calculate grades', () => {
        const calculator = new StudentGradeCalculator(2020);
        
        const examsGrades              = [[100, 5]];
        const hasReachedMinimumClasses = true;
        
        expect(calculator.calculate(examsGrades, hasReachedMinimumClasses)).toBe(6);
    });
    
    it('maintain 10 as the maximum grade even if increasing one extra point', () => {
        const calculator = new StudentGradeCalculator(2020);
        
        const examsGrades              = [[100, 9.8]];
        const hasReachedMinimumClasses = true;
        
        expect(calculator.calculate(examsGrades, hasReachedMinimumClasses)).toBe(10);
    });
});
