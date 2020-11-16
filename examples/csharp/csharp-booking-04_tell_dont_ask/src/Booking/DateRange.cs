using System;

namespace CodelyTv.Booking
{
    public sealed class DateRange
    {
        private readonly DateTime startDate;
        private readonly DateTime endDate;

        public DateRange(DateTime startDate, DateTime endDate)
        {
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public bool IsBetween(DateTime date)
        {
            return date > startDate && date < endDate;
        }

        public bool IsAfter(DateTime date)
        {
            return date < startDate;
        }
    }
}
