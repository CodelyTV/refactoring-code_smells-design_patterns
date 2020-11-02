export class DailyBonusPointsCalculator {
    PREMIUM_USER_POINTS_PER_DAY   = 20;
    NORMAL_USER_POINTS_PER_DAY    = 10;
    PREMIUM_USER_WEEKS_MULTIPLIER = 1.5;
    
    calculate(consecutiveDays, isPremium = false) {
        if (isPremium) {
            const consecutiveWeeks = Math.floor(consecutiveDays / 7);
            
            let consecutiveWeeksMultiplier = 1;
            if (consecutiveWeeks > 0) {
                consecutiveWeeksMultiplier = Math.pow(this.PREMIUM_USER_WEEKS_MULTIPLIER, consecutiveWeeks);
            }
            
            return consecutiveDays * this.PREMIUM_USER_POINTS_PER_DAY * consecutiveWeeksMultiplier;
        } else {
            return consecutiveDays * this.NORMAL_USER_POINTS_PER_DAY;
        }
    }
}
