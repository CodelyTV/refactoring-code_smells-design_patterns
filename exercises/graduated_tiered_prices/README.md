# Graduated Tiered pricing

A more advanced variation of the [Tiered Pricing](../tiered_pricing/README.md) exercise.

## User story

Companies want to get Codely subscriptions for their
employees.

We need to calculate the total price of the subscription
given the number of subscription that a company
wants to purchase.

Each subscription has a different unit price, depending
on the tier it belongs to:

| Range | Unit price |
|------:|-----------:|
|   1-2 |      299 € |
|  3-10 |      239 € |
| 11-25 |      219 € |
| 26-50 |      199 € |
|   51+ |      149 € |

For example, if the company wants 3 subscription,
the price of each subscription would be:

| subscription # | Price |
|---------------:|------:|
|              1 | 299 € |
|              2 | 299 € |
|              3 | 239 € |
|      **Total** | 837 € |

Here are some examples that can guide you during the
development process:

| Subscriptions | Unit price | Total   |
|--------------:|-----------:|--------:|
| 1             |      299 € |   299 € |
| 2             |      299 € |   598 € |
| 3             |      239 € |   837 € |
| 4             |      239 € |  1076 € |
| 5             |      239 € |  1315 € |
| 11            |      219 € |  2729 € |
| 12            |      219 € |  2948 € |
| 13            |      219 € |  3167 € |
| 26            |      199 € |  5994 € |
| 27            |      199 € |  6193 € |
| 28            |      199 € |  6392 € |
| 50            |      149 € | 10770 € |
| 51            |      149 € | 10919 € |
| 52            |      149 € | 11068 € |

## Exercise

Available languages:

- [TypeScript](base/typescript/README.md)