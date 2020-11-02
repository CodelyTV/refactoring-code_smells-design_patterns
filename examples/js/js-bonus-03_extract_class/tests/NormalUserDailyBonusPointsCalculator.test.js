import {NormalUserDailyBonusPointsCalculator} from "../src/NormalUserDailyBonusPointsCalculator";

describe('NormalUserDailyBonusPointsCalculator should', () => {
    it('Calculate points for a normal user on its first day', () => {
        const calculator = new NormalUserDailyBonusPointsCalculator();
        
        expect(calculator.calculate(1)).toBe(10);
    });
    
    it('Calculate points for a normal user on its second consecutive week', () => {
        const calculator = new NormalUserDailyBonusPointsCalculator();
        
        expect(calculator.calculate(14)).toBe(140);
    });
});
