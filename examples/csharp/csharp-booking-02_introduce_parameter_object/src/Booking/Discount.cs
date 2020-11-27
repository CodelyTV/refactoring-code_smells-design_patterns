namespace CodelyTv.Booking
{
    public sealed class Discount
    {
        public DiscountType Type { get; }
        public DiscountValue Value { get; }

        public Discount(DiscountType type, DiscountValue value)
        {
            this.Type = type;
            this.Value = value;
        }
    }
}
