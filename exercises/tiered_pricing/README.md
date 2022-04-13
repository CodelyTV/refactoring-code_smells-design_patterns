# Tiered pricing

## User story

Companies want to get Codely subscriptions for their
employees.

We need to calculate the total price of the subscription
given the number of subscription that a company
wants to purchase.

The annual unit price of the subscription depends on the
volume of the subscriptions as shown in the following
table:

| Range | Unit price |
|------:|-----------:|
|   1-2 |      299 € |
|  3-10 |      239 € |
| 11-25 |      219 € |
| 26-50 |      199 € |
|   51+ |      149 € |

Here are some examples that can guide you during the
development process:

| Subscriptions | Unit price | Total |
|--------------:|-----------:|------:|
| 1             |      299 € | 299 €  |
| 2             |      299 € | 598 €  |
| 3             |      239 € | 717 €  |
| 4             |      239 € | 956 €  |
| 5             |      239 € | 1195 € |
| 11            |      219 € | 2409 € |
| 12            |      219 € | 2628 € |
| 13            |      219 € | 2847 € |
| 26            |      199 € | 5174 € |
| 27            |      199 € | 5373 € |
| 28            |      199 € | 5572 € |
| 50            |      199 € | 9950 € |
| 51            |      149 € | 7599 € |
| 52            |      149 € | 7748 € |

## Exercise

Available languages:

- [Java](base/java/README.md)