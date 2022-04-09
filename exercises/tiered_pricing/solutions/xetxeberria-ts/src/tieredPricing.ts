const priceTiers = [
  { minAmount: 1, unitPrice: 299 },
  { minAmount: 3, unitPrice: 239 },
  { minAmount: 11, unitPrice: 219 },
  { minAmount: 26, unitPrice: 199 },
  { minAmount: 51, unitPrice: 149 },
];

export function tieredPricing(licenseAmount: number): number {
  const licensePrice = calculateLicensePrice(licenseAmount);

  return licensePrice * licenseAmount;
}

function calculateLicensePrice(licenseAmount: number): number {
  const applicableTier = priceTiers
    .filter((tier) => licenseAmount >= tier.minAmount)
    .pop();
  return applicableTier?.unitPrice || 299;
}
