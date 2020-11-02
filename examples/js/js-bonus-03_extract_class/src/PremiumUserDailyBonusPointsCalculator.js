export class PremiumUserDailyBonusPointsCalculator {
    POINTS_PER_DAY   = 20;
    WEEKS_MULTIPLIER = 1.5;
    
    calculate(consecutiveDays) {
        const consecutiveWeeks = Math.floor(consecutiveDays / 7);
        
        let consecutiveWeeksMultiplier = 1;
        if (consecutiveWeeks > 0) {
            consecutiveWeeksMultiplier = Math.pow(this.WEEKS_MULTIPLIER, consecutiveWeeks);
        }
        
        return consecutiveDays * this.POINTS_PER_DAY * consecutiveWeeksMultiplier;
    }
}
