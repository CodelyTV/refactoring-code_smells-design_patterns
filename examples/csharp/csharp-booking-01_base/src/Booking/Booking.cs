using System;

namespace CodelyTv.Booking
{
    public class BookingDetails
{
    public BookingId Id { get; }
    public DateTime StartDate { get; }
    public DateTime EndDate { get; }
    public CustomerId CustomerId { get; }
    public CustomerName CustomerName { get; }
    public EmailAddress CustomerEmail { get; }
    public BookingType BookingType { get; }
    public DiscountType DiscountType { get; }
    public DiscountValue DiscountValue { get; }
    public TaxType TaxType { get; }
    public TaxValue TaxValue { get; }

    public BookingDetails(
        BookingId id, DateTime startDate, DateTime endDate, CustomerId customerId,
        CustomerName customerName, EmailAddress customerEmail, BookingType bookingType,
        DiscountType discountType, DiscountValue discountValue, TaxType taxType, TaxValue taxValue)
    {
        Id = id;
        StartDate = startDate;
        EndDate = endDate;
        CustomerId = customerId;
        CustomerName = customerName;
        CustomerEmail = customerEmail;
        BookingType = bookingType;
        DiscountType = discountType;
        DiscountValue = discountValue;
        TaxType = taxType;
        TaxValue = taxValue;
    }

    public Booking(BookingDetails details)
    {
        this.id = details.Id;
        this.startDate = details.StartDate;
        this.endDate = details.EndDate;
        this.customerId = details.CustomerId;
        this.customerName = details.CustomerName;
        this.customerEmail = details.CustomerEmail;
        this.bookingType = details.BookingType;
        this.discountType = details.DiscountType;
        this.discountValue = details.DiscountValue;
        this.taxType = details.TaxType;
        this.taxValue = details.TaxValue;
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