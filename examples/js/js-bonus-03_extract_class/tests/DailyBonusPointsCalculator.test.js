import {NormalUserDailyBonusPointsCalculator}  from "../src/NormalUserDailyBonusPointsCalculator";
import {PremiumUserDailyBonusPointsCalculator} from "../src/PremiumUserDailyBonusPointsCalculator";

describe('DailyBonusPointsCalculator should', () => {
    it('Calculate points for a normal user on its first day', () => {
        const calculator = new NormalUserDailyBonusPointsCalculator();
        
        expect(calculator.calculate(1)).toBe(10);
    });
    
    it('Calculate points for a normal user on its second consecutive week', () => {
        const calculator = new NormalUserDailyBonusPointsCalculator();
        
        expect(calculator.calculate(14)).toBe(140);
    });
    
    it('Calculate points for a premium user on its first day', () => {
        const calculator = new PremiumUserDailyBonusPointsCalculator();
        
        expect(calculator.calculate(1)).toBe(20);
    });
    
    it('Calculate points for a premium user on its second consecutive week', () => {
        const calculator = new PremiumUserDailyBonusPointsCalculator();
        
        expect(calculator.calculate(14)).toBe(630);
    });
});
