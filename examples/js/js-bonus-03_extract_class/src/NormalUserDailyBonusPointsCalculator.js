export class NormalUserDailyBonusPointsCalculator {
    POINTS_PER_DAY = 10;
    
    calculate(consecutiveDays) {
        return consecutiveDays * this.POINTS_PER_DAY;
    }
}
