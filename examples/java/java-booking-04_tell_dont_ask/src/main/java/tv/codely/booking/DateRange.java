package tv.codely.booking;

import java.time.LocalDateTime;

public final class DateRange {
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    public DateRange(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate   = endDate;
    }

    public boolean isBetween(LocalDateTime date) {
        return date.isAfter(startDate) && date.isBefore(endDate);
    }

    public boolean isAfter(LocalDateTime date) {
        return date.isBefore(startDate);
    }
}
