using System;
using Xunit;

namespace CodelyTv.Booking.Tests
{
    public sealed class BookingShould
    {
        [Fact]
        private void GetTheCorrectStatusWhenTheBookingHasNotStartedYet()
        {
            var dateBeforeBookingHasStarted = new DateTime(2020, 5, 1, 12, 0, 0);

            var bookingStartDate = new DateTime(2020, 6, 26, 19, 0, 0);
            var bookingEndDate = new DateTime(2020, 7, 14, 16, 0, 0);

            var booking = new Booking(
                new BookingId("2c1e34d0-1430-4307-80bf-a71761f71390"),
                bookingStartDate,
                bookingEndDate,
                new CustomerId("72cf3524-7838-45f3-8179-2e75abe5e81c"),
                new CustomerName("Perico Los Palotes"),
                new EmailAddress("perico.los.palotes@mail.com"),
                BookingType.VACATION,
                DiscountType.NONE,
                new DiscountValue(0),
                TaxType.NONE,
                new TaxValue(0)
            );

            Assert.Equal(BookingStatus.NOT_STARTED, booking.StatusFor(dateBeforeBookingHasStarted));
        }

        [Fact]
        private void GetTheCorrectStatusWhenTheBookingIsCurrentlyActive()
        {
            var dateBetweenBooking = new DateTime(2020, 6, 29, 15, 0, 0);

            var bookingStartDate = new DateTime(2020, 6, 26, 19, 0, 0);
            var bookingEndDate = new DateTime(2020, 7, 14, 16, 0, 0);

            var booking = new Booking(
                new BookingId("2c1e34d0-1430-4307-80bf-a71761f71390"),
                bookingStartDate,
                bookingEndDate,
                new CustomerId("72cf3524-7838-45f3-8179-2e75abe5e81c"),
                new CustomerName("Perico Los Palotes"),
                new EmailAddress("perico.los.palotes@mail.com"),
                BookingType.VACATION,
                DiscountType.NONE,
                new DiscountValue(0),
                TaxType.NONE,
                new TaxValue(0)
            );

            Assert.Equal(BookingStatus.ACTIVE, booking.StatusFor(dateBetweenBooking));
        }

        [Fact]
        private void GetTheCorrectStatusWhenTheBookingIsFinished()
        {
            var dateAfterBookingEnds = new DateTime(2020, 8, 30, 19, 0, 0);

            var bookingStartDate = new DateTime(2020, 6, 26, 19, 0, 0);
            var bookingEndDate = new DateTime(2020, 7, 14, 16, 0, 0);

            var booking = new Booking(
                new BookingId("2c1e34d0-1430-4307-80bf-a71761f71390"),
                bookingStartDate,
                bookingEndDate,
                new CustomerId("72cf3524-7838-45f3-8179-2e75abe5e81c"),
                new CustomerName("Perico Los Palotes"),
                new EmailAddress("perico.los.palotes@mail.com"),
                BookingType.VACATION,
                DiscountType.NONE,
                new DiscountValue(0),
                TaxType.NONE,
                new TaxValue(0)
            );

            Assert.Equal(BookingStatus.FINISHED, booking.StatusFor(dateAfterBookingEnds));
        }
    }
}
