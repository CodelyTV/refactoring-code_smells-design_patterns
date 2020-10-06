package tv.codely.booking;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class BookingShould {
    @Test
    void get_the_correct_status_when_the_booking_has_not_started_yet() {
        var dateBeforeBookingHasStarted = LocalDateTime.of(2020, 5, 1, 12, 0);

        var bookingStartDate = LocalDateTime.of(2020, 6, 26, 19, 0);
        var bookingEndDate   = LocalDateTime.of(2020, 7, 14, 16, 0);

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

        assertEquals(BookingStatus.NOT_STARTED, booking.statusFor(dateBeforeBookingHasStarted));
    }

    @Test
    void get_the_correct_status_when_the_booking_is_currently_active() {
        var dateBetweenBooking = LocalDateTime.of(2020, 6, 29, 15, 0);

        var bookingStartDate = LocalDateTime.of(2020, 6, 26, 19, 0);
        var bookingEndDate   = LocalDateTime.of(2020, 7, 14, 16, 0);

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

        assertEquals(BookingStatus.ACTIVE, booking.statusFor(dateBetweenBooking));
    }

    @Test
    void get_the_correct_status_when_the_booking_is_finished() {
        var dateAfterBookingEnds = LocalDateTime.of(2020, 8, 30, 19, 0);

        var bookingStartDate = LocalDateTime.of(2020, 6, 26, 19, 0);
        var bookingEndDate   = LocalDateTime.of(2020, 7, 14, 16, 0);

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

        assertEquals(BookingStatus.FINISHED, booking.statusFor(dateAfterBookingEnds));
    }
}
