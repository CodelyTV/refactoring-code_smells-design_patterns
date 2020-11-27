namespace CodelyTv.Booking
{
    public sealed class Tax
    {
        private readonly TaxType type;
        private readonly TaxValue value;

        public Tax(TaxType type, TaxValue value)
        {
            this.type = type;
            this.value = value;
        }
    }
}
