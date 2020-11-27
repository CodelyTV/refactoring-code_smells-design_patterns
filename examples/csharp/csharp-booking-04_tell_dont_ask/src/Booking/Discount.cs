using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

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
