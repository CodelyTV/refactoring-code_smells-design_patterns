using System;

namespace CodelyTv.Booking
{
    public sealed class Booking
    {
        public BookingId Id { get; }
        public DateRange DateRange { get; }
        public Customer Customer { get; }
        public BookingType BookingType { get; }
        public Discount Discount { get; }
        public Tax Tax { get; }

        public Booking(
            BookingId id,
            DateRange dateRange,
            Customer customer,
            BookingType bookingType,
            Discount discount,
            Tax tax
        )
        {
            Id = id ?? throw new ArgumentNullException(nameof(id), "Booking ID cannot be null.");
            DateRange = dateRange ?? throw new ArgumentNullException(nameof(dateRange), "Date range cannot be null.");
            Customer = customer ?? throw new ArgumentNullException(nameof(customer), "Customer cannot be null.");
            BookingType = bookingType; 
            Discount = discount ?? throw new ArgumentNullException(nameof(discount), "Discount cannot be null.");
            Tax = tax ?? throw new ArgumentNullException(nameof(tax), "Tax cannot be null.");
        }

        public BookingStatus StatusFor(DateTime date)
        {
            if (date < DateRange.StartDate)
            {
                return BookingStatus.NOT_STARTED;
            }

            return IsBetween(date, DateRange) ? BookingStatus.ACTIVE : BookingStatus.FINISHED;
        }

        private static bool IsBetween(DateTime date, DateRange dateRange)
        {
            return date > dateRange.StartDate && date < dateRange.EndDate;
        }
    }
}
