namespace CodelyTv.Booking
{
    public sealed class Customer
    {
        private readonly CustomerId id;
        private readonly CustomerName name;
        private readonly EmailAddress emailAddress;

        public Customer(CustomerId id, CustomerName name, EmailAddress emailAddress)
        {
            this.id = id;
            this.name = name;
            this.emailAddress = emailAddress;
        }
    }
}
