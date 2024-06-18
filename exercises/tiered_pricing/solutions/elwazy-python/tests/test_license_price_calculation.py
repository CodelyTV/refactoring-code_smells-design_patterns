from typing import reveal_type
from elwazy_python.license import License


def test_buy_one_license_price_calculation():
    license = License(amount=1)
    assert license.total() == 299


def test_buy_two_license_price_calculation():
    license = License(amount=2)
    assert license._price_calculator() == 299
    assert license.total() == 598


def test_should_work_well_license_price_calculation():
    amounts = [
        (1, 299),
        (2, 299),
        (3, 239),
        (5, 239),
        (10, 239),
        (12, 219),
        (24, 219),
        (25, 219),
        (50, 199),
        (78, 149),
    ]
    for amount, price in amounts:
        license = License(amount)
        assert license._price_calculator() == price
