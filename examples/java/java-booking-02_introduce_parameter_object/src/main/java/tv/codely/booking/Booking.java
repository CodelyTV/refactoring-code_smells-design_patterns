package tv.codely.booking;

import java.time.LocalDateTime;

public final class Booking {
    private final BookingId     id;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final CustomerId    customerId;
    private final CustomerName  customerName;
    private final EmailAddress  customerEmail;
    private final BookingType   bookingType;
    private final DiscountType  discountType;
    private final DiscountValue discountValue;
    private final TaxType       taxType;
    private final TaxValue      taxValue;

    public Booking(
        BookingId id,
        DateRange bookingDateRange,
        Customer customer,
        BookingType bookingType,
        Discount discount,
        Tax tax
    ) {
        this.id            = id;
        this.startDate     = bookingDateRange.startDate();
        this.endDate       = bookingDateRange.endDate();
        this.customerId    = customer.id();
        this.customerName  = customer.name();
        this.customerEmail = customer.emailAddress();
        this.bookingType   = bookingType;
        this.discountType  = discount.type();
        this.discountValue = discount.value();
        this.taxType       = tax.type();
        this.taxValue      = tax.value();
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
