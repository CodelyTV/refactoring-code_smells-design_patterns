import {PremiumUserDailyBonusPointsCalculator} from "../src/PremiumUserDailyBonusPointsCalculator";

describe('PremiumUserDailyBonusPointsCalculator should', () => {
    it('Calculate points for a premium user on its first day', () => {
        const calculator = new PremiumUserDailyBonusPointsCalculator();
        
        expect(calculator.calculate(1)).toBe(20);
    });
    
    it('Calculate points for a premium user on its second consecutive week', () => {
        const calculator = new PremiumUserDailyBonusPointsCalculator();
        
        expect(calculator.calculate(14)).toBe(630);
    });
});
