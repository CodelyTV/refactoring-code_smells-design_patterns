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
            DateTime startDate,
            DateTime endDate,
            CustomerId customerId,
            CustomerName customerName,
            EmailAddress customerEmail,
            BookingType bookingType,
            DiscountType discountType,
            DiscountValue discountValue,
            TaxType taxType,
            TaxValue taxValue
        )
        {
            this.id = id;
            this.startDate = startDate;
            this.endDate = endDate;
            this.customerId = customerId;
            this.customerName = customerName;
            this.customerEmail = customerEmail;
            this.bookingType = bookingType;
            this.discountType = discountType;
            this.discountValue = discountValue;
            this.taxType = taxType;
            this.taxValue = taxValue;
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
