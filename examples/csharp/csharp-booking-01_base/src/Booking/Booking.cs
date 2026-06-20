using System;

namespace CodelyTv.Booking
{
    public class BookingPricing
    {
        public DiscountType DiscountType { get; }
        public DiscountValue DiscountValue { get; }
        public TaxType TaxType { get; }
        public TaxValue TaxValue { get; }

        public BookingPricing(DiscountType discountType, DiscountValue discountValue, TaxType taxType, TaxValue taxValue)
        {
            DiscountType = discountType;
            DiscountValue = discountValue;
            TaxType = taxType;
            TaxValue = taxValue;
        }

        private readonly BookingPricing pricing;

        public Booking(BookingId id, DateTime startDate, DateTime endDate, CustomerId customerId,
            CustomerName customerName, EmailAddress customerEmail, BookingType bookingType, BookingPricing pricing)
        {
            this.id = id;
            this.startDate = startDate;
            this.endDate = endDate;
            this.customerId = customerId;
            this.customerName = customerName;
            this.customerEmail = customerEmail;
            this.bookingType = bookingType;
            this.pricing = pricing;
        }

        public BookingStatus StatusFor(DateTime date)
        {
            if (date < startDate) return BookingStatus.NOT_STARTED;
            if (date >= startDate && date <= endDate) return BookingStatus.ACTIVE;
            return BookingStatus.FINISHED;
        }
    }
}
