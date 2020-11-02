export class DailyBonusPointsCalculator {
    PREMIUM_USER_POINTS_PER_DAY   = 20;
    NORMAL_USER_POINTS_PER_DAY    = 10;
    
    calculate(consecutiveDays, isPremium) {
        if (isPremium) {
            return consecutiveDays * this.PREMIUM_USER_POINTS_PER_DAY;
        } else {
            return consecutiveDays * this.NORMAL_USER_POINTS_PER_DAY;
        }
    }
}
