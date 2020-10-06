package tv.codely.booking;

import java.time.LocalDateTime;

public final class Booking {
    private final BookingId     id;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final Customer      customer;
    private final BookingType   bookingType;
    private final Discount      discount;
    private final Tax           tax;

    public Booking(
        BookingId id,
        DateRange bookingDateRange,
        Customer customer,
        BookingType bookingType,
        Discount discount,
        Tax tax
    ) {
        this.id          = id;
        this.startDate   = bookingDateRange.startDate();
        this.endDate     = bookingDateRange.endDate();
        this.customer    = customer;
        this.bookingType = bookingType;
        this.discount    = discount;
        this.tax         = tax;
    }

    public BookingStatus statusFor(LocalDateTime date) {
        if (date.isBefore(startDate)) {
            return BookingStatus.NOT_STARTED;
        }

        if (date.isAfter(startDate) && date.isBefore(endDate)) {
            return BookingStatus.ACTIVE;
        }

        return BookingStatus.FINISHED;
    }
}
