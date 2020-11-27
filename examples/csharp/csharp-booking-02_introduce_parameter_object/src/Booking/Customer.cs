namespace CodelyTv.Booking
{
    public sealed class Customer
    {
        public CustomerId Id { get; }
        public CustomerName Name { get; }
        public EmailAddress EmailAddress { get; }

        public Customer(CustomerId id, CustomerName name, EmailAddress emailAddress)
        {
            this.Id = id;
            this.Name = name;
            this.EmailAddress = emailAddress;
        }
    }
}
