namespace CodelyTv.Booking
{
    public sealed class Discount
    {
        private readonly DiscountType type;
        private readonly DiscountValue value;

        public Discount(DiscountType type, DiscountValue value)
        {
            this.type = type;
            this.value = value;
        }
    }
}
