using System;

namespace CodelyTv.Booking
{
    public sealed class Booking
    {
        private readonly BookingId id;
        private readonly DateRange dateRange;
        private readonly Customer customer;
        private readonly BookingType bookingType;
        private readonly Discount discount;
        private readonly Tax tax;

        public Booking(
            BookingId id,
            DateRange dateRange,
            Customer customer,
            BookingType bookingType,
            Discount discount,
            Tax tax
        )
        {
            this.id = id;
            this.dateRange = dateRange;
            this.customer = customer;
            this.bookingType = bookingType;
            this.discount = discount;
            this.tax = tax;
        }

        public BookingStatus StatusFor(DateTime date)
        {
            if (dateRange.IsAfter(date))
            {
                return BookingStatus.NOT_STARTED;
            }

            if (dateRange.IsBetween(date))
            {
                return BookingStatus.ACTIVE;
            }

            return BookingStatus.FINISHED;
        }
    }
}
