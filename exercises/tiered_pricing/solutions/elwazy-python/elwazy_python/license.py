from dataclasses import dataclass


@dataclass
class License:
    amount: int = 0

    def total(self) -> int:
        price = self.amount * self._price_calculator()
        return price

    def _price_calculator(self) -> int:
        match self.amount:
            case self.amount if self.amount <= 0:
                raise Exception("should be minimun 1 license!")
            case self.amount if self.amount <= 2:
                price = 299
            case self.amount if self.amount <= 10:
                price = 239
            case self.amount if self.amount <= 25:
                price = 219
            case self.amount if self.amount <= 50:
                price = 199
            case _:
                price = 149
        return price
