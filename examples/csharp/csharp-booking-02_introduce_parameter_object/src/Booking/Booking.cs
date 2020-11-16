using System;

namespace CodelyTv.Booking
{
    public sealed class Booking
    {
        private readonly BookingId id;
        private readonly DateTime startDate;
        private readonly DateTime endDate;
        private readonly CustomerId customerId;
        private readonly CustomerName customerName;
        private readonly EmailAddress customerEmail;
        private readonly BookingType bookingType;
        private readonly DiscountType discountType;
        private readonly DiscountValue discountValue;
        private readonly TaxType taxType;
        private readonly TaxValue taxValue;

        public Booking(
            BookingId id,
            DateRange bookingDateRange,
            Customer customer,
            BookingType bookingType,
            Discount discount,
            Tax tax
        )
        {
            this.id = id;
            this.startDate = bookingDateRange.StartDate;
            this.endDate = bookingDateRange.EndDate;
            this.customerId = customer.Id;
            this.customerName = customer.Name;
            this.customerEmail = customer.EmailAddress;
            this.bookingType = bookingType;
            this.discountType = discount.Type;
            this.discountValue = discount.Value;
            this.taxType = tax.Type;
            this.taxValue = tax.Value;
        }

        public BookingStatus StatusFor(DateTime date)
        {
            if (date < startDate)
            {
                return BookingStatus.NOT_STARTED;
            }

            if (date > startDate && date < endDate)
            {
                return BookingStatus.ACTIVE;
            }

            return BookingStatus.FINISHED;
        }
    }
}
