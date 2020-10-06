package tv.codely.booking;

import java.time.LocalDateTime;

public final class Booking {
    private final BookingId   id;
    private final DateRange   dateRange;
    private final Customer    customer;
    private final BookingType bookingType;
    private final Discount    discount;
    private final Tax         tax;

    public Booking(
        BookingId id,
        DateRange dateRange,
        Customer customer,
        BookingType bookingType,
        Discount discount,
        Tax tax
    ) {
        this.id          = id;
        this.dateRange   = dateRange;
        this.customer    = customer;
        this.bookingType = bookingType;
        this.discount    = discount;
        this.tax         = tax;
    }

    public BookingStatus statusFor(LocalDateTime date) {
        if (date.isBefore(dateRange.startDate())) {
            return BookingStatus.NOT_STARTED;
        }

        if (isBetween(date, dateRange)) {
            return BookingStatus.ACTIVE;
        }

        return BookingStatus.FINISHED;
    }

    private boolean isBetween(LocalDateTime date, DateRange dateRange) {
        return date.isAfter(dateRange.startDate()) && date.isBefore(dateRange.endDate());
    }
}
