package tv.codely.booking;

import java.util.Date;

public final class Booking {
    private final BookingId     id;
    private final Date          startDate;
    private final Date          endDate;
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
        Date startDate,
        Date endDate,
        CustomerId customerId,
        CustomerName customerName,
        EmailAddress customerEmail,
        BookingType bookingType,
        DiscountType discountType,
        DiscountValue discountValue,
        TaxType taxType,
        TaxValue taxValue
    ) {
        this.id            = id;
        this.startDate     = startDate;
        this.endDate       = endDate;
        this.customerId    = customerId;
        this.customerName  = customerName;
        this.customerEmail = customerEmail;
        this.bookingType   = bookingType;
        this.discountType  = discountType;
        this.discountValue = discountValue;
        this.taxType       = taxType;
        this.taxValue      = taxValue;
    }
}
