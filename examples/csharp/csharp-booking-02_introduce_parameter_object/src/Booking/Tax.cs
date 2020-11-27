namespace CodelyTv.Booking
{
    public sealed class Tax
    {
        public TaxType Type { get; }
        public TaxValue Value { get; }

        public Tax(TaxType type, TaxValue value)
        {
            this.Type = type;
            this.Value = value;
        }
    }
}
