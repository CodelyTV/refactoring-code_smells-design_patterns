import {DailyBonusPointsCalculator} from "../src/DailyBonusPointsCalculator";

describe('DailyBonusPointsCalculator should', () => {
    it('Calculate points for a user on its first day', () => {
        const calculator = new DailyBonusPointsCalculator();
        
        expect(calculator.calculate(1)).toBe(10);
    });
    
    it('Calculate points for a user on its second consecutive week', () => {
        const calculator = new DailyBonusPointsCalculator();
        
        expect(calculator.calculate(14)).toBe(140);
    });
});
