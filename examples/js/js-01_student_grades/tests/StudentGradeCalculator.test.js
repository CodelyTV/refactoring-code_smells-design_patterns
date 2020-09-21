import { StudentGradeCalculator } from '../src/StudentGradeCalculator';

describe('StudentGradeCalculator should', () => {
    let calculator = new StudentGradeCalculator(2020);
    
    it('calculate 0', () => {
        expect(calculator.calculate()).toBe(0);
    });
});
