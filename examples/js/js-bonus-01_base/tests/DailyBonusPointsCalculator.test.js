import {DailyBonusPointsCalculator} from "../src/DailyBonusPointsCalculator";

describe('DailyBonusPointsCalculator should', () => {
    it('Calculate points for a normal user on its first day', () => {
        const calculator = new DailyBonusPointsCalculator();
        
        expect(calculator.calculate(1)).toBe(10);
    });
    
    it('Calculate points for a normal user on its second consecutive week', () => {
        const calculator = new DailyBonusPointsCalculator();
        
        expect(calculator.calculate(14)).toBe(140);
    });
    
    it('Calculate points for a premium user on its first day', () => {
        const calculator = new DailyBonusPointsCalculator();
        
        expect(calculator.calculate(1, true)).toBe(20);
    });
    
    it('Calculate points for a premium user on its second consecutive week', () => {
        const calculator = new DailyBonusPointsCalculator();
        
        expect(calculator.calculate(14, true)).toBe(630);
    });
});
